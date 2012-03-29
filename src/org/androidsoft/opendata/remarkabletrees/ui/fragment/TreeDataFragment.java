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
package org.androidsoft.opendata.remarkabletrees.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import org.androidsoft.opendata.remarkabletrees.Constants;
import org.androidsoft.opendata.remarkabletrees.R;
import org.androidsoft.opendata.remarkabletrees.model.RemarkableTree;
import org.androidsoft.opendata.remarkabletrees.service.TreesService;
import org.androidsoft.opendata.remarkabletrees.ui.activity.TreeActivity;

/**
 * Tree Data Fragment
 * @author Pierre LEVY
 */
public class TreeDataFragment extends Fragment
{
    
    /**
     * The Fragment's UI is just a simple text view showing its instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_tree_data, container, false);

        TreeActivity activity = (TreeActivity) getActivity();

        if (activity == null)
        {
            Log.e( Constants.TAG , "Activity is null ");
        }

        RemarkableTree tree = TreesService.instance().getTree(activity, activity.getTreeId());

        if (tree != null)
        {
            if (tree.getGenre() != null)
            {
                final TextView tvVariety = (TextView) v.findViewById(R.id.gender);
                tvVariety.setText(tree.getGenre());
            }

            if (tree.getEspece() != null)
            {
                final TextView tvSpecies = (TextView) v.findViewById(R.id.species);
                tvSpecies.setText(tree.getEspece());
            }

            if (tree.getVariete() != null)
            {
                final TextView tvVariety = (TextView) v.findViewById(R.id.variety);
                tvVariety.setText(tree.getVariete());
            }

            if (tree.getHauteur() != null)
            {
                final TextView tvHeight = (TextView) v.findViewById(R.id.tree_height);
                tvHeight.setText("" + tree.getHauteur() + " m");
            }

            if (tree.getCirconference() != null)
            {
                final TextView tvCircumference = (TextView) v.findViewById(R.id.tree_circumference);
                tvCircumference.setText(tree.getCirconference() + " cm");
            }

            if (tree.getAnnee() != null)
            {
                final TextView tvYear = (TextView) v.findViewById(R.id.year);
                tvYear.setText("" + tree.getAnnee());
            }
            
        }

        return v;
    }
    
}
