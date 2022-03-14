create table types
(
    id   bigint not null
        constraint types_pkey
            primary key,
    name varchar(255)
);

create table programs
(
    id      bigint not null
        constraint programs_pkey
            primary key,
    name    varchar(255),
    type_id bigint
        constraint fkc5o7x7hxew5xy65mwo5ws0uat
            references types
);

create table monday
(
    id          bigint not null
        constraint monday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fkrs8p1bn7l41ogabwfe5cr5gi1
            references programs
);

create table tuesday
(
    id          bigint not null
        constraint tuesday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fkd90t5g31ygbecpan5gn7mt8iy
            references programs
);

create table wednesday
(
    id          bigint not null
        constraint wednesday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fk1flabmpgyofev359cskug7f3a
            references programs
);

create table thursday
(
    id          bigint not null
        constraint thursday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fkqshg857wgcjc1gwss3dbex6w6
            references programs
);

create table friday
(
    id          bigint not null
        constraint friday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fk38bw7fs34b82tdwa44o1v0cuq
            references programs
);

create table saturday
(
    id          bigint not null
        constraint saturday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fk7kvsehv5pi48eaoo96gewbey8
            references programs
);

create table sunday
(
    id          bigint not null
        constraint sunday_pkey
            primary key,
    airing_time time,
    program_id  bigint
        constraint fk4earrwworus104bsnf6ie8q9f
            references programs
);