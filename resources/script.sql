CREATE TABLE "User" (
	id INT,
	name VARCHAR(255) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	phone VARCHAR(11) UNIQUE NOT NULL,
	gender VARCHAR(100),
	age INT NOT NULL,
	
	PRIMARY KEY(id),
	CHECK(age >= 16)
);

CREATE TABLE "Vacancy" (
	id INT,
	company VARCHAR(255) NOT NULL,
	role VARCHAR(100) NOT NULL,
	description VARCHAR(255) NOT NULL,
	salary DECIMAL(10, 2) NOT NULL DEFAULT 1412.00,
	
	PRIMARY KEY(id),
	CHECK(salary >= 1412.00)
);

CREATE TABLE "User_Vacancy" (
	user_id INT,
	vacancy_id INT,
	FOREIGN KEY (user_id) REFERENCES "User"(id),
	FOREIGN KEY (vacancy_id) REFERENCES "Vacancy"(id),
	PRIMARY KEY (user_id, vacancy_id)
);
