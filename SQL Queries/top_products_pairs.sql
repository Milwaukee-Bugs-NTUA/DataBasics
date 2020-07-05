with cont as  
    (select product_id,name,brand_name,datetime,card_number  
    from contains as c,products as p  
    where c.product_id = p.barcode)  
select c1.product_id as b1,c1.name as name1,  
        c1.brand_name as brand1,c2.product_id as b2,  
        c2.name as name2,c2.brand_name as brand2  
from cont as c1, cont as c2  
where (c1.datetime,c1.card_number) = (c2.datetime,c2.card_number)  
and c1.product_id < c2.product_id  
group by b1,b2  
order by count(*) desc  
limit 5;

