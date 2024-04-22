import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<Item> items;
    private double total;

    public Transaction() {
        items = new ArrayList<>();
        total = 0.0;
    }

    public void addItem(Item item, int quantity) {
        items.add(item);
        total += item.getPrice() * quantity;
    }

    public double getTotal() {
        return total;
    }

    public List<Item> getItems() {
        return items;
    }
}
