create or replace PROCEDURE getpurchasehistory
(custemailid IN VARCHAR,bkname OUT VARCHAR,bkisbnno OUT VARCHAR,bkquantity OUT INTEGER,
transid OUT INTEGER,trandate OUT DATE,bktotprice OUT NUMBER )
IS
custID integer;
BEGIN
select customerid into custid from tcustomer where emailid=custemailid;

select D.bookname,D.ISBN,C.Quantity,C.transid,C.transdate,C.totalprice
into bkname,bkisbnno,bkquantity,transid,trandate,bktotprice
from tcustomer A 
inner join tcustomertransaction B on A.customerid=B.customerid
inner join ttransactiondetails C on B.transid=C.transid
inner join tbook D on C.bookid=D.bookid
where A.customerid=custid;

END getpurchasehistory;