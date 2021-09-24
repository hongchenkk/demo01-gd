package com.godink.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.util.StringUtil;

/**
 * 文件操作代码
 * 
 */
public class FileUtils {
    /**
     * 将文本文件中的内容读入到buffer中
     * @param buffer buffer
     * @param filePath 文件路径
     */
    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }
    
    public static void writeToFile(String sqlStr, String filePath) throws IOException {
        OutputStream out = new FileOutputStream(filePath);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write(sqlStr);
        writer.close();
        out.close();
    }

    /**
     * 读取文本文件内容
     * @param filePath 文件所在路径
     * @return 文本内容
     */
    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileUtils.readToBuffer(sb, filePath);
        return sb.toString();
    }
    
    public static List<File> readFilesByDir(String dirPath) {
    	File dir = new File(dirPath);
    	if(dir.exists() && dir.isDirectory()) {
    		File[] fileArr = dir.listFiles();
    		return Arrays.asList(fileArr);
    	}
    	return new ArrayList<>();
    }
    
    public static void main(String[] args) throws Exception{
    	//filterFile();
//    	delOldFile();
//    	getFileNamePrefixDot();
//    	generateFieldAddSql();
    	
    	generateSqlField();
	}
    
    public static void generateSqlField() throws IOException {
    	String filePath1 = "D:\\tmp\\testtxt\\api1.txt";
    	String filePath2 = "D:\\tmp\\testtxt\\api2.txt";
    	String readFile = FileUtils.readFile(filePath1);
    	String[] split = readFile.split("_");
    	String newStr = "";
    	for (int i = 0; i < split.length; i++) {
			if(i > 0) {
				String first = split[i].substring(0,1).toUpperCase();
				String after = split[i].substring(1).toLowerCase();
				newStr += first + after;
			}else {
				newStr += split[i];
			}
		}
    	//将所有_x开头的x都变成大写的并去掉_
    	FileUtils.writeToFile(newStr, filePath2);
    }
    
    /** 删除文件夹下中文件名包含old.的文件*/
    public static void delOldFile() {
		String dirPath = "C:\\Users\\DELL\\Desktop\\safe_sql\\field_add_sql";
		List<File> files = FileUtils.readFilesByDir(dirPath);
		files.forEach(next->{
			if(next.getName().contains("old.")) {
				next.deleteOnExit();
				System.out.println(next.getName());
			}
			
		});
    }
    
    /** 删除文件夹下中文件名包含old.的文件*/
    public static void getFileNamePrefixDot() {
		String dirPath = "C:\\Users\\DELL\\Desktop\\safe_sql\\field_add_sql";
		List<File> files = FileUtils.readFilesByDir(dirPath);
		files.forEach(next->{
			String tableName = next.getName().substring(0, next.getName().lastIndexOf("."));
			if(tableName.lastIndexOf("(") != -1) {
				tableName = tableName.substring(0, tableName.lastIndexOf("("));
			}
			System.out.println(tableName);
		});
    }
    
    /** 安全模块-脚本生成sql*/
    public static void generateFieldAddSql() throws IOException {
		String dirPath = "C:\\Users\\DELL\\Desktop\\safe_sql\\field_add_sql";
		List<File> files = FileUtils.readFilesByDir(dirPath);
		
		List<String> tableNames = files.stream().map(next->{
			String tableName = next.getName().substring(0, next.getName().lastIndexOf("."));
			if(tableName.lastIndexOf("(") != -1) {
				tableName = tableName.substring(0, tableName.lastIndexOf("("));
			}
			return tableName;
		}).collect(Collectors.toList());
		System.out.println(tableNames);
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("-- 表:%s 新增字段\n");
		sqlSb.append("ALTER TABLE %s ADD create_user INT(11) DEFAULT NULL COMMENT '创建人';\n");
		sqlSb.append("ALTER TABLE %s ADD create_time DATETIME DEFAULT NULL COMMENT '创建时间';\n");
		sqlSb.append("ALTER TABLE %s ADD update_user INT(11) DEFAULT NULL COMMENT '修改人';\n");
		sqlSb.append("ALTER TABLE %s ADD update_time DATETIME DEFAULT NULL COMMENT '修改时间';\n");
		sqlSb.append("ALTER TABLE %s ADD delete_user INT(11) DEFAULT NULL COMMENT '删除人';\n");
		sqlSb.append("ALTER TABLE %s ADD delete_time DATETIME DEFAULT NULL COMMENT '删除时间';\n");
		sqlSb.append("ALTER TABLE %s ADD data_version INT(11) DEFAULT NULL COMMENT '数据版本';\n");
		sqlSb.append("ALTER TABLE %s ADD data_state VARCHAR(50) DEFAULT NULL COMMENT '数据的逻辑状态（1：有效，非1：无效）';\n");
		sqlSb.append("ALTER TABLE %s ADD tenant_id INT(11) DEFAULT NULL COMMENT '租户id';\n");
		sqlSb.append("\n\n");
		
		StringBuilder result = new StringBuilder();
		tableNames.forEach(next->{
			String sqlStr = sqlSb.toString().replaceAll("%s", next);
			result.append(sqlStr);
		});
		
		String saveFiles = "C:\\Users\\DELL\\Desktop\\safe_sql\\final.sql";
		FileUtils.writeToFile(result.toString(), saveFiles);	
    }
    
    /**找包含某个字符串的文件-从众多文件中*/
    public static void filterFile() {
		String dirPath = "C:\\Users\\DELL\\Desktop\\File_list";
		List<File> files = FileUtils.readFilesByDir(dirPath);
		
		files.forEach(next->{
			try {
				String content = FileUtils.readFile(next.getAbsolutePath());
				if(content!=null && content.contains("SensitiveAnalyzeReport")) {
					System.out.println(next.getName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
    }
    
    public static void replaceStr() {
		String dirPath = "C:\\Users\\DELL\\Desktop\\replace_dir\\metadata\\report\\mysql";
		List<File> files = FileUtils.readFilesByDir(dirPath);
		
		files.forEach(next->{
			try {
				String content = FileUtils.readFile(next.getAbsolutePath());
				if(content!=null && content.contains("SensitiveAnalyzeReport")) {
					System.out.println(next.getName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
    }
}
