select prd.barcode, prd.name, prd.brand_name,   
prd.price, prd.category as category_id,  
c.name as category_name from products as prd, product_category as c  
where prd.category = c.category_id and prd.barcode = ?;

