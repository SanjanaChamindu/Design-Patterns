import java.util.ArrayList;
import java.util.List;

public class CompositeMain {
    public static void main(String[] args) {
        Component hardDrive = new Leaf(4000, "Hard Dirve");
        Component mouse = new Leaf(1000, "Mouse");
        Component ram = new Leaf(5000, "RAM");
        Component cpu = new Leaf(6000, "CPU");

        Composite ph = new Composite("Peri");
        Composite cabinet = new Composite("Cabinet");
        Composite mb = new Composite("MB");
        Composite computer = new Composite("Computer");

        ph.addComponent(mouse);
        cabinet.addComponent(hardDrive);
        mb.addComponent(cpu);
        computer.addComponent(ram);
        computer.addComponent(cabinet);

        ram.showPrice();
        ph.showPrice();
        computer.showPrice();
    }
}
interface Component{
    void showPrice();
}
class Leaf implements Component{
    int price;
    String name;

    public Leaf(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void showPrice() {
        System.out.println(name + ": " + price);
    }
}

class Composite implements Component{
    String name;
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component component){
        components.add(component);
    }
    @Override
    public void showPrice() {
        System.out.println(name);
        for (Component c: components){
            c.showPrice();
        }
    }
}