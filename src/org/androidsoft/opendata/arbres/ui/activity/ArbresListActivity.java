/* Copyright (c) 2012 Pierre LEVY androidsoft.org
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.androidsoft.opendata.arbres.ui.activity;

import org.androidsoft.opendata.arbres.ui.adapter.TreesAdapter;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;
import java.util.List;
import org.androidsoft.opendata.arbres.Constants;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.poi.service.LocationService;
import org.androidsoft.poi.service.POIService;
import org.androidsoft.poi.ui.activity.POIListActivity;
import org.androidsoft.poi.ui.adapter.POIAdapter;

/**
 *
 * @author pierre
 */
public class ArbresListActivity extends POIListActivity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    
    
    @Override
    protected int getLayout()
    {
        return R.layout.poi_list;
    }

    @Override
    protected int getListId()
    {
        return R.id.listview_poi;
    }

    @Override
    protected POIAdapter getAdapter()
    {
        ArbreService service = new ArbreService();
        List list = service.getPOIs(this);
        double latitude = 48.8;
        double longitude = 2.34;
        boolean distanceAvailable;
        Location location = LocationService.getLocation(this);
        if( location != null )
        {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            distanceAvailable = true;
        }
        else
        {
            Toast.makeText(this, getString( R.string.no_location ), Toast.LENGTH_LONG).show();
            distanceAvailable = false;
        }
        list = POIService.getNearestPOI(list, latitude, longitude, 60, 1000000000 );

        return new TreesAdapter(this, list , distanceAvailable );
    }

    public void onPOITap(int id)
    {
        startTreeActivity(id);
    }

    private void startTreeActivity( int id )
    {
        Intent intent = new Intent( Constants.ACTION_TREE );
        intent.putExtra(Constants.TREE_ID, id );
        startActivity(intent);
    }
  
}
