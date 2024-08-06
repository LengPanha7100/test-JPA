SELECT
    last_value,
    increment_by,
    max_value,
    min_value,
    cache_size
FROM
    pg_sequences
WHERE
    schemaname = 'public' AND
    sequencename = 'product_seq';