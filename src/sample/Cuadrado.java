package sample;

import javafx.scene.paint.Color;

public class Cuadrado extends Figura {

    private String name;
    private int area;
    private int lado;

    public Cuadrado(int lado) {
        this.name = "cuadrado";
        this.area = lado * lado;
        this.lado = lado;
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

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }
}
