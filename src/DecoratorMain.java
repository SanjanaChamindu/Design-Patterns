public class DecoratorMain {
    public static void main(String[] args) {
        Beverage order = new Caramel(new Espresso());
        System.out.println(order.cost());
    }
}

abstract class Beverage{
    public abstract double cost();
}
class Espresso extends Beverage{ // Can be added as much as beverages
    @Override
    public double cost() {
        return 4;
    }
}

abstract class AddonDecorator extends Beverage{
    public abstract double cost();
}
class Caramel extends AddonDecorator{ // Can be added as much as decorators
    Beverage beverage;
    public Caramel(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return 1 + this.beverage.cost();
    }
}
