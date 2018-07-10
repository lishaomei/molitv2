package com.molitv.android.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.cloudmedia.videoplayer.R;
import com.molitv.android.view.WebVideoInfoButton;

public class FlipTopicActivity extends  MRBaseActivity {

    ImageView i;
    WebVideoInfoButton g;

    protected void onCreate(Bundle paramBundle) {
        boolean bool = true;
        super.onCreate(paramBundle);

        setContentView(R.layout.fliptopic_layout);

        this.i = ((ImageView)findViewById(R.id.fliptopic_btn_shadow));

        this.g = ((WebVideoInfoButton)findViewById(R.id.btn_play_now));
        this.g.a(R.drawable.fliptopic_playbtn, getString(R.string.webvideoinfo_option_toplay), null, 0);

    }
}
