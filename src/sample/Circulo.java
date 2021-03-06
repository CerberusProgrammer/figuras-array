package sample;

import javafx.scene.paint.Color;

public class Circulo extends Figura {

    private String name;
    private int area;
    private int radio;
    private String id;

    public Circulo(int radio) {
        this.id = Controller.arrayList.size() + " - Circulo";
        this.name = "circulo";
        this.area = (int) (Math.PI * Math.pow(radio, 2));
        this.radio = radio;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getArea() {
        return area;
    }

    @Override
    public void setArea(int area) {
        this.area = area;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}
