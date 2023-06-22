CREATE TABLE topics(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(2000) not null unique,
    creation_date date not null unique,
    status varchar(100) not null,
    autor varchar(100) not null,
    course varchar(100),

    primary key(id)
);