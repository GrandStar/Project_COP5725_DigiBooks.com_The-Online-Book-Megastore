create or replace PROCEDURE ADDBOOK 
(Bkname IN VARCHAR,BkAuthor IN VARCHAR,publicaton IN INTEGER,genre IN INTEGER,bkyr IN INTEGER,bkprice IN NUMBER,
bklang IN INTEGER,bkinventory IN INTEGER,bkISBN IN VARCHAR,outvalue OUT INTEGER)
IS
/*declare local variables*/
bkinsertcheck INTEGER;
maxbookid INTEGER;
BEGIN
SELECT count(*) into bkinsertcheck from tbook where ISBN=bkISBN;
select max(BOOKID) into maxbookid from tbook;
if bkinsertcheck =0 then 
outvalue:=0;
insert into tbook (BOOKID,BOOKNAME,AUTHOR,PUBLICATIONHOUSE,GENRE,PUBLICATIONYEAR,PRICE,LANGUAGE,INVENTORY,ISBN)
values (maxbookid+1,Bkname,BkAuthor,publicaton,genre,bkyr,bkprice,bklang,bkinventory,bkISBN);
else 
outvalue:=1;
end if;
END ADDBOOK;