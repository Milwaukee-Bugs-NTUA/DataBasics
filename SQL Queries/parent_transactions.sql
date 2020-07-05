select cast((pr.sum/tr.sum)*100 as decimal(7,2)) as percentage  
from  
(select sum(total_cost) as sum   
from transactions) as tr,  
(select sum(tr.total_cost) as sum  
from transactions as tr,users as u  
where tr.card_number = u.card_number  
and number_of_children > 0) as pr;

