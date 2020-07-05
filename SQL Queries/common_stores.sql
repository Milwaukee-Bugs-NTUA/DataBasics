select distinct tr.purchased_from as common_store,  
s.address_city as name from transactions as tr, stores as s 
where tr.purchased_from = s.store_id and card_number = ?;

