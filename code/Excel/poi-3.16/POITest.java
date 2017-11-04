import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class POITest{
	public void writeExcel(String filename) throws Exception{
		//创建新的Excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();

		//在Excel中新建一个工作表，起名为jsp
		HSSFSheet sheet = workbook.createSheet("jsp");

		//创建第一行
		HSSFRow row = sheet.createRow(0);

		//创建第一列
		HSSFCell cell = row.createCell((short)0);
		//单元格为字符串类型
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		//在单元格中输入一些内容
		cell.setCellValue("作者");
		//创建第二列
		cell = row.createCell((short)1);
		//定义单元格为字符串类型
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		//同上输入内容
		cell.setCellValue("编辑");
		FileOutputStream fos = new FileOutputStream(filename);
		workbook.write(fos);
		fos.flush();
		fos.close();
	}

	public static void main(String[] args){
		POITest ps = new POITest();
		try{
		    ps.writeExcel("C:\\Users\\MrLiao\\Desktop\\code\\Excel\\poi-3.16\\a.xls");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}