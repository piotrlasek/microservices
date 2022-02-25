drop table if exists transfer;

create table transfer (
   id int not null,
   nrb_from varchar(26) not null,
   nrb_to varchar(26) not null,
   amount decimal (10, 2)
);