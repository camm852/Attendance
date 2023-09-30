
CREATE TABLE "customers" (
  "customer_id" serial PRIMARY KEY,
  "name" varchar,
  "location" text
);

CREATE TABLE "employees" (
  "employee_id" serial PRIMARY KEY,
  "id" varchar,
  "name" varchar,
  "photo" text
);

CREATE TABLE "assignments" (
  "assignment_id" serial PRIMARY KEY,
  "customer_id" int,
  "employee_id" int,
  "start" timestamp,
  "end" timestamp
);

CREATE TABLE "attendance" (
  "attendance_id" serial PRIMARY KEY,
  "customer_id" int,
  "employee_id" int,
  "time_in" timestamp,
  "time_out" timestamp,
  "photo" text
);

ALTER TABLE "assignments" ADD FOREIGN KEY ("employee_id") REFERENCES "employees" ("employee_id");

ALTER TABLE "assignments" ADD FOREIGN KEY ("customer_id") REFERENCES "customers" ("customer_id");

ALTER TABLE "attendance" ADD FOREIGN KEY ("employee_id") REFERENCES "employees" ("employee_id");

ALTER TABLE "attendance" ADD FOREIGN KEY ("customer_id") REFERENCES "customers" ("customer_id");


INSERT INTO customers (name, location) VALUES ('Exito', 'Location 1');

INSERT INTO customers (name, location) VALUES ('D1', 'Location 2');

INSERT INTO customers (name, location) VALUES ('Olimpica', 'Location 2');