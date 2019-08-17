package com.excel.util;


	
	import java.util.ArrayList;

	public class Excelutil {
		static ExcelReader excelReader;
		
		
		public static ArrayList<Object[]> getDataFromExcel() {
			ArrayList<Object[]>myData = new ArrayList<Object[]>();
			try {
				excelReader = new ExcelReader("C:\\Users\\Ronak\\eclipse-workspace\\CarGuruCarSearch\\src\\main\\newCars1.xlsx");
					
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			for (int rowNum = 2; rowNum <= excelReader.getRowCount("SearchNewCar"); rowNum++) {

				String selectMake= excelReader.getCellData("SearchNewCar", "selectMake", rowNum);
				String selectModel= excelReader.getCellData("SearchNewcar", "selectModel", rowNum);
				String selectYear= excelReader.getCellData("SearchNewcar", "selectYear", rowNum);
				String selectTrim= excelReader.getCellData("SearchNewcar", "selectTrim", rowNum);
				String  distance= excelReader.getCellData("SearchNewcar", "distance", rowNum);
				String zipcode = excelReader.getCellData("SearchNewcar", "zipcode", rowNum);

				Object ob[] = {selectMake,selectModel,selectYear,selectTrim,distance,zipcode};
				myData.add(ob);

				}
				return myData;
			
				
	

}
	}
