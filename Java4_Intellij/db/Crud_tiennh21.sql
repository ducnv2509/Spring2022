CREATE DATABASE CRUD_Tiennh21
GO

USE CRUD_tiennh21

CREATE TABLE Users
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	fullName NVARCHAR(255),
	address NVARCHAR(255),
	email NVARCHAR(255),
	password NVARCHAR(255),
	phone NVARCHAR(15) UNIQUE,
	avatar NVARCHAR(255)
)
GO

INSERT INTO dbo.Users
(
    fullName,
    address,
    email,
    password,
    phone,
    avatar
)
VALUES
(   'Nguyen DUc2', -- fullName - nvarchar(255)
    'Ha NOi', -- address - nvarchar(255)
   'duc@gmail.com', -- email - nvarchar(255)
    '123', -- password - nvarchar(255)
    '0342429178', -- phone - nvarchar(15)
    NULL  -- avatar - nvarchar(255)
    )
	SELECT * FROM dbo.Users


USE Wish

SELECT * FROM dbo.Account
SELECT * FROM dbo.Cart
SELECT * FROM  dbo.Category
SELECT * FROM dbo.product