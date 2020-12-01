create table public.posts (
  id serial primary key,
  name varchar(2000),
  description text,
  created timestamp without time zone not null default now()
);

CREATE TABLE public.authorities (
  id serial primary key,
  authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE public.users (
  id serial primary key,
  username VARCHAR(50) NOT NULL unique,
  password VARCHAR(100) NOT NULL,
  enabled boolean default true,
  authority_id int not null references authorities(id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, password, authority_id)
values ('root', '$2a$10$Pkp7RE0inziQeYLmoQERiOQoB0cegl.AyXBzIwgyuv0L6SjcQNx5C',
(select id from authorities where authority = 'ROLE_ADMIN'));