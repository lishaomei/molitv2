package com.molitv.android.scene;

import java.util.ArrayList;
import java.util.Iterator;

public class SceneManager {
    public static final SceneManager a = new SceneManager();

    private final ArrayList<a> c = new ArrayList();

    public final void b()
    {
        synchronized (this.c)
        {
            Iterator localIterator = this.c.iterator();
            if (localIterator.hasNext()) {
                ((a)localIterator.next()).f();
            }
        }
    }

}
