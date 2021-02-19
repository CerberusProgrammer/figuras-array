package sample;

import javafx.scene.paint.Color;

public class Triangulo {

    private int area;
    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.area = base * (altura / 2);
        this.base = base;
        this.altura = altura;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
