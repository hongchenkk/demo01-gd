//package com.godink.demo01.ofd;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.ofdrw.converter.ConvertHelper;
//import org.ofdrw.converter.GeneralConvertException;
//import org.ofdrw.layout.OFDDoc;
//import org.ofdrw.layout.PageLayout;
//import org.ofdrw.layout.VirtualPage;
//import org.ofdrw.layout.element.Img;
//import org.ofdrw.layout.element.Position;
//
//import com.itextpdf.text.BadElementException;
//TODO: 暂时屏蔽下，好像引入的相关jar包对svg转png的工具有影响，导致svg转png用不了
///***
// * ofd文档操作参考链接：https://github.com/ofdrw/ofdrw
// */
//class TestImgAddToOfd {
//
//	/**
//	 * 将多张图片生成ofd文件，每页一张图片
//	 */
//	@Test
//	void genrateOfdByImgTest() throws IOException, BadElementException {
//		Path path = Paths.get("D:\\tmp\\testofd\\VPageOfPNG.ofd").toAbsolutePath();
//		try (OFDDoc ofdDoc = new OFDDoc(path)) {
//
//			List<Path> imgPaths = new ArrayList<>();
//			Path imgPath1 = Paths.get("D:\\tmp\\testofd", "1.jpg");
//			Path imgPath2 = Paths.get("D:\\tmp\\testofd", "2.png");
//			imgPaths.add(imgPath1);
//			imgPaths.add(imgPath2);
//
//			for (Path imgPath : imgPaths) {
//				PageLayout pageLayout = ofdDoc.getPageLayout();
//				VirtualPage vPage = new VirtualPage(pageLayout);
//				// 这里需要获取原图片大小，所以只能用这个方法
//				Img img = new Img(imgPath);
//
//				// 设置高度和宽度
//				Double h = img.getHeight();
//				Double w = img.getWidth();
//				Double h1 = pageLayout.getHeight() * 0.95;// 布局的高度0.95
//				Double w1 = pageLayout.getWidth() * 0.95;// 布局宽度的0.95
//				// 如果宽度大于布局宽度，就将宽度设置为布局宽度
//				if (w > w1) {
//					// 将高度缩小相同倍数
//					h = (w1 * h) / w;
//					// 设置为布局宽度
//					w = w1;
//				}
//				// 如果高度大于布局高度，则将高度设置布局高度，宽度缩小
//				if (h > h1) {
//					// 将高度缩小相同倍数
//					w = (h1 * w) / h;
//					// 设置为布局宽度
//					h = h1;
//				}
//				// 设置图片为缩小后的图片大小
//				img.setHeight(h);
//				img.setWidth(w);
//
//				// 图片定位
//				double x = (pageLayout.getWidth() - img.getWidth()) / 2;
//				double y = (pageLayout.getHeight() - img.getHeight()) / 2;
//				img.setPosition(Position.Absolute).setX(x).setY(y);
//				// 设置图片周围的边框的
////                img.setBorder(1d);
////                img.setPadding(1d);
//				vPage.add(img);
//				ofdDoc.addVPage(vPage);
//			}
//		}
//	}
//
//	/**
//	 * 将ofd转为pdf
//	 */
//	@Test
//	void testOfdToPdf() {
//		// 1. 文件输入路径
//		Path src = Paths.get("D:\\tmp\\testofd\\VPageOfPNG.ofd");
//		// 2. 转换后文件输出位置
//		Path dst = Paths.get("D:\\tmp\\testofd\\VPageOfPNG.pdf");
//		try {
//			// 3. OFD转换PDF
//			ConvertHelper.toPdf(src, dst);
//			System.out.println("生成文档位置: " + dst.toAbsolutePath());
//		} catch (GeneralConvertException e) {
//			// GeneralConvertException 类型错误表明转换过程中发生异常
//			e.printStackTrace();
//		}
//	}
//
//}
