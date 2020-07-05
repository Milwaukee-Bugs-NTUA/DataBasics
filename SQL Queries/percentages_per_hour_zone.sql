with r as  
(select u.card_number,  
timestampdiff(year,u.date_of_birth,curdate()) as age,  
hour(t.datetime) as hour_zone  
from users as u  
join transactions as t using(card_number)),  
young as  
(select hour_zone, count(*) as trs  
from r  
where r.age between 15 and 34  
group by r.hour_zone  
order by hour_zone),  
middle as  
(select hour_zone, count(*) as trs  
from r  
where r.age between 35 and 60  
group by r.hour_zone  
order by hour_zone),  
elderly as  
(select hour_zone, count(*) as trs  
from r  
where r.age >= 61  
group by r.hour_zone  
order by hour_zone),  
total as  
(select hour_zone, count(*) as trs  
from r  
group by r.hour_zone  
order by hour_zone)  
select hour_zone,  
cast((ifnull(y.trs,0)/t.trs)*100 as decimal(7,2)) as young_p,  
cast((ifnull(m.trs,0)/t.trs)*100 as decimal(7,2)) as middle_p,  
cast((ifnull(e.trs,0)/t.trs)*100 as decimal(7,2)) as elderly_p  
from total as t  
left join young as y using(hour_zone)  
left join middle as m using(hour_zone)  
left join elderly as e using(hour_zone);

