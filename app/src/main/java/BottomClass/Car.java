package BottomClass;

import android.graphics.Color;

public class Car {
    private int Id;//ID
    private Color Color;//颜色
    private String Brand;//品牌
    private String LicensePlateNumber;//车牌号

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public android.graphics.Color getColor() {
        return Color;
    }

    public void setColor(android.graphics.Color color) {
        Color = color;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getLicensePlateNumber() {
        return LicensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        LicensePlateNumber = licensePlateNumber;
    }
}
