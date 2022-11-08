### Task 05. Online Store Database

CREATE TABLE items (
		 `item_id` INT PRIMARY KEY AUTO_INCREMENT,	
		    `name` VARCHAR(50),	
	`item_type_id` INT    
);

CREATE TABLE item_types (
	`item_type_id` INT PRIMARY KEY AUTO_INCREMENT,	
	        `name` VARCHAR(50)
);

CREATE TABLE customers (
     `customer_id` INT PRIMARY KEY AUTO_INCREMENT,	
            `name` VARCHAR(50),
	    `birthday` DATE,
		 `city_id` INT    
);

CREATE TABLE cities (
         `city_id` INT PRIMARY KEY AUTO_INCREMENT,	
	        `name` VARCHAR(50)
);

CREATE TABLE orders (
	    `order_id` INT PRIMARY KEY AUTO_INCREMENT,	
	 `customer_id` INT
);

CREATE TABLE order_items (
	    `order_id` INT,	
	     `item_id` INT,
	CONSTRAINT pk_order_items
		PRIMARY KEY (`order_id`, `item_id`)
);

ALTER TABLE items
	ADD CONSTRAINT fk_items_ref_item_types
		FOREIGN KEY (`item_type_id`) REFERENCES item_types(`item_type_id`);
    
ALTER TABLE customers
	ADD CONSTRAINT fk_customers_ref_cities
		FOREIGN KEY (`city_id`) REFERENCES cities(`city_id`);

ALTER TABLE orders
	ADD CONSTRAINT fk_orders_ref_customers
		FOREIGN KEY (`customer_id`) REFERENCES customers(`customer_id`);

ALTER TABLE order_items
	ADD CONSTRAINT fk_order_items_ref_orders
		FOREIGN KEY (`order_id`) REFERENCES orders(`order_id`),
    ADD CONSTRAINT fk_order_items_ref_items
		FOREIGN KEY (`item_id`) REFERENCES items(`item_id`);