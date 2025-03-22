import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FloodFill {
    private BufferedImage image;
    private int width;
    private int height;

    public FloodFill(String imagePath) throws IOException {
        image = ImageIO.read(new File(imagePath));
        width = image.getWidth();
        height = image.getHeight();
    }

    // ========== IMPLEMENTAÇÃO COM PILHA (DFS) ========== //
    public void fillWithStack(int initX, int initY, int newColour, int transitionInterval) throws IOException {
        try {
            int initColour = image.getRGB(initX, initY);

            Stack<int[]> stack = new Stack<>();
            stack.stackPush(new int[]{ initX, initY });
            int pixelsModified = 0;

            while (!stack.isEmpty()) {
                int[] pixel = stack.stackPop();
                int x = pixel[0];
                int y = pixel[1];

                if (isValidPixel(x, y, initColour)) {
                    image.setRGB(x, y, newColour);
                    pixelsModified++;

                    // Adiciona vizinhos (ordem inversa para garantir DFS)
                    stack.stackPush(new int[]{ x + 1, y });
                    stack.stackPush(new int[]{ x - 1, y });
                    stack.stackPush(new int[]{ x, y + 1 });
                    stack.stackPush(new int[]{ x, y - 1 });

                    // Salva transição
                    if (pixelsModified % transitionInterval == 0) {
                        ImageManager.saveTransitionImage(image, "stack_transition_" + pixelsModified + ".png");
                    }
                }
            }
            ImageManager.saveFinalImage(image, "output_stack.png");
        } catch (ArrayIndexOutOfBoundsException e) {
            indexOutOfBounds();
        }
    }

    // ========== IMPLEMENTAÇÃO COM FILA (BFS) ========== //
    public void fillWithQueue(int initX, int initY, int newColour, int transitionInterval) throws IOException {
        try {
            int initColour = image.getRGB(initX, initY);

            Queue<int[]> queue = new Queue<>();
            queue.queuePush(new int[]{ initX, initY });
            int pixelsModified = 0;

            while (!queue.isEmpty()) {
                int[] pixel = queue.queuePop();
                int x = pixel[0];
                int y = pixel[1];

                if (isValidPixel(x, y, initColour)) {
                    image.setRGB(x, y, newColour);
                    pixelsModified++;

                    // Adiciona vizinhos (ordem normal para garantir BFS)
                    queue.queuePush(new int[]{ x + 1, y });
                    queue.queuePush(new int[]{ x - 1, y });
                    queue.queuePush(new int[]{ x, y + 1 });
                    queue.queuePush(new int[]{ x, y - 1 });

                    // Salva transição
                    if (pixelsModified % transitionInterval == 0) {
                        ImageManager.saveTransitionImage(image, "queue_transition_" + pixelsModified + ".png");
                    }
                }
            }
            ImageManager.saveFinalImage(image, "output_queue.png");
        } catch (ArrayIndexOutOfBoundsException e) {
            indexOutOfBounds();
        }
    }

    // ========== MÉTODOS AUXILIARES ========== //
    private boolean isValidPixel(int x, int y, int initColour) {
        return x >= 0 && x < width &&
                y >= 0 && y < height &&
                image.getRGB(x, y) == initColour;
    }

    private void indexOutOfBounds() {
        System.out.println("Erro: Coordenadas fora dos limites da imagem!");
        System.out.println("Dimensões válidas: 0 <= X < " + width + ", 0 <= Y < " + height);
    }
}