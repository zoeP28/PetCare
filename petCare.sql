CREATE TABLE User (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE Pet (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  breed VARCHAR(255) NOT NULL,
  age INT,
  medical_information TEXT,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Review (
  id INT PRIMARY KEY,
  rating INT CHECK (rating > 0 and rating < 5) NOT NULL,
  comment TEXT,
  date DATETIME,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Appointment (
  id INT PRIMARY KEY,
  date DATETIME,
  service_type VARCHAR(255) NOT NULL,
  pet_id INT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (pet_id) REFERENCES Pet(id),
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Payment (
  id INT PRIMARY KEY,
  cost DECIMAL(10,2) NOT NULL,
  method VARCHAR(255) NOT NULL,
  date DATETIME,
  appointment_id INT NOT NULL,
  FOREIGN KEY (appointment_id) REFERENCES Appointment(id)
);

CREATE TABLE Business (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE Service (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  price DECIMAL(10,2) NOT NULL,
  duration INT,
  business_id INT NOT NULL,
  FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Business_for_Certification (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL
);

CREATE TABLE Certificates (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL
);

CREATE TABLE Certificated_Business (
  id INT PRIMARY KEY,
  start_date DATETIME NOT NULL,
  expiry_date DATETIME NOT NULL,
  business_for_certification_id INT NOT NULL,
  certificate_id INT NOT NULL,
  FOREIGN KEY (business_for_certification_id) REFERENCES Business_for_Certification(id),
  FOREIGN KEY (certificate_id) REFERENCES Certificates(id)
);

CREATE TABLE Personal_Package (
  id INT PRIMARY KEY,
  services VARCHAR(255) NOT NULL,
  monetary_limit DECIMAL(10,2) NOT NULL,
  amount_generated DECIMAL(10,2) NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Admin (
  id INT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);

CREATE TABLE Statistics (
  id INT PRIMARY KEY,
  rating INT CHECK (rating > 0 and rating < 5) NOT NULL,
  comment TEXT,
  date DATETIME,
  business_id INT NOT NULL,
  FOREIGN KEY (business_id) REFERENCES Business(id)
);
