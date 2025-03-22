import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;

public class FloodFill {
    private BufferedImage image;
    private int width;
    private int height;
    private boolean useStacks;

    public FloodFill(String imagePath) throws IOException{
        image = ImageIO.read(new File(imagePath));
        width = image.getWidth();
        height = image.getHeight();
    }

    public void fillWithStack(int initX, int initY, int newColour, int transitionImg, int transitionInterval) throws IOException {
        try {
            int initColour = image.getRGB(initX, initY);
            
            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{ initX, initY });
            int pixelsModified = 0;
        
            while (!stack.isEmpty()) {
                int[] pixel = stack.pop();
                int x = pixel[0];
                int y = pixel[1];
    
                if (isValidPixel(x, y, initColour)) {
                    image.setRGB(x, y, newColour);
                    pixelsModified++;
                    
                    stack.push(new int[]{ x + 1, y });
                    stack.push(new int[]{ x - 1, y });
                    stack.push(new int[]{ x, y + 1 });
                    stack.push(new int[]{ x, y - 1 });
        
                    if (pixelsModified % transitionInterval == 0) {
                        ImageManager.saveTransitionImage(image, "output_transition_" + pixelsModified + ".png");
                    }
                }
            }
            ImageManager.saveFinalImage(image, "output.png");
        }  catch (ArrayIndexOutOfBoundsException e) {
            indexOutOfBounds();
        }
    }
    
    private boolean isValidPixel(int x, int y, int initColour) {
        if (x < 0 || x >= image.getWidth() || y < 0 || y >= image.getHeight()) {
            return false; 
        }
        
        return image.getRGB(x, y) == initColour; 
    }

    private void indexOutOfBounds() {
        System.out.println("Erro: A coordenada fornecida não existe na imagem.");
        System.out.println("Coordenadas válidas: 0 <= X < " + width + ", 0 <= Y < " + height);
    }

}

