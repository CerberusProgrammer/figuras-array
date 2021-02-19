package sample;

import javafx.scene.paint.Color;

public class Circulo {

    private int area;
    private int radio;

    public Circulo(int radio) {
        this.area = (int) (Math.PI * Math.pow(radio, 2));
        this.radio = radio;
    }

    public int getArea() {
        return area;
    }

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
