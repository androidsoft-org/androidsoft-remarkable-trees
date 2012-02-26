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
package org.androidsoft.opendata.arbres.ui.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.poi.model.POI;
import org.androidsoft.poi.ui.adapter.POIAdapter;

/**
 *
 * @author pierre
 */
public class TreesAdapter extends POIAdapter
{
    /**
     * Constructor
     * @param activity
     * @param list 
     */
    public TreesAdapter( Activity activity , List<POI> list )
    {
        super( activity , list );
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
        Drawable icon = poi.getIcon();
        if( icon == null )
        {
            icon = mActivity.getResources().getDrawable( R.drawable.icon );
        }
        imageView.setImageDrawable( icon );

        final TextView tvTitle = (TextView) convertView.findViewById(R.id.title);
        tvTitle.setText( poi.getTitle());

        final TextView tvDescription = (TextView) convertView.findViewById(R.id.description);
        tvDescription.setText(poi.getDesciption());

        final TextView tvDistance = (TextView) convertView.findViewById(R.id.distance);
        tvDistance.setText(""  + poi.getDistance() + " m");

        return convertView;        
    }

}
