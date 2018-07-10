package com.cloudmedia.tv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.molitv.android.activity.FlipTopicActivity;
import com.molitv.android.activity.MRBaseActivity;

//import com.cloudmedia.videoplayer.R;

public class WelcomeActivity extends Activity {
    RelativeLayout j;
    ImageView i;
    ImageView h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_welcome);
//
//        this.j = ((RelativeLayout)findViewById(R.id.ad_rl_layout));
//        this.i = ((ImageView)findViewById(R.id.ad_iv_img));
//        this.h = ((ImageView)findViewById(R.id.iv_tips));
//
//        this.h.setVisibility(View.VISIBLE);
//
//        this.j.setBackgroundResource(R.drawable.ic_play_bg);

        Intent localObject = new Intent();
        localObject.setClass(WelcomeActivity.this, MainActivity.class);
        localObject.setClass(WelcomeActivity.this,FlipTopicActivity.class);
        //localObject.setFlags(268468224);

        this.startActivity(localObject);
        this.finish();
    }
}
