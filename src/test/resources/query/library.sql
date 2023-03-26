
-- US 01
select count(id) from users;

select count(distinct id) from users;

-- US 02

select * from book_borrow;

select count(id) from book_borrow where is_returned = 0;

-- US 04

select * from books where name='Clean Code';



-- US 05
select bc.name,count(*) from book_borrow bb
                                 inner join books b on bb.book_id = b.id
                                 inner join book_categories bc on b.book_category_id=bc.id
group by name
order by 2 desc;


