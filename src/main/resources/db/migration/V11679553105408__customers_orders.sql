CREATE TABLE IF NOT EXISTS public.customers
(
  customer_id numeric not null,
  customer_name text,
  age text,
  CONSTRAINT customer_pkey PRIMARY KEY (customer_id)

   
)

CREATE TABLE IF NOT EXISTS public.orders
(
   order_id numeric not null,
   item text,
   order_date timestamp,
   order_total decimal
)