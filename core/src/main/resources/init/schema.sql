CREATE TABLE IF NOT EXISTS medical_card(
    id BIGINT PRIMARY KEY NOT NULL,
    client_status CHAR,
    med_status CHAR,
    registry_dt DATE NOT NULL,
    comment TEXT
);

CREATE TABLE IF NOT EXISTS contact(
    id BIGINT PRIMARY KEY NOT NULL,
    phone_number VARCHAR(32) NOT NULL,
    email VARCHAR(128),
    profile_link TEXT
);

CREATE TABLE IF NOT EXISTS illness(
    id BIGINT PRIMARY KEY NOT NULL,
    medical_card_id BIGINT REFERENCES medical_card(id) NOT NULL,
    type_id BIGINT,
    heaviness CHAR,
    appearance_dttm TIMESTAMP NOT NULL,
    recovery_dt DATE
);

CREATE TABLE IF NOT EXISTS address(
    id BIGINT PRIMARY KEY NOT NULL,
    contact_id BIGINT REFERENCES contact(id) NOT NULL,
    country_id BIGINT NOT NULL,
    city VARCHAR(255) NOT NULL,
    index INTEGER,
    street VARCHAR(255) NOT NULL,
    building VARCHAR(32) NOT NULL,
    flat VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS person_data(
    id BIGINT PRIMARY KEY NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    birth_dt DATE NOT NULL,
    age SMALLINT,
    sex CHAR NOT NULL,
    contact_id BIGINT REFERENCES contact(id) NOT NULL,
    medical_card_id BIGINT REFERENCES medical_card(id) NOT NULL,
    parent_id BIGINT CHECK ( parent_id <> id ) REFERENCES person_data(id)
);