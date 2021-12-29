package com.godink.demo01.svgContvertToPng;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

//import org.apache.batik.transcoder.TranscoderException;
//import org.apache.batik.transcoder.TranscoderInput;
//import org.apache.batik.transcoder.TranscoderOutput;
//import org.apache.batik.transcoder.image.ImageTranscoder;
//import org.apache.batik.transcoder.image.PNGTranscoder;
//import org.junit.jupiter.api.Test;

/**
 * 正式数据测试
 */
class TestProdSvgToPngConverter {
//
//	/**
//	 * 不填充数据生成图片
//	 */
//	@Test
//	void testNoDataFill() throws Exception{
//		String svgPath = "D:\\tmp\\testsvg_prod\\data_svg_tpl\\2253_img_base64.svg";
//		String pngPath = "D:\\tmp\\testsvg_prod\\result_png\\no_data_fill_svg.png";
//		Map<String, String> params = new HashMap<>();
//		convertToPngByFile(svgPath, pngPath, params);
//	}
//	
//	/**
//	 * 只填充了表格数据的生成图片
//	 */
//	@Test
//	void testOnlyFillExcelImg() throws Exception{
//		String svgPath = "D:\\tmp\\testsvg_prod\\data_svg_tpl\\2253_img_base64_has_excel_data.svg";
//		String pngPath = "D:\\tmp\\testsvg_prod\\result_png\\only_fill_excel_img.png";
//		Map<String, String> params = new HashMap<>();
//		convertToPngByFile(svgPath, pngPath, params);
//	}
//	
//	/**
//     * batik通过读取svg文件的方式转png
//     * @param svgPath 传入读取的svg文件
//     * @param pngFilePath 转换后的png图片
//     * @param map 更改svg属性的集合 传值规则，id,name,value 主要是更改svg子节点的颜色属性值。
//     *                        如果需要改变svg的多个element的颜色属性 则命名规范为 id1,name1,value1,id2,name2,value2....依次类推
//     * @throws IOException
//     * @throws TranscoderException
//     */
//    public static void convertToPngByFile(String svgPath, String pngFilePath, Map<String, String> map)
//            throws IOException, TranscoderException {
//        File file = new File(pngFilePath);
//        FileOutputStream outputStream = null;
//        try {
//            file.createNewFile();
//            outputStream = new FileOutputStream(file);
//            convertToPngByFile(svgPath, outputStream,map);
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static void convertToPngByFile(String svgPath, OutputStream outputStream,Map<String, String> map)
//            throws TranscoderException, IOException {
//        try {
//            File file = new File(svgPath);
//            String svgURI = file.toURI().toString();
////            String parser = XMLResourceDescriptor.getXMLParserClassName();
////            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
////            Document doc = f.createDocument(svgURI);
////            for (int i = 1; i <= map.size()/3; i++) {
////                Element e = doc.getElementById(map.get("id"+i));
////                System.out.println(map.get("name"+i));
////                e.setAttribute(map.get("name"+i), map.get("value"+i));
////            }
////            //对元素的操作跟xml的dom操作差不多
////            //参考：https://www.w3school.com.cn/xmldom/dom_nodes_get.asp
////            //设置值：签发机关
////            //元素节点
////            Element e1 = doc.getElementById("qfjg");
////            //获取子节点：文本节点
////            Node text1 = e1.getChildNodes().item(0);
////            //获取文本内容
////            System.out.println(text1.getNodeValue());
////            //设置文本内容值
////            text1.setNodeValue("南山区民政局");
////
////            //设置值：有效期限
////            //元素节点
////            Element e2 = doc.getElementById("yxqx");
////            //获取子节点：文本节点
////            Node text2 = e2.getChildNodes().item(0);
////            //获取文本内容
////            System.out.println(text2.getNodeValue());
////            //设置文本内容值
////            text2.setNodeValue("2028-10-14");
//            
//            PNGTranscoder t = new PNGTranscoder();
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
////            TranscoderInput input = new TranscoderInput(doc);
//            TranscoderInput input = new TranscoderInput(svgURI);
//            TranscoderOutput output = new TranscoderOutput(outputStream);
//            t.transcode(input, output);
//            outputStream.flush();
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//	
}
