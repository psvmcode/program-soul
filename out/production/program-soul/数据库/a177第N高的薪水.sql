

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare m int;
set m = N - 1;
RETURN (
    select ifnull((select distinct Salary from Employee order by Salary desc limit 1 offset m),null);
    );
END