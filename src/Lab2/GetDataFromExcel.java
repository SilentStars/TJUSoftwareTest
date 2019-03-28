package Lab2;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.Contract;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
public class GetDataFromExcel {
    @Contract("null -> null")
    public static Workbook readExcel(String fileName) {
        Workbook wb = null;
        if(fileName == null) {
            return null;
        }
        String extString = fileName.substring(fileName.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            if(".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if(".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wb;
    }

    public void analyzeExcel(String fileName, ArrayList<String> number, ArrayList<String> name, ArrayList<String> gitAddress) {
        try {
            Workbook wb = readExcel(fileName);
            Sheet s = wb.getSheetAt(0);

            for(int i = 2; i < s.getPhysicalNumberOfRows(); i++) {
                Row row  = s.getRow(i);
                number.add(getCellFormatValue(row.getCell(1)));
                name.add(getCellFormatValue(row.getCell(2)));
                gitAddress.add(getCellFormatValue(row.getCell(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String getCellFormatValue(Cell cell){
        String cellValue = "";
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case NUMERIC:{
//                    cellValue = cell.getNumericCellValue().toString();
                    Double dou = cell.getNumericCellValue();
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setGroupingUsed(false);
                    cellValue = nf.format(dou);
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }
        return cellValue;
    }
}
