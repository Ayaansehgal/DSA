# Write your MySQL query statement below
with ranked as(
    select d.name as Department , e.name as Employee , e.salary,
    dense_rank()over(partition by d.id order by e.salary desc) as rnk
from employee e
join Department d 
on e.departmentid=d.id
)
select Department,Employee,salary from 
ranked 
where rnk=1;
 