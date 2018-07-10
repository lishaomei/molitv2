package com.molitv.android;

import android.content.Context;

import com.com.moliplayer.android.common.BaseContentProvider;
import com.moliplayer.android.net.share.SambaAuthorizeManager;
import com.moliplayer.android.util.DBApi;

import java.io.InputStream;

public class n  extends BaseContentProvider {
    @Override
    public int getCacheManager() {
        return 0;
    }

    @Override
    public DBApi getDB() {
        return null;
    }

    @Override
    public String[] getDownloading(int paramInt) {
        return new String[0];
    }

    @Override
    public String getFilePathById(int paramInt) {
        return null;
    }

    @Override
    public InputStream getSmbConf() {
        return null;
    }

    @Override
    public void loadPlayerLibrary() {

    }

    @Override
    public void showSambaAuthoDialog(Context paramContext, String paramString, SambaAuthorizeManager.SambaAuthorizeCallback paramSambaAuthorizeCallback) {

    }

    @Override
    public void showSambaErrorDialog(Context paramContext, int paramInt, Runnable paramRunnable) {

    }

    public final void a(Context paramContext)
    {

    }


}
