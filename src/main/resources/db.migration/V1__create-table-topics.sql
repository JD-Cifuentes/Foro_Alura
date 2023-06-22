CREATE TABLE topics(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(2000) not null unique,
    creation_date date not null unique,
    status varchar(100) not null,
    user_id bigint not null,
    course_id bigint not null,

    primary key(id)
);