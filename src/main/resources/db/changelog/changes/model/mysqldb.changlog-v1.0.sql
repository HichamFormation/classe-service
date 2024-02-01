DROP TABLE IF EXISTS class_entity CASCADE;

CREATE TABLE class_entity (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  floor VARCHAR(255),
  nbr_place INT,
  PRIMARY KEY (id)
);
