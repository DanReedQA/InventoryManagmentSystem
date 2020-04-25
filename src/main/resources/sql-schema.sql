create database if not exists ims;
create table if not exists ims.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(item_id int primary key auto_increment, item_name varchar(40), value decimal(7,2) not null);
create table if not exists ims.orders (order_id int primary key auto_increment, customer_id int, total_value decimal(7,2) NOT NULL, FOREIGN KEY (customer_id) REFERENCES ims.customers (customer_id));
create table if not exists ims.orderline (order_id int, item_id int, FOREIGN KEY (item_id) REFERENCES ims.items (item_id), FOREIGN KEY (order_id) REFERENCES ims.orders (order_id));