package com.immoc.servlet;

public class Food {
    /**
     * id
     * 菜名
     * 口味
     * 图片
     * 价格
     * 描述
     */
    private int id;
    private String name;
    private String taste;
    private String url;
    private Double price;
    private String describe;

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }
}
