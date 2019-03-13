package com.example.alex.dissertation.Model;

public class Lesson {
    private String Name;
    private String Image;

    public Lesson() {
    }

    public Lesson(String name, String image) {
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