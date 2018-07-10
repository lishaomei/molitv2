package com.molitv.android.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.cloudmedia.videoplayer.R;

public class MRBaseActivity extends FragmentActivity {
    private PopupWindow d;

    private void b() {
        View localObject =findViewById(android.R.id.content).getRootView();

        View localView = LayoutInflater.from(this).inflate(R.layout.refresh_popup, null, false);
        this.d = new PopupWindow(localObject, -1, -1);
        this.d.setContentView(localView);

        this.d.showAtLocation((View)localObject, 17, 0, 0);
    }

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        if ((Build.VERSION.SDK_INT >= 11))
        {
            //setTheme(R.style.Theme.MoliSmartBar);
        }
        //b();
    }

}
