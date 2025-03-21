import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FloodFill floodFill = new FloodFill("assets/image.png");
            floodFill.fillWithStack(50, 50, 0xFFFF0000, 15000); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
