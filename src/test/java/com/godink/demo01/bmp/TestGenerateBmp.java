package com.godink.demo01.bmp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

/**
 * 生成bmp 图片文件
 * 参考文章：https://www.w3cschool.cn/java/codedemo-484049295.html
 * @ClassName: TestGenerateBmp 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年10月18日 下午2:02:49
 */
class TestGenerateBmp {

	@Test
	void test() {
        BufferedImage img = map( 320, 160 );
//      String pathToSave = "D:\\tmp\\testbmp\\result_bmp\\test_white.bmp";
        String pathToSave = "D:\\tmp\\testbmp\\result_bmp\\test_red.bmp";
        savePNG( img, pathToSave);
	}
	
    private BufferedImage map( int sizeX, int sizeY ){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
//              res.setRGB(x, y, Color.WHITE.getRGB() );//白色背景
                res.setRGB(x, y, Color.RED.getRGB() );//红色背景
            }
        }
        return res;
    }
	
    private void savePNG( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));//生成bmp格式图片
            //ImageIO.write(rendImage, "PNG", new File(path));//生成png格式图片
            //ImageIO.write(rendImage, "jpeg", new File(path));//生成jpeg格式图片
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

}
