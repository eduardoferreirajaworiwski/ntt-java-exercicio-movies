-- Inserções em filmes
INSERT INTO movies (title) VALUES ('The Shawshank Redemption');
INSERT INTO movies (title) VALUES ('Pulp Fiction');
INSERT INTO movies (title) VALUES ('The Godfather');
INSERT INTO movies (title) VALUES ('Fight Club');
INSERT INTO movies (title) VALUES ('The Dark Knight');
INSERT INTO movies (title) VALUES ('Forrest Gump');

-- Inserções em gêneros
INSERT INTO genres (genre_name) VALUES ('Crime');
INSERT INTO genres (genre_name) VALUES ('Thriller');
INSERT INTO genres (genre_name) VALUES ('Fantasy');
INSERT INTO genres (genre_name) VALUES ('Mystery');

-- Inserções em atores
INSERT INTO actors (name) VALUES ('Morgan Freeman');
INSERT INTO actors (name) VALUES ('Tim Robbins');
INSERT INTO actors (name) VALUES ('John Travolta');
INSERT INTO actors (name) VALUES ('Bruce Willis');
INSERT INTO actors (name) VALUES ('Al Pacino');
INSERT INTO actors (name) VALUES ('Robert De Niro');

-- Inserções em estúdios
INSERT INTO studios (name, country) VALUES ('20th Century Studios', 'Estados Unidos');
INSERT INTO studios (name, country) VALUES ('DreamWorks', 'Estados Unidos');
INSERT INTO studios (name, country) VALUES ('Pixar Animation Studios', 'Estados Unidos');

-- Inserções em diretores
INSERT INTO directors (name) VALUES ('Quentin Tarantino');
INSERT INTO directors (name) VALUES ('Francis Ford Coppola');
INSERT INTO directors (name) VALUES ('David Fincher');
INSERT INTO directors (name) VALUES ('Frank Darabont');

-- Inserções em usuários
INSERT INTO users (name, username, email, password) VALUES ('Lucas', 'lucas', 'lucas@email.com', 'password123');
INSERT INTO users (name, username, email, password) VALUES ('Ana', 'ana', 'ana@email.com', 'abcdef');

-- Inserções em franquias
INSERT INTO franchises (name) VALUES ('Harry Potter');
INSERT INTO franchises (name) VALUES ('Star Wars');

-- Inserções em serviços de streaming
INSERT INTO streamings (name, url) VALUES ('Disney+', 'www.disneyplus.com');
INSERT INTO streamings (name, url) VALUES ('HBO Max', 'www.hbomax.com');