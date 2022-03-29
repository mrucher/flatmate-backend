insert into "user" (user_id, city, email, firstname, login, password, role_id)
values ('0060f831-0556-430a-a30b-f017c44950f3', 'St. Petersburg', 'test-spb21@yandex.ru',
        'Maxim', 'admin', '$2a$12$UTebuE95b.cI9lkpAcktXeaKy0fJuugEl1DItKkAERuufEaMjXaPW', 2)
on conflict (user_id) do nothing;
