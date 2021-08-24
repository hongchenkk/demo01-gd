package com.godink.demo01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 测试：批量图片生成一个pdf
 * 说明：每页pdf放一张图片
 * 可用性：可用
 * @ClassName: TestGeneratePDFbyImg 
 * @author: Hong.Chen
 * @date: 2021年8月23日 上午9:50:51
 */
@Slf4j
class TestGeneratePDFbyImg {

	@Test
	void test() throws Exception {
		imgOfPdf();
	}

	private void imgOfPdf() throws Exception {
		  try {
		  		//创建个存放图片地址的集合
		       List<String> imageUrlList = new ArrayList();
		       //添加图片地址到集合
		       imageUrlList.add("D:\\tmp\\testpdf\\1.jpg");
		       imageUrlList.add("D:\\tmp\\testpdf\\2.png");
		       //存放pdf文件的路径
		       String pdfUrl = "D:\\tmp\\testpdf\\12.pdf";
		       File file = pdf(imageUrlList, pdfUrl);//生成pdf
		       file.createNewFile();
			  
//			  Image png1 = Image.getInstance("D:\\tmp\\testpdf\\1.jpg");
//			  log.info("png1: {}", png1);
			  
		   } catch (IOException e) {
		       e.printStackTrace();
		   }
	}
	
	private File pdf(List<String> imageUrlList, String pdfUrl) {
		//new一个pdf文档
	    Document doc = new Document(PageSize.A4, 20, 20, 20, 20); 
	    try {
	        //pdf写入
	        PdfWriter.getInstance(doc, new FileOutputStream(pdfUrl));
	        //打开文档
	        doc.open();
	        //遍历集合，将图片放在pdf文件
	        for (int i = 0; i < imageUrlList.size(); i++) {
	        	//在pdf创建一页   主：此处为每一张图片是pdf文件的一页
	            doc.newPage();  
	            //通过文件路径获取image
	            Image png1 = Image.getInstance(imageUrlList.get(i));
	            log.info("png{}: {}", i, png1);
	            float heigth = png1.getHeight();
	            float width = png1.getWidth();
	            int percent = getPercent2(heigth, width);
	            png1.setAlignment(Image.MIDDLE);
	            // 表示是原来图像的比例;
	            png1.scalePercent(percent+3);
	            doc.add(png1);
	        }
	        doc.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (DocumentException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		//输出流
	    File mOutputPdfFile = new File(pdfUrl); 
	    if (!mOutputPdfFile.exists()) {
	        mOutputPdfFile.deleteOnExit();
	        return null;
	    }
	    //反回文件输出流
	    return mOutputPdfFile;
	}
	
	/**通过图片的base64编码生成pdf*/
	@Test
	void testGenPdfByImgBase64Str() throws Exception {
		try {
			// 创建个存放图片地址的集合
			List<String> imageUrlList = new ArrayList();
			// 添加图片地址到集合
			imageUrlList.add("D:\\tmp\\testpdf\\1.jpg");
			imageUrlList.add("D:\\tmp\\testpdf\\2.png");
			// 存放pdf文件的路径
			String pdfUrl = "D:\\tmp\\testpdf\\test.pdf";
			// 生成pdf
			List<String> base64StrList = fileToBase64Str(imageUrlList);
			File file = pdfBase64Img(base64StrList, pdfUrl);
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**转换图片为base64字符串*/
	private List<String> fileToBase64Str(List<String> imageUrlList) throws Exception{
		List<String> base64StrList = new ArrayList<>();
		for (String imgUrl : imageUrlList) {
			String base64Str = encodeBase64File(imgUrl);
			base64StrList.add(base64Str);
		}
		return base64StrList;
	}
	
	private File pdfBase64Img(List<String> base64StrList, String pdfUrl) {
		//new一个pdf文档
	    Document doc = new Document(PageSize.A4, 20, 20, 20, 20); 
	    try {
	        //pdf写入
	        PdfWriter.getInstance(doc, new FileOutputStream(pdfUrl));
	        //打开文档
	        doc.open();
	        //遍历集合，将图片放在pdf文件
	        for (int i = 0; i < base64StrList.size(); i++) {
	        	//在pdf创建一页   主：此处为每一张图片是pdf文件的一页
	            doc.newPage();  
	            String base64StrImg = base64StrList.get(i);
	            System.out.println("--------------------------分隔符---------------------------------");
	            log.info("base64StrImg{}: {}", i, base64StrImg);
	            byte[] imgb = new BASE64Decoder().decodeBuffer(base64StrImg);
	            //通过图片字节数组获取image
	            Image png1 = Image.getInstance(imgb);
	            log.info("png{}: {}", i, png1);
	            float heigth = png1.getHeight();
	            float width = png1.getWidth();
	            int percent = getPercent2(heigth, width);
	            png1.setAlignment(Image.MIDDLE);
	            // 表示是原来图像的比例;
	            png1.scalePercent(percent+3);
	            doc.add(png1);
	        }
	        doc.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (DocumentException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		//输出流
	    File mOutputPdfFile = new File(pdfUrl); 
	    if (!mOutputPdfFile.exists()) {
	        mOutputPdfFile.deleteOnExit();
	        return null;
	    }
	    //反回文件输出流
	    return mOutputPdfFile;
	}

	public int getPercent(float h, float w) {
	    int p = 0;
	    float p2 = 0.0f;
	    if (h > w) {
	        p2 = 297 / h * 100;
	    } else {
	        p2 = 210 / w * 100;
	    }
	    p = Math.round(p2);
	    return p;
	}

	public int getPercent2(float h, float w) {
	    int p = 0;
	    float p2 = 0.0f;
	    p2 = 530 / w * 100;
	    p = Math.round(p2);
	    return p;
	}
	
    /**
    * <p>将文件转成base64 字符串</p>
    * @param path 文件路径
    * @return
    * @throws Exception
    */
    public String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        return new BASE64Encoder().encode(buffer);
    }
    
    /**
     * 针对格式的问题：
     * 1.有的地方带以下格式：data:image/jpeg;base64,
     * 2.有的则不带，统一去掉这个格式之后在处理
     * */
    @Test
    void testGenBase64FromImg() throws Exception {
    	String imgPath = "D:\\tmp\\testpdf\\1.jpg";
    	String encodeBase64File = encodeBase64File(imgPath);
    	System.out.println(encodeBase64File);
    }

}
