select Email as 'Email'
from Person
group by Email
having count(Email) > 1;

select distinct a.Email as 'Email'
from Person a,
     Person b
where a.id != b.id
and a.Email = b.Email;