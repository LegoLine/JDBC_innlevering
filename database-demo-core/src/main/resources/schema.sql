create table if not exists talks (
    id serial primary key,
    talks_title varchar not null,
    talks_topic varchar not null,
    talks_description varchar not null
);

create table if not exists days (
    id serial primary key,
    days_days varchar not null
    days_date varchar not null
);

create table if not exists timeslots (
    id serial primary key,
    timeslots_time varchar not null
);

create table if not exists offerings (
    id serial primary key,
    talks_id integer not null,
    days_id integer not null,
    timeslots_id integer,
    foreign key (talks_id) references talks(id),
    foreign key (days_id) references days(id),
    foreign key (timeslots_id) references timeslots(id)
);

create table if not exists student_enrollment (
    id serial primary key,
    student_id integer not null,
    course_offering_id integer not null,
    foreign key (student_id) references persons(id),
    foreign key (offering_id) references offerings(id)
);