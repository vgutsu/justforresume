package com.cinecentre.cinecentrecinema;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by victg on 14.02.2017.
 */

public class SessionManager {
    private static final String APP_INFO = "APP_INFO";
    private static final String SESSION = "SESSION";


    private static SessionManager managerSingleton;
    private final SharedPreferences sharedPreferences;

    // nullable
    private String sessionString;

    public static synchronized SessionManager getInstance(Context context) {
        if (null == managerSingleton) {
            managerSingleton = new SessionManager(context);
        }
        return managerSingleton;
    }

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_INFO, Context.MODE_PRIVATE);
        sessionString = getCurrentSession();
    }

    public String getCurrentSession() {
        if (TextUtils.isEmpty(sessionString)) {
            sessionString = sharedPreferences.getString(SESSION, null);
        }
        return sessionString;
    }

    public void saveSession(String sessionData) {
        this.sessionString = sessionData;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SESSION, sessionString);
        editor.apply();
    }

    public void eraseSession() {
        this.sessionString = null;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(SESSION);
        editor.apply();
    }

    public boolean hasSession() {
        return !TextUtils.isEmpty(sessionString);
    }

    public void logOut() {
        eraseSession();
    }

}
