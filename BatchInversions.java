
/**
 * @author (Jayant Arora)
 */

import edu.duke.*;
import java.io.*;

public class BatchInversions
{
    // instance variables - replace the example below with your own
    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel p : inImage.pixels()){
            int x = p.getX();
            int y = p.getY();
            p.setRed(255 - p.getRed());
            p.setGreen(255 - p.getGreen());
            p.setBlue(255 - p.getBlue());
            outImage.setPixel(x, y, p);
        }
        return outImage;
    }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File image : dr.selectedFiles()){
            ImageResource imageSelected = new ImageResource(image);
            ImageResource invertedImage = makeInversion(imageSelected);
            String oldName = imageSelected.getFileName();
            String newName = "inverted-"+oldName;
            invertedImage.setFileName(newName);
            invertedImage.save();
            invertedImage.draw();
        }
    }
}
