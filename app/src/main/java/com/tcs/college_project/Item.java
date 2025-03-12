package com.tcs.college_project;
public class Item {
    private String name;
    private String Category;
    private int image;
    private int count;

    public Item(String name, String Category, int image) {
        this.name = name;
        this.Category = Category;
        this.image = image;
        this.count = 0; // Default count is 0
    }

    public String getName() { return name; }
    public String getCategory() { return Category; }
    public int getImage() { return image; }
    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }
}