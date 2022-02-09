drop table if exists accounts;

create table accounts (
   id int not null,
   customer_id int not null,
   nrb varchar(26) not null,
   currency varchar(4) not null,
   available_funds decimal (10, 2)
);