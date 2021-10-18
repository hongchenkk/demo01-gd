package com.godink.demo01.svgContvertToPng;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试svg文件生成png图片
 * 参考文档1：https://www.open-open.com/lib/view/open1414817090294.html
 * 前端js插件，可产生svg文件的：http://fabricjs.com/
 */
@Slf4j
class TestSvgToPngConverter {

	@Test
	void test1() {
		String svgPath = "D:\\tmp\\testsvg\\test1.svg";
		String pngPath = "D:\\tmp\\testsvg\\test1.png";
		Map<String, String> params = new HashMap<>();
		try {
			convertToPngByFile(svgPath, pngPath, params);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TranscoderException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
     * batik通过读取svg文件的方式转png
     * @param filePath 传入读取的svg文件
     * @param pngFilePath 转换后的png图片
     * @param map 更改svg属性的集合 传值规则，id,name,value 主要是更改svg子节点的颜色属性值。
     *                        如果需要改变svg的多个element的颜色属性 则命名规范为 id1,name1,value1,id2,name2,value2....依次类推
     * @throws IOException
     * @throws TranscoderException
     */
    public static void convertToPngByFile(String filePath, String pngFilePath, Map<String, String> map)
            throws IOException, TranscoderException {
        File file = new File(pngFilePath);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file);
            convertToPngByFile(filePath, outputStream,map);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
	@Test
	void test2() {
		String svgPath = "D:\\tmp\\testsvg\\test2.svg";
		String pngPath = "D:\\tmp\\testsvg\\test2.png";
		Map<String, String> params = new HashMap<>();
		try {
			convertToPngByFile(svgPath, pngPath, params);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TranscoderException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test3() {
		String svgPath = "D:\\tmp\\testsvg\\test5.svg";
		String pngPath = "D:\\tmp\\testsvg\\test5.png";
		Map<String, String> params = new HashMap<>();
		try {
			convertToPngByFile(svgPath, pngPath, params);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TranscoderException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test4() {
		String svgPath = "D:\\tmp\\testsvg\\test8.svg";
		String pngPath = "D:\\tmp\\testsvg\\test8.png";
		Map<String, String> params = new HashMap<>();
		try {
			convertToPngByFile(svgPath, pngPath, params);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TranscoderException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void test5() {
		String svgPath = "D:\\tmp\\testsvg\\test9.svg";
		String pngPath = "D:\\tmp\\testsvg\\test9.png";
		Map<String, String> params = new HashMap<>();
		try {
			convertToPngByFile(svgPath, pngPath, params);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TranscoderException e) {
			e.printStackTrace();
		}
	}
    
    public static void convertToPngByFile(String path, OutputStream outputStream,Map<String, String> map)
            throws TranscoderException, IOException {
        try {
            File file = new File(path);
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            Document doc = f.createDocument(file.toURI().toString());
            for (int i = 1; i <= map.size()/3; i++) {
                Element e = doc.getElementById(map.get("id"+i));
                System.out.println(map.get("name"+i));
                e.setAttribute(map.get("name"+i), map.get("value"+i));
            }
//            //对元素的操作跟xml的dom操作差不多
//            //参考：https://www.w3school.com.cn/xmldom/dom_nodes_get.asp
//            //设置值：签发机关
//            //元素节点
//            Element e1 = doc.getElementById("qfjg");
//            //获取子节点：文本节点
//            Node text1 = e1.getChildNodes().item(0);
//            //获取文本内容
//            System.out.println(text1.getNodeValue());
//            //设置文本内容值
//            text1.setNodeValue("南山区民政局");
//
//            //设置值：有效期限
//            //元素节点
//            Element e2 = doc.getElementById("yxqx");
//            //获取子节点：文本节点
//            Node text2 = e2.getChildNodes().item(0);
//            //获取文本内容
//            System.out.println(text2.getNodeValue());
//            //设置文本内容值
//            text2.setNodeValue("2028-10-14");
            
            PNGTranscoder t = new PNGTranscoder();
            TranscoderInput input = new TranscoderInput(doc);
            TranscoderOutput output = new TranscoderOutput(outputStream);
            t.transcode(input, output);
            outputStream.flush();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
