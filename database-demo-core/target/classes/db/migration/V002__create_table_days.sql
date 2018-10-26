drop table if exists days;

create table days(
  id serial primary key,
  days varchar not null,
  date varchar not null
);
