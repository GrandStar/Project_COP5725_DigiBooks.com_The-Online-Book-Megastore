create or replace PROCEDURE getdataEmployee 
(usrname IN VARCHAR,firstname OUT VARCHAR,lastname OUT VARCHAR,phoneno OUT VARCHAR,email OUT VARCHAR,pwd OUT VARCHAR)
IS
BEGIN
SELECT FNAME,LNAME,PHONENUMBER,EMAILID,PASSWORD INTO firstname,lastname,phoneno,email,pwd
FROM MEMPLOYEE WHERE USERNAME=USRNAME;
END getdataEmployee;