package com.ung.galleryrefresh;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;


/**
 * This class echoes a string called from JavaScript.
 */
public class GalleryRefresh extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
          if (action.equals("refresh")) {
          cordova.getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(filePath))));            
          callbackContext.success("Gallery successfully updated for provided path");
          return true;
        } catch (Exception e) {
          callbackContext.error(e.getMessage());
          return false;
        }
    }
}
