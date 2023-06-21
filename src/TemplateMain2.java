public class TemplateMain2 {
    public static void main(String[] args) {
        Tea tea = new Tea(true);
        Coffee coffee = new Coffee(false);

        System.out.println("New Tea");
        tea.prepareRecipe();

        System.out.println("Making Coffee");
        coffee.prepareRecipe();
    }
}

abstract class CaffeineBeverage{
    boolean answer;
    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments(this.answer))
            addCondiments();
    }
    public void boilWater(){
        System.out.println("Boiling water");
    }
    public void pourInCup(){
        System.out.println("Pouring into cup");
    }
    public abstract void brew();
    public abstract void addCondiments();
    public boolean customerWantsCondiments(boolean answer){
        return true;
    }
}

class Coffee extends CaffeineBeverage{
    public Coffee(boolean answer){
        this.answer = answer;
    }
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    public boolean customerWantsCondiments(boolean answer) {
        return this.answer;
    }
}

class Tea extends CaffeineBeverage{
    public Tea(boolean answer){
        this.answer = answer;
    }
    @Override
    public void brew() {
        System.out.println("Steeping the tea");
    }
    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }

    @Override
    public boolean customerWantsCondiments(boolean answer) {
        return this.answer;
    }
}