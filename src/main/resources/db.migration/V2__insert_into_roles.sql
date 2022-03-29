insert into role (role_id, role)
values (1, 'ROLE_USER')
on conflict (role_id) do nothing;
insert into role (role_id, role)
values (2, 'ROLE_ADMIN')
on conflict (role_id) do nothing;
