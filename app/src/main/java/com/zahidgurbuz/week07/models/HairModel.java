package com.zahidgurbuz.week07.models;

import android.graphics.Color;

public class HairModel {
    String title, url;
    int color;
    //if there is only title (not url), consider this as a header
    boolean isHeader;

    public HairModel(String title, String url, int color) {
        this.title = title;
        this.url = url;
        this.color = color;
        this.isHeader = false; //if there is a url return false
    }
    public HairModel(String title, int color) {
        this.title = title;
        this.url = null;
        this.color = color;
        this.isHeader = true; //if there is no url coming, return true
    }

    public String getTitle() { return title;  }
    public String getUrl() {   return url;    }
    public int getColor() {    return color;    }
    public boolean getIsHeader() { return isHeader;   }
}
