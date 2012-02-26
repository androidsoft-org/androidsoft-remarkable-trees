/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import org.androidsoft.opendata.arbres.R;
import org.androidsoft.opendata.arbres.ui.adapter.TabsAdapter;
import org.androidsoft.opendata.arbres.ui.fragment.TreeDataFragment;
import org.androidsoft.opendata.arbres.ui.fragment.TreeDescriptionFragment;

/**
 *
 * @author pierre
 */
public class TreeActivity extends FragmentActivity
{

    TabHost mTabHost;
    ViewPager mViewPager;
    TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_tabs_pager);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
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

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("tab", mTabHost.getCurrentTabTag());
    }
}
