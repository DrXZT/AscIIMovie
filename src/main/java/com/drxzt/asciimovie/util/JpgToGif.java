package com.drxzt.asciimovie.util;


import java.awt.image.BufferedImage;

/**
 * className JpgToGif
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/5/27 20:38
 */


public class JpgToGif {


    public synchronized void jpgToGif(BufferedImage src[] , String newPic) {
        try {
            AnimatedGifEncoder  e = new AnimatedGifEncoder ();
            e.setRepeat(0);
            e.start(newPic);
            for (int i = 0; i < src.length; i++) {
                if(i%8==0) continue;
                e.setDelay(80); //设置每帧时间
                e.addFrame(src[i]);
            }
            e.finish();
        } catch (Exception e) {
            System.out.println( "jpgToGif Failed:");
            e.printStackTrace();
        }
    }
}
