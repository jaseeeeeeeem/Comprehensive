package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	public void initialiseWorkbook(String sname) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\ExcelFiles\\exceldata.xlsx");
		workbook=new XSSFWorkbook(fis);
		for(int i=0;i<workbook.getNumberOfSheets();i++)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sname))
			{
				sheet=workbook.getSheetAt(i);
				break;
			}
		}
	}
	
	public ArrayList<String> l=new ArrayList<String>();
	
	public ArrayList<String> getData(String tname)
	{
		Iterator<Row> rows= sheet.rowIterator();
		Row firstrow=rows.next();
		Iterator<Cell> cells=firstrow.cellIterator();
		int index=0;
		while(cells.hasNext())
		{
			if(cells.next().getStringCellValue().equalsIgnoreCase("testcase"))
			{
				break;
			}
			else
			{
				index+=1;
			}
		}
		while(rows.hasNext())
		{
			Row r1=rows.next();
			if(r1.getCell(index).getStringCellValue().equalsIgnoreCase(tname))
			{
				Iterator<Cell> c1=r1.cellIterator();
				for(int i=0;i<index;i++)
				{
					c1.next();
				}
				while(c1.hasNext())
				{
					l.add(c1.next().getStringCellValue());
				}
				break;
			}
		}
		return l;
	}

}
