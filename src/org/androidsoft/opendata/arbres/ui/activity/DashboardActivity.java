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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.androidsoft.opendata.arbres.Constants;
import org.androidsoft.opendata.arbres.R;

public class DashboardActivity extends Activity implements View.OnClickListener
{
    
    private Button mButtonPOIList;
    private Button mButtonPOIMap;
    private Button mButtonPOIAR;
    private Button mButtonAbout;
            
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        
        mButtonPOIList = (Button) findViewById( R.id.button_poi_list );
        mButtonPOIList.setOnClickListener(this); 
        mButtonPOIMap = (Button) findViewById( R.id.button_poi_map );
        mButtonPOIMap.setOnClickListener(this); 
        mButtonPOIAR = (Button) findViewById( R.id.button_poi_ar );
        mButtonPOIAR.setOnClickListener(this); 
        mButtonAbout = (Button) findViewById( R.id.button_about );
        mButtonAbout.setOnClickListener(this); 
        
        
    }
    
    public void onClick(View v)
    {
        if( v == mButtonPOIList )
        {
            startPoiList();
        }
        else if( v == mButtonPOIMap )
        {
            startPoiMap();
        }
        else if( v == mButtonPOIAR )
        {
            startPoiAR();
        }
        else if( v == mButtonAbout )
        {
            startAbout();
        }
    }

    
    private void startPoiList()
    {
        Intent intent = new Intent( Constants.ACTION_DISPLAY_POI_LIST );
        startActivity(intent);
    }

    private void startPoiMap()
    {
        Intent intent = new Intent( Constants.ACTION_DISPLAY_POI_MAP );
        startActivity(intent);
    }

    private void startPoiAR()
    {
        Intent intent = new Intent( Constants.ACTION_DISPLAY_POI_AR );
        startActivity(intent);
    }

    private void startAbout()
    {
        Intent intent = new Intent( Constants.ACTION_ABOUT );
        startActivity(intent);
    }

}
