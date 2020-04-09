package lodz.uni.math;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

import static lodz.uni.math.Utilities.*;

public class Controller implements Initializable {

    public Canvas screenCanv;
    private GraphicsContext graphicsContext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsContext = screenCanv.getGraphicsContext2D();
        graphicsContext.fillRect(0,0,screenCanv.getWidth(),screenCanv.getHeight());
        fill();
        placeRectangles();
        moveRectangles();
    }

    private void moveRectangles() {
        for(int i=0;i<screenCanv.getWidth();i+=40){
            MovingRectsThread mv = new MovingRectsThread(i, screenCanv, graphicsContext);
            mv.start();
        }

    }

    private void placeRectangles() {
        for(int i=0;i<screenCanv.getWidth();i+=40)
            for(int j=0;j<screenCanv.getHeight();j+=40){
                    if(i == 0){
                        graphicsContext.setFill(Color.BLACK);
                        graphicsContext.fillRect(i,j, Utilities.RECT_WIDTH,Utilities.RECT_HEIGHT);
                        graphicsContext.setFill(Color.BLUE);
                        graphicsContext.fillRect(i,j, Utilities.RECT_WIDTH-1,Utilities.RECT_HEIGHT-1);
                    }
            }
    }

    public void fill(){
        for(int i=0;i<screenCanv.getWidth();i+=40)
            for(int j=0;j<screenCanv.getHeight();j+=40){
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.fillRect(i,j, Utilities.RECT_WIDTH,Utilities.RECT_HEIGHT);
                graphicsContext.setFill(Color.WHITE);
                graphicsContext.fillRect(i,j, Utilities.RECT_WIDTH-1,Utilities.RECT_HEIGHT-1);
            }
    }

}
