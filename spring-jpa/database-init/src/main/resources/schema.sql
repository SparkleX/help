CREATE TABLE [dbo].[@EVENT1](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ObjectType] [nvarchar](20) NOT NULL,
	[TransType] [nchar](1) NOT NULL,
	[ObjectKeys] [nvarchar](255) NOT NULL,
	[Status] [nchar](1) NOT NULL,
	[TsCreate] [datetime] NOT NULL,
	[UID] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
);

CREATE TABLE [dbo].[@EVENT2](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ObjectType] [nvarchar](20) NOT NULL,
	[TransType] [nchar](1) NOT NULL,
	[ObjectKeys] [nvarchar](255) NOT NULL,
	[Status] [nchar](1) NOT NULL,
	[TsCreate] [datetime] NOT NULL,
	[UID] [nvarchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
)