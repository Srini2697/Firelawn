package com.Ecommerce.Firelawn.genericLIB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;



/**
 * 
 * @author Srinivas M
 *
 */
public class FileUtilies {
	public static Connection con;
	
	/**
	 * it is used to read the data from property file 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getthepropertydata(String key) throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(AutoConstant.propoertyFilepath);
		p.load(fis);
		return p.getProperty(key);
	}
	/**
	 * it is used to read the data from excel file 
	 * @param Sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getexcelData(String sheetname, int rownumb,int cellnumb) throws EncryptedDocumentException, IOException {
		String s="";
		FileInputStream fis=new FileInputStream(AutoConstant.execelPath);
		Workbook wb = WorkbookFactory.create(fis);
		s = wb.getSheet(sheetname).getRow(rownumb).getCell(cellnumb).getStringCellValue();
		return s;
	}
	/**
	 * it is used to read the date from database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getdataDB() throws SQLException {
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","harsha","harsha");
		 
	}
	 /**
	  * it is execuit the query
	  * @param query
	  * @param columName
	  * @param ExceptedResult
	  * @return
	  * @throws SQLException
	  */
	
	public String queyExecution(int columName,String ExceptedResult) throws SQLException {
		Statement statemnet = con.createStatement();
		String query="select * from firelawncarddetails";
		ResultSet result = statemnet.executeQuery(query);
		
		
		while(result.next()) {
			if( result.getString(columName).equals(ExceptedResult)) {
				break;
			}
			else
			{
				System.out.println("data not found");
			}
			}
		return ExceptedResult;
	}
	public static void closedb() throws SQLException {
		con.close();
	}
}

	
	 
