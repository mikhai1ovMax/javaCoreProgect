create table if not exists region(
    id serial not null primary key,
    region varchar(45)
);

create table if not exists writer(
    id serial not null primary key,
    first_name varchar(45),
    last_name varchar(45),
    region_id int,
    constraint fk_region
        foreign key (region_id)
            references Region(id)
);

create table if not exists post(
    id serial not null primary key,
    content text not null,
    created timestamptz not null,
    updated timestamptz,
    writer_id int,
    constraint fk_writer
        foreign key(writer_id)
            references Writer(id)
);