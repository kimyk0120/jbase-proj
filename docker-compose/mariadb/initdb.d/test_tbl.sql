create table test_tbl
(
    id          bigint auto_increment
        primary key,
    memo        varchar(300)                         null,
    amount      int                                  null,
    modified_at datetime default current_timestamp() null,
    created_at  datetime default current_timestamp() null
)
    comment 'test table';

INSERT INTO test.test_tbl (id, memo, amount, modified_at, created_at) VALUES (1, 'test', 100, '2023-10-01 16:08:42', '2023-10-01 16:08:43');
