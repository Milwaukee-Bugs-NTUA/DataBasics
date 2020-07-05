select c.product_id, p.name, p.brand_name from contains as c,  
products as p   
where c.product_id = p.barcode and c.card_number = ?  
group by c.product_id order by sum(c.pieces) desc limit 10;

