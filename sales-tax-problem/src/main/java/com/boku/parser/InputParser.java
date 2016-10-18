package com.boku.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.boku.model.Item;
import com.google.common.base.Joiner;

/**
 * @author shivammishra
 * It parses the input file passed from user and classifies the items based on whether it 
 * is exempted or imported or both. 
 *
 */
public class InputParser {

	private final List<String> inputText;
	
	private final List<String> exclusions;
	
	private final String REGEX_CLASSIFIER = "(\\d+)([a-zA-Z0-9_\\s]+?)( at )(\\d+.\\d+)";
	
	private final String IMPORTED_CLASSIFIER = "IMPORTED";
	
	public InputParser(List<String> inputText, List<String> exclusions){
		this.inputText = inputText;
		this.exclusions = exclusions;
	}
	
	/*
	 * take each item description and parse it and extract the required related info.
	 */
	public List<Item> extractDataFromText(){
		List<Item> items = new ArrayList<Item>();
		for (String item : inputText) {
			items.add(parser(item));
		}
		return items;
	}
	
	/*
	 * parses the item and assign value to its respective attributes.
	*/
	private Item parser(String itemText){
		Pattern textPattern = Pattern.compile(REGEX_CLASSIFIER, Pattern.CASE_INSENSITIVE);
		Matcher textMatcher = textPattern.matcher(itemText);
		Integer qty = null;
		Double price = null;
		String desc = null;
		if (textMatcher.find()){
			qty = Integer.parseInt(textMatcher.group(1));
			price = Double.parseDouble(textMatcher.group(4));
			desc = textMatcher.group(2);
		}
		return new Item(qty, desc, price, isExcluded(itemText), isImported(itemText));
	}
	
	/*
	 * @param: String containing item description 
	 * @output: boolean (whether it is one of excluded item or not.)
	*/
	private boolean isExcluded(String itemText){
		Joiner joiner = Joiner.on("|");
		Pattern exclusionPattern = Pattern.compile(joiner.join(exclusions), Pattern.CASE_INSENSITIVE);
		Matcher exclusionMatcher = exclusionPattern.matcher(itemText);
		return exclusionMatcher.find();
	}
	
	/*
	 * @param: String containing item description 
	 * @output: boolean 
	 * its check whether given line contains imported item based on predefined pattern.
	*/
	private boolean isImported(String itemText){
		Pattern importPattern = Pattern.compile(IMPORTED_CLASSIFIER, Pattern.CASE_INSENSITIVE);
		Matcher importMatcher = importPattern.matcher(itemText);
		return importMatcher.find();
	}
	
}
