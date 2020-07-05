with r as  
(select hour(datetime) as hour_zone,sum(total_cost) as money_spend  
from transactions  
group by hour_zone  
order by money_spend)  
select r.hour_zone  
from r left join  
(select distinct r1.hour_zone,r1.money_spend  
from r as r1, r as r2  
where r1.money_spend < r2.money_spend) as s using(hour_zone)  
where s.money_spend is null;

