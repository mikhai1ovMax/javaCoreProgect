create table if not exists public.Region(
    id serial not null primary key,
    region varchar(45)
);

create table if not exists public.Writer(
    id serial not null primary key,
    first_name varchar(45),
    last_name varchar(45),
    region_id int,
    constraint fk_region
        foreign key (region_id)
            references Region(id)
);

create table if not exists public.Post(
    id serial not null primary key,
    content text not null,
    created timestamptz not null,
    updated timestamptz,
    writer_id int,
    constraint fk_writer
        foreign key(writer_id)
            references Writer(id)
);