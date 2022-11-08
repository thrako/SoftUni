### 01.	Table Design

DROP DATABASE IF EXISTS restaurant_db;
CREATE DATABASE 		restaurant_db;
USE 					restaurant_db;

CREATE TABLE        products (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
             `name` VARCHAR(30) 	NOT NULL UNIQUE,
             `type` VARCHAR(30) 	NOT NULL,
            `price` DECIMAL(10,2) 	NOT NULL
);

CREATE TABLE        clients (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
       `first_name` VARCHAR(50) 	NOT NULL,
        `last_name` VARCHAR(50) 	NOT NULL,
        `birthdate` DATE 			NOT NULL,
             `card` VARCHAR(50) 	,
           `review` TEXT	 		       
);

CREATE TABLE        `tables` (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
            `floor` INT 			NOT NULL,
         `reserved` BOOLEAN 		,
         `capacity` INT 			NOT NULL
);

CREATE TABLE        waiters (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
       `first_name` VARCHAR(50) 	NOT NULL,
        `last_name` VARCHAR(50) 	NOT NULL,
            `email` VARCHAR(50) 	NOT NULL,
            `phone` VARCHAR(50) 	,
           `salary` DECIMAL(10,2) 	       
);

CREATE TABLE        orders (
		       `id` INT 			PRIMARY KEY AUTO_INCREMENT,
         `table_id` INT 			NOT NULL,
        `waiter_id` INT 			NOT NULL,
       `order_time` TIME 			NOT NULL,
     `payed_status` BOOLEAN         ,
         CONSTRAINT fk_orders_ref_tables
        FOREIGN KEY (`table_id`) REFERENCES `tables`(`id`),
         CONSTRAINT fk_orders_ref_waiters
        FOREIGN KEY (`waiter_id`) REFERENCES waiters(`id`)
);

CREATE TABLE        orders_clients (
		 `order_id` INT 			,
        `client_id` INT 			,
         CONSTRAINT fk_orders_clients_ref_orders
        FOREIGN KEY (`order_id`) REFERENCES orders(`id`),
         CONSTRAINT fk_orders_clients_ref_clients
        FOREIGN KEY (`client_id`) REFERENCES clients(`id`)
--         ,       
--          CONSTRAINT pk_orders_clients
--         PRIMARY KEY (`order_id`, `client_id`)
);

CREATE TABLE        orders_products (
		 `order_id` INT 			,
       `product_id` INT 			,
         CONSTRAINT fk_orders_products_ref_orders
        FOREIGN KEY (`order_id`) REFERENCES orders(`id`),
         CONSTRAINT fk_orders_products_ref_products
        FOREIGN KEY (`product_id`) REFERENCES products(`id`)
    --     ,
--          CONSTRAINT pk_orders_products
--         PRIMARY KEY (`order_id`, `product_id`)
);




/*

*/