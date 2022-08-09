CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.banners(
    banner_id uuid NOT NULL DEFAULT uuid_generate_v4(),
    banner_url character varying ,
    created_date timestamp with time zone NOT NULL DEFAULT now(),
    CONSTRAINT banners_pkey PRIMARY KEY (banner_id)
    )