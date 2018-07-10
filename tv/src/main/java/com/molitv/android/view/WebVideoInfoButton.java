package com.molitv.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class WebVideoInfoButton extends RelativeLayout {


    public WebVideoInfoButton(Context paramContext)
    {
        super(paramContext);
    }

    public WebVideoInfoButton(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }

    public WebVideoInfoButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public final void a(int paramInt1, String paramString1, String paramString2, int paramInt2) {
        setTag(Integer.valueOf(paramInt2));
    }
}
