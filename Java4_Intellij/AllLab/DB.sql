CREATE DATABASE Lab05
GO
USE Lab05
GO

CREATE TABLE [User]
(
	UserId NVARCHAR(20) PRIMARY KEY,
	PASSWORD NVARCHAR(50),
	fullname NVARCHAR(50),
	email NVARCHAR(50),
	admin bit
)
go