# ShoppingList
Patch notes:

Reworked project to new version, at least looks better than old one.
Added more tables with list and account entities.
Also added some html and site jsp`s.

Problems:

Having problems with appConfig and Bean configurations, all implementations are correct
and all code works with clean, compile, test, and validate options.

P.S.

Thinking about to delete all classes and set up this as general.

v.1.1. Test

---
Patch notes:
*Moving to web app with shopping list.*

Problems with jsp and Category showing method

---
Patch notes:
*Moved to Hibernate and partly configured output.*

Problems with output to Category and saving only name and id without discount and description.

v.1.0.2

---
Patch Notes:
*Partly moved on spring*

v.1.0.1

---
App can:
Create, delete, show category.

Shopping list patch notes:

Added: 
*Category, Discount, Description functions*

- price of product can be more than 0.
- discount can be more than 100 % and less than 0.
- name must be form 3 to 32 symbols.
- #####Refactored with Single Responsibility Principle

Tests were done on:

- ProductService
- Product
- NameValidationRule
- ProductValidationRule

v 1.0.0

---