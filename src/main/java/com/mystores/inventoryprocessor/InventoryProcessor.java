package com.mystores.inventoryprocessor;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryProcessor {
} /*{


           =========================================================================================
           Alternate way of processing the spreadsheet through REST service  /import
           This service can be intergrated with a UI componenet, so that user can upload the inventory
           file from the UI.

           Author: Saravanan Dharmalingam
           ==========================================================================================

    @PostMapping("/import")
    public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {

        List<Orders> tempOrdersList = new ArrayList<Orders>();
        XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0); // Product

        Workbook workbook = WorkbookFactory.create(new File(INVENTORY_XLSX_FILE_PATH));

			// Retrieving the number of sheets in the Workbook
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

			XSSFSheet worksheet1 = (XSSFSheet) workbook.getSheetAt(0); // Product

			// Orders Data processing
			for (int i = 1; i < worksheet1.getPhysicalNumberOfRows(); i++) {
				Orders orders = new Orders();

				XSSFRow row = worksheet1.getRow(i);
				orders.setId((long) row.getCell(0).getNumericCellValue());
				orders.setAmount((float) row.getCell(1).getNumericCellValue());
				orders.setCreated_date((Date) row.getCell(2).getDateCellValue());

				System.out.println("Id: " + orders.getId());
				System.out.println("Amont: " + orders.getAmount());
				System.out.println("date: " + orders.getCreated_date());

				orderRepository.save(orders);
			}

			// Product data processing
		     worksheet1 = (XSSFSheet) workbook.getSheetAt(1);
			for (int i = 1; i < worksheet1.getPhysicalNumberOfRows(); i++) {
				Products products = new Products();

				XSSFRow row = worksheet1.getRow(i);
				products.setId(((int)row.getCell(0).getNumericCellValue()));
				products.setSku((row.getCell(1).getStringCellValue()));
				products.setQuantity((int) row.getCell(2).getNumericCellValue());
				products.setUnit_price((float) row.getCell(3).getNumericCellValue());

				System.out.println("sku: " + products.getSku());
				System.out.println("Quantity: " + products.getQuantity());
				System.out.println("unit price: " + products.getUnit_price());

				productRepository.save(products);
			}


			// OrderItems data processing
			worksheet1 = (XSSFSheet) workbook.getSheetAt(2);
			for (int i = 1; i < worksheet1.getPhysicalNumberOfRows(); i++) {
				OrderItems orderItems = new OrderItems();

				XSSFRow row = worksheet1.getRow(i);
				orderItems.setOrderItemId((row.getCell(0).getStringCellValue()));
				orderItems.setSoldQuantity((long) row.getCell(1).getNumericCellValue());
				orderItems.setUnitPrice((float) row.getCell(2).getNumericCellValue());

				//Save the Order Items
				orderItemRepository.save(orderItems);

				System.out.println("orderItemId: " + orderItems.getOrderItemId());
				System.out.println("SoldQuantity: " + orderItems.getSoldQuantity());
				System.out.println("UnitPrice: " + orderItems.getUnitPrice());


			}


		}
    }
}*/
