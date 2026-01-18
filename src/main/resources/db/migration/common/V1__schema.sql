CREATE TABLE pokemons (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    genus VARCHAR(100),
    height DECIMAL(5,2),
    weight DECIMAL(5,2)
);

COMMENT ON TABLE pokemons IS 'ポケモン基本マスタ';
COMMENT ON COLUMN pokemons.name IS 'ポケモン名';