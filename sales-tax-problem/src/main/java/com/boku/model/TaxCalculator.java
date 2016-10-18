package com.boku.model;

import java.util.List;
import com.boku.util.NumberUtils;

/**
 * @author shivammishra
 * This class actually does all core work and compute the tax. 
 * 
 */
public class TaxCalculator {
	
	private final double SALES_TAX_RATE = 0.10d;
	
	private final double IMPORT_TAX_RATE = 0.05d;
	
	private final List<Item> items;
	
	private double total;
	
	private double salesTaxes;

	
	public TaxCalculator(List<Item> items){
		this.items = items;
	}
	
	public double getTotalAll() {
		return NumberUtils.roundOff(total+salesTaxes);
	}

	public double getSalesTaxes() {
		return salesTaxes;
	}
	
	/*
	 * This method works on below logic:
	 * 1) total: it stores total price of items in bucket.
	 * 2) salesTaxes: it stores the total sales tax.
	 */
	public void computeTax(){
		for (Item item : items) {
			if (!item.isExcluded())
				item.setSalesTax(NumberUtils.roundOff(getSalesTax(item.getPrice())));
			if (item.isImported())
				item.setImportTax(NumberUtils.roundOff(getImportTax(item.getPrice())));
			total = total + (item.getQuantity()*item.getPrice());
			salesTaxes = NumberUtils.roundOff(salesTaxes + item.getTotalTax());
		}
	}
		
	private double getSalesTax(double price){
		return price * SALES_TAX_RATE;
	}
	
	private double getImportTax(double price){
		return price * IMPORT_TAX_RATE;
	}
}
