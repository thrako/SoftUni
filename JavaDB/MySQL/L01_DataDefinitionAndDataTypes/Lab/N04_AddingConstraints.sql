### Task 04. Adding Constraints

   ALTER TABLE products
ADD CONSTRAINT fk_products_ref_categories 
   FOREIGN KEY (`category_id`) 
    REFERENCES categories(id);