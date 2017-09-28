package com.brightminded.cordova.plugins;

import android.content.Context;
import android.media.AudioManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioFocus extends CordovaPlugin {

	private AudioFocusChangeListener audioFocusChangeListener;
	// private AudioManager audioManager;

	public AudioFocus() {
		// get AudioManager
		audioManager = (AudioManager)this.cordova.getActivity()
									.getApplicationContext()
									.getSystemService(Context.AUDIO_SERVICE);
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("requestFocus")) {
			this.requestFocus(callbackContext);
			return true;
		}

		if (action.equals("releaseFocus")) {
			this.releaseFocus(callbackContext);
			return true;
		}

		return false;
	}

	private void requestFocus(CallbackContext callbackContext) {
		// request audio focus
		int result = audioManager.requestAudioFocus(audioFocusChangeListener,
										AudioManager.STREAM_MUSIC,
										AudioManager.AUDIOFOCUS_GAIN);

		// return result
		if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
			callbackContext.success("");
		} else {
			callbackContext.error("");
		}
	}

	private void releaseFocus(CallbackContext callbackContext) {
		int result = audioManager.abandonAudioFocus(audioFocusChangeListener);

		// return result
		if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
			callbackContext.success("");
		} else {
			callbackContext.error("");
		}
	}

	private class AudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener
	{
		@Override
		public void onAudioFocusChange(int focusChange){}
	}
}
