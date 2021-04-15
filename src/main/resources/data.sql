INSERT INTO countries (continent,name) VALUES
  ('Europe', 'UK'),
  ('Europe', 'Germany'),
  ('Europe', 'France'),
  ('Europe', 'Russia'),
  ('North America', 'USA'),
  ('North America', 'Canada'),
  ('Europe', 'Spain');

INSERT INTO authors (name,surname,country_id) VALUES
('Agatha', 'Christie',1),
('Jane', 'Austen',1),
('Miguel','de Cervantes',7),
('Leo','Tolstoy', 4),
('Alexander', 'Pushkin',4),
('Hermann', 'Hesse',2),
('Victor', 'Hugo',3),
('Ernest', 'Hemingway',5),
('Mark', 'Twain',5);

INSERT INTO books (available_copies, category, name, author_id) VALUES
(5,'NOVEL','Murder on the Orient Express',1),
(2,'NOVEL','Steppenwolf',6),
(2,'NOVEL','Murder on the Orient Express',1),
(3,'NOVEL','Steppenwolf',5),
(4,'NOVEL','Murder on the Orient Express',4),
(6,'NOVEL','Steppenwolf',3);