create or replace PROCEDURE updateEmployee 
(usrname IN VARCHAR,firstname IN VARCHAR,lastname IN VARCHAR,phnno IN VARCHAR,email IN VARCHAR,pwd IN VARCHAR,updateCheck OUT INTEGER)
IS
rowsupdated number;
BEGIN
update memployee set fname=firstname,lname=lastname,phonenumber=phnno,
emailid=email, password=pwd where username=usrname and isactive=1;
rowsupdated :=sql%rowcount;
if rowsupdated =1 then 
updateCheck:=1;
else
updateCheck:=0;
end if ;
END updateEmployee;