CREATE DATABASE hoteldb;
USE hoteldb;
CREATE TABLE room(
                     room_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     available BOOLEAN NOT NULL,
                     type VARCHAR(255) NOT NULL,
                     capacity VARCHAR(255) NOT NULL,
                     price DECIMAL(7,2) NOT NULL
);
CREATE TABLE customer(
                         customer_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         first_name VARCHAR(255) NOT NULL,
                         last_name VARCHAR(255) NOT NULL
);
CREATE TABLE Booking(
                        booking_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        customer_id int NOT NULL,
                        room_id int NOT NULL,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                        CONSTRAINT fk_room_id FOREIGN KEY (room_id) REFERENCES room(room_id),
);
