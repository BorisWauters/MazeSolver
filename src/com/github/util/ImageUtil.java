package com.github.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

    private ImageUtil() {
        // static util class
    }

    public static Color[][] loadImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int height = image.getHeight();
        int width = image.getWidth();

        Color[][] colorMatrix = new Color[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = image.getRGB(i, j);
                colorMatrix[i][j] = new Color(rgb);
            }
        }

        return colorMatrix;
    }

    public static void writeImage(Color[][] colorMatrix, String path) {
        int width = colorMatrix.length;
        int height = colorMatrix[0].length;

        BufferedImage image = new BufferedImage(width, height, 1);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = colorMatrix[i][j].getRGB();
                image.setRGB(i, j, rgb);
                colorMatrix[i][j] = new Color(rgb);
            }
        }
        try {
            ImageIO.write(image , "png", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
