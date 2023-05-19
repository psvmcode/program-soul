select b.name as 'Department',a.name as 'Employee',a.salary as 'Salary'
from Employee a,
     Department b
where a.departmentId = b.id
group by b.name
having a.salary = max(a.salary);
