package com.nvv.itstep.hw.d28082021;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main2 {
    public static void main(String[] args) {
//        создать папку в проекте для картинок.
//        поместить в эту папку картинку.
//                програмным образом сделать копию этой картинки в эту же папку.

        final String res = "https://zurich.itstep.org/dist/images/courses-adult/design/training3.jpg";
        final String nDir = "." + File.separator + "tasks";
        final String nameOrgImg = File.separator + "original";
        final String extImg = ".jpg";
        final String imgOriginal = nDir + nameOrgImg + extImg;

        File dir = new File(nDir);
        boolean isDirExist = dir.mkdir();


        if (isDirExist) {
            URL url = null;
            byte[] response = null;
            try {
                url = new URL(res);

                InputStream in = null;
                try {
                    in = new BufferedInputStream(url.openStream());

                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    int n = 0;
                    while (true) {
                        try {
                            if (!(-1 != (n = in.read(buf)))) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if(out !=null){
                                    out.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (n > 0) {
                            out.write(buf, 0, n);
                        }
                    }
                    response = out.toByteArray();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(in!=null){
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            if (response != null) {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(imgOriginal);
                    try {
                        fos.write(response);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(fos != null){
                            fos.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            if(Files.exists(Path.of(imgOriginal))){
                try {
                    BufferedImage bi = ImageIO.read(new File(imgOriginal));
                    ImageIO.write(bi, "jpg", new File( nDir + File.separator + "copy" + extImg));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
