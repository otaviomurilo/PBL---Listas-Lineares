import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public static void saveIntermediateImage(BufferedImage image, String fileName) throws IOException {
        try {
            File output = new File("transitions", fileName);
    
            ImageIO.write(image, "png", output);
            System.out.println("Imagem intermediária salva em: " + output.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    

    public static void saveFinalImage(BufferedImage image, String fileName) throws IOException {
        try{
            File outputFile = new File("assets/" + fileName);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imagem final salva em: " + fileName);
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void clearFolder(){
        try{
            File folder = new File("transitions");
            File[] files = folder.listFiles();

            if (files != null){
                for (File file : files) {
                    if (file.isFile()){
                        file.delete();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Erro ao limpar a pasta" + e.getMessage());
        }
    }
}
