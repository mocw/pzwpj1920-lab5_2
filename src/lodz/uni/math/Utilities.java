package lodz.uni.math;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Utilities {
    private Utilities() { }
    public static int RECT_WIDTH = 40;
    public static int RECT_HEIGHT = 40;

    public static synchronized void setFill(Color color, GraphicsContext graphicsContext){
        graphicsContext.setFill(color);
    }

    public static synchronized void fillRect(int j, int i, int w, int h, GraphicsContext graphicsContext){
        graphicsContext.fillRect(j,i, w, h);
    }
}
