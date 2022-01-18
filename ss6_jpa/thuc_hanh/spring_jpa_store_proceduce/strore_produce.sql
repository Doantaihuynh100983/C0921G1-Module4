SELECT * FROM quan_ly_bai_hat.customers;
DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO quan_ly_bai_hat.customers(firstName,lastName) VALUES (first_name,last_name);
END//
DELIMITER ;