import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageManager {
    public static BufferedImage loadImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public static void saveImage(BufferedImage image, String filePath) {
        try {
            ImageIO.write(image, "png", new File(filePath));
            System.out.println("Imagem salva em: " + filePath);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
