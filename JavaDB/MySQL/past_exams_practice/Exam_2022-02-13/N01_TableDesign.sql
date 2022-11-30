### 01.	Table Design

DROP DATABASE IF EXISTS online_store;
CREATE DATABASE 		online_store;
USE 					online_store;

CREATE TABLE        brands (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(40) 	NOT NULL 	UNIQUE      
);

CREATE TABLE        categories (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(40) 	NOT NULL 	UNIQUE      
);

CREATE TABLE        reviews (
               `id` INT 			PRIMARY KEY AUTO_INCREMENT,
          `content` TEXT,
           `rating` DECIMAL(10,2) 	NOT NULL,
      `picture_url` VARCHAR(80) 	NOT NULL,
     `published_at` DATETIME 		NOT NULL
);

CREATE TABLE        products (
	  	       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(40) 	NOT NULL,
            `price` DECIMAL(19,2) 	NOT NULL,
`quantity_in_stock` INT,
      `description` TEXT,
         `brand_id` INT 			NOT NULL,
      `category_id` INT 			NOT NULL,
        `review_id` INT,
         CONSTRAINT fk_products_ref_brands
        FOREIGN KEY (`brand_id`) 	REFERENCES brands(`id`),
         CONSTRAINT fk_products_ref_categories
        FOREIGN KEY (`category_id`) REFERENCES categories(`id`),
         CONSTRAINT fk_products_ref_reviews
        FOREIGN KEY (`review_id`) 	REFERENCES reviews(`id`)
);

CREATE TABLE        customers (
	  	       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
       `first_name` VARCHAR(20) 	NOT NULL,
        `last_name` VARCHAR(20) 	NOT NULL,
            `phone` VARCHAR(30) 	NOT NULL 	UNIQUE,
          `address` VARCHAR(60) 	NOT NULL,
    `discount_card` BIT(1)	 		NOT NULL 	DEFAULT 0
);

CREATE TABLE        orders (
	  	       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
   `order_datetime` DATETIME		NOT NULL,
      `customer_id` INT				NOT NULL,
         CONSTRAINT fk_orders_ref_customers
        FOREIGN KEY (`customer_id`) REFERENCES customers(`id`)
);

CREATE TABLE        orders_products (
	     `order_id` INT,
       `product_id` INT,
         CONSTRAINT fk_orders_products_ref_orders
        FOREIGN KEY (`order_id`) 	REFERENCES orders(`id`),
         CONSTRAINT fk_orders_products_ref_products
        FOREIGN KEY (`product_id`) 	REFERENCES products(`id`)
);
               

/*
01.	Table Design
You have been tasked to create the tables in the database by the following models:

# brands
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 40 characters. Unicode is NOT needed.	NULL is NOT permitted. UNIQUE values.

# categories
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 40 characters. Unicode is NOT needed.	NULL is NOT permitted. UNIQUE values.

# reviews
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
content			A very long string field	
rating			DECIMAL, up to 10 digits, 2 of which after the decimal point.			NULL is NOT permitted.
picture_url		A string containing a maximum of 80 characters. Unicode is NOT needed.	NULL is NOT permitted.
published_at	The publishing datetime of the review.	NULL is NOT permitted.

# products
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
name			A string containing a maximum of 40 characters. Unicode is NOT needed.	NULL is NOT permitted.
price			DECIMAL, up to 19 digits, 2 of which after the decimal point.			NULL is NOT permitted.
quantity_in_stock	Integer, from 1 to 2,147,483,647.	
description		A very long string field	
brand_id		Integer, from 1 to 2,147,483,647.										Relationship with table brands. NULL is NOT permitted.
category_id		Integer, from 1 to 2,147,483,647.										Relationship with table categories. NULL is NOT permitted.
review_id		Integer, from 1 to 2,147,483,647.										Relationship with table reviews.

# customers
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
first_name		A string containing a maximum of 20 characters. Unicode is NOT needed.	NULL is NOT permitted.
last_name		A string containing a maximum of 20 characters. Unicode is NOT needed.	NULL is NOT permitted.
phone			A string containing a maximum of 30 characters. Unicode is NOT needed	NULL is NOT permitted. UNIQUE values.
address			A string containing a maximum of 60 characters. Unicode is NOT needed.	NULL is NOT permitted.
discount_card	Can be true or false													NULL is NOT permitted. Default is FALSE

# orders
Column Name		Data Type																Constraints
id				Integer, from 1 to 2,147,483,647.										Primary Key AUTO_INCREMENT
order_datetime	The publishing datetime of the order.									NULL is NOT permitted.
customer_id		Integer, from 1 to 2,147,483,647.										Relationship with table customers. NULL is NOT permitted.

# orders_products
Column Name		Data Type																Constraints
order_id		Integer, from 1 to 2,147,483,647.										Relationship with table orders.
product_id		Integer, from 1 to 2,147,483,647.										Relationship with table products.

*/