CREATE TABLE pokemons (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    genus VARCHAR(100),
    height DECIMAL(5,2),
    weight DECIMAL(5,2)
);

COMMENT ON TABLE pokemons IS 'ポケモン基本マスタ';
COMMENT ON COLUMN pokemons.name IS 'ポケモン名';

INSERT INTO pokemons (id, name, genus, height, weight) VALUES
    (1, 'フシギダネ', 'たねポケモン', 0.7, 6.9),
    (25, 'ピカチュウ', 'ねずみポケモン', 0.4, 6.0);