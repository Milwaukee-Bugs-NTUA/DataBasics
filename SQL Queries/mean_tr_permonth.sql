select cast(avg(total_cost) as decimal(7, 2)) as mean  
from transactions where month(datetime) = ?   
and year(datetime) = ? and card_number = ?;

