create or replace PROCEDURE getdataBookInventory
(ISBNNO IN VARCHAR,bkname OUT VARCHAR,bkisbnno OUT VARCHAR,bkinventory OUT INTEGER)
IS
BEGIN
SELECT BOOKNAME,ISBN,INVENTORY INTO bkname,bkisbnno,bkinventory 
FROM tbook WHERE ISBN=ISBNNO;
END getdataBookInventory;