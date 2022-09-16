create table customer (
    id bigint primary key,
    first_name varchar(100) not null,
    last_name varchar(100),
    birth_date timestamp,
    phone_nr varchar(50) not null,
    email varchar(50)
);
create table reservation (
    id bigint primary key,
    customer_id bigint not null,
    comment varchar(1024),
    constraint fk_customer_id foreign key(customer_id) references customer(id)
);
create table workshop (
    id bigint primary key,
    name varchar(254) not null,
    description varchar(10000)
);
create table timeslot(
    id bigint primary key,
    start_time timestamp not null,
    end_time timestamp not null
);
create table workshop_timeslot (
    id bigint primary key,
    start_date date not null,
    end_date date not null,
    workshop_id bigint not null,
    timeslot_id bigint not null,
    reservation_id bigint,
    constraint fk_workshop_id foreign key(workshop_id) references workshop(id),
    constraint fk_timeslot_id foreign key(timeslot_id) references timeslot(id),
    constraint fk_reservation_id foreign key(reservation_id) references reservation(id)
);