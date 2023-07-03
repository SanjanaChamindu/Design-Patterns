import java.awt.*;
import java.util.ArrayList;

public class IteratorMain {
    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        pancakeHouseMenu.addItem("Pancake Egg", "Pancake with scrambled Eggs, and toast",
                 false, 2.99);
        pancakeHouseMenu.addItem("Pancake Veg", "Pancake with vegetables",
                true, 1.49);
        pancakeHouseMenu.addItem("Pancake Honey", "Honey pancake",
                true, 0.99);
        pancakeHouseMenu.addItem("Pancake Bacon", "Pancake with crunchy bacon",
                false, 2.49);

        DinerMenu dinerMenu = new DinerMenu();
        dinerMenu.addItem("BBQ", "Chicken BBQ",
                false, 3.99);
        dinerMenu.addItem("Pizza", "Chicken Pizza",
                false, 3.49);
        dinerMenu.addItem("Prawns", "Crispy Prawns",
                false, 4.49);
        dinerMenu.addItem("Vegetable Salad", "Salad",
                true, 1.99);

        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}

class MenuItem{
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price){
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public double getPrice() {
        return price;
    }
}

class PancakeHouseMenu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(this.menuItems);
    }
}

class DinerMenu{
    static final int MAX_ITEMS = 4;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        if (numberOfItems >= MAX_ITEMS)
            System.out.println("Sorry, menu is full! cannot add item to menu");
        else {
            MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
            menuItems[numberOfItems] = menuItem;
            numberOfItems += 1;
        }
    }
    public Iterator createIterator(){
        return new DinerMenuIterator(this.menuItems);
    }
}

interface Iterator{
    boolean hasNext();
    MenuItem next();
}

class DinerMenuIterator implements Iterator{
    MenuItem[] items;
    int position;

    public DinerMenuIterator(MenuItem[] items){
        this.items = items;
        this.position = 0;
    }
    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position+=1;
        return menuItem;
    }
}

class PancakeHouseMenuIterator implements Iterator{
    ArrayList<MenuItem> menuItems;
    int position;
    public PancakeHouseMenuIterator(ArrayList<MenuItem> menuItems){
        this.menuItems = menuItems;
        this.position = 0;
    }
    @Override
    public boolean hasNext() {
        return position < menuItems.size() && menuItems.get(position) != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(position);
        position+=1;
        return menuItem;
    }
}

class Waitress{
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }
    public void printMenu(){
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator = dinerMenu.createIterator();

        System.out.println("Breakfast...");
        printMenu(pancakeIterator);

        System.out.println("Lunch...");
        printMenu(dinerIterator);
    }
    public void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getDescription());
            System.out.println(menuItem.getPrice());
        }
    }
}
