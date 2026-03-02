# Vehicle Rental Management System (Java)

## Description

This project is a vehicle rental management system developed in Java as part of an academic project.

The system allows the management of different types of vehicles and users, supporting rental creation, user classification and data persistence. It was developed using object-oriented programming principles with a modular and structured design.

## System Overview

The system includes:

- Multiple vehicle types (Bicycle, E-Bike, Scooter)
- Different user categories (Student, Teacher, Non-Teaching Staff, Employee)
- Rental creation and management
- File-based data loading for vehicles and users
- Object serialization for rental data persistence

## Object-Oriented Concepts Applied

- Encapsulation
- Inheritance
- Polymorphism
- Class hierarchy design
- Separation of responsibilities
- File handling (File I/O)
- Object serialization

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- File I/O
- Serialization

## Project Structure

vehicle-rental-system-java/
│
├── src/
│   ├── Main.java
│   ├── Veiculo.java
│   ├── Bicicleta.java
│   ├── EBike.java
│   ├── Trotinete.java
│   ├── Utilizador.java
│   ├── Estudante.java
│   ├── Docente.java
│   ├── NaoDocente.java
│   ├── Funcionario.java
│   ├── Aluguer.java
│   ├── GestorAlugueres.java
│   ├── LeitorFicheiros.java
│   ├── veículos.txt
│   ├── utilizadores.txt
│
├── README.md
└── .gitignore

## How to Run

Navigate to the `src` folder and compile:

javac *.java

Run the program:

java Main

## Features

- Vehicle registration and classification
- User hierarchy and differentiation
- Rental processing and management
- Data loading from text files
- Persistent storage of rental data
- Modular object-oriented architecture

## What I Learned

- Structuring medium-sized Java projects
- Designing and implementing class hierarchies
- Applying object-oriented programming principles
- Managing file input/output operations
- Working with object serialization for data persistence

## Author

Gonçalo Costa  
Computer Engineering Student – University of Coimbra
