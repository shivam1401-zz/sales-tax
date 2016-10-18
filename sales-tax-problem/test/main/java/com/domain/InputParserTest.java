package com.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.boku.model.Item;
import com.boku.parser.InputParser;

public class InputParserTest {

	private InputParser parser;
	
	private List<String> inputItems = null;
	
	private List<String> exclusions = null;
	
	private String[] input,exclusion,inputWithImportedItem;
	
	@Before
	public void setUp() throws Exception {
		input = new String[]{"1 chocolate at 0.50",  "1 perfume at 199.99"};
		exclusion = new String[]{"chocolate"};
		inputWithImportedItem = new String[]{"1 perfume at 199.99"};
	}

	@After
	public void tearDown() throws Exception {
		inputItems = null;
		exclusions = null;
	}

	@Test
	public void testParserShouldParseItems() {
		Set<Item> expectedItems = new HashSet<Item>();
		expectedItems.add(new Item(1, " chocolate", 0.50, true, false));
		expectedItems.add(new Item(1, " perfume", 199.99, false, false));

		inputItems = Arrays.asList(input);
		exclusions = Arrays.asList(exclusion);
		parser = new InputParser(inputItems, exclusions);
		List<Item> actualItems = parser.extractDataFromText();
		
		Assert.assertTrue(expectedItems.containsAll(actualItems));
	}
	
	@Test 
	public void testParserShouldDetectImportedItems(){
		Set<Item> expectedItems = new HashSet<Item>();
		expectedItems.add(new Item(1, " imported perfume", 199.99, false, true));
		inputItems = Arrays.asList(inputWithImportedItem);
		exclusions = Arrays.asList(exclusion);
		parser = new InputParser(inputItems, exclusions);
		List<Item> actualItems = parser.extractDataFromText();
		
		Assert.assertTrue(expectedItems.containsAll(actualItems));
	}

}
