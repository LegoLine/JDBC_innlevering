create table if not exists persons (
    id serial primary key,
    given_name varchar not null,
    family_name varchar not null,
    email varchar not null unique
);

create table if not exists courses (
    id serial primary key,
    title varchar not null
);

create table if not exists semester (
    id serial primary key,
    title varchar not null,
    start_date date not null,
    finish_date date not null
);

create table if not exists course_offerings (
    id serial primary key,
    semester_id integer not null,
    course_id integer not null,
    teacher_id integer,
    foreign key (semester_id) references semester(id),
    foreign key (course_id) references courses(id),
    foreign key (teacher_id) references persons(id)
);

create table if not exists student_enrollment (
    id serial primary key,
    student_id integer not null,
    course_offering_id integer not null,
    foreign key (student_id) references persons(id),
    foreign key (course_offering_id) references course_offerings(id)
);