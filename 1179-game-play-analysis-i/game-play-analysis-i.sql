# Write your MySQL query statement below
WITH ranked AS (
    SELECT
        player_id,
        event_date,
        DENSE_RANK() OVER (
            PARTITION BY player_id
            ORDER BY event_date
        ) AS rnk
    FROM Activity
)

SELECT
    player_id,
    event_date AS first_login
FROM ranked
WHERE rnk = 1;