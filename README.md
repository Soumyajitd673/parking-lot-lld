# Parking Lot — Low Level Design

A Java implementation of a **Parking Lot system** designed to demonstrate object-oriented design and commonly used design patterns.

The project supports multiple parking levels, different vehicle types, configurable parking-slot allocation strategies, and configurable fare calculation strategies.

---

## Features

* Multiple parking levels
* Support for:

    * Car
    * Bike
    * Bus
* Different slot types for different vehicles
* Vehicle entry and exit
* Automatic slot allocation
* Configurable entry strategies
* Configurable fare calculation strategies
* Vehicle creation using a Factory
* Parking data management
* Extensible object-oriented design

---

## Design Patterns Used

### 1. Factory Pattern

`VehicleFactory` is responsible for creating the appropriate vehicle object based on the requested vehicle type.

```text
VehicleFactory
      |
      +---- Car
      +---- Bike
      +---- Bus
```

This keeps vehicle creation separate from the rest of the parking logic.

---

### 2. Strategy Pattern — Entry Strategy

The `EntryStrategy` interface allows different algorithms to determine which parking slot should be assigned to a vehicle.

```text
             EntryStrategy
                  |
          +-------+-------+
          |               |
   EntryStrategyV1   EntryStrategyV2
```

A new parking allocation algorithm can be introduced without modifying the vehicle or parking-lot classes.

---

### 3. Strategy Pattern — Fare Strategy

`FareStrategy` is used to separate fare calculation from the vehicle and parking management logic.

```text
             FareStrategy
                  |
          +-------+-------+
          |               |
   FareStrategyV1   FareStrategyV2
```

This makes it possible to change the pricing policy independently.

---

## Project Structure

```text
src/
└── parkinglot/
    ├── Main.java
    │
    ├── controller/
    │
    ├── data/
    │
    ├── entity/
    │   ├── Vehicle
    │   ├── Car
    │   ├── Bike
    │   ├── Bus
    │   ├── Slot
    │   └── Level
    │
    ├── factory/
    │   └── VehicleFactory
    │
    ├── strategy/
    │   ├── EntryStrategy
    │   ├── EntryStrategyV1
    │   ├── FareStrategy
    │   └── FareStrategyV1
    │
    └── ui/
```

> The exact package structure may change as the project evolves.

---

## High-Level Architecture

```text
                         +----------------+
                         |      Main      |
                         +-------+--------+
                                 |
                                 v
                         +----------------+
                         |      UI        |
                         +-------+--------+
                                 |
                                 v
                         +----------------+
                         |  SlotManager   |
                         +---+--------+---+
                             |        |
                +------------+        +------------+
                |                              |
                v                              v
       +------------------+            +----------------+
       |  VehicleFactory  |            |    AllData     |
       +--------+---------+            +--------+-------+
                |                               |
                v                               v
        +-------------+                  +-------------+
        |   Vehicle   |                  |    Level    |
        +------+------+                  +------+------+
               |                                |
        +------+------+                         v
        |      |      |                       Slot
       Car    Bike   Bus
```

---

## Main Components

### `Vehicle`

Represents a vehicle entering the parking lot.

The project supports:

* `Car`
* `Bike`
* `Bus`

Common vehicle behavior is handled through the vehicle abstraction, while vehicle-specific behavior is implemented by the concrete vehicle classes.

---

### `Slot`

Represents an individual parking slot.

A slot maintains whether it is currently occupied and which vehicle is parked there.

---

### `Level`

Represents one parking level containing multiple parking slots.

A level can be configured with different numbers of slots for different vehicle types.

---

### `SlotManager`

Acts as the main coordinator for parking and vehicle exit operations.

It handles operations such as:

* Parking a vehicle
* Finding an appropriate slot
* Exiting a vehicle
* Calculating the fare

---

### `AllData`

Maintains the application's parking-related data, including vehicles and slots.

---

### `VehicleFactory`

Creates the appropriate vehicle implementation based on `VehicleType`.

Example:

```java
Vehicle vehicle = VehicleFactory.createVehicle(
    VehicleType.Car,
    "WB12AB1234",
    entryStrategy,
    fareStrategy
);
```

---

### `EntryStrategy`

Determines which available slot should be assigned to a vehicle.

Because this behavior is represented by an interface, different slot-allocation algorithms can be implemented independently.

---

### `FareStrategy`

Determines the parking fee for a vehicle.

The current implementation calculates the fare based on the vehicle type and parking duration.

---

## Example Flow

### Vehicle Entry

```text
User
 |
 | Vehicle details
 v
SlotManager
 |
 v
VehicleFactory
 |
 v
Vehicle
 |
 v
EntryStrategy
 |
 v
Available Slot
 |
 v
Vehicle parked
```

### Vehicle Exit

```text
User
 |
 | Number plate
 v
SlotManager
 |
 v
Find Vehicle
 |
 v
Find assigned Slot
 |
 v
Release Slot
 |
 v
FareStrategy
 |
 v
Fare
```

---

## Running the Project

### Requirements

* Java 21 or later
* Git

### Clone the repository

```bash
git clone <repository-url>
cd Parking-Lot
```

### Compile

```bash
javac -d out $(find src -name "*.java")
```

### Run

```bash
java -cp out parkinglot.Main
```

If using an IDE such as IntelliJ IDEA or VS Code, the project can also be run directly from `Main.java`.

---

## Example

A typical parking flow looks like:

```text
=== Parking Lot ===

1. Add Level
2. Park Vehicle
3. Exit Vehicle
4. Exit

Enter choice: 2

Vehicle Type: Car
Number Plate: WB12AB1234

Vehicle parked successfully.
Slot: Car_0_0
```

On exit:

```text
Enter number plate: WB12AB1234

Vehicle exited successfully.
Fare: ₹2.0
```

---

## Design Goals

The main goal of this project is to practice **Low Level Design (LLD)** concepts rather than build a production-ready parking management application.

The design focuses on:

* Encapsulation
* Abstraction
* Polymorphism
* Composition
* Separation of responsibilities
* Dependency on interfaces
* Extensibility
* Design patterns

---

## Possible Future Improvements

The project can be extended with:

* Multiple entry and exit gates
* Different fare calculation policies
* Different slot allocation algorithms
* Parking reservations
* Displaying available slots
* Payment handling
* Persistent storage
* Unit and integration tests
* Concurrency support
* REST API
* Database integration

These features are intentionally kept separate from the current core LLD implementation so that the domain model remains easy to understand.

---

## Learning Outcomes

This project was built as a practical exercise in Java LLD and demonstrates how design patterns can be used to keep a system modular and extensible.

The main patterns explored are:

* **Factory Pattern**
* **Strategy Pattern**

The project also provides practice with Java interfaces, inheritance, composition, dependency injection, collections, and object-oriented design.

---

## License

This project is available for educational and learning purposes.
