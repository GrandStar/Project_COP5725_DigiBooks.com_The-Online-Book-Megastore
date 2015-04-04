-- Query to create table mRegion
-- This table will hold information about a particular state (Region)
CREATE TABLE mRegion (
RegionID INTEGER NOT NULL,
RegionName VARCHAR(30) NOT NULL,
PRIMARY KEY (RegionID));

-- Query to create table mGender
-- This table will consist of Gender information.
CREATE TABLE mGender (
GenderID Number(1) NOT NULL,
Gender VARCHAR(10) NOT NULL,
PRIMARY KEY (GenderID));

--Query to create a table mGenre
-- This table consist of books genre which will be used 
-- to classify the books.
CREATE TABLE mGenre (
GenreID INTEGER NOT NULL ,
GenreDesc VARCHAR(30) NOT NULL,
PRIMARY KEY (GenreID));

--Query to create a table tCustomer
-- This will contain the customer personal information and will uniquely assigned a
-- ID to each customer
CREATE TABLE tCustomer (
CustomerID INTEGER NOT NULL,
FName VARCHAR(30) NOT NULL,
LName VARCHAR(30) NOT NULL,
Gender Number(1) NOT NULL,
AddressL1 VARCHAR(80) NOT NULL,
AddresL2 VARCHAR(80),
PhoneNumber VARCHAR(15),
Zipcode INTEGER NOT NULL,
State INTEGER NOT NULL,
EmailID VARCHAR(30) NOT NULL,
Password VARCHAR(30) NOT NULL,
PRIMARY KEY (CustomerID),
FOREIGN KEY (Gender) REFERENCES mGender(GenderID),
FOREIGN KEY (State) REFERENCES mRegion(RegionID));

--Query to create table mPublicationHouse.
--This will store the publication house details for books.
CREATE TABLE mPublicationHouse (
HouseID INTEGER NOT NULL,
HouseName VARCHAR(30) NOT NULL,
Address VARCHAR(80),
PRIMARY KEY (HouseID));

--Query to create table mLanguage
--Contains language details
CREATE TABLE mLanguage (
LangID INTEGER NOT NULL,
LangName VARCHAR(30) NOT NULL,
PRIMARY KEY (LangID));

--Query to create book table.
--Will contain book information details.
CREATE TABLE tBook (
BookID INTEGER NOT NULL,
BookName VARCHAR(100) NOT NULL,
Author VARCHAR(50) NOT NULL,
PublicationHouse INTEGER NOT NULL,
Genre INTEGER NOT NULL,
ISBN LONG NOT NULL,
PublicationYear INTEGER NOT NULL,
Price FLOAT NOT NULL,
Language INTEGER NOT NULL,
Inventory INTEGER DEFAULT 0,
PRIMARY KEY (BookID),
FOREIGN KEY (PublicationHouse) REFERENCES mPublicationHouse(HouseID),
FOREIGN KEY (Genre) REFERENCES mGenre(GenreID),
FOREIGN KEY (language) REFERENCES mLanguage(LangID));

--Query to create table mPaymentMethod
--Each record in this table will specify a payment method that will be 
--used by the customer for payment options and the corresponding ID for that method.
CREATE TABLE mPaymentMethod (
MethodID INTEGER NOT NULL,
PayMethod VARCHAR(30) NOT NULL,
PRIMARY KEY (MethodID));

--Each record in this table will correspond to a single customer transaction. 
--Also it is very important to note here that in a single customer transaction 
--the customer may choose to buy multiple books. It will consist of information 
--such as ID, Transaction date, Transaction amount, CustomerID, payment method, 
--Quantity (which is the number of books brought either same or different bought in that transaction).
CREATE TABLE tCustomerTransaction (
TransID INTEGER NOT NULL,
TransDate DATE NOT NULL,
TransAmount FLOAT NOT NULL,
CustomerID INTEGER NOT NULL,
PaymentMethod INTEGER NOT NULL,
Quantity INTEGER NOT NULL,
PRIMARY KEY (TransID),
FOREIGN KEY (CustomerID) REFERENCES tCustomer(CustomerID),
FOREIGN KEY (PaymentMethod) REFERENCES mPaymentMethod(MethodID));


--Each record in this table will correspond to details regarding a single transaction in the tCustomerTransaction table.
--Now it may happen that a single transaction may contain information regarding multiple books which may have different
--prices individually. But since the transaction will be represented by a single tuple in the above mentioned table it 
--will not be possible to find out the exact information about the each book sold and its quantities. Hence we need to
--create this table so that information corresponding to single book sold as a part of transaction along with the price
--may be captured in the system. Thus a single transaction tuple from tCustomerTransaction table may have corresponding
--single or multiple tuple in this table depending upon the different types of the books which may be a part of the transaction. 
--This information will be very helpful in implementing our proposed Sales Management Dashboard Module.
CREATE TABLE tTransactionDetails (
DetailID INTEGER NOT NULL,
TransID INTEGER NOT NULL,
BookID INTEGER NOT NULL,
BookUnitPrice FLOAT NOT NULL,
Quantity INTEGER NOT NULL,
TotalPrice FLOAT NOT NULL,
TransDate DATE NOT NULL,
PRIMARY KEY (DetailID),
FOREIGN KEY (TransID) REFERENCES tCustomerTransaction(TransID),
FOREIGN KEY (BookID) REFERENCES tBook(BookID));

--Query to create the mEmployeeRole. This table consist of different employee roles that will assigned to 
--users who will be managong the site.
CREATE TABLE mEmployeeRole(
RoleID INTEGER NOT NULL,
Description VARCHAR (30),
isActive Number(1) DEFAULT 1,
PRIMARY KEY (RoleID)
);

--Query to create table mEmployee.
--This will consist of personal and contact information of the employees who will be 
--managing the website.
CREATE TABLE mEmployee (
EmployeeID INTEGER NOT NULL,
FName VARCHAR(30) NOT NULL,
LName VARCHAR(30) NOT NULL,
Gender Number(1) NOT NULL,
PhoneNumber VARCHAR(15),
EmailID VARCHAR(30) NOT NULL,
Username Varchar (20) NOT NULL UNIQUE,
Password VARCHAR(30) NOT NULL,
RoleID Integer NOT NULL,
isActive Number(1) DEFAULT 1,
PRIMARY KEY (EmployeeID),
FOREIGN KEY (Gender) REFERENCES mGender(GenderID),
FOREIGN KEY (RoleID) REFERENCES mEmployeeRole(RoleID)
);

select * from mregion;

