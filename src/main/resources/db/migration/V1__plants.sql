CREATE TABLE plants
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    height_cm INTEGER      NOT NULL CHECK (height_cm > 0)
);

CREATE INDEX plants_name_idx ON plants (name);