package com.reinhardjs.dsc_training.Training2;

public class RecyclerViewData {

    String city;
    String temperature;
    int imageResId;

    public RecyclerViewData(String city, String temperature, int imageResId){
        this.city = city;
        this.temperature = temperature;
        this.imageResId = imageResId;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

}
