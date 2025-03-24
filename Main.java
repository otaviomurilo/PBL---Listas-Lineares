import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageManager.clearFolder();
        try {
            FloodFill floodFillStack = new FloodFill("assets/input.png");
            floodFillStack.fillWithStack(200, 150, 0xFF00FF00, 100, 1000);

            FloodFill floodFillQueue = new FloodFill("assets/input.png");
            floodFillQueue.fillWithQueue(200, 150, 0xFFFF0000, 1500);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}