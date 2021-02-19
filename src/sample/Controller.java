package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private MenuButton listFigure;
    @FXML
    private MenuButton selectFigure;
    @FXML
    private Label textoVariable2;
    @FXML
    private Label figuraSeleccionada;
    @FXML
    private Label textoVariable1;
    @FXML
    private TextField x;
    @FXML
    private TextField y;
    @FXML
    private Button addFig;
    @FXML
    private Label dato1;
    @FXML
    private Label dato2;
    @FXML
    private Label datos;
    @FXML
    private TextField valor1;
    @FXML
    private TextField valor2;
    @FXML
    private Pane dibujo;
    @FXML
    private TextField valorArea;
    @FXML
    private Label textArea;

    ArrayList<Figura> arrayList = new ArrayList<>();

    @FXML
    void selectFigure(ActionEvent event) {
        offDisplay();
        listFigure.setDisable(true);
        textoVariable1.setText("Ingrese la base:");
        figuraSeleccionada.setText(((MenuItem)event.getSource()).getId());
        switch (((MenuItem) event.getSource()).getId()) {
            case "Circulo":
                textoVariable1.setText("Ingrese el radio:");
                break;
            case "Rectangulo":
            case "Triangulo":
                textoVariable2.setVisible(true);
                textoVariable2.setText("Ingrese la altura:");

                y.setVisible(true);
                break;
        }
        x.setVisible(true);
        figuraSeleccionada.setVisible(true);
        textoVariable1.setVisible(true);
        addFig.setVisible(true);
        selectFigure.setDisable(true);
    }

    @FXML
    void addFigure(ActionEvent event) {
        switch (figuraSeleccionada.getText()){
            case "Circulo":
                arrayList.add(new Circulo(Integer.parseInt(x.getText())));
                break;
            case "Cuadrado":
                arrayList.add(new Cuadrado(Integer.parseInt(x.getText())));
                break;
            case "Rectangulo":
                arrayList.add(new Rectangulo(Integer.parseInt(x.getText()), Integer.parseInt(y.getText())));
                break;
            case "Triangulo":
                arrayList.add(new Triangulo(Integer.parseInt(x.getText()), Integer.parseInt(y.getText())));
                break;
        }

        MenuItem item = new MenuItem(arrayList.size() + " - "+ figuraSeleccionada.getText());
        item.setId("" + (arrayList.size() - 1));

        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Figura figura = arrayList.get(Integer.parseInt(item.getId()));

                dato1.setText("Base:");
                valorArea.setText("" + figura.getArea());

                if (!dibujo.getChildren().isEmpty())
                    dibujo.getChildren().remove(0);

                switch (figura.getName()) {
                    case "circulo":
                        dato1.setText("Radio:");
                        valor1.setText("" + ((Circulo)figura).getRadio());

                        Circle circle = new Circle();
                        circle.setRadius(50);
                        circle.setCenterX(dibujo.getWidth()/2);
                        circle.setCenterY(dibujo.getHeight()/2);
                        dibujo.getChildren().add(circle);
                        break;
                    case "cuadrado":
                        valor1.setText("" + ((Cuadrado)figura).getLado());

                        Rectangle rectangle = new Rectangle();
                        rectangle.setX(dibujo.getWidth()/4);
                        rectangle.setY(dibujo.getHeight()/4);
                        rectangle.setWidth(100);
                        rectangle.setHeight(100);
                        dibujo.getChildren().add(rectangle);
                        break;
                    case "rectangulo":
                        valor1.setText("" + ((Rectangulo)figura).getBase());
                        valor2.setVisible(true);
                        valor2.setText("" + ((Rectangulo)figura).getAltura());

                        Rectangle rectangles = new Rectangle();
                        rectangles.setX(dibujo.getWidth()/4);
                        rectangles.setY(dibujo.getHeight()/3);
                        rectangles.setWidth(100);
                        rectangles.setHeight(75);
                        dibujo.getChildren().add(rectangles);
                        break;
                    case "triangulo":
                        valor1.setText("" + ((Triangulo)figura).getBase());
                        valor2.setVisible(true);
                        valor2.setText("" + ((Triangulo)figura).getAltura());

                        Polygon polygon = new Polygon();
                        polygon.getPoints().addAll(
                                dibujo.getWidth()/2, dibujo.getHeight()/4,
                                dibujo.getWidth()/4 + 100, dibujo.getHeight()/4 + 100,
                                dibujo.getWidth() - 150, dibujo.getHeight()/4 + 100);
                        polygon.setFill(Color.BLACK);
                        polygon.setStroke(Color.BLACK);
                        dibujo.getChildren().add(polygon);
                        break;
                }
                datos.setVisible(true);
                dato1.setVisible(true);
                valor1.setVisible(true);
                textArea.setVisible(true);
                valorArea.setVisible(true);
                dibujo.setVisible(true);
            }
        });

        listFigure.getItems().add(item);
        listFigure.setDisable(false);
        offPanel();
        selectFigure.setDisable(false);
    }

    void offPanel() {
        figuraSeleccionada.setVisible(false);
        textoVariable1.setVisible(false);
        x.setVisible(false);
        textoVariable2.setVisible(false);
        y.setVisible(false);
        addFig.setVisible(false);
    }

    void offDisplay() {
        dato1.setVisible(false);
        dato2.setVisible(false);
        datos.setVisible(false);
        valor1.setVisible(false);
        valor2.setVisible(false);
        dibujo.setVisible(false);
        textArea.setVisible(false);
        valorArea.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figuraSeleccionada.setVisible(false);
        textoVariable1.setVisible(false);
        x.setVisible(false);
        textoVariable2.setVisible(false);
        y.setVisible(false);
        addFig.setVisible(false);
        dato1.setVisible(false);
        dato2.setVisible(false);
        datos.setVisible(false);
        valor1.setVisible(false);
        valor2.setVisible(false);
        dibujo.setVisible(false);
        textArea.setVisible(false);
        valorArea.setVisible(false);
    }
}
