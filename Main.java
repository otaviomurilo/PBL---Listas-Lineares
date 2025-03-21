import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ImageManager.clearFolder();
        try {
            FloodFill floodFill = new FloodFill("assets/input.png");
            floodFill.fillWithStack(400, 250, 0xFFFF0000, 15000); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
