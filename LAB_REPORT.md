# LAB REPORT

## Lab Information
- Course: SE 3006 Software Architecture
- Lab: Lab 02
- Topic: Modular Monolith Built with Pure Java

## Implemented Work
- Completed `catalog` module internals by implementing `ProductRepository`, `CatalogServiceImpl`, and `CatalogFactory`.
- Completed `orders` module flow by implementing `OrderService`, `OrderController`, `OrdersFactory`, and `OrderRepository`.
- Wired both modules in `Main.java` using factories.
- Added test scenarios for successful ordering, insufficient stock, and missing product cases.

## Architectural Decisions
- `catalog` internals remain package-private so the `orders` module cannot directly reach `Product` or `ProductRepository`.
- Inter-module communication happens only through the public `CatalogService` interface.
- Factories are used to assemble internal dependencies and expose only the public entry points.

## Test Result
- Project compiles successfully with `javac`.
- Running `Main` confirms both successful and failing order scenarios behave as expected.
