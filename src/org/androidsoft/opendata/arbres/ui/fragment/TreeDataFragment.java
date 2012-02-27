/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.model.Arbre;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.opendata.arbres.ui.activity.TreeActivity;

/**
 *
 * @author pierre
 */
public class TreeDataFragment extends Fragment
{

    int mNum;

    /**
     * Create a new instance of CountingFragment, providing "num" as an
     * argument.
     */
    static TreeDescriptionFragment newInstance(int num)
    {
        TreeDescriptionFragment f = new TreeDescriptionFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    /**
     * The Fragment's UI is just a simple text view showing its instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_tree_data, container, false);
        
        TreeActivity activity = (TreeActivity) getActivity();

        Arbre tree = ArbreService.instance().getTree( activity, activity.getTreeId() );
        
        if( tree.getNomCommun() != null )
        {    
            final TextView tvName = (TextView) v.findViewById(R.id.common_name);
            tvName.setText( tree.getNomCommun());
        }
        
        if( tree.getGenre() != null )
        {
            final TextView tvVariety = (TextView) v.findViewById(R.id.gender);
            tvVariety.setText( tree.getGenre());
        }
        
        if( tree.getEspece() != null )
        {    
            final TextView tvSpecies = (TextView) v.findViewById(R.id.species);
            tvSpecies.setText( tree.getEspece());
        }
        
        if( tree.getVariete() != null )
        {
            final TextView tvVariety = (TextView) v.findViewById(R.id.variety);
            tvVariety.setText( tree.getVariete());
        }
        
        if( tree.getHauteur() != null )
        {
            final TextView tvHeight = (TextView) v.findViewById(R.id.tree_height);
            tvHeight.setText( "" + tree.getHauteur() + " m");
        }
        
        if( tree.getCirconference() != null )
        {
            final TextView tvCircumference = (TextView) v.findViewById(R.id.tree_circumference);
            tvCircumference.setText( tree.getCirconference() + " m");
        }

        if( tree.getAnnee() != null )
        {
            final TextView tvYear = (TextView) v.findViewById(R.id.year);
            tvYear.setText( "" + tree.getAnnee());
        }
        
        if( tree.getEspaceVert() != null )
        {
            final TextView tvLocation = (TextView) v.findViewById(R.id.tree_location);
            tvLocation.setText( tree.getEspaceVert());
        }
            
            
        return v;
    }
}
