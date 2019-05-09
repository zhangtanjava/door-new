package com.gx.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.print.attribute.standard.MediaName;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelUtils {
public static void main(String[] args) {
	String filePath = "/Users/zhangtan/Downloads/库存表.xlsx";
    String columns[] = {"model","size","left","right"};
    readExcelUtils.excel2List(filePath,columns);
}
    public static List<Map<String,String>> excel2List(String filePath,String columns[]) {
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String,String>> list = null;
        String cellData = null;
        wb = readExcel(filePath);
       
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<Map<String,String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            System.out.println("最大行数:"+rownum);
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            System.out.println("最大列数:"+colnum);
            //获取列最大可以分为几个单元列
            int nums = (colnum+1)/5;
            System.out.println("最大可以分为几个单元列:"+nums);
            for (int i = 0; i<rownum; i++) {
                row = sheet.getRow(i);
                //空行跳过
                if (isRowEmpty(row)) {
					continue;
				}
                //标题行跳过
                if (isTile(row)) {
					continue;
				}
                for(int n =1;n<=nums;n++) {
                	 Map<String,String> map = new LinkedHashMap<String,String>();
                    for (int j=n*5-5;j<n*5;j++){
                    	if (j%5 == 4) {
							continue;
						}
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map.put(columns[j%5], cellData);
                    }
                    list.add(map);
                }
            }
        }
        //遍历解析出来的list
        for (Map<String,String> map1 : list) {
            for (Entry<String,String> entry : map1.entrySet()) {
                System.out.print(entry.getKey()+":"+entry.getValue()+",");
            }
            System.out.println();
        }
        return list;
    }
    
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
	            case Cell.CELL_TYPE_NUMERIC:{//数字类型都转为String
	            	if(DateUtil.isCellDateFormatted(cell)){
	                    //转换为日期格式yyyy-MM-dd HH:mm:ss
	                    cellValue = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell.getDateCellValue());
	                }else{
	                    //数字
	                	cell.setCellType(Cell.CELL_TYPE_STRING);//String 类型
	                	cellValue = cell.getStringCellValue() + "";
	                    //cellValue = String.valueOf(cell.getNumericCellValue());//数字变成科学计数法
	                }
	                break;
	            }
	            case Cell.CELL_TYPE_FORMULA:{
	                //判断cell是否为日期格式
	                if(DateUtil.isCellDateFormatted(cell)){
	                    //转换为日期格式YYYY-mm-dd
	                    cellValue = cell.getDateCellValue();
	                }else{
	                    //数字
	                	cell.setCellType(Cell.CELL_TYPE_STRING);//String 类型
	                	cellValue = cell.getStringCellValue() + "";
	                }
	                break;
	            }
	            case Cell.CELL_TYPE_STRING:{
	                cellValue = cell.getRichStringCellValue().getString();
	                break;
	            }
	            default:
	                cellValue = "";
	         	}
        }else{
            cellValue = "";
        }
        return cellValue;
    }

    public static boolean isRowEmpty(Row row){
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK){
                return false;
            }
        }
        return true;
  }
    public static boolean isTile(Row row){
    	Cell cell = row.getCell(0);
	    	if ("型号".equals(cell.toString().trim())) {
				return true;
			}
        return false;
  }
}