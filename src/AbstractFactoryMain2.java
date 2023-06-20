public class AbstractFactoryMain2 {
    public static void main(String[] args) {
        String name = "Victoria";
        AbstractFactory2 abstractFactory = new AbstractFactory2();
        FurnitureFactory furnitureFactory = abstractFactory.createFactory(name);
        Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();
        CoffeeTable coffeeTable = furnitureFactory.createCoffeeTable();

        chair.makeChair();
        sofa.makeSofa();
        coffeeTable.makeCoffeeTable();
    }
}

interface Chair{
    void makeChair();
}
class ArtDecoChair implements Chair{
    @Override
    public void makeChair() {
        System.out.println("Chair: Art Deco");
    }
}
class VictorianChair implements Chair{
    @Override
    public void makeChair() {
        System.out.println("Chair: Victorian");
    }
}
class ModernChair implements Chair{
    @Override
    public void makeChair() {
        System.out.println("Chair: Modern");
    }
}

interface Sofa{
    void makeSofa();
}
class ArtDecoSofa implements Sofa{
    @Override
    public void makeSofa() {
        System.out.println("Sofa: Art Deco");
    }
}
class VictorianSofa implements Sofa{
    @Override
    public void makeSofa() {
        System.out.println("Sofa: Victorian");
    }
}
class ModernSofa implements Sofa{
    @Override
    public void makeSofa() {
        System.out.println("Sofa: Modern Sofa");
    }
}

interface CoffeeTable{
    void makeCoffeeTable();
}
class ArtDecoCoffeeTable implements CoffeeTable{
    @Override
    public void makeCoffeeTable() {
        System.out.println("Coffee Table: Art Deco");
    }
}
class VictorianCoffeeTable implements CoffeeTable{
    @Override
    public void makeCoffeeTable() {
        System.out.println("Coffee Table: Victorian");
    }
}
class ModernCoffeeTable implements CoffeeTable{
    @Override
    public void makeCoffeeTable() {
        System.out.println("Coffee Table: Modern");
    }
}

abstract class FurnitureFactory{
    public abstract Chair createChair();
    public abstract Sofa createSofa();
    public abstract CoffeeTable createCoffeeTable();
}
class ArtDecoFactory extends FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }
    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }
    @Override
    public CoffeeTable createCoffeeTable() {
        return new ArtDecoCoffeeTable();
    }
}

class VictoriaFactory extends FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

class ModernFactory extends FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
    @Override
    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

class AbstractFactory2{
    public FurnitureFactory createFactory(String name){
        if (name.equals("Art Deco"))
            return new ArtDecoFactory();
        else if (name.equals("Victoria"))
            return new VictoriaFactory();
        else
            return new ModernFactory();
    }
}