package practice3;

import java.math.BigDecimal;
import java.util.List;

public class PriceCaculator {

    public BigDecimal getPriceTotal(List<OrderLineItem> orderLineItemList) {
        BigDecimal subTotal = new BigDecimal(0);

        // Total up line items
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }

        return subTotal;
    }

    public BigDecimal getDiscountedTotal(List<BigDecimal> discounts) {
        BigDecimal discountTotal = new BigDecimal(0);

        // get discount total
        for (BigDecimal discount : discounts) {
             discountTotal = discountTotal.add(discount);
        }

        return discountTotal;
    }

    public BigDecimal getTaxTotal(BigDecimal subTotal, BigDecimal tax) {
        // calculate tax
        BigDecimal taxTotal = subTotal.multiply(tax);

        return taxTotal;
    }

    public BigDecimal calculate(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts, BigDecimal tax) {

        BigDecimal subTotal = getPriceTotal(orderLineItemList).subtract(getDiscountedTotal(discounts));

        // calculate GrandTotal
        BigDecimal grandTotal = subTotal.add(getTaxTotal(subTotal, tax));

        return grandTotal;
    }
}
