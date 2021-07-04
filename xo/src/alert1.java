/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author comp
 */
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class alert1 {
    static Path path2 =Paths.get("nani.mp3");
    static Media media2;
    static MediaPlayer mediaPlayer2;

    public alert1(String name) {
        Stage wind = new Stage();
//to not let the user go to another window !!!!!!

        if(NewMain.mediaPlayer !=null){
            NewMain.mediaPlayer.stop();
        }

        File f2=new File(path2.toString());

        if(f2.exists()){
            wind.initModality(Modality.APPLICATION_MODAL);
            media2 = new Media(f2.toURI().toString());
            media2.setOnError(() -> {
                System.out.println("error 1");
            });
            mediaPlayer2 = new MediaPlayer(media2);
            mediaPlayer2.setOnError(() -> {
                System.out.println("error 2");
            });
            mediaPlayer2.setAutoPlay(true);

            mediaPlayer2.setVolume(0.5);


        }
        else{

        }

        VBox h = new VBox(10);
        h.setAlignment(Pos.CENTER);
        Scene s = new Scene(h, 200, 50);
        Label btn = new Label(name);

        s.getStylesheets().add(getClass().getResource("colors_1.css").toExternalForm());
        wind.setOnCloseRequest((event) -> {
            if(NewMain.f!=null && NewMain.f.exists()){
                NewMain.mediaPlayer.play();
                NewMain.mediaPlayer.setVolume(0.5);}
            if(f2.exists()){
                mediaPlayer2.setVolume(0);
            }
        });
        h.getChildren().addAll(btn);
        wind.setTitle("Result");
        wind.setScene(s);
        wind.show();
    }
}
