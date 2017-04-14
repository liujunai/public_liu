package poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;

/**
 * Created by titanic on 17-4-13.
 */
public class testPOIDemo {

    @Test
    public void HSSF() throws IOException {
        //创建一个工作薄excel文件
        Workbook wb = new HSSFWorkbook();    //HSSF操作excel 2003以下版本
        //创建一个工作表sheet
        Sheet sheet = wb.createSheet();
        //创建一个行对象Row
        Row nrow = sheet.createRow(4);  //指定行,坐标从0开始
        //创建一个单元格,列
        Cell nCell = nrow.createCell(3); //指定列
        //给单元格设置内容
        nCell.setCellValue("liujunfeng");
        //保存
        OutputStream os = new FileOutputStream(new File("/home/titanic/testPOI.xls"));
        wb.write(os);
        //关闭
        os.close();
    }

    //带格式
    @Test
    public void HSSFStyle() throws IOException {
        Workbook wb = new HSSFWorkbook();    //HSSF操作excel 2003以下版本
        Sheet sheet = wb.createSheet();

        Row nRow = sheet.createRow(4);  //指定行,坐标从0开始
        Cell nCell = nRow.createCell(3); //指定列
        nCell.setCellValue("liujunfeng");
        //创建一个单元格样式
        CellStyle titleStyle = wb.createCellStyle();
        //创建一个字体对象
        Font titleFont = wb.createFont();
        titleFont.setFontName("Noto Sans CJK SC Regular");            //设置字体
        titleFont.setFontHeightInPoints((short)40); //设置字体大小
        titleStyle.setFont(titleFont);              //加载样式


        Row xRow = sheet.createRow(5);
        Cell xCell = xRow.createCell(4);
        xCell.setCellValue("刘俊峰");
        CellStyle textStyle = wb.createCellStyle();
        Font textFont = wb.createFont();
        textFont.setFontName("AR PL UMing CN");
        textFont.setFontHeightInPoints((short)26);
        textStyle.setFont(textFont);

        xCell.setCellStyle(textStyle);
        nCell.setCellStyle(titleStyle);             //单元格绑定字体样式

        OutputStream os = new FileOutputStream(new File("/home/titanic/testPOI.xls"));
        wb.write(os);
        os.close();
    }


    /*
    * 不重复创建行，列，样式对象
    * 样式是wb.createCellStyle();创建的全局样式
    *
    * */
    @Test
    public void HSSFStyleM() throws IOException {
        Workbook wb = new HSSFWorkbook();    //HSSF操作excel 2003以下版本
        Sheet sheet = wb.createSheet();

        Row nRow = sheet.createRow(4);  //指定行,坐标从0开始
        Cell nCell = nRow.createCell(3); //指定列
        nCell.setCellValue("liujunfeng");


        CellStyle nStyle = wb.createCellStyle(); //创建一个单元格样式
        Font nFont = wb.createFont();            //创建一个字体对象

        nFont.setFontName("Noto Sans CJK SC Regular");            //设置字体
        nFont.setFontHeightInPoints((short)40); //设置字体大小
        nStyle.setFont(nFont);              //加载样式
        nCell.setCellStyle(nStyle);             //单元格绑定字体样式


        nRow = sheet.createRow(5);
        nCell = nRow.createCell(4);
        nCell.setCellValue("刘俊峰");
        //防止最后一个样式覆盖前面的样式,从新new一个
        nStyle = wb.createCellStyle();
        nFont = wb.createFont();

        nFont.setFontName("AR PL UMing CN");
        nFont.setFontHeightInPoints((short)26);
        nStyle.setFont(nFont);
        nCell.setCellStyle(nStyle);


        OutputStream os = new FileOutputStream(new File("/home/titanic/testPOI.xls"));
        wb.write(os);
        os.close();
    }

    //提取样式封装为对象
    @Test
    public void HSSFStyleMk() throws IOException {
        Workbook wb = new HSSFWorkbook();    //HSSF操作excel 2003以下版本
        Sheet sheet = wb.createSheet();

        Row nRow = sheet.createRow(4);  //指定行,坐标从0开始
        Cell nCell = nRow.createCell(3); //指定列
        nCell.setCellValue("liujunfeng");


        CellStyle nStyle = wb.createCellStyle(); //创建一个单元格样式
        Font nFont = wb.createFont();            //创建一个字体对象

        nCell.setCellStyle(this.titleStyle(wb,nStyle,nFont));      //单元格绑定字体样式


        nRow = sheet.createRow(5);
        nCell = nRow.createCell(4);
        nCell.setCellValue("刘俊峰");
        //样式初始化
        nStyle = wb.createCellStyle();
        nFont = wb.createFont();
        nCell.setCellStyle(this.textStyle(wb,nStyle,nFont));

        OutputStream os = new FileOutputStream(new File("/home/titanic/testPOI.xls"));
        wb.write(os);
        os.close();
    }

    //标题样式
    public CellStyle titleStyle(Workbook wb,CellStyle nStyle,Font nFont){
        nFont.setFontName("Noto Sans CJK SC Regular");            //设置字体
        nFont.setFontHeightInPoints((short)40);                   //设置字体大小
        nStyle.setFont(nFont);                                    //加载样式
       return nStyle;
    }

    //文字样式
    public CellStyle textStyle(Workbook wb,CellStyle nStyle,Font nFont){
        nFont.setFontName("AR PL UMing CN");
        nFont.setFontHeightInPoints((short)17);
        nStyle.setFont(nFont);
        return nStyle;
    }
}
