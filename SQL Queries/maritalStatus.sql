with tr as
(select sum(total_cost) as sum
from transactions),
m as
(select sum(total_cost) as sum,u.marital_status
from transactions as tr,users as u
where tr.card_number = u.card_number
and u.marital_status = 'married'),
s as
(select sum(total_cost)as sum,u.marital_status
from transactions as tr,users as u
where tr.card_number = u.card_number
and u.marital_status = 'single'),
d as
(select sum(total_cost) as sum,u.marital_status
from transactions as tr,users as u
where tr.card_number = u.card_number
and u.marital_status = 'divorced'),
r as
(select sum(total_cost) as sum,u.marital_status
from transactions as tr,users as u
where tr.card_number = u.card_number
and u.marital_status = 'in_relationship')

(select m.marital_status,cast((m.sum/tr.sum)*100 as decimal(7,2)) as percentage
from m,tr) union
(select  s.marital_status, cast((s.sum/tr.sum)*100 as decimal(7,2)) as percentage
from s,tr) union
(select  d.marital_status, cast((d.sum/tr.sum)*100 as decimal(7,2)) as percentage
from d,tr) union
(select r.marital_status, cast((r.sum/tr.sum)*100 as decimal(7,2)) as percentage
from r,tr)