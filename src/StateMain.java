public class StateMain {
    public static void main(String[] args) {
        GumballMachine2 gumballMachine = new GumballMachine2(5);
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.refill(10);
        System.out.println(gumballMachine);
    }
}
class GumballMachine2{
    State soldOutState;
    State noQuartersState;
    State hasQuartersState;
    State soldState;
    State state;
    int count;
    public GumballMachine2(int count){
        soldState = new SoldState(this);
        noQuartersState = new NoQuarterState(this);
        soldOutState = new SoldOutState(this);
        hasQuartersState = new HasQuarterState(this);

        this.count = count;

        if (count > 0)
            state = noQuartersState;
        else
            state = soldOutState;
    }
    public void insertQuarter(){
        state.insertQuarter();
    }
    public void ejectQuarter(){
        state.ejectQuarter();
    }
    public void turnCrank(){
        state.turnCrank();
    }
    public void dispenseBall(){
        state.dispense();
    }
    public int getCount(){
        return count;
    }
    public void setState(State state){
        this.state = state;
    }
    public State getSoldOutState(){
        return soldOutState;
    }
    public State getNoQuarterState(){
        return noQuartersState;
    }
    public State getSoldState(){
        return soldState;
    }
    public State getHasQuarterState(){
        return hasQuartersState;
    }

    public void refill(int count){
        this.count += count;
    }

    public String toString(){
        String result;
        if (state == soldOutState)
            result = "Sold out";
        else if (state == noQuartersState)
            result = "No quarter inserted";
        else if (state == hasQuartersState)
            result = "Quarter has been inserted";
        else
            result = "Gumball sold";
        return result + "\nGumballs left:" + count;
    }
    public void releaseBall(){
        System.out.println("A gumball is rolling out the slot...");
        if (count > 0)
            count -= 1;
    }
}

interface State{
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

class NoQuarterState implements State{
    GumballMachine2 gumballMachine;
    public NoQuarterState(GumballMachine2 gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}

class HasQuarterState implements State{
    GumballMachine2 gumballMachine;
    public HasQuarterState(GumballMachine2 gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You cannot insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
        gumballMachine.dispenseBall();
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class SoldState implements State{
    GumballMachine2 gumballMachine;
    public SoldState(GumballMachine2 gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("WAit, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();

        if (gumballMachine.getCount() == 0){
            System.out.println("Oops, out of gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else
            gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
}

class SoldOutState implements State{
    GumballMachine2 gumballMachine;
    public SoldOutState(GumballMachine2 gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}