package com.brightminded.cordova.plugins;

import android.content.Context;
import android.media.AudioManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioFocus extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("requestFocus")) {
            this.requestFocus(callbackContext);
            return true;
        }

        return false;
    }

    private void requestFocus(CallbackContext callbackContext) {
        // get AudioManager
        AudioManager am = (AudioManager)this.cordova.getActivity()
                                    .getApplicationContext()
                                    .getSystemService(Context.AUDIO_SERVICE);

        // request audio focus
        int result = am.requestAudioFocus(null,
                                        AudioManager.STREAM_MUSIC,
                                        AudioManager.AUDIOFOCUS_GAIN);

        // return result
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            callbackContext.success("");
        } else {
            callbackContext.error("");
        }
    }
}
