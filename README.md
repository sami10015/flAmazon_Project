<snippet>
# flAmazon Program

This program allows a user to keep track of his/her order on a fictional website called "flAmazon."  The user's data is stored in an Access 2013 database.  The database is stored in the top-level folder of my Eclipse project, and also in this repository.  The shopping cart is shown within a JTable.  The program includes a main menu bar with File, Tools, and Help items.  

## Database ShoppingCart Table Fields
1. ItemID: Integer/Primary Key/Indexed(No Duplicates)
2. ItemName: Short Text(up to 20 characters)/Indexed(No Duplicates)
3. Category: Short Text(up to 20 characters)
4. Quantity: Integer
5. Price: Currency
6. Shipping: Currency

##File Menu
1. Provided an exit operation, which will exit the application
2. Application is not allowed to exit on close

##Tools Menu - Add Item
1. Add Item pops up a second window, on which the user is prompted to enter six pieces of information for adding a new item.
2. All these pieces of information correspond to the fields within the ShoppingCart table
3. Data validation is considered when entering an TtemID and ItemName due to no duplicates being allowed
 
##Tools Menu - Set Sort
1. The Set Sort menu has sub-menus "By Item Name", "By Price", and "By Category"
2. It sets he sort setting of the data to be one of those options
3. Created more sub-menus to allowed if they want the data to be sorted in a descending or ascending order

##Tools Menu - Set Filter
1. The Set Filter menu has sub-menus "By Price", and "By Category"
2. These set one or more filter settings which are used every time the items are redisplayed
3. The Filter Settings restric the output shown to those meeting certain criteria
4. By Price option pops up a window that allows the user to specify all items that are less than a certain price, all items that are more than a certain price, or all items in a range of prices
5. By Category option pops up a window that will allow the user to select one or more categories to only display in the shopping cart

</snippet>
