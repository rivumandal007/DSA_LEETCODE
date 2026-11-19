# Write your MySQL query statement below
SELECT o.unique_id, e.name
FROM Employees AS e
LEFT JOIN EmployeeUNI AS o
ON e.id = o.id;