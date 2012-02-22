/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.ui.activity;

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
import org.androidsoft.poi.ui.activity.POIAdapter;

/**
 *
 * @author pierre
 */
public class ArbresAdapter extends POIAdapter
{
    /**
     * Constructor
     * @param activity
     * @param list 
     */
    public ArbresAdapter( Activity activity , List<POI> list )
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
