package com.facebook.android;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.socialin.android.L;

public abstract class BaseRequestListener implements RequestListener {

    public void onFacebookError(FacebookError e, Object state) {
        L.d("BaseRequestListener : ", e.getMessage());
        e.printStackTrace();
    }

    public void onFileNotFoundException(FileNotFoundException e, Object state) {
        L.d("BaseRequestListener : ", e.getMessage());
        e.printStackTrace();
    }

    public void onIOException(IOException e, Object state) {
        L.d("BaseRequestListener : ", e.getMessage());
        e.printStackTrace();
    }

    public void onMalformedURLException(MalformedURLException e, Object state) {
        L.d("BaseRequestListener : ", e.getMessage());
        e.printStackTrace();
    }
    
}