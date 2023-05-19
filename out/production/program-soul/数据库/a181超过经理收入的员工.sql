
-- 一共分为a和b，取出a.managerId=b.id并且a.salary>b.salary，其中a专门代表员工，b专门代表经理
select a.name as 'Employee'
from Employee a,Employee b
where a.managerId = b.id and a.salary > b.salary;

--join on
select a.name as 'Employee'
from Employee a join Employee b
on a.managerId = b.id and a.salary > b.salary;