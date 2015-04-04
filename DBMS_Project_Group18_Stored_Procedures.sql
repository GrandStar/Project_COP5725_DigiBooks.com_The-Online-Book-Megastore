-- SQL Stored Procedures Used in our project.

-- Query To Create Stored Procedure for  validateEmployee which will validate 
-- the employee of Digibooks.com and redirect them to the correct page depending
-- on their roles.
create or replace PROCEDURE validateEmployee 
(EUsername IN VARCHAR, EPassword IN VARCHAR, Role OUT INTEGER)
IS
BEGIN
SELECT ROLEID into Role FROM MEMPLOYEE WHERE USERNAME=EUSERNAME AND PASSWORD=EPASSWORD AND ISACTIVE=1;
END validateEmployee;
