SELECT *
FROM Users
WHERE email REGEXP '^[A-Za-z0-9_]+@[a-z]+\\.com$'
ORDER BY user_id;