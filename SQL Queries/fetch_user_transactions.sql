select tr.*,count(*) as count  
from   
(select datetime,card_number,total_cost,payment_method,address_city  
    from transactions, stores   
    where purchased_from=store_id  
    and card_number = ?) as tr, contains as c  
where (tr.datetime,tr.card_number) = (c.datetime,c.card_number)  
group by tr.datetime,tr.card_number  
order by tr.datetime desc;

