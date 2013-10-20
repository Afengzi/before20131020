package com.klov.readExcel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * <title>ReadExcel</title>
 *
 * <project>HelperUtil</project>
 *
 * <package>com.klov.readExcel</package>
 *
 * <file>ReadExcel.java</file>
 *
 * <date>2012-12-6</date>
 *
 * <brief>读取Excel表格</brief>
 *
 * @author klov
 *
 */
public class ReadExcel {

	final Logger LOG = Logger.getLogger("Logger");

	// excel路径
	private String excelUrl;
	// 输入流
	private InputStream in;

	public ReadExcel(String excelUrl) {
		this.excelUrl = excelUrl;
		in = this.getClass().getClassLoader().getResourceAsStream(excelUrl);
	}

	/**
	 * param[0]:设定开始行，[1]设定读取的sheet的名字，[2]读取列号,[3]读取列号,[...]
	 * 
	 * @param param
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<String[]> readExcel(String[] param) throws FileNotFoundException, IOException {
		List<String[]> list = new ArrayList<String[]>();
		// 承装每一行的值
		String[] context = null ;
		POIFSFileSystem fsys = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(fsys);
		// 读取工作薄
		HSSFSheet imp = wb.getSheetAt(wb.getSheetIndex(param[1]));
		// 工作薄中的所有行数
		int rows = imp.getLastRowNum();
		// 开始行
		int rowStart = Integer.parseInt(param[0]);
		HSSFCell value = null;
		String cont = null;
		int index = 1;
		for (int i = rowStart; i < rows + 1; i++) {
			
			context = new String[param.length - 2];
			HSSFRow row = imp.getRow(i);
			if (row == null) {
				continue;
			}

			for (int j = 2; j < param.length; j++) {

				value = row.getCell(Short.parseShort(param[j]));
				if (value != null) {
					cont = getContent(value);
					context[j - 2] = cont;
				}

			}
			list.add(context);

			index++;
		}
		LOG.warning("start:" + rowStart + ",end:" + index);
		return list;
	}

	/**
	 * 转换每一各的值
	 * @param cell
	 * @return
	 */
	private String getContent(HSSFCell cell) {
		String str = "";
		if (cell != null) {
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					str = cell.getStringCellValue();
					break;

				case HSSFCell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						if (date != null) {
							str = new SimpleDateFormat("yyyymmdd").format(date);
						} else {
							str = new SimpleDateFormat("yyyymmdd").format(new Date());
						}

					} else {
						str = new DecimalFormat("0").format(cell.getNumericCellValue());
					}
					break;
				default:
					str = "unknow";
			}

		}
		return str;
	}

	/**
	 * @return the excelUrl
	 */
	public String getExcelUrl() {
		return excelUrl;
	}

	/**
	 * @param excelUrl the excelUrl to set
	 */
	public void setExcelUrl(String excelUrl) {
		this.excelUrl = excelUrl;
	}

	/**
	 * @return the in
	 */
	public InputStream getIn() {
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(InputStream in) {
		this.in = in;
	}

}
