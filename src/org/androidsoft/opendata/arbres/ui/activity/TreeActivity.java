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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import android.widget.TextView;
import org.androidsoft.opendata.arbres.Constants;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.model.Arbre;
import org.androidsoft.opendata.arbres.service.ArbreService;
import org.androidsoft.opendata.arbres.ui.adapter.TabsAdapter;
import org.androidsoft.opendata.arbres.ui.fragment.TreeDataFragment;
import org.androidsoft.opendata.arbres.ui.fragment.TreeDescriptionFragment;

/**
 *
 * @author pierre
 */
public class TreeActivity extends FragmentActivity
{
    private static final String KEY_TREE_ID = "tree_id";

    private TabHost mTabHost;
    private ViewPager mViewPager;
    private TabsAdapter mTabsAdapter;
    private int mTreeId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent = getIntent();
        mTreeId = intent.getIntExtra(Constants.TREE_ID, 0);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tree_activity);


        mTabHost = (TabHost) findViewById(android.R.id.tabhost);

        if (mTabHost != null)
        {
            mTabHost.setup();

            mViewPager = (ViewPager) findViewById(R.id.pager);

            mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);

            mTabsAdapter.addTab(mTabHost.newTabSpec("data").setIndicator("Caractéristiques"),
                    TreeDataFragment.class, null);
            mTabsAdapter.addTab(mTabHost.newTabSpec("description").setIndicator("Description"),
                    TreeDescriptionFragment.class, null);

            if (savedInstanceState != null)
            {
                mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
            }

        }
        else
        {
//            Fragment dataFragment = getFragmentManager().findFragmentById( R.id.tree_data_fragment );
            
        }
        Arbre arbre = ArbreService.instance().getTree(this, mTreeId);
        TextView tvTitle = (TextView) findViewById(R.id.title);
        tvTitle.setText(arbre.getNomCommun());

        TextView tvAddress = (TextView) findViewById(R.id.address);
        tvAddress.setText(arbre.getEspaceVert());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        if( mTabHost != null )
        {
            outState.putString("tab", mTabHost.getCurrentTabTag());
        }
    }


    public int getTreeId()
    {
        return mTreeId;
    }
}
