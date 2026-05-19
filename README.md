# 🅿️ Parking Lot System — Low-Level Design (LLD)

A clean, extensible **Parking Lot Management System** built in Java as a Low-Level Design practice project. Demonstrates real-world OOP principles, design patterns, and SOLID design applied to a classic system design problem.

---

## 📐 System Overview

This system simulates a multi-level parking lot that can park vehicles of different sizes, assign slots intelligently, generate tickets, and calculate parking charges — all wired together through well-defined abstractions.

---

## 🗂️ Project Structure

```
src/main/java/org/example/
├── factory/
│   ├── ParkingStrategyFactory.java     # Creates parking strategy instances
│   └── PriceStrategyFactory.java       # Creates pricing strategy instances
├── manager/
│   └── ParkingSystemManager.java       # Entry point for park/unpark operations
├── model/
│   ├── enums/                          # Enums for vehicle size, slot size, etc.
│   ├── Level.java                      # Represents a floor/level in the parking lot
│   ├── ParkingSlot.java                # Individual parking slot with size & availability
│   ├── ParkingTicket.java              # Ticket issued on parking a vehicle
│   └── Vehicle.java                    # Vehicle entity with size, id, number plate
├── service/
│   ├── ParkingService.java             # Core business logic for parking operations
│   └── TicketService.java              # Ticket generation and management
└── strategy/
    ├── parking/
    │   ├── ParkingStrategy.java        # Interface for slot assignment strategies
    │   └── FirstFitStrategy.java       # Assigns the first available matching slot
    └── pricing/
        ├── PricingStrategy.java        # Interface for pricing strategies
        └── HourlyPricingStrategy.java  # Charges based on hours parked
```

---

## ✨ Features

- **Multi-level parking** — supports multiple floors, each with independent slot management
- **Vehicle size matching** — SMALL, MEDIUM, and LARGE vehicle-to-slot assignment
- **Pluggable parking strategies** — swap slot assignment algorithms without touching core logic
- **Pluggable pricing strategies** — easily extend to flat-rate, hourly, or subscription models
- **Ticket system** — generates a ticket on entry; ticket holds vehicle and slot reference
- **Factory pattern** — strategies are created via factories, decoupling instantiation from usage

---

## 🧩 Design Patterns Used

| Pattern | Where |
|---|---|
| **Strategy** | `ParkingStrategy`, `PricingStrategy` — interchangeable algorithms |
| **Factory** | `ParkingStrategyFactory`, `PriceStrategyFactory` — object creation |
| **Facade** | `ParkingSystemManager` — single interface over complex subsystems |
| **Dependency Injection** | `ParkingSystemManager` takes `ParkingService` via constructor |

---

## 🚀 Getting Started

### Prerequisites

- Java 11+
- Maven

### Run

```bash
git clone https://github.com/YOUR_USERNAME/parking-lot-lld.git
cd parking-lot-lld
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Sample Output

```
CG 04 ABCD    ← vehicle number printed from the generated ticket
```

---

## 🧪 How It Works (Walkthrough)

```java
// 1. Create parking slots of different sizes
ParkingSlot slot1 = new ParkingSlot();
slot1.size = ParkingSlotSize.LARGE;

// 2. Organize slots into a level
Level level1 = new Level();
level1.parkingSlots = new ArrayList<>(List.of(slot1, slot2, slot3));

// 3. Attach level to parking service
parkingService.parkingLevels = new ArrayList<>(List.of(level1));

// 4. Park a vehicle via the manager
ParkingSystemManager manager = new ParkingSystemManager(parkingService);
Vehicle v = new Vehicle();
v.size = VehicleSize.LARGE;
v.number = "CG 04 ABCD";

ParkingTicket ticket = manager.parkVehicle(v);
System.out.println(ticket.vehicle.number); // CG 04 ABCD
```

---

## 🔌 Extending the System

**Add a new parking strategy:**
```java
public class BestFitStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot findSlot(List<Level> levels, Vehicle vehicle) {
        // your logic here
    }
}
```

**Add a new pricing model:**
```java
public class FlatRateStrategy implements PricingStrategy {
    @Override
    public double calculate(ParkingTicket ticket) {
        return 50.0; // flat rate
    }
}
```

Register the new strategy in the respective factory and it's ready to use — zero changes to core logic.

---

## 📚 Concepts Practiced

- Low-Level Design (LLD) & Object-Oriented Design
- SOLID principles (especially Open/Closed and Dependency Inversion)
- Strategy and Factory design patterns
- Clean package structure and separation of concerns
- Modeling real-world entities as classes

---

## 🛣️ Potential Enhancements

- [ ] Unpark vehicle and calculate fee
- [ ] Concurrent access handling (thread safety)
- [ ] Persistence layer (database integration)
- [ ] REST API layer (Spring Boot)
- [ ] Unit tests with JUnit 5
- [ ] Support for reserved/handicapped slots

---

## 👤 Author
Harsh kumar pandey
Linkedin: www.linkedin.com/in/harsh-kumar-pandey-0a64082b8

Built as part of a Low-Level Design (LLD) practice.  
Feel free to fork, extend, and raise PRs!

---

## 📄 License

MIT License
