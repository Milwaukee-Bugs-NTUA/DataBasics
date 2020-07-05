create view transactions_category_stores
as
select distinct tr.card_number,tr.datetime,p.category,st.store_id
from transactions as tr,stores as st, contains as c, products as p
where tr.purchased_from = st.store_id
and (tr.datetime,tr.card_number) = (c.datetime,c.card_number)
and p.barcode = c.product_id