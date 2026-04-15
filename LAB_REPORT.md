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

## Discussion: Layered Architecture vs. Modular Monolith
In the layered architecture from Lab 01, the system is organized by technical responsibility such as presentation, business, and persistence. This structure is simple to understand at the beginning, because each class has a clear technical role. However, business capabilities are spread across multiple layers, which can make the codebase harder to evolve when the project grows. A change related to one business feature often requires touching several packages across the system.

In the modular monolith design from Lab 02, the system is organized by business domains such as `catalog` and `orders`. Each module owns its internal classes, data, and logic, while exposing only a small public API. This improves information hiding and reduces direct coupling between domains. The application is still a single deployable unit, but internally it behaves in a more structured and maintainable way.

## Example: Adding a Shipping Module
If a new `shipping` feature is added in a layered architecture, the implementation would usually be split into multiple technical layers such as `ShippingController`, `ShippingService`, and `ShippingRepository`. This is workable, but the feature would be distributed across several folders. If shipping needs data from orders or catalog, developers may be tempted to access repositories or shared entities directly, which increases coupling and weakens architectural boundaries.

In a modular monolith, `shipping` would be added as a new business module with its own internal model, repository, service implementation, and factory. Only a public `ShippingService` interface would be exposed. The `orders` module could then call the shipping API after an order is confirmed, for example to create a shipment request, without knowing any shipping internals. This keeps responsibilities local to the module and makes future changes more predictable.

## Advantages and Disadvantages
### Layered Architecture
- Advantage: Easy to learn and implement for small systems.
- Advantage: Technical responsibilities are explicit and familiar.
- Disadvantage: Business logic is scattered across layers instead of being grouped by domain.
- Disadvantage: As the project grows, cross-feature changes can affect many files and create tighter coupling.
- Disadvantage: Adding a feature like `shipping` may encourage direct access to shared repositories or models.

### Modular Monolith
- Advantage: Business capabilities are grouped into cohesive modules.
- Advantage: Clear module boundaries improve maintainability and information hiding.
- Advantage: New modules such as `shipping` can be introduced with their own API and internal implementation.
- Disadvantage: Initial design requires more discipline and planning than a simple layered structure.
- Disadvantage: If module boundaries are not respected, the monolith can still become tightly coupled internally.

## Test Result
- Project compiles successfully with `javac`.
- Running `Main` confirms both successful and failing order scenarios behave as expected.
