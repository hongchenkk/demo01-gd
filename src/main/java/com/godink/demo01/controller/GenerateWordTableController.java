package com.godink.demo01.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通过XWPF poi生成word文档
 * @ClassName: GenerateWordTableController 
 * @author: Hong.Chen
 * @date: 2021年9月7日 上午10:42:34
 */
@RequestMapping("/word/doc")
@Controller
public class GenerateWordTableController {
	
 	@GetMapping("/generate")
    public void generate(HttpServletResponse response) throws Exception {
        XWPFDocument doc = new XWPFDocument();// 创建Word文件
        XWPFParagraph p = doc.createParagraph();// 新建段落
        p.setAlignment(ParagraphAlignment.CENTER);// 设置段落的对齐方式
        XWPFRun r = p.createRun();//创建标题
        r.setText("[资源名称]-申请说明");
        r.setBold(true);//设置为粗体
        r.setColor("000000");//设置颜色
        r.setFontSize(21); //设置字体大小
        r.addCarriageReturn();//回车换行
        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.BOTH);

        XWPFRun c1 = p1.createRun();
        c1.setText("资源用途说明:xxxxxx");
        c1.setColor("000000");
        c1.setFontSize(12);
        c1.addCarriageReturn();
        XWPFRun c2 = p1.createRun();
        c2.setText("申请依据:xxxxxxx" );
        c2.setColor("000000");
        c2.setFontSize(12);
        c2.addCarriageReturn();
        String fileNameURL = URLEncoder.encode("[资源名称]-申请说明.doc", "UTF-8");
        response.setCharacterEncoding("UTF-8");
        //response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setHeader("Content-disposition", "attachment;filename=" + fileNameURL + ";" + "filename*=utf-8''" + fileNameURL);
        response.setContentType("application/octet-stream");
        //刷新缓冲
        response.flushBuffer();
        OutputStream ouputStream = response.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        doc.write(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String contentStr = new Base64().encodeAsString(bytes);
        System.out.println(contentStr);
        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        doc.write(ouputStream);
//	        File file = new File(fileNameURL);
        ouputStream.flush();
        ouputStream.close();
    } 
 	
 	@GetMapping("/test1")
 	@ResponseBody
 	public void test1() {
 		System.out.println("test1 start");
 	}
 	
 	@GetMapping("/test3")
    public void tes3(HttpServletResponse response) throws Exception {
        XWPFDocument doc = new XWPFDocument();// 创建Word文件
        XWPFParagraph p = doc.createParagraph();// 新建段落
        p.setAlignment(ParagraphAlignment.CENTER);// 设置段落的对齐方式
        XWPFRun r = p.createRun();//创建标题
        r.setText("[资源名称]-申请说明");
        r.setBold(true);//设置为粗体
        r.setColor("000000");//设置颜色
        r.setFontSize(21); //设置字体大小
        r.addCarriageReturn();//回车换行
        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.BOTH);

        XWPFRun c1 = p1.createRun();
        c1.setText("资源用途说明:xxxxxx");
        c1.setColor("000000");
        c1.setFontSize(12);
        c1.addCarriageReturn();
        XWPFRun c2 = p1.createRun();
        c2.setText("申请依据:xxxxxxx" );
        c2.setColor("000000");
        c2.setFontSize(12);
        c2.addCarriageReturn();
        String fileNameURL = URLEncoder.encode("[资源名称]-申请说明.doc", "UTF-8");
        response.setCharacterEncoding("UTF-8");
        //response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setHeader("Content-disposition", "attachment;filename=" + fileNameURL + ";" + "filename*=utf-8''" + fileNameURL);
        response.setContentType("application/octet-stream");
        //刷新缓冲
        response.flushBuffer();
        OutputStream ouputStream = response.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        doc.write(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String contentStr = new Base64().encodeAsString(bytes);
        System.out.println(contentStr);
        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        doc.write(ouputStream);
//	        File file = new File(fileNameURL);
        ouputStream.flush();
        ouputStream.close();
    } 
}
