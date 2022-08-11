CREATE TABLE IF NOT EXISTS public.comments
(
    comment_id uuid NOT NULL,
    comment_text character varying ,
    created_date timestamp with time zone,
    product_id uuid NOT NULL,
    CONSTRAINT comments_pkey PRIMARY KEY (comment_id)
)