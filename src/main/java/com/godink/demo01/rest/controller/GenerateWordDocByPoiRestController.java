package com.godink.demo01.rest.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godink.demo01.model.RecordDto;


/**
 * 通过XWPF Poi生成word文档
 * @author: Hong.Chen
 * @date: 2021年9月7日 下午3:02:14
 */
@RequestMapping("/rest/word/doc")
@RestController
public class GenerateWordDocByPoiRestController {

	//测试url: http://127.0.0.1:23080/demo02/rest/word/doc/generate
    @GetMapping("/generate")
    public void exportScoreWordDoc(HttpServletResponse response){
        RecordDto record1 = new RecordDto("paramname1", "VARCHAR", 100, "是", "这是字段描述1这是字段描述1");
        RecordDto record2 = new RecordDto("paramname2", "INT", 10, "是", "这是字段描述2");
        RecordDto record3 = new RecordDto("paramname3", "DATE", 0, "否", "这是字段描述3这是字段描述1");
        RecordDto record4 = new RecordDto("paramname4", "VARCHAR", 100, "是", "这是字段描述4");
        List<RecordDto> list= new ArrayList<>();
//        list.add(record1);
//        list.add(record2);
//        list.add(record3);
//        list.add(record4);
        
        List<RecordDto> list2= new ArrayList<>();
        list2.add(record1);
        list2.add(record2);
        list2.add(record3);
        list2.add(record4);
        try {
            String fileName="[XXXX接口名称]"+"接口文档.doc";
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
            OutputStream outputStream=response.getOutputStream();
 
            XWPFDocument document =getTestScoreListWord(list, list);
            document.write(outputStream);
            outputStream.flush();//请求参数
            outputStream.close();//返回参数
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
   //生成考试成绩单Word文档
    public XWPFDocument getTestScoreListWord(List<RecordDto> inputRecords, List<RecordDto> outputRecords) throws IOException{
        XWPFDocument document = new XWPFDocument();
        generateDoc(inputRecords, document, "input");
        generateDoc(outputRecords, document, "output");
        
        //文件生成base64编码
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.write(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String contentStr = new Base64().encodeAsString(bytes);
        System.out.println("===================base64str start================");
        System.out.println(contentStr);
        System.out.println("===================base64str end================");        
        return document;
    }
    
	public void generateDoc(List<RecordDto> records, XWPFDocument document, String type) {
		//标题行
		String titieName = "input".equals(type) ? "请求参数：" : "返回数据：";
		XWPFParagraph p = document.createParagraph();
        XWPFRun r = p.createRun();//创建标题
        r.setText(titieName);//内容
        r.setFontFamily("宋体");//宋体
        r.setFontSize(11); //字体大小
        r.setColor("000000");//字体颜色
        //生成表格
        int cols = "input".equals(type) ? 5 : 4;
        XWPFTable table = document.createTable(records.size()+1, cols);
        List<XWPFTableRow> rowList = table.getRows();
        //表头下标
        final int COL_NAME = 0;//字段名称
        final int COL_IS_REQUIRED = "input".equals(type) ? 1 : -1;//是否必填
        final int COL_DATA_TYPE = "input".equals(type) ? 2 : 1;//数据类型
        final int COL_LENGTH = "input".equals(type) ? 3 : 2;//字段长度
        final int COL_DESC = "input".equals(type) ? 4 : 3;//字段描述
        //设置表头
        List<XWPFTableCell> cellList=rowList.get(0).getTableCells();
        //字段名称
        XWPFTableCell tc = cellList.get(COL_NAME);
        tc.setColor("C0C0C0");//表格背景色为淡灰色
        XWPFParagraph p1= tc.getParagraphArray(0);
        setupHeadStyle(p1, "字段名称");
        //是否必填
        if("input".equals(type)) {
            tc = cellList.get(COL_IS_REQUIRED);
            tc.setColor("C0C0C0");
            p1= tc.getParagraphArray(0);
            setupHeadStyle(p1, "是否必填");
        }
        //数据类型
        tc = cellList.get(COL_DATA_TYPE);
        tc.setColor("C0C0C0");
        p1= tc.getParagraphArray(0);
        setupHeadStyle(p1, "数据类型");
        //字段长度
        tc = cellList.get(COL_LENGTH);
        tc.setColor("C0C0C0");
        p1= tc.getParagraphArray(0);
        setupHeadStyle(p1, "字段长度");
        //字段描述
        tc = cellList.get(COL_DESC);
        tc.setColor("C0C0C0");
        p1= tc.getParagraphArray(0);
        setupHeadStyle(p1, "字段描述");
        
        //设置表格内容
        for(int i = 0; i < records.size(); i++) {
            RecordDto record = records.get(i);
            cellList = rowList.get(i+1).getTableCells();
            //字段名称
            p1=cellList.get(COL_NAME).getParagraphArray(0);            
            p1.setAlignment(ParagraphAlignment.LEFT);//左对齐
    		setupBodyStyle(p1, record.getParamname());
            
            //是否必填
            if("input".equals(type)) {
                p1=cellList.get(COL_IS_REQUIRED).getParagraphArray(0);
                p1.setAlignment(ParagraphAlignment.LEFT);
        		setupBodyStyle(p1, record.getMustfill());
            }
            //数据类型
            p1=cellList.get(COL_DATA_TYPE).getParagraphArray(0);
            p1.setAlignment(ParagraphAlignment.LEFT);
    		setupBodyStyle(p1, record.getParamtype());
            //字段长度
            p1=cellList.get(COL_LENGTH).getParagraphArray(0);
            p1.setAlignment(ParagraphAlignment.LEFT);
    		setupBodyStyle(p1, record.getLength()+"");
            //字段描述
            p1=cellList.get(COL_DESC).getParagraphArray(0);
            p1.setAlignment(ParagraphAlignment.LEFT);
    		setupBodyStyle(p1, record.getRemark());
        }
        
        if(CollectionUtils.isEmpty(records)) {
    		String emptyTip = "input".equals(type) ? "无数据项" : "无数据项";
    		XWPFParagraph p2 = document.createParagraph();
            XWPFRun r2 = p2.createRun();//创建标题
            r2.setText(emptyTip);//内容
            r2.setFontFamily("宋体");//宋体
            r2.setFontSize(9); //字体大小
            r2.setColor("000000");//字体颜色
        }
	}
	
	//设置表格内容样式
	private void setupBodyStyle(XWPFParagraph p, String body) {
		XWPFRun r = p.createRun();
		r.setText(body);
		r.setFontFamily("宋体");//宋体
		r.setFontSize(10); //字体大小
		r.setColor("000000");//字体颜色
	}
	
	//设置表头字段样式
	private void setupHeadStyle(XWPFParagraph p, String headName) {
        p.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r = p.createRun();
        r.setText(headName);//创建标题
        r.setBold(true);//加粗
        r.setFontFamily("宋体");//宋体
        r.setFontSize(11); //字体大小
        r.setColor("000000");//字体颜色
	}
}
