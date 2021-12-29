package com.godink.demo01.svgContvertToPng;

//import java.awt.Color;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.batik.transcoder.TranscoderException;
//import org.apache.batik.transcoder.TranscoderInput;
//import org.apache.batik.transcoder.TranscoderOutput;
//import org.apache.batik.transcoder.image.ImageTranscoder;
//import org.apache.batik.transcoder.image.PNGTranscoder;
//import org.junit.jupiter.api.Test;

/**
 * 测试ok
 * 参考的是文章：https://stackoverflow.com/questions/11234455/poor-image-quality-when-using-svgconverter-in-batik-to-convert-svg-to-png
 * 
 
int RESOLUTION_DPI = 600;
float SCALE_BY_RESOLUTION = RESOLUTION_DPI / 72f;
float scaledWidth = 252*SCALE_BY_RESOLUTION;
float scaledHeight = 144*SCALE_BY_RESOLUTION;
float pixelUnitToMM = new Float(25.4f/RESOLUTION_DPI);

transcoderInput = new TranscoderInput(svgDocument);
TranscoderOutput transcoderOutput = new TranscoderOutput(ostream);
transcoder.addTranscodingHint(ImageTranscoder.KEY_BACKGROUND_COLOR, Color.WHITE);
transcoder.addTranscodingHint(PNGTranscoder.KEY_WIDTH, scaledWidth);
transcoder.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, scaledHeight);
transcoder.addTranscodingHint(PNGTranscoder.KEY_PIXEL_UNIT_TO_MILLIMETER, pixelUnitToMM);
transcoder.transcode(transcoderInput, transcoderOutput);
 
 * 
 * 
 * 调整svg转图片的质量,因为默认参数转换出来的图片质量太差，太模糊了
 * 
 * @ClassName: TestSvgToImgQuality
 * @author: Hong.Chen
 * @date: 2021年11月1日 上午10:20:28
 */
class TestSvgToImgQuality {
//
//	/**
//	 * 将从测试环境生成的svg包含数据的生成图片
//	 */
//	@Test
//	void testProdDataToPng() throws Exception {
//		String svgPath = "D:\\tmp\\testsvg_prod_test\\343_svg_result_data2.svg";
//		String pngPath = "D:\\tmp\\testsvg_prod_test\\343_svg_result_data2.png";
//		Map<String, String> params = new HashMap<>();
//		convertToPngByFile(svgPath, pngPath, params);
//	}
//
//	/**
//	 * batik通过读取svg文件的方式转png
//	 * 
//	 * @param svgPath     传入读取的svg文件
//	 * @param pngFilePath 转换后的png图片
//	 * @param map         更改svg属性的集合 传值规则，id,name,value 主要是更改svg子节点的颜色属性值。
//	 *                    如果需要改变svg的多个element的颜色属性 则命名规范为
//	 *                    id1,name1,value1,id2,name2,value2....依次类推
//	 * @throws IOException
//	 * @throws TranscoderException
//	 */
//	public static void convertToPngByFile(String svgPath, String pngFilePath, Map<String, String> map)
//			throws IOException, TranscoderException {
//		File file = new File(pngFilePath);
//		FileOutputStream outputStream = null;
//		try {
//			file.createNewFile();
//			outputStream = new FileOutputStream(file);
//			convertToPngByFile(svgPath, outputStream, map);
//		} finally {
//			if (outputStream != null) {
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//	public static void convertToPngByFile(String svgPath, OutputStream outputStream, Map<String, String> map)
//			throws TranscoderException, IOException {
//		try {
//			File file = new File(svgPath);
//			String svgURI = file.toURI().toString();
//
//			PNGTranscoder t = new PNGTranscoder();
//			
//			//设置图片质量，因为默认的参数生成图片会很模糊
//			int RESOLUTION_DPI = 600;
//			float SCALE_BY_RESOLUTION = RESOLUTION_DPI / 72f;
//			float scaledWidth = 252*SCALE_BY_RESOLUTION;
//			float scaledHeight = 144*SCALE_BY_RESOLUTION;
//			float pixelUnitToMM = new Float(25.4f/RESOLUTION_DPI);
//			t.addTranscodingHint(ImageTranscoder.KEY_BACKGROUND_COLOR, Color.WHITE);
//			t.addTranscodingHint(PNGTranscoder.KEY_WIDTH, scaledWidth);
//			t.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, scaledHeight);
//			t.addTranscodingHint(PNGTranscoder.KEY_PIXEL_UNIT_TO_MILLIMETER, pixelUnitToMM);
//			
//			TranscoderInput input = new TranscoderInput(svgURI);
//			TranscoderOutput output = new TranscoderOutput(outputStream);
//			t.transcode(input, output);
//			outputStream.flush();
//		} finally {
//			if (outputStream != null) {
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
}
