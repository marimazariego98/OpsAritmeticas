package com.iupanamericano.mariaramirez;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class App extends Application {

    private final DecimalFormat fmt = new DecimalFormat("#.############");

    @Override
    public void start(Stage stage) {
        // Título (puedes poner tu nombre)
        stage.setTitle("Maria Guadalupe Ramirez Mazariego");

        // ====== Controles ======
        Label lblN1 = new Label("Ingresar número");
        TextField txtN1 = new TextField();
        txtN1.setPromptText("Ej. 45");

        Label lblN2 = new Label("Ingresar número");
        TextField txtN2 = new TextField();
        txtN2.setPromptText("Ej. 68");

        Label lblResultado = new Label("Resultado");
        Label lblValor = new Label(""); // aquí mostramos el resultado

        // Botones de operaciones
        Button btnSuma = botonOp("+");
        Button btnResta = botonOp("-");
        Button btnMult = botonOp("X");
        Button btnDiv  = botonOp("/");

        // Botón reset
        Button btnReset = new Button("RESET");
        btnReset.setPrefWidth(90);
        btnReset.setStyle("-fx-font-weight: bold;");

        // ====== Acciones ======
        btnSuma.setOnAction(e -> operar(txtN1, txtN2, lblValor, (a, b) -> a + b));
        btnResta.setOnAction(e -> operar(txtN1, txtN2, lblValor, (a, b) -> a - b));
        btnMult.setOnAction(e -> operar(txtN1, txtN2, lblValor, (a, b) -> a * b));
        btnDiv.setOnAction(e -> operar(txtN1, txtN2, lblValor, (a, b) -> b == 0 ? null : a / b));

        btnReset.setOnAction(e -> {
            txtN1.clear();
            txtN2.clear();
            lblValor.setText("");
            txtN1.requestFocus();
        });

        // ====== Layout ======
        // Panel de botones en 2x2: (+  -)  (X  /)
        GridPane gpOps = new GridPane();
        gpOps.setHgap(6);
        gpOps.setVgap(6);
        gpOps.add(btnSuma, 0, 0);
        gpOps.add(btnResta, 1, 0);
        gpOps.add(btnMult, 0, 1);
        gpOps.add(btnDiv,  1, 1);
        gpOps.setAlignment(Pos.CENTER);

        // Grid principal imitanto el applet
        GridPane root = new GridPane();
        root.setPadding(new Insets(12));
        root.setHgap(10);
        root.setVgap(12);
        root.setStyle("-fx-background-color: #d9dbe0;"); // gris suave como en la imagen

        // Fila 1
        root.add(lblN1, 0, 0);
        root.add(txtN1, 1, 0);
        root.add(gpOps, 2, 0, 1, 2); // ocupa dos filas a la derecha

        // Fila 2
        root.add(lblN2, 0, 1);
        root.add(txtN2, 1, 1);

        // Fila 3 (resultado + reset a la derecha)
        root.add(lblResultado, 0, 2);
        root.add(lblValor, 1, 2);
        root.add(btnReset, 2, 2);
        GridPane.setHalignment(btnReset, HPos.CENTER);

        // Anchos preferidos para que se vea compacto
        txtN1.setPrefWidth(140);
        txtN2.setPrefWidth(140);
        lblValor.setMinWidth(140);

        Scene scene = new Scene(root, 420, 220);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // Crea botón cuadrado estilo "operación"
    private Button botonOp(String texto) {
        Button b = new Button(texto);
        b.setPrefSize(44, 30);
        b.setStyle(
            "-fx-background-color: linear-gradient(#f5f6f7, #cfd3d6);" +
            "-fx-background-radius: 6;" +
            "-fx-font-weight: bold;"
        );
        return b;
    }

    // Ejecuta operación y muestra el resultado; si hay error, deja vacío o indica mensaje
    private void operar(TextField a, TextField b, Label salida, java.util.function.BiFunction<Double, Double, Double> op) {
        try {
            double x = Double.parseDouble(a.getText().trim());
            double y = Double.parseDouble(b.getText().trim());
            Double r = op.apply(x, y);
            if (r == null) {
                salida.setText("∞ / inválido");
            } else {
                salida.setText(fmt.format(r));
            }
        } catch (NumberFormatException ex) {
            salida.setText("Entrada inválida");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
