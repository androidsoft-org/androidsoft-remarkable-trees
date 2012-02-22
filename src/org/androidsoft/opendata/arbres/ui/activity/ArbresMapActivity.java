/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.ui.activity;

import java.util.List;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.poi.model.POI;
import org.androidsoft.poi.service.POIService;
import org.androidsoft.poi.ui.activity.POIMapActivity;
import org.androidsoft.poi.ui.activity.POIOverlayResources;

/**
 *
 * @author pierre
 */
public class ArbresMapActivity extends POIMapActivity
{
    private static final int ZOOM = 15;
    private static final int BOTTOM_OFFSET = 48;

    private POIService mPOIService = new ArbreService();

    @Override
    public int getMapViewId()
    {
        return R.id.mapview;
    }

    @Override
    public int getLayout()
    {
        return R.layout.poi_map;
    }

    @Override
    public int getMarkerRes()
    {
        return R.drawable.marker;
    }

    @Override
    public List<POI> getPOIs()
    {
        return mPOIService.getPOIs(this);
    }

    @Override
    public POIOverlayResources getOverlayResources()
    {
        POIOverlayResources res = new POIOverlayResources();
        res.setLayout(R.layout.balloon_overlay);
        res.setInnerLayoutId(R.id.balloon_inner_layout);
        res.setMainLayoutId(R.id.balloon_main_layout);
        res.setItemTitleId(R.id.balloon_item_title);
        res.setItemSnippetId(R.id.balloon_item_snippet);
        res.setCloseId(R.id.balloon_close);
        res.setBottomOffset( BOTTOM_OFFSET );
        return res;
    }
    
    @Override
    protected int getZoom()
    {
        return ZOOM;
    }
    
}
