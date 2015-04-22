create or replace PROCEDURE createCustomer 
(firstname IN VARCHAR,lastname IN VARCHAR,gendercust IN INTEGER,adrslone IN VARCHAR,adrsltwo IN VARCHAR,phoneno IN VARCHAR,
zip IN INTEGER,statecode IN INTEGER ,custEmail IN VARCHAR, custPassword IN VARCHAR,outvalue OUT INTEGER)
IS
/*declare local variables*/
customerCheck INTEGER;
maxcustid INTEGER;
BEGIN
SELECT count(customerid) into customerCheck from tcustomer where emailid=custEmail;
select max(customerid) into maxcustid from tcustomer;
if customerCheck =0 then 
outvalue:=1;
insert into tcustomer (CUSTOMERID,FNAME,LNAME,GENDER,ADDRESSL1,ADDRESL2,PHONENUMBER,ZIPCODE,STATE,EMAILID,PASSWORD)
values (maxcustid+1,firstname,lastname,gendercust,adrslone,adrsltwo,phoneno,zip,statecode,custEmail,custPassword);
else 
outvalue:=0;
end if;
END createCustomer;