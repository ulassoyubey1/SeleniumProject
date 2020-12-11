package com.trendyolselenium.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelUtil {
    static Sheet workSheet;
    static Workbook workBook;
    private static String _excelSheetPath;
    private static int _excelSheetNumber;
    static Hashtable dict = new Hashtable();
    public ExcelUtil(String excelSheetPath,int excelSheetNumber){
        _excelSheetNumber = excelSheetNumber;
        _excelSheetPath = excelSheetPath;
    }
    public void OpenExcel() throws IOException, BiffException {
        workBook = Workbook.getWorkbook(new File(_excelSheetPath));
        workSheet = workBook.getSheet(_excelSheetNumber);
        ColumnDictionary();
    }
    public static int RowCount(){
        return workSheet.getRows();
    }
    private static String ReadCell(int column,int row){
        return workSheet.getCell(column,row).getContents();
    }
    public static String ReadCell(String columnName,int rowNumber) {
        return ReadCell(GetCell(columnName),rowNumber);
    }
    private static void ColumnDictionary(){
        for (int col = 0;col<workSheet.getColumns();col++){
            dict.put(ReadCell(col,0),col);
        }
    }

    private static int GetCell(String colName){
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        }catch (NullPointerException e){
            return (0);
        }
    }
}
