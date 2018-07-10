package com.moliplayer.android.extend.ad;

import com.com.moliplayer.android.common.BaseContentProvider;

public class AdActionBaseFactory {

    private static AdActionBaseFactory mDefaultInstance = new AdActionBaseFactory();

    public static AdActionBaseFactory getInstance()
    {
        if ((BaseContentProvider.Default != null) && (BaseContentProvider.Default.getCustomAdActionFactory() != null)) {
            return BaseContentProvider.Default.getCustomAdActionFactory();
        }
        return mDefaultInstance;
    }
}
