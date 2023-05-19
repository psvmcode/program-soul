

-- 如果没有某个人的信息，使用where子句会过滤失败，不会显示姓名信息
select FirstName,LastName,City,State
from Person
left join Address
on Person.PersonId = Address.PersonId;