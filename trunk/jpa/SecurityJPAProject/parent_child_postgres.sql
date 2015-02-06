drop table child;
drop table parent;

DROP TABLE IF EXISTS PARENT CASCADE;
CREATE TABLE PARENT (
    ID SERIAL PRIMARY KEY,
    NAME varchar(50) not null  
);

CREATE TABLE CHILD (
     ID SERIAL PRIMARY KEY,
    CHILD_NAME varchar(50) not null,
    PARENT_ID INT 
);

ALTER TABLE child ADD CONSTRAINT   parent_child_fk  FOREIGN KEY 
( parent_id ) REFERENCES   parent  ( id );
	




 