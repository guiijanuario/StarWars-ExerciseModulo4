CREATE TABLE rebels(
  ID SERIAL PRIMARY KEY,
  NAME varchar(255),
  age integer,
  gender varchar(20),
  location varchar(255),
  status varchar(10) DEFAULT 'aliado'
);

CREATE TABLE traitors(
  ID SERIAL PRIMARY KEY,
  id_rebel integer NOT NULL,
  warnings integer NOT NULL,
  report_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_rebel) REFERENCES rebels (id)
);

CREATE TABLE locations(
  ID SERIAL PRIMARY KEY,
  id_rebel integer NOT NULL,
  old_location varchar(255),
  new_location varchar(255),
  data_change TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_rebel) REFERENCES rebels (ID)
);

CREATE TABLE items (
  id SERIAL PRIMARY KEY,
  name varchar(255),
  damage integer,
  color varchar(30),
  durability integer,
  maximumAmmoAmount integer,
  amount integer,
  category varchar(20)
);

CREATE TABLE store (
  id_item integer NOT NULL,
  price decimal(10,2) NOT NULL,
  amount integer NOT NULL,
  FOREIGN KEY (id_item) REFERENCES items (id)
);

CREATE TABLE inventory (
  id SERIAL PRIMARY KEY,
  id_rebel integer,
  id_weapon_slot integer,
  id_water_slot integer,
  id_food_slot integer,
  id_ammo integer,
  ammo_quantity integer,
  food_quantity integer,
  water_quantity integer,
  FOREIGN KEY (id_rebel) REFERENCES rebels (id),
  FOREIGN KEY (id_weapon_slot) REFERENCES items (id),
  FOREIGN KEY (id_food_slot) REFERENCES items (id),
  FOREIGN KEY (id_water_slot) REFERENCES items (id),
  FOREIGN KEY (id_ammo) REFERENCES items (id)
);

CREATE TABLE inventory (
  id SERIAL PRIMARY KEY,
  id_rebel integer,
  id_item integer,
  ammo_quantity integer,
  food_quantity integer,
  water_quantity integer,
  FOREIGN KEY (id_rebel) REFERENCES rebels (id),
  FOREIGN KEY (id_item) REFERENCES items (id)
);

CREATE TABLE purchases (
  id SERIAL PRIMARY KEY,
  rebel_id INT REFERENCES rebels (id),
  item_id INT REFERENCES items (id),
  quantity INT,
  price DECIMAL(10,2),
  purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO items (name, damage, color, durability, maximumAmmoAmount, amount, category) VALUES
('Lightsaber', 15, 'blue', 100, null, null, 'weapon'),
('Lightsaber', 15, 'green', 100, null, null, 'weapon'),
('Lightsaber', 15, 'red', 100, null, null, 'weapon'),
('Lightsaber', 15, 'yellow', 100, null, null, 'weapon'),
('Gun', 25, 'black', 100, 12, null, 'weapon'),
('Stick', 5, 'brown', 100, null, null, 'weapon'),
('Beast', 15, 'brown', 100, 15, null, 'weapon'),
('Rifre', 12, 'Branco', 100, 30, null, 'weapon'),
('Shotgun', 35, 'black with white', 100, 6, null, 'weapon'),
('Water', 0, 'blue', 100, null, 30, 'foods'),
('Food', 0, 'brown', 100, null, 50, 'foods'),
('Ammo', 5, null, 100, null, 100, 'ammo'),
(null, null, Null, null, null, null, null);

INSERT INTO store (id_item, price, amount) VALUES
(1, 120.0, 10),
(2, 120.0, 10),
(3, 120.0, 10),
(4, 120.0, 10),
(5, 150.0, 15),
(6, 60.0, 15),
(7, 90.0, 5),
(8, 280.0, 20),
(9, 180.0, 5),
(10, 20.0, 80),
(11, 25.0, 120);

