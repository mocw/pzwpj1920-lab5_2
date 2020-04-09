package lodz.uni.math;

import com.sun.prism.Graphics;
import com.sun.webkit.network.Util;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class MovingRectsThread extends Thread {

    private int row;
    private double time = (Math.random() * ((4000 - 1000) + 1)) + 1000;
    private static Random rand = new Random();
    private Canvas screenCanv;
    private GraphicsContext graphicsContext;

    public MovingRectsThread(int l, Canvas c, GraphicsContext gc) {
        this.row = l;
        this.screenCanv = c;
        this.graphicsContext = gc;
    }

    @Override
    public void run(){
            for(int i=0;i<screenCanv.getWidth();i+=40)
                for(int j=0;j<screenCanv.getHeight();j+=40){
                    if(i == row){
                        Utilities.setFill(Color.BLACK, graphicsContext);
                        Utilities.fillRect(j, i, Utilities.RECT_WIDTH,Utilities.RECT_HEIGHT, graphicsContext);
                        Utilities.setFill(Color.WHITE, graphicsContext);
                        Utilities.fillRect(j, i, Utilities.RECT_WIDTH-1,Utilities.RECT_HEIGHT-1, graphicsContext);

                        Utilities.setFill(Color.BLACK, graphicsContext);
                        Utilities.fillRect((j+40) < screenCanv.getHeight() ? j+40 : j,i, Utilities.RECT_WIDTH,Utilities.RECT_HEIGHT, graphicsContext);
                        Utilities.setFill(Color.RED, graphicsContext);
                        Utilities.fillRect((j+40) < screenCanv.getHeight() ? j+40 : j,i, Utilities.RECT_WIDTH-1,Utilities.RECT_HEIGHT-1, graphicsContext);
                            try {
                                Thread.sleep((long) time);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }
                }
    }
}
