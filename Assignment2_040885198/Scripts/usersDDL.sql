DROP TABLE IF exists public.users;

CREATE TABLE public.users (
  id                   int not null IDENTITY,
-- TODO more member fields
  Student_Name          varchar(50),
  Student_Number        int,
  college               varchar(50),
  course                 varchar(50),
  primary key (id)
);