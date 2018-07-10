package com.com.moliplayer.android.common;

import android.content.Context;

import com.moliplayer.android.extend.ad.AdActionBaseFactory;
import com.moliplayer.android.net.share.SambaAuthorizeManager;
import com.moliplayer.android.util.DBApi;

import java.io.InputStream;
import java.util.ArrayList;

public abstract class BaseContentProvider
{
    public static BaseContentProvider Default = null;

    public ArrayList<String> convertCDNUrl(String paramString)
    {
        return null;
    }

    public abstract int getCacheManager();

    public AdActionBaseFactory getCustomAdActionFactory()
    {
        return null;
    }

    public abstract DBApi getDB();

    public DBApi getDB(String paramString)
    {
        return null;
    }

    public Object getData(int paramInt, Object paramObject)
    {
        return null;
    }

    public abstract String[] getDownloading(int paramInt);

    public abstract String getFilePathById(int paramInt);

    public abstract InputStream getSmbConf();

    public abstract void loadPlayerLibrary();

    public abstract void showSambaAuthoDialog(Context paramContext, String paramString, SambaAuthorizeManager.SambaAuthorizeCallback paramSambaAuthorizeCallback);

    public abstract void showSambaErrorDialog(Context paramContext, int paramInt, Runnable paramRunnable);
}
