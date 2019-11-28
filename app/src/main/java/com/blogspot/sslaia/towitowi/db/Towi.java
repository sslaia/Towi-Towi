package com.blogspot.sslaia.towitowi.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "towi_table")
public class Towi {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String label;
    private String body;
//    private int image;
//    private boolean uploaded;

//    @Ignore
//    public Towi(String title, String label, String body, int image, boolean uploaded) {
//        this.title = title;
//        this.label = label;
//        this.body = body;
//        this.image = image;
//        this.uploaded = uploaded;
//    }

    public Towi(String title, String label, String body) {
        this.title = title;
        this.label = label;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getLabel() {
        return label;
    }

    public String getBody() {
        return body;
    }

//    public int getImage() {
//        return image;
//    }
//
//    public boolean isUploaded() {
//        return uploaded;
//    }

}
