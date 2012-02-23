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

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.poi.service.LocationService;
import org.androidsoft.poi.service.POIService;

/**
 *
 * @author pierre
 */
public class ArbresListActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.poi_list);
        ListView lvPOIs = (ListView) findViewById( R.id.listview_poi);
        
        ArbreService service = new ArbreService();
        List list = service.getPOIs(this);
        double latitude = 2.34;
        double longitude = 48.8;
        Location location = LocationService.getLocation(this);
        if( location != null )
        {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
        list = POIService.getNearestPOI(list, latitude, longitude, 60, 1000000000 );

        lvPOIs.setAdapter( new ArbresAdapter(this, list ));
        
    }
    
}
