CREATE TABLE answers(
    id bigint not null auto_increment,
    message varchar(2000) not null unique,
    creation_date date not null unique,
    topic_id bigint not null,
    user_id bigint not null,
    solution boolean not null,

    primary key(id)
);