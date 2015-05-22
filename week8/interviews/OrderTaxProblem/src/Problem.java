import java.util.LinkedList;

public class Problem {
    public static void main(String[] args) {
        Customer bgCustomer = new Customer();
        bgCustomer.StateCode="BUL";

        OrderItem item1 = new OrderItem();
        item1.Cost = 100;
        item1.Quantity = 10;

        Order order = new Order();
        order.orderItems = new LinkedList<OrderItem>();
        order.orderItems.add(item1);
        System.out.println(order.CalculateTotal(bgCustomer));
    }
}
