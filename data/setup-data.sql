INSERT INTO `cash_book` (`cash_book_id`, `cash_book_name`, `description`, `version`, `organization`, `status`, `cash_book_code`) VALUES (1,'Cash Book',NULL,NULL,'welfare','ACT','CASH');
INSERT INTO `cash_book_balance` (`cash_book_balance_id`, `balance`, `date`, `cash_book_id`, `version`) VALUES (1,1000.00,'2018-03-31 00:00:00',1,NULL);


INSERT INTO `final_account_element` (`element_id`, `ledger_account_id`, `elements_element_group_id`, `version`, `operator`) VALUES (1,1,1,NULL,'+'),(2,2,2,NULL,'+'),(3,3,2,NULL,'+'),(4,4,2,NULL,'-');
INSERT INTO `final_account_element_group` (`element_group_id`, `group_footer`, `group_header`, `parent_element_group_id`, `groups_structure_id`, `version`, `operator`) VALUES (1,'','Income',3,NULL,NULL,'+'),(2,NULL,'Expense',3,NULL,NULL,'-'),(3,'Net Profit','Profit And Loss Account',NULL,1,NULL,NULL);
INSERT INTO `final_account_structure` (`structure_id`, `final_account_type`, `version`, `organization`) VALUES (1,'PL',NULL,'welfare'),(2,'B',NULL,'welfare');


INSERT INTO `item_brand` (`item_brand_id`, `brand_name`, `low_stock_quantity`, `low_stock_unit`, `profit_type`, `profit_value`, `item_category_id`) VALUES (1,'Lifebuoy Soap',NULL,NULL,NULL,NULL,1),(2,'Baby Cheramy Soap',NULL,NULL,NULL,NULL,1),(3,'Signal Toothpaste',NULL,NULL,NULL,NULL,2),(4,'Cloguard Toothpaste',NULL,NULL,NULL,NULL,2);
INSERT INTO `item_category` (`item_category_id`, `version`, `description`, `item_category_code`, `low_stock_quantity`, `low_stock_unit`, `profit_type`, `profit_value`) VALUES (1,NULL,'Soap','soap',NULL,NULL,NULL,NULL),(2,NULL,'Toothpaste','toothpaste',NULL,NULL,NULL,NULL);


INSERT INTO `ledger_account` (`ledger_account_id`, `account_name`, `description`, `ledger_category`, `status`, `attached_account_id`, `version`, `organization`) VALUES (1,'Sales','Sales','I','ACT',NULL,NULL,'welfare'),(2,'Purchases','Purchases','X','ACT',NULL,NULL,'welfare'),(3,'Opening Stock','Opening Stock','N','ACT',NULL,NULL,'welfare'),(4,'Closing Stock','Closing Stock','A','ACT',NULL,NULL,'welfare');
INSERT INTO `ledger_account_balance` (`ledger_account_balance_id`, `balance`, `date`, `ledger_account_id`, `version`, `status`, `ledger_account_ledger_account_id`) VALUES (1,100.00,'2018-11-01 00:00:00',3,NULL,'ACT',NULL),(2,200.00,'2018-11-30 00:00:00',4,NULL,'ACT',NULL);


INSERT INTO `supplier` (`supplier_id`, `name`, `address_line1`, `address_line2`, `contact_information_id`, `email_address`, `phone_number`) VALUES (1,'Kularathna',NULL,NULL,NULL,NULL,NULL),(2,'Ranatunga',NULL,NULL,NULL,NULL,NULL);


INSERT INTO `transaction_type` (`transaction_type_id`, `description`, `status`, `transaction_category`, `transaction_name`, `parent_type_id`, `version`, `organization`, `transaction_code`) VALUES (1,'Sales','ACT','D','Sales',NULL,NULL,'welfare','SALES'),(2,'Purchases','ACT','C',NULL,NULL,NULL,'welfare','PURCHASES');
INSERT INTO `transaction_type_ledger_account` (`transaction_type_id`, `ledger_account_id`) VALUES (1,1),(2,2);

