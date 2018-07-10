package com.moliplayer.android.net.share;

public class SambaAuthorizeManager {

    public static abstract interface SambaAuthorizeCallback
    {
        public abstract void OnCompleted();

        public abstract void OnFailed();
    }
}
