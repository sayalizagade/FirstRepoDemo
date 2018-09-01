package com.sourcey.materiallogindemo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mac on 30/08/18.
 */

public class Dog {

    @SerializedName("breed")

    public String breed;

    @SerializedName("Colors")
    public String Colors;

    @SerializedName("Life span")
    public String LifeSpan;

    @SerializedName("info")
    public String DogInfo;


    public Dog(){

    }
    public Dog(String breed, String colors, String lifeSpan, String dogInfo) {
        this.breed = breed;
        this.Colors = colors;
        this.LifeSpan = lifeSpan;
        this.DogInfo = dogInfo;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColors() {
        return Colors;
    }

    public void setColors(String colors) {
        Colors = colors;
    }

    public String getLifeSpan() {
        return LifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        LifeSpan = lifeSpan;
    }

    public String getDogInfo() {
        return DogInfo;
    }

    public void setDogInfo(String dogInfo) {
        DogInfo = dogInfo;
    }
}
