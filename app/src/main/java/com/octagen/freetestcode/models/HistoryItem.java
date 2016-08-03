package com.octagen.freetestcode.models;

/**
 * Created by Mohammed Aouf ZOUAG on 03/08/2016.
 */
public class HistoryItem {
    private int id;
    private int image;
    private String time;
    private String date;
    private String category;
    private String serie;
    private String ratio;

    public HistoryItem(int id, int image, String time, String date, String category, String serie, String ratio) {
        this.id = id;
        this.image = image;
        this.time = time;
        this.date = date;
        this.category = category;
        this.serie = serie;
        this.ratio = ratio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "HistoryItem{" +
                "id=" + id +
                ", image=" + image +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", serie='" + serie + '\'' +
                ", ratio='" + ratio + '\'' +
                '}';
    }
}
