package com.example.alex.dissertation.Model;

public class Walkthrough {
    private String Name;
    private String Image;

    public Walkthrough() {
    }

    public Walkthrough(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

