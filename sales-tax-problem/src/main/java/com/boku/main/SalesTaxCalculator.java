package com.boku.main;

import com.boku.service.TaxCalculatorService;
import com.boku.service.TaxCalculatorServiceImpl;

/**
 * @author shivammishra
 *
 */
public class SalesTaxCalculator {
	
	private static TaxCalculatorService taxCalculatorService = TaxCalculatorServiceImpl.getInstance();

	public static void main(String [] args){
		if (args.length > 0){
			try {
				taxCalculatorService.calculateTax(args[0]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Specify file name after the command: java SalesTaxMain.java <filePath>");
		}
	}
}
