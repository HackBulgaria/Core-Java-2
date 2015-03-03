package pkg4.convert.to.greyscale;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Miglen Evlogiev
 */
public class ConvertToGreyscale {
    
public static void convertToGreyscale(String file)
{
	File outfile = new File(file);
        try {
	Image image = ImageIO.read(outfile);
	BufferedImage img = (BufferedImage) image;

	int width =  img.getWidth();
	int height = img.getHeight();
	// Go trought the image px by px
        for (int x = 0; x < width; ++x)
		for (int y = 0; y < height; ++y)
		{
			//Get the RGB color of the pixel, divide the sum by 3 and set it back
                        int color = img.getRGB(x, y);
			color = (((color >> 16) & 0xFF) + ((color >> 8) & 0xFF) + (color & 0xFF)) / 3;
			img.setRGB(x, y, ((color << 16) + (color << 8) + color));
		}

	ImageIO.write(img, "jpg", outfile);
        } catch (IOException e) {
        	e.printStackTrace();
        }        
}    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        convertToGreyscale("C:\\test.jpg");
    }
    
}
