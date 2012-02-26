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

        Arbre tree = ArbreService.instance().getTree( getActivity(), 52 );
        final TextView tvTitle = (TextView) v.findViewById(R.id.title);
        tvTitle.setText( tree.getTitle());

        final TextView tvDescription = (TextView) v.findViewById(R.id.description);
        tvDescription.setText(tree.getDesciption());

        final TextView tvDistance = (TextView) v.findViewById(R.id.distance);
        tvDistance.setText(""  + tree.getDistance() + " m");

        return v;
    }
}
