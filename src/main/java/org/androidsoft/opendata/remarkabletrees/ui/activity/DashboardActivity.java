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
package org.androidsoft.opendata.remarkabletrees.ui.activity;

import android.content.Intent;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidsoft.opendata.remarkabletrees.Constants;
import org.androidsoft.opendata.remarkabletrees.R;
import org.androidsoft.poi.ui.activity.POILocationCheckActivity;

/**
 * Dashboard Activity
 *
 * @author Pierre LEVY
 */
@EActivity(R.layout.dashboard)
public class DashboardActivity extends POILocationCheckActivity
{

    @Click(R.id.button_list_around)
    void startPoiList()
    {
        Intent intent = new Intent(Constants.ACTION_DISPLAY_POI_LIST);
        startActivity(intent);
    }

    @Click(R.id.button_map)
    void startPoiMap()
    {
        Intent intent = new Intent(Constants.ACTION_DISPLAY_POI_MAP);
        startActivity(intent);
    }

    @Click(R.id.button_ar)
    void startPoiAR()
    {
        Intent intent = new Intent(Constants.ACTION_DISPLAY_POI_AR);
        startActivity(intent);
    }

    @Click(R.id.button_about)
    void startAbout()
    {
        Intent intent = new Intent(Constants.ACTION_ABOUT);
        startActivity(intent);
    }


    protected String getNoLocationServiceMessage()
    {
        return getString( R.string.message_activate_location );
    }
}
