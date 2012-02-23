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
