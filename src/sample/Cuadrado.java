package sample;

import javafx.scene.paint.Color;

public class Cuadrado {

    private int area;
    private int lado;

    public Cuadrado(int lado) {
        this.area = lado * lado;
        this.lado = lado;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
}
