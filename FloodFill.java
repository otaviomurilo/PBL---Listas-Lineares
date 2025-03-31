    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    import javax.imageio.ImageIO;

    public class FloodFill {
        private BufferedImage image;
        private int width;
        private int height;
        private boolean isStack = false;

        public FloodFill(String imagePath, boolean useStack) throws IOException {
            image = ImageIO.read(new File(imagePath));
            width = image.getWidth();
            height = image.getHeight();
            this.isStack = useStack;
        }

        public void fillWithStack(int initX, int initY, int newColour, int transitionInterval) throws IOException {
            if (!isStack) {
                System.out.println("Erro: instância criada para usar Queue, não Stack!");
                return;
            }

            try {
                int initColour = image.getRGB(initX, initY); //cor inicial do pixel
                
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{ initX, initY }); //add o pixel inicial a stack instanciada
                int pixelsModified = 0;
            
                while (!stack.isEmpty()) {
                    int[] pixel = stack.pop();
                    int x = pixel[0];
                    int y = pixel[1];
        
                    if (isValidPixel(x, y, initColour)) { //verifica se o pixel tem a mesma cor que o pixel inicial
                        image.setRGB(x, y, newColour); //modifica a cor
                        pixelsModified++;
                        
                        stack.push(new int[]{ x + 1, y }); //direita
                        stack.push(new int[]{ x - 1, y }); // esquerda
                        stack.push(new int[]{ x, y + 1 }); // abaixo
                        stack.push(new int[]{ x, y - 1 }); // acima
            
                        if (pixelsModified % transitionInterval == 0) { //a cada x pixels modificados salva uma imagem de transição
                            ImageManager.saveTransitionImage(image, "output_transition_" + pixelsModified + ".png");
                        }
                    }
                }
                ImageManager.saveFinalImage(image, "output_stack.png");
            } catch (ArrayIndexOutOfBoundsException e) {
                indexOutOfBounds();
            }
        }

        public void fillWithQueue(int initX, int initY, int newColour, int transitionInterval) throws IOException {
            if (isStack) {
                System.out.println("Erro: instância criada para usar Stack, não Queue!");
                return;
            }
            try {
                int initColour = image.getRGB(initX, initY);

                Queue<int[]> queue = new Queue<>();
                queue.enqueue(new int[]{ initX, initY });
                int pixelsModified = 0;

                while (!queue.isEmpty()) {
                    int[] pixel = queue.dequeue();
                    int x = pixel[0];
                    int y = pixel[1];

                    if (isValidPixel(x, y, initColour)) {
                        image.setRGB(x, y, newColour);
                        pixelsModified++;

                        queue.enqueue(new int[]{ x + 1, y });
                        queue.enqueue(new int[]{ x - 1, y });
                        queue.enqueue(new int[]{ x, y + 1 });
                        queue.enqueue(new int[]{ x, y - 1 });

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

    private boolean isValidPixel(int x, int y, int initColour) {
        return x >= 0 && x < width && //x está dentro das coordenadas da img
                y >= 0 && y < height && //y está dentro das coordenadas da img
                image.getRGB(x, y) == initColour; //se x e y são das mesmas cores que as coordenadas iniciais
    }

    private void indexOutOfBounds() {
        System.out.println("Erro: Coordenadas fora dos limites da imagem!");
        System.out.println("Dimensões válidas: 0 <= X < " + width + ", 0 <= Y < " + height);
    }
}
