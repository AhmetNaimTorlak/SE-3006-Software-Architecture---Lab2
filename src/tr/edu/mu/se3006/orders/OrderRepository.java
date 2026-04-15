package tr.edu.mu.se3006.orders;
import java.util.*;

class OrderRepository {
    private Map<Long, Order> database = new HashMap<>();
    
    void save(Order order) {
        database.put(order.getId(), order);
    }
}
