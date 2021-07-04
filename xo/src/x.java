/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 *
 * @author comp
 */
public class x extends GridPane {
    public  x(int x ){
        Line l1=new Line(20,20,10+x,10-x);
        l1.setStrokeWidth(5);

        l1.setStroke(Paint.valueOf("#513F68"));
        Line l2=new Line(20,10,10+x,20+x);
        l2.setStrokeWidth(5);
        l2.setStroke(Paint.valueOf("#513F68"));


        add(l1, 0, 0);
        add(l2, 0, 0);
    }
}