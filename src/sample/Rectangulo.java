package sample;

import javafx.scene.paint.Color;

public class Rectangulo extends Figura{

    private String name;
    private int area;
    private int base;
    private int altura;
    private String id;

    public Rectangulo(int base, int altura) {
        this.id = Controller.arrayList.size() + " - Rectangulo";
        this.name = "rectangulo";
        this.area = base * altura;
        this.base = base;
        this.altura = altura;
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
