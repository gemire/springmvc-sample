-- this is derby dialect
    alter table security.application_groups 
        drop constraint FK16C837A380B23EC7;

    alter table security.application_groups 
        drop constraint FK16C837A36A04B369;

    alter table security.group_assignments 
        drop constraint FKB451E1862B4DA1D;

    alter table security.group_assignments 
        drop constraint FKB451E1866A04B369;

    drop table security.application_groups;

    drop table security.applications;

    drop table security.group_assignments;

    drop table security.groups;

    drop table security.users;

    create table security.application_groups (
        id integer generated by default as identity,
        group_id integer not null,
        application_id integer not null,
        primary key (id)
    );

    create table security.applications (
        id integer generated by default as identity,
        application_name varchar(120),
        primary key (id)
    );

    create table security.group_assignments (
        id integer generated by default as identity,
        group_id integer not null,
        user_id varchar(20) not null,
        primary key (id)
    );

    create table security.groups (
        id integer generated by default as identity,
        group_name varchar(120),
        primary key (id)
    );

    create table security.users (
        UserID varchar(20) not null,
        username varchar(20),
        primary key (UserID)
    );

    alter table security.application_groups 
        add constraint FK16C837A380B23EC7 
        foreign key (application_id) 
        references security.applications;

    alter table security.application_groups 
        add constraint FK16C837A36A04B369 
        foreign key (group_id) 
        references security.groups;

    alter table security.group_assignments 
        add constraint FKB451E1862B4DA1D 
        foreign key (user_id) 
        references security.users;

    alter table security.group_assignments 
        add constraint FKB451E1866A04B369 
        foreign key (group_id) 
        references security.groups;