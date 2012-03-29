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
package org.androidsoft.opendata.remarkabletrees.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import org.androidsoft.opendata.remarkabletrees.Constants;
import org.androidsoft.opendata.remarkabletrees.R;

/**
 * Splash Activity 
 * @author Pierre LEVY
 */
public class SplashActivity extends Activity
{

    private static final int SPLASH_DELAY = 2000;
    private Thread mThread;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        mThread = new Thread()
        {

            @Override
            public void run()
            {
                try
                {
                    synchronized (this)
                    {
                        wait(SPLASH_DELAY);
                    }
                }
                catch (InterruptedException ex)
                {
                }
                startDashboard();
            }
        };

        mThread.start();
    }

    private void startDashboard()
    {
        Intent intent = new Intent(Constants.ACTION_DASHBOARD);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt)
    {
        if (evt.getAction() == MotionEvent.ACTION_DOWN)
        {
            synchronized (mThread)
            {
                mThread.notifyAll();
            }
        }
        return true;
    }
}
