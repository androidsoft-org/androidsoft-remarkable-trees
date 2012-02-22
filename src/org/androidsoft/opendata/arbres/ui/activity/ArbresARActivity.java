/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.ui.activity;

import android.os.Bundle;
import com.jwetherell.augmented_reality.data.ARData;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.poi.service.POIDataSource;
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
    
    

    
}
