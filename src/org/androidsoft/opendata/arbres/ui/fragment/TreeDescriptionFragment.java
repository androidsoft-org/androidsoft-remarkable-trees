package org.androidsoft.opendata.arbres.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.ui.activity.TreeActivity;
import org.androidsoft.utils.res.ResourceImageGetter;
import org.androidsoft.utils.res.ResourceUtils;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author pierre
 */
public class TreeDescriptionFragment extends Fragment
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
        View v = inflater.inflate(R.layout.fragment_tree_description, container, false);
        TextView tv = (TextView) v.findViewById(R.id.text);

        TreeActivity activity = (TreeActivity) getActivity();
        
        String assetFormat = activity.getString( R.string.html_asset_format);
        String asset = String.format(assetFormat, activity.getTreeId() );

        String help = ResourceUtils.readAssetTextFile(getActivity(), asset );
        tv.setText(Html.fromHtml(help, new ResourceImageGetter(getActivity()), null));
        return v;
    }
}
