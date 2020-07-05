select cast(avg(total_cost) as decimal(7,2)) as mean  
from transactions  
where date(datetime) between ? and ?  
and card_number = ?;

