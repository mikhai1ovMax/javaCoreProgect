create table if not exists public.region(
    id serial not null primary key,
    region varchar(45)
);

create table if not exists public.writer(
    id serial not null primary key,
    first_name varchar(45),
    last_name varchar(45),
    region_id int,
    constraint fk_region
        foreign key (region_id)
            references region(id)
);

create table if not exists public.post(
    id serial not null primary key,
    content text not null,
    created timestamptz not null,
    updated timestamptz,
    writer_id int,
    constraint fk_writer
        foreign key(writer_id)
            references writer(id)
);