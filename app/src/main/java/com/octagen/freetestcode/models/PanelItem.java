package com.octagen.freetestcode.models;

/**
 * Created by Mohammed Aouf ZOUAG on 18/08/2016.
 */
public class PanelItem {
    private int id;
    private String arabic;
    private String french;
    private String category;
    private String image;
    private String audio;

    public PanelItem(int id, String arabic, String french, String category, String image, String audio) {
        this.id = id;
        this.arabic = arabic;
        this.french = french;
        this.category = category;
        this.image = image;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    @Override
    public String toString() {
        return "PanelItem{" +
                "id=" + id +
                ", arabic='" + arabic + '\'' +
                ", french='" + french + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", audio='" + audio + '\'' +
                '}';
    }
}
