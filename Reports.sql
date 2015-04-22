--Best Selling Report
select A.isbn,A.bookname,A.author,A.price,sum(B.quantity) as TotalBooksSold
from tbook A 
inner join ttransactiondetails B on A.bookid=B.bookid
group by A.isbn,A.bookname,A.author,A.price
order by TotalBooksSold desc;


--Least Selling Report
select A.isbn,A.bookname,A.author,A.price,sum(B.quantity) as TotalBooksSold
from tbook A 
inner join ttransactiondetails B on A.bookid=B.bookid
group by A.isbn,A.bookname,A.author,A.price
order by TotalBooksSold asc;

--Region wise Sales Report
select A.regionid,A.regionname,sum(B.customerid)as totalcustomerperregion,sum(C.transamount) as totalsales,sum(C.quantity) as totalqtysold
from mregion  A 
inner join tcustomer B on A.regionID=B.state
inner join tcustomertransaction C on B.customerid=C.customerid 
group by A.regionid,A.regionname
order by totalsales desc;

--Genre wise Sales Report:
select genreid,genredesc,sum(quantity) as QuantitySold,avg(bookunitprice) as avgbookprice
from mgenre A 
inner join tbook B on A.genreid=B.genre
inner join ttransaction C on B.bookid=C.bookid
group by genreid,genredesc
order by QuantitySold desc;
