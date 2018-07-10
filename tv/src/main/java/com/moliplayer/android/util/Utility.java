package com.moliplayer.android.util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class Utility {

    public static boolean ACTIVATED = false;
    public static boolean DEBUG = false;
    public static String LAUNCHER_APP;
    public static final String[] MUSIC_EXTS;
    public static final String NOTIFY_CONTEXT_EMPTY = "notify_context_empty";
    public static boolean PUSH_ENABLED;
    public static String SESSIONID_APP;
    public static final String[] SUBTITLE_EXTS;

    private static final ArrayList<Context> _contextList;

    private static Handler _mainHandler;

    static
    {
        SUBTITLE_EXTS = new String[] { "idx", "sub", "srt", "ssa", "ass", "smi", "utf", "utf8", "utf-8", "rt", "aqt", "txt", "usf", "jss", "cdg", "psb", "mpsub", "mpl2", "pjs", "dks", "lrc" };
        MUSIC_EXTS = new String[] { "mp3", "wav", "wma", "flac", "ape", "mp1", "mp2", "midi", "mid", "ra", "ram", "au", "aac", "m4a", "alac", "aiff", "cda", "vqf", "aif", "aiff", "adts", "latm", "amr", "pcm" };
        _contextList = new ArrayList();
    }
    public static boolean stringIsEmpty(String paramString)
    {
        return (paramString == null) || (paramString.length() == 0) || (paramString.trim() == "");
    }

    public static ArrayList<Context> getContextList()
    {
        return _contextList;
    }

    public static boolean hasContextFinishing()
    {
        synchronized (_contextList)
        {
            Iterator localIterator = _contextList.iterator();
            while (localIterator.hasNext())
            {
                Context localContext = (Context)localIterator.next();
                if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing())) {
                    return true;
                }
            }
            return false;
        }
    }



    public static void LogD(String paramString1, String paramString2)
    {
        if ((DEBUG) && (!stringIsEmpty(paramString2))) {
            Log.d(paramString1, paramString2);
        }
    }


    public static Handler getMainHandler()
    {
        return _mainHandler;
    }

    public static void postInUIThread(Runnable paramRunnable, long paramLong)
    {
        getMainHandler().postDelayed(paramRunnable, paramLong);
    }
}
