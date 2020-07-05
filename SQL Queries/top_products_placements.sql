select alley_number,shelf_number  
from offers  
group by alley_number,shelf_number  
order by count(*) desc limit 5;

