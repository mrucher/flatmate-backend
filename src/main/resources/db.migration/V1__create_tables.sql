create table if not exists apartment (
        apartment_id uuid not null,
        is_active boolean,
        address varchar(255),
        location bytea,
        lodger_count int4,
        price float8,
        publication_date timestamp with time zone,
        rooms_count int4,
        constraint apartment_pkey primary key (apartment_id)
    );

create table if not exists role (
        role_id  serial not null,
        role varchar(20),
        constraint role_pkey primary key (role_id)
    );

create table if not exists "user" (
        user_id uuid not null,
        city varchar(255),
        email varchar(255),
        firstname varchar(255) not null,
        login varchar(255) not null,
        password varchar(255),
        photo bytea,
        role_id int4,
        constraint user_pkey primary key (user_id),
        constraint fk_role
            foreign key (role_id)
                references role(role_id)
                on delete cascade
    );

create table if not exists renter(
                                     renter_id        uuid not null,
                                     max_price        int4,
                                     publication_date timestamp with time zone,
                                     user_id          uuid not null,
                                     apartment_id     uuid,
                                     constraint renter_pkey primary key (renter_id),
                                     constraint fk_aparment
                                         foreign key (apartment_id)
                                             references apartment (apartment_id)
                                             on delete no action,
                                     constraint fk_user
                                         foreign key (user_id)
                                             references "user"(user_id)
                                             on delete cascade

);

create table if not exists landlord (
        landlord_id uuid not null,
        apartment_id uuid not null,
        user_id uuid not null,
        constraint landlord_pkey primary key (landlord_id),
        constraint fk_aparment
            foreign key (apartment_id)
                references apartment(apartment_id)
                on delete cascade,
        constraint fk_user
            foreign key (user_id)
                references "user"(user_id)
                on delete cascade
    );

create table if not exists apartment_photo (
        apartment_photo_id uuid not null,
        apartment_id uuid,
        photo bytea,
        constraint apartment_photo_pkey primary key (apartment_photo_id),
        constraint fk_apartment
            foreign key (apartment_id)
                references apartment(apartment_id)
                on delete cascade
    );

create table if not exists apartment_feedback (
        apartment_feedback_id uuid not null,
        apartment_id uuid,
        author_id uuid,
        feedback text,
        rating int4,
        constraint apartment_fb_pkey primary key (apartment_feedback_id),
        constraint fk_apartment
            foreign key (apartment_id)
                references apartment(apartment_id)
                on delete cascade
--         constraint fk_author
--             foreign key (author_id)
--                 references renter(renter_id)
--                 on delete cascade
    );

create table if not exists renter_feedback (
        renter_feedback_id uuid not null,
        feedback varchar(255),
        rating int4 not null,
--        author_id uuid not null,
        renter_id uuid not null,
        constraint renter_fb_pkey primary key (renter_feedback_id),
        constraint fk_renter
            foreign key (renter_id)
                references renter(renter_id)
                on delete cascade
--         constraint fk_author
--             foreign key (author_id)
--                 references users(user_id)
--                 on delete cascade
    );