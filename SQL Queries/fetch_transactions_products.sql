select p.barcode,p.name,p.brand_name,c.pieces  
from contains as c, products as p  
where c.product_id = p.barcode  
and c.card_number = ?  
and c.datetime = ?  
order by p.name;

