SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Application](
	[idApplication] [tinyint] NOT NULL,
	[descriptionApplication] [varchar](50) NOT NULL,
	[typeApplication] [char](1) NOT NULL,
 CONSTRAINT [PK_Application] PRIMARY KEY CLUSTERED 
(
	[idApplication] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[Category]    Script Date: 26/09/2017 15:05:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[idCategory] [int] IDENTITY(1,1) NOT NULL,
	[nameCategory] [varchar](50) NOT NULL,
	[descriptionCategory] [varchar](100) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[idCategory] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[Client]    Script Date: 26/09/2017 15:05:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Client](
	[idClient] [int] IDENTITY(1,1) NOT NULL,
	[fullNameClient] [varchar](100) NOT NULL,
	[emailClient] [varchar](100) NOT NULL,
	[passwordClient] [varchar](64) NOT NULL,
	[CPFClient] [char](14) NOT NULL,
	[phoneClient] [varchar](20) NULL,
	[birthDayClient] [date] NULL,
	[newsLetterClient] [bit] NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[idClient] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[Address]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Address](
	[idAddress] [int] IDENTITY(1,1) NOT NULL,
	[idClient] [int] NOT NULL,
	[nameAddress] [varchar](50) NOT NULL,
	[numberAddress] [varchar](10) NOT NULL,
	[CEPAddress] [char](9) NOT NULL,
	[cityAddress] [varchar](50) NOT NULL,
	[countryAddress] [varchar](50) NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[idAddress] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[ItemRequest]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemRequest](
	[idProduct] [int] NOT NULL,
	[idRequest] [int] NOT NULL,
	[countItemRequest] [smallint] NOT NULL,
	[priceItemRequest] [money] NOT NULL,
 CONSTRAINT [PK_ItemRequest] PRIMARY KEY CLUSTERED 
(
	[idProduct] ASC,
	[idRequest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[Request]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[idRequest] [int] IDENTITY(1,1) NOT NULL,
	[idClient] [int] NOT NULL,
	[idStatus] [tinyint] NOT NULL,
	[dateRequest] [smalldatetime] NOT NULL,
	[idTypePayment] [tinyint] NOT NULL,
	[idAddress] [int] NULL,
	[idApplication] [tinyint] NOT NULL,
 CONSTRAINT [PK_Request] PRIMARY KEY CLUSTERED 
(
	[idRequest] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[Product]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[idProduct] [int] IDENTITY(1,1) NOT NULL,
	[nameProduct] [varchar](70) NOT NULL,
	[descriptionProduct] [varchar](500) NULL,
	[priceProduct] [money] NOT NULL,
	[discountProduct] [decimal](18, 2) NULL,
	[idCategory] [int] NOT NULL,
	[activeProduct] [char](1) NOT NULL,
	[idUser] [int] NULL,
	[stockProduct] [int] NULL,
	[imageProduct] [varchar](255) NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[idProduct] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[StatusRequest]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusRequest](
	[idStatus] [tinyint] NOT NULL,
	[descriptionStatus] [varchar](50) NOT NULL,
 CONSTRAINT [PK_StatusRequest] PRIMARY KEY CLUSTERED 
(
	[idStatus] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[TypePayment]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypePayment](
	[idTypePayment] [tinyint] NOT NULL,
	[descriptionTypePayment] [varchar](50) NOT NULL,
 CONSTRAINT [PK_TypePayment] PRIMARY KEY CLUSTERED 
(
	[idTypePayment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
/****** Object:  Table [dbo].[User]    Script Date: 26/09/2017 15:05:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[idUser] [int] IDENTITY(1,1) NOT NULL,
	[emailUser] [varchar](100) NOT NULL,
	[passwordUser] [varchar](64) NULL,
	[nameUser] [varchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[idUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)

GO
SET IDENTITY_INSERT [dbo].[Category] ON 

GO
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Client] ON 

GO
SET IDENTITY_INSERT [dbo].[Client] OFF
GO
SET IDENTITY_INSERT [dbo].[Address] ON 

GO
SET IDENTITY_INSERT [dbo].[Address] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 
GO
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

GO
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [FK_Address_Client] FOREIGN KEY([idClient])
REFERENCES [dbo].[Client] ([idClient])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [FK_Address_Client]
GO
ALTER TABLE [dbo].[ItemRequest]  WITH CHECK ADD  CONSTRAINT [FK_ProductRequest_Request] FOREIGN KEY([idRequest])
REFERENCES [dbo].[Request] ([idRequest])
GO
ALTER TABLE [dbo].[ItemRequest] CHECK CONSTRAINT [FK_ProductRequest_Request]
GO
ALTER TABLE [dbo].[ItemRequest]  WITH CHECK ADD  CONSTRAINT [FK_ProductRequest_Product] FOREIGN KEY([idProduct])
REFERENCES [dbo].[Product] ([idProduct])
GO
ALTER TABLE [dbo].[ItemRequest] CHECK CONSTRAINT [FK_ProductRequest_Product]
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Application] FOREIGN KEY([idApplication])
REFERENCES [dbo].[Application] ([idApplication])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Application]
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Client] FOREIGN KEY([idClient])
REFERENCES [dbo].[Client] ([idClient])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Client]
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Address] FOREIGN KEY([idAddress])
REFERENCES [dbo].[Address] ([idAddress])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Address]
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Status] FOREIGN KEY([idStatus])
REFERENCES [dbo].[StatusRequest] ([idStatus])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Status]
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_TypePayment] FOREIGN KEY([idTypePayment])
REFERENCES [dbo].[TypePayment] ([idTypePayment])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_TypePayment]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([idCategory])
REFERENCES [dbo].[Category] ([idCategory])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_User] FOREIGN KEY([idUser])
REFERENCES [dbo].[User] ([idUser])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_User]
GO
