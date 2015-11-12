package com.capgemini.job.portal.util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;


public final class FileUploadUtil {
	
	
	/**
    This method is used to conver an InputStream into byte array
    */
    private byte[] getImageByteArray(final InputStream inputStream) {
     byte images[] = null;
   try{
       final BufferedImage image = ImageIO.read(inputStream);
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();
       ImageIO.write(image, "jpeg", baos);
       images = baos.toByteArray();
      }catch (final Exception e) {
        e.printStackTrace();
    }
   return images;
 }

}
