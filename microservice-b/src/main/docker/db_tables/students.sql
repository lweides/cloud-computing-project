create table if not exists students (
    id integer auto_increment primary key,
    name varchar(255) not null,
    matriculation_number varchar(255) not null,
    comment varchar(255)
);

insert into students (id, name, matriculation_number, comment) values (1, "Test Student", "k12341234", "This is a test");
