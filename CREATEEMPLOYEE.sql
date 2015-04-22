create or replace PROCEDURE createEmployee 
(firstname IN VARCHAR,lastname IN VARCHAR,genderemp IN INTEGER,phoneno IN VARCHAR,email IN VARCHAR,usrname IN VARCHAR,
pwd IN VARCHAR,role IN INTEGER,outvalue OUT INTEGER)
IS
/*declare local variables*/
empcheck INTEGER;
maxempid INTEGER;
BEGIN
SELECT count(*) into empcheck from memployee where username=usrname and isactive=1;
select max(employeeid) into maxempid from memployee;
if empcheck =0 then 
outvalue:=0;
insert into memployee (employeeid,fname,lname,gender,phonenumber,emailid,username,password,roleid,isactive)
values (maxempid+1,firstname,lastname,genderemp,phoneno,email,usrname,pwd,role,1);
else 
outvalue:=1;
end if;
END createEmployee;