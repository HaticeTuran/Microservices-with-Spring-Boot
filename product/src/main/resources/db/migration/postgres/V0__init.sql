CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.products
(
    product_id uuid NOT NULL DEFAULT uuid_generate_v4(),
    product_name character varying NOT NULL,
    list_price integer,
    quantity_in_stock integer,
    product_description character varying NOT NULL,
    created_date time with time zone NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (product_id)
)