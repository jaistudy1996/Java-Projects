/**
 * @author (Jayant Arora)
 */

import edu.duke.*;
import java.io.File;

public class fileiteration
{
    // instance variables - replace the example below with your own
    public ImageResource greyImage(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel px: outImage.pixels()){
            int x = px.getX();
            int y = px.getY();
            Pixel inpx = inImage.getPixel(x, y);
            int average = (inpx.getRed()+inpx.getGreen()+inpx.getBlue())/3;
            px.setRed(average);
            px.setGreen(average);
            px.setBlue(average);
        }        
        return outImage;
    }
    
    public void newName(ImageResource image){
        String oldName = image.getFileName();
        String newName = "gray-"+oldName;
        image.setFileName(newName);
        image.save();
    }
    
    public void file()
    {
        // put your code here
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource original = new ImageResource(f);
            ImageResource grayscale = greyImage(original);
            //newName(file);
           String fname = original.getFileName();
           String newName = "grayscale-" + fname;
           grayscale.setFileName(newName);
           grayscale.draw();
           grayscale.save();
            //System.out.println("New name is: "+ newName);
        }
    }
}
