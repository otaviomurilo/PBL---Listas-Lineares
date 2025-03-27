import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageManager.clearFolder();
        try {
            FloodFill floodFillStack = new FloodFill("assets/input.png", true);
            floodFillStack.fillWithStack(200, 150, 0xFF00FF00, 1000);
            
            FloodFill floodFillQueue = new FloodFill("assets/input.png", false);
            floodFillQueue.fillWithQueue(200, 150, 0xFF00FF00, 1000); 
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}