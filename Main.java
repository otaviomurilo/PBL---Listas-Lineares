import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ImageManager.clearFolder();
        try {
            FloodFill floodFillStack = new FloodFill("assets/input.png");
            // 4 argumentos: x, y, cor, intervalo de transição
            floodFillStack.fillWithStack(200, 150, 0xFF00FF00, 500);

            FloodFill floodFillQueue = new FloodFill("assets/input.png");
            // 4 argumentos: x, y, cor, intervalo de transição
            floodFillQueue.fillWithQueue(200, 150, 0xFFFF0000, 500);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}