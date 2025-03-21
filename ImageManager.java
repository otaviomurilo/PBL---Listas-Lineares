import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class ImageManager {
    private static JFrame frame;
    private static JPanel panel;
    
    public static void displayImage(BufferedImage image){
        if (frame == null) {
            frame = new JFrame("Animação de Flood Fill");
            panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(image, 0, 0, null);
                }
            };
            frame.add(panel);
            frame.setSize(image.getWidth(), image.getHeight());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }else{
            panel.repaint();
        }
    }

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

    public static void saveTransitionImage(BufferedImage image, String fileName) throws IOException {
        try {
            File output = new File("transitions", fileName);  
            output.getParentFile().mkdirs(); 
            ImageIO.write(image, "png", output);
            displayImage(image); 
        } catch (IOException e) {
            System.out.println("Erro ao salvar imagem intermediária: " + e.getMessage());
        }
    }
    

    public static void saveFinalImage(BufferedImage image, String fileName) throws IOException {
        try {
            File outputFile = new File("assets", fileName); 
            outputFile.getParentFile().mkdirs();  
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imagem final salva em: " + outputFile.getPath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar imagem final: " + e.getMessage());
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
