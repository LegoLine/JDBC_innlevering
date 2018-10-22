create table if not exists persons (
    id serial primary key,
    given_name varchar not null,
    family_name varchar not null,
    email varchar not null unique
);
