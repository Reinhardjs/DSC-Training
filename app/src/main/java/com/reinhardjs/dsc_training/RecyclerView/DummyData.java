package com.reinhardjs.dsc_training.RecyclerView;

public class DummyData {

    private int imageResId;
    private String content;

    public DummyData(int imageResId, String content){
        this.imageResId = imageResId;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getImageResId() {
        return imageResId;
    }
}
