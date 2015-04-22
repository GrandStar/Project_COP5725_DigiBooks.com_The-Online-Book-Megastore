create or replace PROCEDURE validateCustomer 
(CEmailID IN VARCHAR, CPassword IN VARCHAR, isValidCustomer OUT INTEGER)
IS
custCheck Integer;
BEGIN
select count(customerid) into custCheck from tcustomer where emailid=CEmailID and password=CPassword;
if custCheck=1 then 
isValidCustomer:=1;
else
isValidCustomer:=0;
end if;
END validateCustomer;