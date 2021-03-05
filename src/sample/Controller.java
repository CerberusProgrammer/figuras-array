package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private MenuButton listFigure;
    @FXML
    private MenuButton selectFigure;
    @FXML
    private Label figuraName;
    @FXML
    private Label textoVariable2;
    @FXML
    private Label figuraSeleccionada;
    @FXML
    private Label textoVariable1;
    @FXML
    private Label dato1;
    @FXML
    private Label dato2;
    @FXML
    private Label datos;
    @FXML
    private Label textArea;
    @FXML
    private TextField x;
    @FXML
    private TextField y;
    @FXML
    private TextField valor1;
    @FXML
    private TextField valor2;
    @FXML
    private Button addFig;
    @FXML
    private Button editButton;
    @FXML
    private TextField inputEliminar;
    @FXML
    private Pane dibujo;
    @FXML
    private TextField valorArea;
    @FXML
    private Button buttonDelete;

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

    void displayMessage(String header, String content, Alert.AlertType alert) {
        Alert adminLoginFailedAlert = new Alert(alert);
        DialogPane dialogPane = adminLoginFailedAlert.getDialogPane();
        adminLoginFailedAlert.setTitle("Aviso");
        adminLoginFailedAlert.setHeaderText(header);
        adminLoginFailedAlert.setContentText(content);
        adminLoginFailedAlert.showAndWait();
    }

    @FXML
    void addFigure(ActionEvent event) {
        if (x.getText().isEmpty() && x.isVisible() || y.getText().isEmpty() && y.isVisible()) {
            displayMessage("Falta de datos.", "Ingrese los valores sin dejar los campos vacios.",
                    Alert.AlertType.ERROR);
            return;
        }

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
                offDisplay();
                Figura figura = arrayList.get(Integer.parseInt(item.getId()));
                figuraName.setText(((MenuItem)event.getSource()).getText());
                figuraName.setVisible(true);

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
                        dato2.setText("Altura");
                        dato2.setVisible(true);

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
                        dato2.setText("Altura");
                        dato2.setVisible(true);

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
                editButton.setVisible(true);
                datos.setVisible(true);
                dato1.setVisible(true);
                valor1.setVisible(true);
                textArea.setVisible(true);
                valorArea.setVisible(true);
                dibujo.setVisible(true);
                inputEliminar.setVisible(true);
                buttonDelete.setVisible(true);
            }
        });

        listFigure.getItems().add(item);
        listFigure.setDisable(false);
        offPanel();
        selectFigure.setDisable(false);
        displayMessage("Figura creada.", "Figura creada correctamente.", Alert.AlertType.INFORMATION);
    }

    @FXML
    void editValue(ActionEvent event) {
        int index = Integer.parseInt(figuraName.getText().substring(0, 1)) - 1;
        String figure = figuraName.getText().substring(4);

        arrayList.remove(index);

        switch (figure) {
            case "Circulo":
                arrayList.add(index, new Circulo(Integer.parseInt(valor1.getText())));
                break;
            case "Cuadrado":
                arrayList.add(index, new Cuadrado(Integer.parseInt(valor1.getText())));
                break;
            case "Rectangulo":
                arrayList.add(index, new Rectangulo(Integer.parseInt(valor1.getText()),
                        Integer.parseInt(valor2.getText())));
                break;
            case "Triangulo":
                arrayList.add(index, new Triangulo(Integer.parseInt(valor1.getText()),
                        Integer.parseInt(valor2.getText())));
                break;
        }
        valorArea.setText("" + arrayList.get(index).getArea());
        displayMessage("Datos Modificados.", "Los datos han sido editados correctamente.",
                Alert.AlertType.INFORMATION);
    }

    @FXML
    void eliminarFigura(ActionEvent event) {
        int index = 0;
        String figura = "";
        try {
            index = Integer.parseInt(inputEliminar.getText().substring(0, 1)) - 1;
            figura = inputEliminar.getText().substring(2);
        } catch (Exception e) {
            displayMessage("Error", "Error en la entrada de datos, verifique el metodo de entrada de eliminacion.",
                    Alert.AlertType.ERROR);
            return;
        }

        int x = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getName().equals(figura)) {
                if (index == x) {
                    arrayList.remove(i);
                    listFigure.getItems().remove(i);
                    offDisplay();
                    displayMessage("Figura Eliminada", "Figura eliminada de forma correcta.",
                            Alert.AlertType.INFORMATION);
                    return;
                }
                x++;
            }
        }
        displayMessage("Figura no encontrada", "La figura no se ha encontrado, verifique los datos.",
                Alert.AlertType.ERROR);
    }

    public void onlyNumbers(KeyEvent keyEvent) {
        char key = keyEvent.getCharacter().charAt(0);

        if (!Character.isDigit(key))
            keyEvent.consume();
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
        inputEliminar.setVisible(false);
        buttonDelete.setVisible(false);
        editButton.setVisible(false);
        figuraName.setVisible(false);
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
        offPanel();
        offDisplay();
        buttonDelete.setTooltip(new Tooltip("Para eliminar una figura, debes colocar el numero de la figura pero\n" +
                "en orden de su tipo de figura, es decir 3 Circulo, sera el tercer circulo, no el tercero de la lista,\n" +
                " y despues su nombre. \n\n Ejemplo: [0-9] ['NOMBRE'] = 1 circulo."));
    }
}
