select Name as 'Customers'
from Customers
where Id not in
      (select distinct CustomerId from Orders);

-- 左连接
select a.Name as 'Customers'
from Customers a
         left join Orders b
                   on a.Id = b.CustomerId
where b.Id is null;