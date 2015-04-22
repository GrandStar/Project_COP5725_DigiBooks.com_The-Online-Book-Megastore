create or replace PROCEDURE updateBookInventory
(bkisbnno IN VARCHAR,bkinventory IN INTEGER,updateCheck OUT INTEGER)
IS
rowsupdated number;
BEGIN
update tbook set INVENTORY=bkinventory where ISBN=bkisbnno;
rowsupdated :=sql%rowcount;
if rowsupdated =1 then 
updateCheck:=1;
else
updateCheck:=0;
end if;
END updateBookInventory;