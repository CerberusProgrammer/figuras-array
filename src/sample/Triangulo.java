package sample;

import javafx.scene.paint.Color;

public class Triangulo extends Figura {

    private String name;
    private int area;
    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.name = "triangulo";
        this.area = base * (altura / 2);
        this.base = base;
        this.altura = altura;
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
