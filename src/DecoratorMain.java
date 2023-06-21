public class DecoratorMain {
    public static void main(String[] args) {
        Beverage order = new Caramel(new Espresso());
        System.out.println(order.cost());

        Beverage order2 = new Caramel(new Milk( new IceCoffee()));
        System.out.println(order2.cost());
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

class IceCoffee extends Beverage{
    @Override
    public double cost() {
        return 3;
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

class Milk extends AddonDecorator{
    Beverage beverage;
    public Milk(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double cost() {
        return 2+ this.beverage.cost();
    }
}
