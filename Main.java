import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ImageManager.clearFolder();
        try {
            FloodFill floodFill = new FloodFill("assets/input.png");
            floodFill.fillWithStack(500, 650, 0xFF00FF00, 500, 700); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
