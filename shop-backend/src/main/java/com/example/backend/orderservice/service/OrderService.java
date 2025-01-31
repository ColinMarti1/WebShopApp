import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final Map<String, Order> orders = new HashMap<>();
    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createOrder(Order order) {
        orders.put(order.getOrderId(), order);

        // Beispiel: Eine REST-Anfrage an den Versandservice senden
        String shippingServiceUrl = "http://shipping-service/api/shipping/initiate";
        restTemplate.postForObject(shippingServiceUrl, order, String.class);
    }

    public Order getOrderById(String orderId) {
        return orders.get(orderId);
    }
}
