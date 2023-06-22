CREATE TABLE courses(
    id bigint not null auto_increment,
    name varchar(100) not null,
    category varchar(100) not null,
    user_id bigint not null,

    primary key(id)
);