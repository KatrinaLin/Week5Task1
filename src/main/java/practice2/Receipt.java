package practice2;

import java.math.BigDecimal;
import java.util.List;

public class Receipt {

    public Receipt() {
        tax = new BigDecimal(0.1);
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private BigDecimal tax;

    public double CalculateGrandTotal(List<Product> products, List<OrderItem> items) {

        BigDecimal grandTotal = calculateTaxTotal(calculateSubtotal(products, items));

        return grandTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public BigDecimal calculateTaxTotal(BigDecimal subTotal) {
        return subTotal.add(subTotal.multiply(tax));
    }

    private BigDecimal calculateSubtotal(List<Product> products, List<OrderItem> items) {
        BigDecimal subTotal = new BigDecimal(0);

        for (OrderItem item : items) {
            item.setProduct(products);
            BigDecimal itemTotal = item.getItemTotal();
            subTotal = subTotal.add(itemTotal);
        }

        return subTotal;
    }
}
