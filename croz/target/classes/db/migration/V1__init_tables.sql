create table category(
    id integer not null primary key,
    name varchar(400) not null
);
create table joke(
    id integer not null,
    content varchar(400) not null primary key,
    likes integer default 0,
    dislikes integer default 0,
    foreign key (id) references category(id)
);
