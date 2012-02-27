/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.androidsoft.opendata.arbres.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import org.androidsoft.opendata.arbres.Constants;
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
    private int mTreeId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_tabs_pager);
        
        Intent intent = getIntent();
        mTreeId = intent.getIntExtra(Constants.TREE_ID, 0);
        
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
    
    public int getTreeId()
    {
        return mTreeId;
    }
}
