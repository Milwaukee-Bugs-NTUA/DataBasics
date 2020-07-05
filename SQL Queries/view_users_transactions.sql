create view users_transactions as
select distinct u.*,tr.datetime as transaction_datetime
from users as u, transactions as tr
where u.card_number = tr.card_number