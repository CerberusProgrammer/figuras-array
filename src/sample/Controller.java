package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private MenuButton listFigure;
    @FXML
    private MenuItem rectangulo;
    @FXML
    private MenuItem triangulo;
    @FXML
    private Label textoVariable2;
    @FXML
    private Label figuraSeleccionada;
    @FXML
    private Label textoVariable1;
    @FXML
    private MenuItem cuadrado;
    @FXML
    private TextField x;
    @FXML
    private TextField y;
    @FXML
    private MenuItem circulo;
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

    ArrayList<Object> arrayList = new ArrayList<>();

    @FXML
    void selectFigure(ActionEvent event) {
        System.out.println(((MenuItem) event.getSource()).getId());
        switch (((MenuItem) event.getSource()).getId()) {
            case "circulo":
                figuraSeleccionada.setVisible(true);
                figuraSeleccionada.setText("Circulo");

                textoVariable1.setVisible(true);
                textoVariable1.setText("Ingrese el radio:");

                x.setVisible(true);
                addFig.setVisible(true);
                break;
            case "cuadrado":
                break;
            case "rectangulo":
                break;
            case "triangulo":
                break;
        }
    }


    @FXML
    void addFigure(ActionEvent event) {
        switch (figuraSeleccionada.getText()){
            case "circulo":
                arrayList.add(new Circulo(Integer.parseInt(x.getText())));
                break;
            case "cuadrado":
                arrayList.add(new Cuadrado(Integer.parseInt(x.getText())));
                break;
            case "rectangulo":
                arrayList.add(new Rectangulo(Integer.parseInt(x.getText()), Integer.parseInt(y.getText())));
                break;
            case "triangulo":
                arrayList.add(new Triangulo(Integer.parseInt(x.getText()), Integer.parseInt(y.getText())));
                break;
        }
        MenuItem item = new MenuItem(arrayList.size() + " - "+ figuraSeleccionada.getText());
        item.setId("" + (arrayList.size() - 1));
        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        listFigure.getItems().add(item);
        offPanel();
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
    }
}
