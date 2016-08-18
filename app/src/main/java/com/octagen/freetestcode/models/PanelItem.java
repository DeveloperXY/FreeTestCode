package com.octagen.freetestcode.models;

/**
 * Created by Mohammed Aouf ZOUAG on 18/08/2016.
 */
public class PanelItem {
    private int image;

    public PanelItem(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PanelItem{" +
                "image=" + image +
                '}';
    }
}
