package practice2;

import java.math.BigDecimal;
import java.util.List;

public class OrderItem {
    private Integer count;
    private long code;
    private Product product;

    public OrderItem(long code, int count) {
        this.code = code;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public long getCode() {
        return code;
    }

    public void setProduct(List<Product> products) {
        for (Product p : products) {
            if (p.getCode() == code) {
                this.product = p;
                break;
            }
        }
    }

    public BigDecimal getItemTotal() {
        if (product == null) {
            return new BigDecimal(0);
        }
        return product.getDiscountedPrice().multiply(new BigDecimal(count));
    }
}
