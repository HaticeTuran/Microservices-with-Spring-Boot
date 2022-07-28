CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.banners (
    "bannerId" uuid NOT NULL,
    "bannerUrl" character varying NOT NULL,
    "createdDate" time with time zone NOT NULL,
    CONSTRAINT banners_pkey PRIMARY KEY ("bannerId")
    );
