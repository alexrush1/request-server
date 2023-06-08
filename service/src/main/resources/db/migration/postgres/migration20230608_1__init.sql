create table status(
    status VARCHAR primary key,
    description VARCHAR
);

comment on column status.status is 'Имя статуса';
comment on column status.description is 'Описание статуса';

create table request(
    id UUID primary key,
    creation_date TIMESTAMP,
    status VARCHAR,
    client_id UUID,
    payload JSONB
);

comment on column request.id is 'ИД заявки';
comment on column request.creation_date is 'Дата создания заявки';
comment on column request.creation_date is 'Статус заявки';
comment on column request.client_id is 'ИД клиента';
comment on column request.payload is 'Наполнение заявки';