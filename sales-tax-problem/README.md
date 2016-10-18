Problem
-----------------

SALES TAX PROBLEM

Basic sales tax is applicable at a rate of 10% on all goods, except books, food,
and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no
exemptions.
When I purchase items I receive a receipt that lists the name of all the items and
their price (including tax), finishing with the total cost of the items, and the total
amounts of sales tax paid. The rounding rules for sales tax are that for a tax rate
of n%, a shelf price of p contains np/100 rounded up to the nearest 0.05 amount
of sales tax.


INPUTS:

	Input 1:
		1 book at 12.49
		1 music CD at 14.99
		1 chocolate bar at 0.85
		
		
	Input 2:
		1 imported box of chocolates at 10.00
		1 imported bottle of perfume at 47.50
		
	Input 3:
		1 imported bottle of perfume at 27.99
		1 bottle of perfume at 18.99
		1 packet of headache pills at 9.75
		1 box of imported chocolates at 11.25

OUTPUTS:

	Output 1:
		1 book : 12.49
		1 music CD: 16.49
		1 chocolate bar: 0.85
		Sales Taxes: 1.50
		Total: 29.83
		
	Output 2:
		1 imported box of chocolates: 10.50
		1 imported bottle of perfume: 54.65
		Sales Taxes: 7.65
		Total: 65.15
		
	Output 3:
		1 imported bottle of perfume: 32.19
		1 bottle of perfume: 20.89
		1 packet of headache pills: 9.75
		1 imported box of chocolates: 11.85
		Sales Taxes: 6.70
		Total: 74.68


Solution
-----------------
Implemented a simple sales tax calculator application , which can load shopping list items from the static file, calculate total price and sales tax and show purchase receipt.

Assumption
-------------------
1. Shopping cart data will be stored temporarily
2. Implementation can be done using any latest technology and this solution based on OOD(obeject oriented design).
3. Require maven to run this application
4. The following assumption is made from the input requirement
	a. System will decide whether a product is imported or not based on "imported" word token from  the product description
	b. Every line item in the input data will use either this format <qty> <desc> at <price> OR  <qty> <imported> <desc> at <price>
    c. Exempt items are determined from static file list which is placed under input folder.


To get started, please complete the following steps:

1. Download/checkout project
2. Extract the file to a folder
3. Go to the extracted project root folder
4. Run this command from Terminal/Command Line - "run mvn clean install".
5. There will be a generated jar under target folder of the project. 
5. Run the jar via " java -jar <jar-name>.jar <input-file-path>.
eg: java -jar salesCalculator.jar input/input1.txt

Technology Used
-----------------

Core Java and maven