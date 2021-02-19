package sample;

import javafx.scene.paint.Color;

public class Rectangulo {

    private int area;
    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.area = base * altura;
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
