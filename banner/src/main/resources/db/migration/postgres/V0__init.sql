CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.banners
(
    "bannerId" uuid NOT NULL DEFAULT uuid_generate_v4(),
    "bannerUrl" character varying NOT NULL,
    "createdDate" time with time zone NOT NULL DEFAULT now(),
    CONSTRAINT banners_pkey PRIMARY KEY ("bannerId")
)
