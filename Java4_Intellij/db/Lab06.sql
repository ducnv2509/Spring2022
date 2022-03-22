CREATE DATABASE Lab06_ducnv
GO

USE Lab06_ducnv
GO

CREATE TABLE videos
(
	id CHAR(11) PRIMARY KEY,
	title NVARCHAR(50),
	poster NVARCHAR(50),
	description NVARCHAR(max),
	active BIT,
	views INT, 
)
GO

CREATE TABLE favorites
(
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	videoid CHAR(11),
	userid NVARCHAR(20),
	likedate DATE
)
GO

CREATE TABLE Users
(
	id NVARCHAR(20) PRIMARY KEY,
	password NVARCHAR(50),
	fullname NVARCHAR(50),
	email NVARCHAR(50),
	admin BIT
    
)
GO

ALTER TABLE dbo.favorites ADD FOREIGN KEY (videoid) REFERENCES dbo.videos(id)
ALTER TABLE dbo.favorites ADD FOREIGN KEY (userid) REFERENCES dbo.Users(id)

INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14047', N'123', N'John Breznk', N'PS14047@gmail.com', 0)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14048', N'123', N'Nguyễn Thái Bình', N'ps14048@gmail.com', 1)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14049', N'123456', N'Nguyễn Phồng Tôm', N'PS14049@gmail.com', 0)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14050', N'1234', N'Lê Minh Kha', N'PS14050@gmail.com', 0)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14051', N'123', N'Lê Thị Thuý', N'PS14051@gmail.com', 1)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14052', N'123', N'Kim Bình Trọng', N'PS14052@gmail.com', 0)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14053', N'123', N'Kim Bình Quý', N'PS14053@gmail.com', 0)
INSERT [dbo].[Users] (ID, [password], [fullName], [email], [admin]) VALUES (N'PS14054', N'123', N'Trần Văn Dần', N'PS14054@gmail.com', 0)
GO
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid001     ', N'Life is Strange', N'Life_Is_Strange_-_True_Colors.png', N'Superpower', 1, 4)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid002     ', N'FarCry6', N'farCry6.jpeg', N'Survival and Battling', 1, 1)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid003     ', N'Kena - Bridge of Spirits', N'kenabridgeofspirits.jpg', N'Kena - Bridge of Spirits', 0, 1)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid004     ', N'Insurmountable', N'insurmountable-cover.jpg', N'Insurmountable', 1, 4)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid005     ', N'Outriders', N'outrightder.jpg', N'Blood and fight', 1, 2)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid006     ', N'Scarlet Nesus', N'Scarlet_Nexus_cover.jpg', N'Scarlet Nesus', 1, 5)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid007     ', N'War Of The World', N'WarOfTheWorld.jpg', N'War Of The World', 0, 6)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid008     ', N'Prometheus', N'Prometheus.jpg', N'Prometheus', 1, 0)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid009     ', N'The Dark Knight Rises', N'Dark_knight_rises_poster.jpg', N'The Dark Knight Rises', 1, 0)
INSERT [dbo].[Videos] (id, [title], [poster], [description], [active], [views]) VALUES (N'Vid010     ', N'Spider Man 3', N'spiderman3.jpg', N'Spider Man 3', 1, 0)
GO

SET DATEFORMAT dmy;  
GO  
Insert into favorites values('Vid001','PS14047','22-05-2020')
Insert into favorites values('Vid001','PS14048','17-05-2021')
Insert into favorites values('Vid001','PS14049','18-05-2021')
Insert into favorites values('Vid001','PS14050','22-04-2021')
Insert into favorites values('Vid002','PS14051','22-03-2021')
Insert into favorites values('Vid003','PS14052','22-02-2020')
Insert into favorites values('Vid004','PS14053','12-05-2020')
Insert into favorites values('Vid004','PS14054','02-05-2020')
Insert into favorites values('Vid004','PS14051','22-07-2020')
Insert into favorites values('Vid005','PS14052','19-08-2020')
Insert into favorites values('Vid005','PS14053','20-05-2020')
Insert into favorites values('Vid006','PS14054','11-05-2020')
Insert into favorites values('Vid006','PS14048','22-02-2020')
Insert into favorites values('Vid006','PS14049','12-05-2020')
Insert into favorites values('Vid006','PS14050','12-01-2020')
Insert into favorites values('Vid006','PS14051','30-04-2020')
Insert into favorites values('Vid007','PS14052','01-05-2020')
Insert into favorites values('Vid007','PS14053','19-05-2020')
Insert into favorites values('Vid007','PS14054','06-05-2020')
Insert into favorites values('Vid007','PS14049','20-04-2020')
Insert into favorites values('Vid007','PS14047','12-05-2020')
Insert into favorites values('Vid007','PS14048','11-03-2020')
GO

SELECT * FROM dbo.Users
SELECT * FROM dbo.favorites
SELECT * FROM dbo.videos

SELECT dbo.favorites.videoid FROM dbo.favorites WHERE dbo.favorites.userid =