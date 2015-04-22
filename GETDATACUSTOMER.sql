create or replace PROCEDURE getdataCustomer
(custemail IN VARCHAR,firstname OUT VARCHAR,lastname OUT VARCHAR,adrslone OUT VARCHAR,adrsltwo OUT VARCHAR,phoneno OUT VARCHAR,
zip OUT INTEGER,state OUT INTEGER)
IS
BEGIN
SELECT FNAME,LNAME,ADDRESSL1,ADDRESL2,PHONENUMBER,ZIPCODE,STATE INTO firstname,lastname,adrslone,adrsltwo,phoneno,zip,state
FROM tcustomer WHERE EMAILID=custemail;
END getdataCustomer;