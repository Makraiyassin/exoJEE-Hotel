DROP DATABASE hoteldb;
CREATE DATABASE hoteldb;
USE hoteldb;
CREATE TABLE room(
                     room_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     available BOOLEAN NOT NULL,
                     type VARCHAR(255) NOT NULL,
                     capacity int NOT NULL,
                     price DECIMAL(7,2) NOT NULL
);
CREATE TABLE customer(
                         customer_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         last_name VARCHAR(255) NOT NULL,
                         first_name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL,
);
CREATE TABLE Booking(
                        booking_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        customer_id int NOT NULL,
                        room_id int NOT NULL,
                        date_begin DATE NOT NULL,
                        date_end DATE NOT NULL,
                        CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                        CONSTRAINT fk_room_id FOREIGN KEY (room_id) REFERENCES room(room_id)
);

INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'BASIC', 2, 200.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'SUITE', 6, 400.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'BASIC', 2, 200.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'SUITE', 6, 400.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'BASIC', 2, 200.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'SUITE', 6, 400.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'BASIC', 2, 200.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'MEDIOR', 4, 300.99);
INSERT INTO `room` (`room_id`, `available`, `type`, `capacity`, `price`) VALUES (NULL, 1, 'SUITE', 6, 400.99);




