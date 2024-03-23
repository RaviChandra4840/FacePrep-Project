package placementproject;
import java.util.*;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Map<Item, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public void addItem(Item item, int quantity) {
        if (cart.containsKey(item)) {
            int currentQuantity = cart.get(item);
            cart.put(item, currentQuantity + quantity);
        } else {
            cart.put(item, quantity);
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }

    public Map<Item, Integer> getCartItems() {
        return cart;
    }
}
class Manage{
	void add_to_menu(List<Item> li, String na, double pr){
		Item i = new Item(na,pr);
		li.add(i);
	}
}

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        List<Item> availableItems = new ArrayList<>();
        Item it = new Item("DragonFruit",150.0);
        Item it2 = new Item("Toys",100.0);
        Item it3 = new Item("DairyMilkSilk",80.0);
        Item it4 = new Item("MilkPackeet",30.0);
        Item it5 = new Item("Bread",40.0);
        availableItems.add(it);
        availableItems.add(it2);
        availableItems.add(it3);
        availableItems.add(it4);
        availableItems.add(it5);
        System.out.println("Welcome to the Supermarket Billing System!");
        while (true){
        	System.out.println("1.Shopper Dashboard");
            System.out.println("2.Customer Dashboard");
            System.out.println("0 to exit");
            int ch = scanner.nextInt();
            if (ch == 1){
            	Manage mn = new Manage();
            	System.out.println("Add To Menu:");
            	System.out.println("Enter Item name:");
            	scanner.nextLine();
            	String nm = scanner.nextLine();
            	System.out.println("Enter Price:");
            	int pr = scanner.nextInt();
            	mn.add_to_menu(availableItems, nm, pr);
            	
            }
            else if (ch == 2){
            	while (true) {
                    System.out.println("\nAvailable Items:");
                    for (int i = 0; i < availableItems.size(); i++) {
                        System.out.println((i + 1) + ". " + availableItems.get(i).getName() + " - Rs " + availableItems.get(i).getPrice());
                    }
                    System.out.println("0. Checkout");

                    System.out.print("Enter the item number to add to cart (or 0 to checkout): ");
                    int choice = scanner.nextInt();
                    if (choice == 0) {
                        break;
                    }
                    if (choice < 1 || choice > availableItems.size()) {
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                    }

                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();

                    Item selected = availableItems.get(choice - 1);
                    cart.addItem(selected, quantity);
                    System.out.println(quantity + " " + selected.getName() + "(s) added to cart.");
                    System.out.println("CART ITEMS:");
                    for (Map.Entry<Item, Integer> entry : cart.getCartItems().entrySet()) {
                    	Item item2 = entry.getKey();
                        int quantity2 = entry.getValue();
                    	System.out.println(item2.getName()+" "+quantity2);
                    }
            	}
                double total = cart.calculateTotal();
                if(total >= 500){
                	System.out.println("\nReceipt:");
                    System.out.println("----------------------------");
                    for (Map.Entry<Item, Integer> entry : cart.getCartItems().entrySet()) {
                        Item item = entry.getKey();
                        int quantity = entry.getValue();
                        System.out.println(item.getName() + "\t" + quantity + "\t Rs " + (item.getPrice() * quantity));
                    }
                    System.out.println("----------------------------");
                    System.out.println("Total\t\tRs " + total);
                    System.out.println("----------------------------");
                    double total2 = total - total*(0.20);
                    System.out.println("*DISCOUNT*");
                    System.out.println("Total\t\tRs " + total2);
                    System.out.println("----------------------------");
                }
                else{
                	System.out.println("\nReceipt:");
                    System.out.println("----------------------------");
                    for (Map.Entry<Item, Integer> entry : cart.getCartItems().entrySet()) {
                        Item item = entry.getKey();
                        int quantity = entry.getValue();
                        System.out.println(item.getName() + "\t" + quantity + "\t Rs " + (item.getPrice() * quantity));
                    }
                    System.out.println("----------------------------");
                    System.out.println("Total\t\tRs " + total);
                    System.out.println("----------------------------");
                } }
            else{
            	return;
            } } } }