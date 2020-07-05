select tr.*,count(*) as count  
from   
(select datetime,card_number,total_cost,payment_method,address_city  
from transactions, stores   
where purchased_from=store_id  
and purchased_from = ?) as tr, contains as c  
where (tr.datetime,tr.card_number) = (c.datetime,c.card_number) 
and
date(tr.datetime) between ? and ?
and
tr.payment_method = ?
and
tr.total_cost <= ? 
group by tr.datetime,tr.card_number 
 having count(*) between 
 order by tr.total_cost;

