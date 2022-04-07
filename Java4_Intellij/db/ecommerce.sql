CREATE DATABASE ecommerce
GO
USE ecommerce
GO

CREATE TABLE products
(
	id INT IDENTITY(1,1 )PRIMARY KEY,
	nameProduct NVARCHAR(255),
	category_id INT,
	supplier_id INT,
	price INT,
	imageProduct NVARCHAR(max),
	size NVARCHAR(255),
	color NVARCHAR(255),
	description NVARCHAR(255),
	quantity INT,
	created DATE
)
GO

CREATE TABLE users
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	username NVARCHAR(255),
	password NVARCHAR(255),
	fullName NVARCHAR(255),
	address NVARCHAR(max),
	email NVARCHAR(255),
	phone NVARCHAR(20),
	gender BIT,
	avatar NVARCHAR(max),
	created DATETIME,
	isAdmin BIT,
	status BIT,
)
GO

CREATE TABLE orders
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	p_id INT,
	u_id INT,
	o_quantity INT,
	o_date VARCHAR(450)
)
GO

CREATE TABLE supplier
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameSupplier NVARCHAR(255),
	phone VARCHAR(20),
	address NVARCHAR(max)
)
GO

CREATE TABLE category
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameCategory VARCHAR(255)
)
GO


CREATE TABLE orderStates
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameStates NVARCHAR(255)
)
GO

CREATE TABLE favorite
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	user_id INT,
	product_id INT,
	likeDate DATETIME

)
GO

CREATE TABLE share
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	user_id INT, 
	product_id INT,
	email NVARCHAR(255),
	shareDate DATETIME
)
GO

ALTER TABLE dbo.products ADD FOREIGN KEY (supplier_id) REFERENCES dbo.supplier(id)
ALTER TABLE dbo.products ADD FOREIGN KEY (category_id) REFERENCES dbo.category(id)
ALTER TABLE dbo.orders ADD FOREIGN KEY (u_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.orders ADD FOREIGN KEY (p_id) REFERENCES dbo.products(id)

ALTER TABLE dbo.favorite ADD FOREIGN KEY (user_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.favorite ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)
ALTER TABLE dbo.share ADD FOREIGN KEY (user_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.share ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)
ALTER TABLE dbo.orders ADD statusState INT
ALTER TABLE dbo.orders ADD FOREIGN KEY (statusState) REFERENCES dbo.orderStates(id)


INSERT INTO dbo.products
(
    nameProduct,
    category_id,
    supplier_id,
    price,
    imageProduct,
    size,
    color,
    description,
    quantity,
    created
)
VALUES
(   N'Áo Khoác', -- nameProduct - nvarchar(255)
    1, -- category_id - int
    1, -- supplier_id - int
    100, -- price - int
    N'http://res.cloudinary.com/ducnv2509/image/upload/v1648627655/whgtfpcg77kop8qdbfai.jpg', -- imageProduct - nvarchar(max)
    N'L', -- size - nvarchar(255)
    N'Đỏ', -- color - nvarchar(255)
    N'Áo Đẹp', -- description - nvarchar(255)
    12, -- quantity - int
    NULL  -- created - date
    )

SELECT * FROM dbo.category
INSERT INTO dbo.supplier
(
    nameSupplier,
    phone,
    address
)
VALUES
(   N'GUCCI', -- nameSupplier - nvarchar(255)
    N'0332429178', -- phone - varchar(20)
    N'Hà Nội'  -- address - nvarchar(max)
    )

INSERT INTO dbo.users
(
    username,
    password,
    fullName,
    address,
    email,
    phone,
    gender,
    avatar,
    created,
    isAdmin,
    status
)
VALUES
(   'ducnv', -- username - nvarchar(255)
   '123', -- password - nvarchar(255)
   'Nguyen Van Duc', -- fullName - nvarchar(255)
    'Ha Noi', -- address - nvarchar(max)
    'ducnvph14435@fpt.edu.vn', -- email - nvarchar(255)
    '0332429178', -- phone - nvarchar(20)
    1, -- gender - bit
    NULL, -- avatar - nvarchar(max)
    NULL, -- created - datetime
    1, -- isAdmin - bit
    1  -- status - bit
    )

	SELECT * FROM dbo.users\

	SELECT * FROM dbo.orders