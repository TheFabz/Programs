DROP DATABASE IF EXISTS library;
CREATE DATABASE library;

USE library;

CREATE TABLE book_types (
  title_id INT AUTO_INCREMENT UNIQUE NOT NULL,
  book_title VARCHAR(30) NOT NULL,
  author VARCHAR(30) NOT NULL DEFAULT 'Unknown',
  publisher VARCHAR(20) NOT NULL DEFAULT 'Self-published',
  genre VARCHAR(15) NOT NULL,
  observations VARCHAR(40),
  PRIMARY KEY (title_id)
);

CREATE TABLE books (
  book_id INT AUTO_INCREMENT UNIQUE NOT NULL,
  title_id INT NOT NULL,
  state VARCHAR(15) NOT NULL DEFAULT 'New',
  date_add_to_lib DATE NOT NULL,
  observations VARCHAR(40),
  PRIMARY KEY (book_id),
  FOREIGN KEY (title_id) REFERENCES book_types(title_id) ON DELETE CASCADE
);

CREATE TABLE users (
  user_id INT AUTO_INCREMENT UNIQUE NOT NULL,
  name VARCHAR(30) NOT NULL,
  contact LONG NOT NULL,
  user_status VARCHAR(20) NOT NULL DEFAULT 'Regular',
  observations VARCHAR(40),
  PRIMARY KEY (user_id)
);

CREATE TABLE log_reservations (
  book_id INT NOT NULL,
  user_id INT NOT NULL,
  date_borrowed DATE NOT NULL,
  date_returned DATE NOT NULL,
  state VARCHAR(15) NOT NULL,
  PRIMARY KEY (book_id, user_id, date_borrowed),
  FOREIGN KEY (book_id) REFERENCES books(book_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE active_reservations (
  book_id INT NOT NULL,
  user_id INT NOT NULL,
  date_borrowed DATE NOT NULL,
  PRIMARY KEY (book_id),
  FOREIGN KEY (book_id) REFERENCES books(book_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

DELIMITER //
CREATE TRIGGER before_reservation_delete
    BEFORE DELETE ON active_reservations
    FOR EACH ROW
BEGIN
    INSERT INTO log_reservations
    VALUES (OLD.book_id, OLD.user_id, OLD.date_borrowed, CURDATE(), 'No value');
END //
DELIMITER ;

INSERT INTO book_types(book_title, author, publisher, genre) VALUES ('The Little Prince', 'Saint-Exupery', 'Leya', 'Children');
INSERT INTO book_types(book_title, author, publisher, genre) VALUES ('War and Peace', 'Tolstoy', 'Areal', 'Drama');
INSERT INTO book_types(book_title, author, publisher, genre) VALUES ('Animal Farm', 'Orwell', 'Penguin', 'Politics');
INSERT INTO book_types(book_title, author, publisher, genre) VALUES ('Fahrenheit 451', 'Bradbury', 'Porto Editora', 'Distopia');

INSERT INTO books (title_id, state, date_add_to_lib) VALUES (1, 'used-ok', '2018-07-21');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (1, 'used-old', '2019-09-11');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (2, 'new', '2018-01-20');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (2, 'old', '2018-03-13');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (2, 'used-ok', '2018-09-15');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (3, 'used-ok', '2018-01-19');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (4, 'new', '2018-11-20');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (4, 'new', '2018-10-26');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (4, 'used-ok', '2018-01-30');
INSERT INTO books (title_id, state, date_add_to_lib) VALUES (4, 'used-old', '2018-03-10');

INSERT INTO users (name, contact, user_status) VALUES ('John Doe', 967734144, 'Good');
INSERT INTO users (name, contact) VALUES ('Jane Doe', 967734144);
INSERT INTO users (name, contact, user_status) VALUES ('Susan', 967734144, 'Bad');
INSERT INTO users (name, contact) VALUES ('Mark', 967734144);
INSERT INTO users (name, contact, user_status) VALUES ('Bruno', 967734144, 'Good');
INSERT INTO users (name, contact) VALUES ('Maggie', 967734144);
INSERT INTO users (name, contact) VALUES ('Mag', 967734144);
INSERT INTO users (name, contact) VALUES ('Angie', 967734144);
INSERT INTO users (name, contact, user_status) VALUES ('Berta', 967734144, 'Bad');
INSERT INTO users (name, contact) VALUES ('Filip', 967734144);

INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (1, 1, '2020-09-17', '2020-09-29', 'used-ok');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (1, 2, '2020-08-15', '2020-08-29', 'used-ok');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (2, 3, '2020-01-15', '2020-01-30', 'used-old');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (3, 4, '2020-10-01', '2020-10-27', 'new');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (4, 1, '2020-11-20', '2020-11-28', 'old');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (5, 5, '2020-02-21', '2020-02-27', 'used-ok');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (7, 9, '2020-01-09', '2020-01-26', 'new');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (9, 9, '2020-12-11', '2020-12-25', 'used-ok');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (4, 1, '2020-05-10', '2020-05-29', 'old');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (2, 8, '2020-03-11', '2020-03-28', 'used-old');
INSERT INTO log_reservations (book_id, user_id, date_borrowed, date_returned, state) VALUES (5, 5, '2020-02-18', '2020-02-21', 'used-ok');

INSERT INTO active_reservations (book_id, user_id, date_borrowed) VALUES (1, 5, '2021-01-21');
INSERT INTO active_reservations (book_id, user_id, date_borrowed) VALUES (2, 4, '2021-02-15');
INSERT INTO active_reservations (book_id, user_id, date_borrowed) VALUES (3, 3, '2021-03-10');
INSERT INTO active_reservations (book_id, user_id, date_borrowed) VALUES (4, 2, '2021-01-14');
