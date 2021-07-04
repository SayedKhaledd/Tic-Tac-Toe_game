/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Struct;
import java.util.Stack;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author comp
 */
public class the_game {
    static int i,j;
    static int counter = 0;
    static String stat1, stat2;
    static Stage wind;
    static Scene scene;
    public the_game(String stat1, String stat2) throws InterruptedException {
        this.stat1 = stat1;
        this.stat2 = stat2;

        wind = new Stage();
        BorderPane root = new BorderPane();
        StackPane[] h1 = new StackPane[9];
        scene = new Scene(root, 300, 300);
        scene.getStylesheets().add(getClass().getResource("colors_1.css").toExternalForm());
        wind.setScene(scene);
        HBox h = new HBox();
        HBox h2 = new HBox();
        HBox h3 = new HBox();
        Rectangle r[] = new Rectangle[9];

// ------------the shape-------------------------
        for (int s = 0; s < 9; s++) {
            r[s] = new Rectangle(100, 100, Color.AQUA);
            r[s].setId("tt");
            h1[s] = new StackPane();
            h1[s].setId("tt");
            r[s].setStroke(Color.BLACK);
            if (s < 3) {
                h1[s].getChildren().add(r[s]);
                h.getChildren().add(h1[s]);

            } else if (s < 6) {
                h1[s].getChildren().add(r[s]);
                h2.getChildren().add(h1[s]);

            } else {
                h1[s].getChildren().add(r[s]);
                h3.getChildren().add(h1[s]);

            }

        }
        root.setBottom(h3);
        root.setCenter(h2);
        root.setTop(h);
        //closing on ESCAPE

// ------------------------------- the game -----------------------------------
        for ( i = 0; i < 9; i++) {
            check(i, r, h1);

        }
//the window
        wind.initStyle(StageStyle.TRANSPARENT);
        wind.setTitle("Hello World!");
        wind.initModality(Modality.APPLICATION_MODAL);
        wind.show();

//---------------------	scene actions---------
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.ESCAPE) {
                    System.out.println("Key Pressed: " + ke.getCode());
                    wind.close();
                }
            }
        });
        scene.setOnMouseClicked((event2) -> {

            counter++;

        });
    }

    public static void check(int i, Rectangle[] r, StackPane[] h1) {

        if(!r[i].isPressed()){
            r[i].setOnMousePressed((event) -> {
                        draw(i, r, h1);


                        if (XO.checkx() && !XO.checko()){
                            System.out.println("win");

                            if(stat1.equals("X")){
                                alert1 a = new alert1("Player 1 (x) won!!");
                            }  else if(stat2.equals("X")){
                                alert1 a = new alert1("Player 2 (X) won!!");
                            }
                            wind.close();
                            clear();}
                        else if(XO.checko()&&!XO.checkx()){
                            System.out.println("win");
                            if(stat1.equals("O")){
                                alert1 a = new alert1("Player 1 (o) won!!");
                            }  else if(stat2.equals("O")){
                                alert1 a = new alert1("Player 2 (o) won!!");
                            }

                            wind.close();
                            clear();

                        }
                        else if (!XO.checkx() && full()&&!XO.checko()) {

                            alert1 a = new alert1("Draw !!!");
                            wind.close();
                            clear();

                        }

                        j++;
                    }

            );}
    }

    public static void draw(int i, Rectangle[] r, StackPane[] h1) {
        if (counter % 2 == 0 && stat1.equals("X")) {
            x v = new x(50);
            v.setAlignment(Pos.CENTER);
            h1[i].getChildren().add(v);
            if (i < 3) {
                XO.x[0][i] = 'X';
            } else if (i < 6) {
                XO.x[1][i - 3] = 'X';
            } else {
                XO.x[2][i - 6] = 'X';
            }
        }
        if (counter % 2 != 0 && stat2.equals("O")) {
            o p = new o(40);
            p.setAlignment(Pos.CENTER);
            h1[i].getChildren().add(p);

            if (i < 3) {
                XO.x[0][i] = 'O';
            } else if (i < 6) {
                XO.x[1][i - 3] = 'O';
            } else {
                XO.x[2][i - 6] = 'O';
            }
        }
        if (counter % 2 == 0 && stat1.equals("O")) {
            o p = new o(40);
            p.setAlignment(Pos.CENTER);
            h1[i].getChildren().add(p);

            if (i < 3) {
                XO.x[0][i] = 'O';
            } else if (i < 6) {
                XO.x[1][i - 3] = 'O';
            } else {
                XO.x[2][i - 6] = 'O';
            }
        }
        if (counter % 2 != 0 && stat2.equals("X")) {
            x v = new x(50);
            v.setAlignment(Pos.CENTER);
            h1[i].getChildren().add(v);

            if (i < 3) {
                XO.x[0][i] = 'X';
            } else if (i < 6) {
                XO.x[1][i - 3] = 'X';
            } else {
                XO.x[2][i - 6] = 'X';
            }
        }
    }

    public static void clear() {

        for (int k = 0; k < 3; k++) {

            for (int c = 0; c < 3; c++) {
                XO.x[k][c] = '\0';
            }
        }
        i=0;
    }

    public static boolean full() {
        for (int k = 0; k < 3; k++) {

            for (int c = 0; c < 3; c++) {
                if (XO.x[k][c] == '\0') {
                    return false;
                };
            }
        }
        return true;
    }

}
