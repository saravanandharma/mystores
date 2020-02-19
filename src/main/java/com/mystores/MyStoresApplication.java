package com.mystores;

import com.mystores.inventory.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

	/*
          ================================================================
           Entry point to the application, this class initializes and
           bootstrap the application.
           Also it performs Processing the inventory from spread sheet as a
           bean initializer.

           Author: Saravanan Dharmalingam.
           ================================================================
     */


@SpringBootApplication
public class MyStoresApplication {

	public static final String INVENTORY_XLSX_FILE_PATH = "./MyStoreInventory2.xlsx";
	private static final Logger log = LoggerFactory.getLogger(MyStoresApplication.class);
	Workbook workbook = null;
	@Autowired
	private OrdersRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStoresApplication.class, args);

	}

		/*
           ================================================================
           Processing the inventory from spread sheet as a bean initializer.
           ================================================================
        */

	@Bean
	InitializingBean processInvetoryItems() throws IOException, InvalidFormatException {
		return () -> {
			try {
				// Creating a Workbook from an Excel file (.xls or .xlsx)
				workbook = WorkbookFactory.create(new File(INVENTORY_XLSX_FILE_PATH));

				// Retrieving the number of sheets in the Workbook
				System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

				XSSFSheet worksheet1 = (XSSFSheet) workbook.getSheetAt(0); // Product

				// Orders Data processing   - Sheet 1
				// ignore first row as it is for header.
				for (int i = 1; i < worksheet1.getPhysicalNumberOfRows(); i++) {
					Orders orders = new Orders();

					XSSFRow row = worksheet1.getRow(i);
					//orders.setId((long) row.getCell(0).getNumericCellValue());
					orders.setId(row.getCell(0).getStringCellValue());
					orders.setAmount((float) row.getCell(1).getNumericCellValue());
					orders.setCreated_date(row.getCell(2).getDateCellValue());

					log.info("Id: " + orders.getId());
					log.info("Amont: " + orders.getAmount());
					log.info("date: " + orders.getCreated_date());

					orderRepository.save(orders);

				}
				worksheet1 = null; // help GC to release the memory.

				// Product data processing   - Sheet 2
				// ignore first row as it is for header.
				XSSFSheet worksheet2 = (XSSFSheet) workbook.getSheetAt(1);
				for (int i = 1; i < worksheet2.getPhysicalNumberOfRows(); i++) {
					Products products = new Products();

					XSSFRow row = worksheet2.getRow(i);
					//products.setId(((int)row.getCell(0).getNumericCellValue()));
					products.setSku((row.getCell(1).getStringCellValue()));
					products.setQuantity((int) row.getCell(2).getNumericCellValue());
					products.setUnit_price((float) row.getCell(3).getNumericCellValue());

					log.info("sku: " + products.getSku());
					log.info("Quantity: " + products.getQuantity());
					log.info("unit price: " + products.getUnit_price());

					productRepository.save(products);

				}
				worksheet2 = null; // help GC to release the memory.

				// OrderItems data processing   - Sheet 3
				// ignore first row as it is for header.
				XSSFSheet worksheet3 = (XSSFSheet) workbook.getSheetAt(2);
				for (int i = 1; i < worksheet3.getPhysicalNumberOfRows(); i++) {
					OrderItems orderItems = new OrderItems();

					XSSFRow row = worksheet3.getRow(i);
					//orderItems.setOrderItemId((row.getCell(0).getStringCellValue()));
					orderItems.setOrderItemId(row.getCell(1).getStringCellValue());
					orderItems.setUnitPrice((float) row.getCell(2).getNumericCellValue());
					orderItems.setSku(row.getCell(2).getStringCellValue());
					orderItems.setUnitPrice((float) row.getCell(2).getNumericCellValue());

					//Save the Order Items
					orderItemRepository.save(orderItems);

					log.info("orderItemId: " + orderItems.getOrderItemId());
					log.info("SoldQuantity: " + orderItems.getSoldQuantity());
					log.info("UnitPrice: " + orderItems.getUnitPrice());
				}

				worksheet3 = null; // help GC to release the memory.
			} catch (InvalidFormatException ex) {
				log.error(ex.getMessage());

			} catch (IOException ex) {
				log.error(ex.getMessage());
			} finally {
				workbook = null;  // help GC to release the memory.
			}
		};
	}

}
