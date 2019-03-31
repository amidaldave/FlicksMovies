package com.example.ronald.flicksmovies.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ronald on 2019-03-31.
 */

public class Config {
    String imageBaseUrl;
    String posterSize;
    public Config(JSONObject object) throws JSONException {
        JSONObject images=object.getJSONObject("images");
        imageBaseUrl=images.getString("secure_base_url");
        JSONArray posterSizeOption =images.getJSONArray("poster_sizes");
        posterSize=posterSizeOption.optString(3,"w342");
    }

    public String getImageUrl(String size,String path){
        return String.format("%s%s%s",imageBaseUrl,size,path);
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }
}
