Create database PaymentWebApp;

Use PaymentWebApp; 

Create table Users(
	UserId Int auto_increment,
    FirstName Varchar(25),
    LastName varchar(25),
    PhoneNo varchar(15) unique,
    EmailId varchar(200),
    DateOfBirth date,
    Address Varchar(100),
    PassWord varchar(25),
    CurrWalletBalance Double(8,2),
   Primary Key (UserId)
    
);

desc Users;
drop table users;
Select * from users;

Create Table BankAcctType(
	BankAcctTypeId int,
    BankAcctTypeCode Varchar(3),
    BankAcctTypeDesc Varchar(50),
    primary key (BankAcctTypeId)
);

Insert into BankAcctType value(1,'SA','SAVINGS');
Insert into BankAcctType value(2,'CA','CURRENT');
Insert into BankAcctType value(3,'SL','SALARY');
Insert into BankAcctType value(4,'LO','LOAN');

Select * from BankAcctType;
Desc BankAcctType;
Create table BankAccount(
	BankAcctNo Varchar(16) Not Null,
    BankAcctName Varchar(50),
    BankAcctTypeId int,
    BankIFSCCode varchar(10),
    UserId int,
    CurrBankBalance double(12,2),
    foreign key(BankAcctTypeId) references BankAcctType(BankAcctTypeId),
    foreign key(UserId) references User(UserId),
    Primary Key(BankAcctNo)
);
desc BankAccount;
CREATE TABLE Transaction (
    TxnId Int NOT NULL,
    TxnDate datetime,
    TxnAmount DOUBLE,
    SourceType Enum ('BankAcct','Wallet'),
    DestType Enum ('BankAcct','Wallet'),
    UserId int,
    FOREIGN KEY (UserId) REFERENCES User(UserId),
    PRIMARY KEY (Txn_Id)
);
Alter table users add column primaryBankAcctNo Varchar(16) primary key;
Alter table users drop column primaryBankAcctNo ;

