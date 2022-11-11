package fi.tetaka.imagesplitter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSplitter {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("ERROR\nYou need to give 3 arguments: input_dir rows cols");
            return;
        }
        String inputPath;
        String outputPath;
        int rows;
        int cols;
        try {
            inputPath = args[0];
            outputPath = inputPath.substring(0,inputPath.lastIndexOf("\\")+1);
            rows = Integer.parseInt(args[1]);
            cols = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("ERROR\nIllegal parameters! Example parameters: C:\\imagefolder\\ 1 2 ");
            return;
        }
        try {
            final BufferedImage source = ImageIO.read(new File(inputPath));
            int imageWidth = source.getWidth();
            int imageHeight = source.getHeight();;
            int subImageWidth = imageWidth / cols;
            int subImageHeight = imageHeight / rows;
            int index = 0;
            for (int y = 0; y < imageHeight; y += subImageHeight) {
                for (int x = 0; x < imageWidth; x += subImageWidth){
                    ImageIO.write(source.getSubimage(x, y, subImageWidth, subImageHeight), "png", new File(outputPath + index++ + ".png"));
                }
            }
        } catch (IOException e) {
            System.out.println("Something's Fucky! \n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Something's Fucky! \n" +e.getMessage());
        }
    }
}

