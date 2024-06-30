CREATE TABLE product
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    price NUMERIC      NOT NULL
);

CREATE TABLE coupon
(
    id            SERIAL PRIMARY KEY,
    code          VARCHAR(255) NOT NULL,
    discount NUMERIC      NOT NULL,
    percentage  BOOLEAN      NOT NULL
);

INSERT INTO product (name, price) VALUES ('iphone', 100);
INSERT INTO product (name, price) VALUES ('case', 10);
INSERT INTO coupon (code, discount, percentage) VALUES ('P10', 10, true);
INSERT INTO coupon (code, discount, percentage) VALUES ('D5', 5, true);