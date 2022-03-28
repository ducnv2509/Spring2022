CREATE DATABASE AssignmentJava4
GO

USE AssignmentJava4
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

CREATE TABLE products
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameProduct NVARCHAR(255),
	category_id INT,
	supplier_id INT,
	quantity INT,
	price INT, 
	color INT,
	size NVARCHAR(255),
	imageProduct NVARCHAR(max),
	description NVARCHAR(max),
	title NVARCHAR(max),
	lastUpdate DATETIME,
	created DATETIME
)
GO

CREATE TABLE orderStates
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	nameStates NVARCHAR(255)
)
GO

CREATE TABLE orders
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	[user_id] INT,
	amount FLOAT,
	orderState INT,
	customerName NVARCHAR(255),
	ship_address NVARCHAR(max),
	phone NVARCHAR(20),
	created DATETIME,
	updated DATETIME,
	fixer DATETIME,
)
GO

CREATE TABLE orderdetails
(
	id INT IDENTITY(1,1) PRIMARY KEY,
	product_id INT,
	order_id INT,
	quantity INT,
)
GO

ALTER TABLE dbo.products ADD FOREIGN KEY (supplier_id) REFERENCES dbo.supplier(id)
ALTER TABLE dbo.products ADD FOREIGN KEY (category_id) REFERENCES dbo.category(id)
ALTER TABLE dbo.orders ADD FOREIGN KEY (user_id) REFERENCES dbo.Users(id)
ALTER TABLE dbo.orders ADD FOREIGN KEY (orderState) REFERENCES dbo.orderStates(id)
ALTER TABLE dbo.orderdetails ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)
ALTER TABLE dbo.orderdetails ADD FOREIGN KEY (order_id) REFERENCES dbo.orders(id)


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

ALTER TABLE dbo.favorite ADD FOREIGN KEY (user_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.favorite ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)
ALTER TABLE dbo.share ADD FOREIGN KEY (user_id) REFERENCES dbo.users(id)
ALTER TABLE dbo.share ADD FOREIGN KEY (product_id) REFERENCES dbo.products(id)

ALTER TABLE dbo.products ALTER COLUMN color NVARCHAR(255)

CREATE TABLE demo
(
	nameM NVARCHAR(255) PRIMARY KEY
)
GO
SELECT * FROM dbo.category
SELECT * FROM dbo.supplier

INSERT INTO dbo.supplier
(
    nameSupplier,
    phone,
    address
)
VALUES
(   'Gucci', -- nameSupplier - nvarchar(255)
    '0332429178', -- phone - varchar(20)
    N'Hà Nội'  -- address - nvarchar(max)
    )

	INSERT INTO dbo.supplier
(
    nameSupplier,
    phone,
    address
)
VALUES
(   'Louis Vuitton', -- nameSupplier - nvarchar(255)
    '0976903277', -- phone - varchar(20)
    N'Hà Tĩnh'  -- address - nvarchar(max)
    )

		INSERT INTO dbo.supplier
(
    nameSupplier,
    phone,
    address
)
VALUES
(   'Dolce & Gabbana', -- nameSupplier - nvarchar(255)
    '0378564956', -- phone - varchar(20)
    N'Hà Đôbg'  -- address - nvarchar(max)
    )

	INSERT INTO dbo.products
	(
	    nameProduct,
	    category_id,
	    supplier_id,
	    quantity,
	    price,
	    color,
	    size,
	    imageProduct,
	    description,
	    title,
	    lastUpdate,
	    created
	)
	VALUES
	(   N'Men Hiking Shoes Waterproof Non', -- nameProduct - nvarchar(255)
	    2, -- category_id - int
	    1, -- supplier_id - int
	    34, -- quantity - int
	    350, -- price - int
	    N'Xanh', -- color - nvarchar(255)
	    N'45', -- size - nvarchar(255)
	    N'https://canary.contestimg.wish.com/api/webimage/5dc3c309d8b69d0de8949a21-large.jpg?cache_buster=68ad269a9f7b07d0effa9e48c1dc5c0f', -- imageProduct - nvarchar(max)
	    N'Men Hiking Shoes Waterproof Non-slip Sport Shoes Casual Running Camping Shoes Outdoor Sneakers for Men Size 39-47 3 Colors  ', -- description - nvarchar(max)
	    N'Men Hiking Shoes Waterproof Non-slip Sport Shoes Casual Running Camping Shoes Outdoor Sneakers for Men Size 39-47 3 Colors  ', -- title - nvarchar(max)
	    NULL, -- lastUpdate - datetime
	    NULL  -- created - datetime
	    )

		INSERT INTO dbo.products
	(
	    nameProduct,
	    category_id,
	    supplier_id,
	    quantity,
	    price,
	    color,
	    size,
	    imageProduct,
	    description,
	    title,
	    lastUpdate,
	    created
	)
	VALUES
	(   N'Giày du lịch', -- nameProduct - nvarchar(255)
	    1, -- category_id - int
	    3, -- supplier_id - int
	    22, -- quantity - int
	    250, -- price - int
	    N'Đen', -- color - nvarchar(255)
	    N'37', -- size - nvarchar(255)
	    N'https://canary.contestimg.wish.com/api/webimage/5da6e559dcf2d00d2fbc707c-normal.jpg?cache_buster=d9139cea7e503395b907432f89e292d6', -- imageProduct - nvarchar(max)
	    N'Giày thể thao Adidas Advantage Clean sử dụng chất liệu cao cấp, thoáng khí cả mặt trong và mặt ngoài giúp bạn luôn dễ chịu và thoải mái dù mang trong thời gian dài. Giày Adidas VS Advantage có bộ đế êm ái giúp người đi tận hưởng cảm giác thoải mái cho cả ngày dài vận động. Thời trang vốn là sự quay vòng, và thiết kế đơn giản, cổ điển đại diện cho xu hướng thời trang hoài cổ đang quay trở lại và được giới trẻ đón nhận nồng nhiệt hơn bao giờ hết. Không giống như những loại giày thể thao thông thường, mẫu giày adidas Advantage có kiểu dáng "thon thả" hơn, khiến cho đôi chân không bị trở nên lạc lõng so với đôi giày thể thao vốn bị "mang tiếng" là thô kệch, không đẹp mắt. Thêm nữa, đế của loại giày này được thiết kế theo kiểu đế xuồng 3cm vừa tạo tính đàn hồi cho từng bước đi mà cũng "tiện tay" giúp cho người đi "ăn gian" chiều cao khá đáng kể. Và tất nhiên, điểm cộng tuyệt vời nhất chính là sự phối hợp tuyệt vời từ kiểu dáng đến màu sắc của các nhà thiết kế tài hoa đã làm cho đôi giày phù hợp với mọi giới tính, mọi lứa tuổi, mix được với rất nhiều phong cách khác nhau', -- description - nvarchar(max)
	    N'Dép đúc thể thao nam Adidas Adilette Boost Slides Đen - EH2256  ', -- title - nvarchar(max)
	    NULL, -- lastUpdate - datetime
	    NULL  -- created - datetime
	    )



		
		INSERT INTO dbo.products
	(
	    nameProduct,
	    category_id,
	    supplier_id,
	    quantity,
	    price,
	    color,
	    size,
	    imageProduct,
	    description,
	    title,
	    lastUpdate,
	    created
	)
	VALUES
	(   N'New Mens Running Shoes', -- nameProduct - nvarchar(255)
	    2, -- category_id - int
	    2, -- supplier_id - int
	    22, -- quantity - int
	    150, -- price - int
	    N'Vàng', -- color - nvarchar(255)
	    N'42', -- size - nvarchar(255)
	    N'https://canary.contestimg.wish.com/api/webimage/5c4a05a08b26e56dcf17a643-normal.jpg?cache_buster=6d01b751858e14e68932bb234cdc44c1', -- imageProduct - nvarchar(max)
	    N'New Mens Running Shoes Comfortable Sports Shoes Men Athletic Outdoor Cushioning Sneakers for Walking&Jogging (EUR Size 39-48)', -- title - nvarchar(max)
	  N'Comfortable Sports Shoes Men Athletic Outdoor Cushioning Sneakers for Walking&Jogging (EUR Size 39-48)', -- title - nvarchar(max)
	    NULL, -- lastUpdate - datetime
	    NULL  -- created - datetime
	    )




