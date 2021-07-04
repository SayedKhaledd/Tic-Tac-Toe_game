
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author comp
 */
public class o extends GridPane {

    public o(int x) {
        Circle cir = new Circle(x);
        cir.setId("cir");

        add(cir, 0, 0);
    }
}
