CREATE TABLE User (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  address VARCHAR(255) NOT NULL,
  profile_picture VARBINARY(255) NOT NULL
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


CREATE TABLE Business (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  profile_picture VARBINARY(255) NOT NULL,
  business_information TEXT NOT NULL
);


CREATE TABLE Service (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  price DECIMAL(10,2) NOT NULL,
  availability ENUM('yes','no') NOT NULL,
  rating INT CHECK (rating > 0 and rating < 5) NOT NULL,
  duration FLOAT,
  business_id INT NOT NULL,
  FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Appointment (
  id INT PRIMARY KEY,
  date DATETIME,
  service_type VARCHAR(255) NOT NULL,
  status ENUM('pending', 'canceled', 'confirmed'),
  pet_id INT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (pet_id) REFERENCES Pet(id),
  FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Rating (
  id INT PRIMARY KEY,
  rating INT CHECK (rating > 0 and rating < 5) NOT NULL,
  comment TEXT,
  date DATETIME,
  user_id INT NOT NULL,
  service_id INT NOT NULL,
  Appointment_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES User(id),
  FOREIGN KEY (service_id) REFERENCES Service(id),
  FOREIGN KEY (Appointment_id) REFERENCES Appointment(id)
);


CREATE TABLE Payment (
  id INT PRIMARY KEY,
  user_id INT NOT NULL,
  cost DECIMAL(10,2) NOT NULL,
  payment_method VARCHAR(255) NOT NULL,
  date DATETIME,
  appointment_id INT NOT NULL,
  service_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES User(id),
  FOREIGN KEY (appointment_id) REFERENCES Appointment(id),
  FOREIGN KEY (service_id) REFERENCES Service(id)
);

CREATE TABLE Business_for_Certification (
  id INT PRIMARY KEY NOT NULL,
  business_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL,
  FOREIGN KEY (business_id) REFERENCES Business(id)
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
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  profile_picture VARBINARY(255) NOT NULL
);

CREATE TABLE Statistics (
  id INT PRIMARY KEY,
  rating INT CHECK (rating > 0 and rating < 5) NOT NULL,
  comment TEXT,
  date DATETIME,
  business_id INT NOT NULL,
  FOREIGN KEY (business_id) REFERENCES Business(id)
);

CREATE TABLE Frequent_Questions (
  id INT PRIMARY KEY,
  date_created date NOT NULL
);