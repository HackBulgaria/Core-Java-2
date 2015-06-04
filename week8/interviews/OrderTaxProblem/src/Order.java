import java.util.LinkedList;
import java.util.List;

public class Order
{
    public List<OrderItem> orderItems = new LinkedList<OrderItem>();
    public double CalculateTotal(Customer customer)
    {
        double total = 0;
        for (OrderItem item : orderItems){
            total += item.Cost*item.Quantity;
        };

        double tax;
        if (customer.StateCode == "BUL")
            tax = total * .2;
        else if (customer.StateCode == "GER")
            tax = total * .3;
        else
            tax = .1;

        total = total + tax;
        return total;
    }


}