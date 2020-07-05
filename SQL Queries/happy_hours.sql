with r as   
(select count(*) as total from transactions  
where card_number = ? and purchased_from = ?  
group by card_number),  
tr as  
(select hour(datetime) as hour_zone, count(*) as count  
from transactions  
where card_number = ? and purchased_from = ?  
group by hour_zone  
order by hour_zone)  
select tr.hour_zone,cast((tr.count/r.total)*100 as decimal(7,2))  
from tr,r;

