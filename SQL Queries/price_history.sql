select barcode, starting_date, ending_date, old_price  
from price_history where barcode = ? order by starting_date desc;

