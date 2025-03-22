import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ImageManager.clearFolder();
        try {
            FloodFill floodFill = new FloodFill("assets/input.png");
            floodFill.fillWithStack(200, 150, 0xFF00FFF0, 500, 700); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
