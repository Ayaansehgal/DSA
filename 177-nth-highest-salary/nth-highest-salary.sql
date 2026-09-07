CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      with ranker as(
        select 
        salary,
        dense_rank()over(order by salary desc)as rnk
        from employee
      )
      select max(salary) as getNthHighestSalary
      from ranker 
      where rnk=N

  );
END