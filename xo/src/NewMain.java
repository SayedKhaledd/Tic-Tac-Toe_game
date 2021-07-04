/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Struct;
import java.util.Stack;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author comp
 */
public class NewMain extends Application {

    static boolean player = true;
    String stat1 = "", stat2 = "";
    static int i = 0;
    static Path path = Paths.get("src/jojo.mp3");
    static Media media;
    static MediaPlayer mediaPlayer;
    static File f;

    @Override
    @SuppressWarnings("empty-statement")
    public void start(Stage primaryStage) {
        BorderPane bord = new BorderPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(8);
        Text tx = new Text("Player 1 :");
        Text tx2 = new Text("Player 2 :");

        //----------------------song-----------------------------
    /*    f = new File(path.toString());
        if (f.exists()) {
            System.out.println("yes");
            media = new Media(f.toURI().toString());
            media.setOnError(() -> {
                System.out.println("error 1");
            });
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setOnError(() -> {
                System.out.println("error 2");
            });
            mediaPlayer.setAutoPlay(true);

            mediaPlayer.setVolume(0.5);
        } else {
            System.out.println("no");
        }
*/
//buttons
        Button btn1 = new Button("Player 1");
        Button btn2 = new Button("Player 2");
        Button btn3 = new Button("Done");

//texts
        Text t = new Text("Welcome To X O game");
        t.setId("tt");
        tx.setId("tt");
        tx2.setId("tt");
        Text t3 = new Text("Mute");
        Text t4 = new Text("Esc to close");
        t4.setId("tt");
        t3.setId("tt");
        t3.setOnMousePressed((event) -> {
            if (i % 2 == 0) {
                mediaPlayer.setVolume(0);
                t3.setText("Unmute");
            } else {
                mediaPlayer.setVolume(1);
                t3.setText("mute");
            }
            i++;

        });

        HBox hoba1 = new HBox(10);
        hoba1.getChildren().addAll(t);
        t.setFont(Font.font(20));
        grid.add(hoba1, 2, 0);
        grid.add(tx, 2, 3);
        grid.add(tx2, 2, 4);
        grid.add(btn3, 3, 4);
        grid.add(t3, 3, 5);
        grid.add(t4, 3, 6);

// X and O
        Circle cir = new Circle(20, 10, 10, Color.WHITE);
        HBox hoba = new HBox(10);
        x x1 = new x(0);

        hoba.getChildren().addAll(btn1);
        grid.add(hoba, 2, 1);

//second X and O
        Circle cir2 = new Circle(20, 10, 10, Color.WHITE);
        HBox hoba2 = new HBox(10);
        x x2 = new x(0);

        hoba2.getChildren().addAll(btn2);
        grid.add(hoba2, 2, 2);
//styles:
        cir2.setStroke(Color.GREEN);
        cir.setStroke(Color.GREEN);
        cir.setId("cir");
        x1.setId("m");
        x2.setId("m");
        cir2.setId("cir");

// ----------------------actions------------------
//button Actions:
        btn1.setOnAction((event) -> {
            try {
                hoba.getChildren().addAll(x1, cir);
            } catch (Exception e) {

            }

        });
        btn2.setOnAction((event) -> {
            try {
                hoba2.getChildren().addAll(x2, cir2);
            } catch (Exception e) {

            }

        });
        btn3.setOnAction((event) -> {
            try {
                if ((stat1.equals("O") || stat1.equals("X")) && (stat2.equals("O") || stat2.equals("X"))) {
                    if (!(stat1.equals(stat2))) {
                        the_game game = new the_game(stat1, stat2);
                    } else {
                        tx.setText("choose different choices");
                        tx2.setText("choose different choices");

                    }
                }

            } catch (Exception e) {

            }

        });

//other Actions
        cir.setOnMousePressed((event) -> {

            stat1 = "O";
            tx.setText("Player 1 : " + stat1);
            System.out.println(stat1);
        });
        cir2.setOnMousePressed((event) -> {

            stat2 = "O";
            tx2.setText("Player 2 : " + stat2);

            System.out.println(stat2);
        });
        x1.setOnMousePressed((event) -> {

            stat1 = "X";
            tx.setText("Player 1 : " + stat1);

            System.out.println(stat1);

        });
        x2.setOnMousePressed((event) -> {
            stat2 = "X";
            tx2.setText("Player 2 : " + stat2);

            System.out.println(stat2);
        });

//Postions
        grid.setAlignment(Pos.CENTER);
        bord.setCenter(grid);
        Scene scene = new Scene(bord, 300, 250);
        scene.getStylesheets().add(getClass().getResource("colors.css").toExternalForm());

//closing on ESCAPE
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.ESCAPE) {
                    System.out.println("Key Pressed: " + ke.getCode());
                    System.exit(1);
                }
            }
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
