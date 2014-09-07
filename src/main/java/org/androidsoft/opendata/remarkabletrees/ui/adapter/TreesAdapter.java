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
package org.androidsoft.opendata.remarkabletrees.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidsoft.opendata.remarkabletrees.R;
import org.androidsoft.poi.model.POI;
import org.androidsoft.poi.ui.adapter.POIAdapter;

import java.util.List;

/**
 * Trees Adapter
 * @author Pierre LEVY
 */
public class TreesAdapter extends POIAdapter
{
    private boolean mDistanceAvailable;
    private Context mContext;
    private static int[] DRAWABLE_IDS = new int[] {
        R.drawable.tree1,
        R.drawable.tree2,
        R.drawable.tree3,
        R.drawable.tree4,
        R.drawable.tree5,
        R.drawable.tree6,
        R.drawable.tree7,
        R.drawable.tree8,
        R.drawable.tree9,
        R.drawable.tree10,
        R.drawable.tree11,
        R.drawable.tree12,
        R.drawable.tree13,
        R.drawable.tree14,
        R.drawable.tree15,
        R.drawable.tree16,
        R.drawable.tree17,
        R.drawable.tree18,
        R.drawable.tree19,
        R.drawable.tree20,
        R.drawable.tree21,
        R.drawable.tree22,
        R.drawable.tree23,
        R.drawable.tree24,
        R.drawable.tree25,
        R.drawable.tree26,
        R.drawable.tree27,
        R.drawable.tree28,
        R.drawable.tree29,
        R.drawable.tree30,
        R.drawable.tree31,
        R.drawable.tree32,
        R.drawable.tree33,
        R.drawable.tree34,
        R.drawable.tree35,
        R.drawable.tree36,
        R.drawable.tree37,
        R.drawable.tree38,
        R.drawable.tree39,
        R.drawable.tree40,
        R.drawable.tree41,
        R.drawable.tree42,
        R.drawable.tree43,
        R.drawable.tree44,
        R.drawable.tree45,
        R.drawable.tree46,
        R.drawable.tree47,
        R.drawable.tree48,
        R.drawable.tree49,
        R.drawable.tree50,
        R.drawable.tree51,
        R.drawable.tree52,
        R.drawable.tree53,
        R.drawable.tree54,
        R.drawable.tree55,
        R.drawable.tree56,
        R.drawable.tree57,
        R.drawable.tree58,
        R.drawable.tree59,
        R.drawable.tree60,
    };
    
    /**
     * Constructor
     * @param activity
     * @param list 
     */
    public TreesAdapter( Activity activity , List<POI> list , boolean distanceAvailable )
    {
        super( activity , list );
        mDistanceAvailable = distanceAvailable;
        mContext = activity.getApplicationContext();
    }
    
        /**
     * {@inheritDoc }
     */
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final POI poi = (POI) getItem(position);

        if (convertView == null)
        {
            final LayoutInflater inflater = mActivity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.poi_list_item, parent, false);
        }

        final ImageView imageView = (ImageView) convertView.findViewById(R.id.icon);
        Drawable icon = mActivity.getResources().getDrawable(DRAWABLE_IDS[poi.getId() - 1]);
        imageView.setImageDrawable(icon);

        final TextView tvTitle = (TextView) convertView.findViewById(R.id.title);
        tvTitle.setText( poi.getTitle());

        final TextView tvDescription = (TextView) convertView.findViewById(R.id.description);
        tvDescription.setText(poi.getDescription());

        final TextView tvDistance = (TextView) convertView.findViewById(R.id.distance);
        if( mDistanceAvailable )
        {
            tvDistance.setText(""  + poi.getDistance() + " m");
        }
        else
        {
            tvDistance.setText( mContext.getString(R.string.no_distance ));
        }
        
        return convertView;        
    }

}
