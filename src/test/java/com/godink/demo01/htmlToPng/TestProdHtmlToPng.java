package com.godink.demo01.htmlToPng;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

import com.godink.springboot.common.demo.utils.FileUtils;

import cn.hutool.core.codec.Base64;
import gui.ava.html.image.generator.HtmlImageGenerator;

/**
 * 正式数据：html表格生成图片
 * @ClassName: TestProdHtmlToPng 
 * @Description: TODO
 * @author: Hong.Chen
 * @date: 2021年10月18日 下午2:34:21
 */
class TestProdHtmlToPng {

	@Test
	void testNoDataFillExcel() throws Exception {
		doNoDataFillExcel();
	}
	
	/**测试：未填充数据的表格图片生成*/
	public void doNoDataFillExcel() throws Exception {
		HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
		String htmlPath = "D:\\tmp\\testsvg_prod\\data_excel_html_tpl\\excel.html";
		String htmlStr = FileUtils.readFile(htmlPath);
		imageGenerator.loadHtml(htmlStr);
		
		BufferedImage bufferedImage = getGrayPicture(imageGenerator.getBufferedImage());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			ImageIO.write(bufferedImage, "jpg", outputStream);
			String base64String = Base64.encode(outputStream.toByteArray());
			String base64Img = "data:image/jpg;base64," + base64String.toString();
			System.out.println("base64Img:" + base64Img);
			
			//保存base64编码
			String base64Path = "D:\\tmp\\testsvg_prod\\data_excel_base64\\no_data_fill_excel.base64";
			FileUtils.writeToFile(base64Img, base64Path);

			//生成图片
			String pngPath = "D:\\tmp\\testsvg_prod\\data_excel_img\\no_data_fill_excel.png";
	        FileOutputStream out = new FileOutputStream(pngPath);
	        out.write(outputStream.toByteArray());
	        out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outputStream != null){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public BufferedImage getGrayPicture(BufferedImage originalImage)
	{
		BufferedImage grayPicture;
		int imageWidth = originalImage.getWidth();
		int imageHeight = originalImage.getHeight();
 
		grayPicture = new BufferedImage(imageWidth, imageHeight,
				BufferedImage.TYPE_INT_RGB);
		ColorConvertOp cco = new ColorConvertOp(ColorSpace
				.getInstance(ColorSpace.CS_GRAY), null);
		cco.filter(originalImage, grayPicture);
		return grayPicture;
	}

}
