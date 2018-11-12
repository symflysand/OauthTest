package com.fy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;


/**
 * Title: MoreSheetExcelUtil
 * Description:多sheet页EXCEL表格生成工具类
 * @author flysand
 * @date 2016年3月21日
 */
public class MoreSheetExcelUtil {

	private static Logger logger = Logger.getLogger(MoreSheetExcelUtil.class);
	
	
	/**
	 * 根据要生成EXCEL表格的全部sheet页信息以及表格名称创建多sheet页EXCEL表格，并返回文件路径
	 * @param listSheet 全部需要创建sheet页的数据信息
	 * @param bookName	要生成的EXCEL名称
	 * @return	生成文件路径
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String moreSheetExcel(List<?> listSheet,String bookName){
		logger.debug("moreSheetExcel method");
		String filePathR ="";
		//创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook();  
		for (int i = 0;i<listSheet.size();i++) {
			Map map =  (Map) listSheet.get(i);
			String sheetName = (String) map.get("sheetName");
			List title = (List) map.get("title");
			List<Object[]> data = (List<Object[]>) map.get("data");
			//创建sheet页
			HSSFSheet sheet = wb.createSheet(sheetName);  
			//宽度
			sheet.setDefaultColumnWidth(18);
			//创建标题行
			HSSFRow row = sheet.createRow((int) 0);
			row.setHeight((short) (25*20));
			HSSFCell titleCell = row.createCell(0);
			//合并单元格
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, title.size()-1)); 
			//设置标题行样式
			titleCell.setCellStyle(MoreSheetExcelUtil.titleCellStyle(wb));
			titleCell.setCellValue(sheetName);
			//创建列名行
			HSSFRow rowColTitle = sheet.createRow(1);
			//创建列名行单元格
			for(int j=0;j<title.size();j++){
				HSSFCell cell = rowColTitle.createCell(j);
				cell.setCellValue((String)title.get(j));
				//设置单元格样式
				cell.setCellStyle(MoreSheetExcelUtil.columnCellStyle(wb));
			}
			if(data.size()>0){
				//有数据则继续创建数据行
				for(int k=0;k<data.size();k++){
					Object[] obj = data.get(k);
					HSSFRow row1 = sheet.createRow(k+2);
					for(int l=0;l<obj.length;l++){
						HSSFCell cell = row1.createCell(l,HSSFCell.CELL_TYPE_STRING);
						if(obj[l]!=null && ""!=obj[l]){
							cell.setCellValue(obj[l].toString());
						}else{
							cell.setCellValue("");
						}
						cell.setCellStyle(MoreSheetExcelUtil.dataCellStyle(wb, k+2));
					}
				}
			}
		}
		if(wb!=null){
			try {
				String filePath = "/tpsys/file/";
				String filePaths = filePath+DateUtils.formatTime(Calendar.getInstance().getTime(),"yyyyMMdd")+"/";
				File fs = new File(filePaths);
				if(!fs.exists()){
					fs.mkdirs();
				}
				File file = new File(filePaths+bookName+Calendar.getInstance().getTime().getTime()+".xls");
				//FileOutputStream fileO = new FileOutputStream(filePaths+bookName+Calendar.getInstance().getTime().getTime()+".xls");
				FileOutputStream out = new FileOutputStream(file);
				wb.write(out);
				out.close();
				filePathR = file.getPath();
				System.out.println("文件写入成功！"+filePathR);
			} catch (Exception e) {
				logger.error(e);
				System.out.println("文件写入失败！"+filePathR);
			}
		}
		return filePathR;
	}
	
	/**
	 * 标题行单元格样式
	 * @param workbook 工作簿
	 * @return 单元格样式
	 */
	public static HSSFCellStyle titleCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		
		// 设置字体  
        HSSFFont font = workbook.createFont();  
        //设置字体大小  
        font.setFontHeightInPoints((short)18);  
        //字体加粗  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        //设置字体名字   
       // font.setFontName("微软雅黑");  
       /* //设置底边框;   
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        //设置底边框颜色;    
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);  
        //设置左边框;     
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        //设置左边框颜色;   
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);  
        //设置右边框;   
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        //设置右边框颜色;   
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);  
        //设置顶边框;   
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        //设置顶边框颜色;    
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index); */
        //在样式用应用设置的字体;    
        cellStyle.setFont(font);  
        //设置自动换行;   
        cellStyle.setWrapText(false);  
        //设置水平对齐的样式为居中对齐;    
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;   
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
		return cellStyle;
	}
	
	/**
	 * 列名行单元格样式
	 * @param workbook 工作簿
	 * @return 单元格样式
	 */
	public static HSSFCellStyle columnCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		
		// 设置字体  
        HSSFFont font = workbook.createFont();  
        //设置字体大小  
        font.setFontHeightInPoints((short)10);  
        //字体加粗  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        //设置字体名字   
       // font.setFontName("微软雅黑");  
        //在样式用应用设置的字体;    
        cellStyle.setFont(font);  
      //设置底边框;   
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        //设置底边框颜色;    
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);  
        //设置左边框;     
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        //设置左边框颜色;   
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);  
        //设置右边框;   
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        //设置右边框颜色;   
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);  
        //设置顶边框;   
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        //设置顶边框颜色;    
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        //设置自动换行;   
        cellStyle.setWrapText(false); 
        //背景颜色--以纯色填充
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(new HSSFColor.SKY_BLUE().getIndex());
        //设置水平对齐的样式为居中对齐;    
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;   
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
		return cellStyle;
	}
	
	/**
	 * 数据行单元格样式
	 * @param workbook 工作簿
	 * @param index 行索引
	 * @return
	 */
	public static HSSFCellStyle dataCellStyle(HSSFWorkbook workbook,int index){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		//设置字体
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short)10);
		//font.setFontName("微软雅黑");
		cellStyle.setFont(font);
		//设置底边框;   
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
        //设置底边框颜色;    
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);  
        //设置左边框;     
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
        //设置左边框颜色;   
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);  
        //设置右边框;   
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);  
        //设置右边框颜色;   
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);  
        //设置顶边框;   
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);  
        //设置顶边框颜色;    
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
		//设置水平对齐的样式为居中对齐;    
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;   
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); 
        /*//设置偶数行背景颜色
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		if(index%2==0){
			cellStyle.setFillForegroundColor(new HSSFColor.PINK().getIndex());
		}else{
			cellStyle.setFillForegroundColor(new HSSFColor.WHITE().getIndex());
		}*/
		return cellStyle;
	}
}
