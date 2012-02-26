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

import android.content.Intent;
import android.os.Bundle;
import com.jwetherell.augmented_reality.data.ARData;
import org.androidsoft.opendata.arbres.Constants;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.poi.ar.POIDataSource;
import org.androidsoft.poi.ui.activity.POIARActivity;

/**
 *
 * @author pierre
 */
public class ArbresARActivity extends POIARActivity
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Local
        POIDataSource localData = new POIDataSource( this , new ArbreService(), R.drawable.icon );
        
        ARData.addMarkers(localData.getMarkers());

    }
    
    public void onPOITap(int id)
    {
        startTreeActivity(id);
    }
    
    public void startTreeActivity( int id )
    {
        Intent intent = new Intent( Constants.ACTION_TREE );
        intent.putExtra(Constants.TREE_ID, id );
        startActivity(intent);
    }
    

    
}
