create or replace PROCEDURE updateCustomer
(custEmail IN VARCHAR, firstname IN VARCHAR,lastname IN VARCHAR,adrslone IN VARCHAR,adrsltwo IN VARCHAR,phoneno IN VARCHAR,
zip IN INTEGER,custstate IN INTEGER,updateCheck OUT INTEGER)
IS
rowsupdated number;
BEGIN
update tcustomer set fname=firstname,lname=lastname,ADDRESSL1=adrslone,ADDRESL2=adrsltwo,phonenumber=phoneno,
ZIPCODE=zip, STATE=custstate where EMAILID=custEmail;
rowsupdated :=sql%rowcount;
if rowsupdated =1 then 
updateCheck:=1;
else
updateCheck:=0;
end if ;
END updateCustomer;