-- 子查询+limit
-- offset表示去掉几行元素 limit a offset b 表示去掉b行元素后选择接下来的a行
select (select distinct Salary from Employee order by Salary desc limit 1 offset 1)
as SecondHighestSalary

-- 使用ifnull和limit,ifnull(a,b)如果不为空则返回a，否则返回b
select ifnull((select distinct Salary from Employee order by Salary desc limit 1 offset 1),null)
as SecondHighestSalary




