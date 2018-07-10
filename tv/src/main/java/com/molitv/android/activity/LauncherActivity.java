package com.molitv.android.activity;

import android.app.Activity;
import android.os.Bundle;

import com.com.moliplayer.android.common.BaseContentProvider;
import com.moliplayer.android.util.Utility;
import com.molitv.android.n;

import java.util.ArrayList;

public class LauncherActivity extends Activity {

    private Runnable a = new Runnable() {
        public final void run() {
            if (Utility.hasContextFinishing())
            {
                Utility.postInUIThread(this, 10L);
                return;
            }
        }
    };

    protected void onCreate(Bundle paramBundle) {
        Utility.DEBUG = false;
        Utility.LogD("my", "LauncherActivity onCreate " + getTaskId());
        if (BaseContentProvider.Default == null) {
            BaseContentProvider.Default = new n();
        }
       ((n) BaseContentProvider.Default).a(this);
        super.onCreate(paramBundle);

        ArrayList paramBundle2 = new ArrayList(Utility.getContextList());
        if (paramBundle2.size() > 0)
        {

        }

        this.a.run();
    }
}
