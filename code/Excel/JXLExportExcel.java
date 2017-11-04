package org.nfmedia.filesystem.util;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.nfmedia.filesystem.model.Department;
import org.nfmedia.filesystem.model.UploadFile;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
* @author jan  
* @E-mail:ja.janliao@gmail.com
* @version V1.0
* @date 2017年8月10日 下午7:42:37
* 
*/
public class ExportExcel {

	public static void exportExcel(String fileName, String[] title, List dataList) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("aplication/vnd.ms-excel");  
        response.addHeader("Content-Disposition", "inline; filename="  
                        + fileName + ".xls");
        try{
        	// 创建Excel工作薄  
            WritableWorkbook wwb = Workbook.createWorkbook(response  
                    .getOutputStream());  
  
            // 添加第一个工作表并设置第一个Sheet的名字  
            WritableSheet sheet = wwb.createSheet(fileName, 0); 
  
            Label label;  
            
            //设置列宽度
            sheet.setColumnView(0, 10);
            sheet.setColumnView(3, 10);
            sheet.setColumnView(6, 30);
            
            //单元格样式
            WritableCellFormat wcf_title = new WritableCellFormat();
            wcf_title.setBackground(jxl.format.Colour.GRAY_25);
            wcf_title.setAlignment(jxl.format.Alignment.CENTRE);
            //添加标题
            if(title!=null){
            	for (int i = 0; i < title.length; i++) {  
                    label = new Label(i, 0, title[i],wcf_title);  
                    sheet.addCell(label);  
                }
            }
            // 下面是填充数据
    		//label 构造函数 第一个参数为列 ，第二个为行，第三个为内容值
            if(dataList != null && dataList.size() > 0 ){
            	int count=0;
            	for(int i=0,size=dataList.size();i<size;i++){
//            			Object[] row = (Object[])dataList.get(i);
            			UploadFile uploadFile = (UploadFile) dataList.get(i);
                        sheet.addCell(new Label(0, i+1,DateUtil.DateToString(uploadFile.getDateOfText())));
                        sheet.addCell(new Label(1, i+1,uploadFile.getSerial())); 
                        sheet.addCell(new Label(2, i+1,uploadFile.getTitle())); 
                        sheet.addCell(new Label(3, i+1,uploadFile.getDescription())); 
                        sheet.addCell(new Label(4, i+1,uploadFile.getPartnerName())); 
                        sheet.addCell(new Label(5, i+1,uploadFile.getDepartment().getDepartmentName())); 
                        sheet.addCell(new Label(6, i+1,uploadFile.getOperator())); 
                        sheet.addCell(new Label(7, i+1,uploadFile.getContractValue())); 
                        sheet.addCell(new Label(8, i+1,DateUtil.DateToString(uploadFile.getExpiryDateStart())+"至"+DateUtil.DateToString(uploadFile.getExpiryDateEnd()))); 
            	        count++;
            	}
            	sheet.addCell(new Label(0, count+2,"文件总份数:"));
            	sheet.addCell(new Label(1, count+2,String.valueOf(dataList.size())));
            }
            wwb.write();  
            // 关闭  
            wwb.close();  
        }catch (Exception e) {  
            e.printStackTrace();  
        }
		
	}
}
