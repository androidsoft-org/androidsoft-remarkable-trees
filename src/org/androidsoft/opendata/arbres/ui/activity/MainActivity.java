package org.androidsoft.opendata.arbres.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.androidsoft.opendata.arbres.R;

public class MainActivity extends Activity implements View.OnClickListener
{
    private static final String ACTION_DISPLAY_POI_LIST = "org.androidsoft.opendata.arbres.DISPLAY_LIST";
    private static final String ACTION_DISPLAY_POI_MAP = "org.androidsoft.opendata.arbres.DISPLAY_MAP";
    private static final String ACTION_DISPLAY_POI_AR = "org.androidsoft.opendata.arbres.DISPLAY_AR";
    
    private Button mButtonPOIList;
    private Button mButtonPOIMap;
    private Button mButtonPOIAR;
            
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        mButtonPOIList = (Button) findViewById( R.id.button_poi_list );
        mButtonPOIList.setOnClickListener(this); 
        mButtonPOIMap = (Button) findViewById( R.id.button_poi_map );
        mButtonPOIMap.setOnClickListener(this); 
        mButtonPOIAR = (Button) findViewById( R.id.button_poi_ar );
        mButtonPOIAR.setOnClickListener(this); 
        
        
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
    }

    
    private void startPoiList()
    {
        Intent intent = new Intent( ACTION_DISPLAY_POI_LIST );
        startActivity(intent);
    }

    private void startPoiMap()
    {
        Intent intent = new Intent( ACTION_DISPLAY_POI_MAP );
        startActivity(intent);
    }

    private void startPoiAR()
    {
        Intent intent = new Intent( ACTION_DISPLAY_POI_AR );
        startActivity(intent);
    }

}
