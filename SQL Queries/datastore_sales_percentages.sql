with total_sales_per_product as  
(select p.barcode,p.brand_name,p.category as category_id,cat.name as category,sum(c.pieces) as pieces  
from contains as c,products as p, product_category as cat  
where c.product_id = p.barcode  
and p.category = cat.category_id   
group by p.barcode),  
total_sales as  
(select tsp.category_id, tsp.category,sum(tsp.pieces) as sales  
from total_sales_per_product as tsp  
group by tsp.category_id),  
total_sales_datastore as  
(select tsp.category_id,tsp.category,sum(tsp.pieces) as sales  
from total_sales_per_product as tsp  
where tsp.brand_name = 'Datastore'  
group by tsp.category_id)  
select t.category_id,t.category,ifnull(cast((d.sales/t.sales)*100 as decimal(7,2)),0) as percentage  
from total_sales_datastore as d  
right join total_sales as t using(category_id)  
order by t.category_id;

