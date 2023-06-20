import java.util.Stack;

public class CommandMain {
    public static void main(String[] args) {
        Light light = new Light();
        Invoker invoker1 = new Invoker(new LightOnCommand(light), new IncreaseBrightness(light));
        invoker1.onButton();
        invoker1.increaseBrightnessButton();
        invoker1.undo();
        invoker1.undo();
    }
}

interface ICommand{
    void execute();
    void unexecute();
}

class LightOnCommand implements ICommand{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        this.light.on();
    }

    @Override
    public void unexecute() {
        this.light.off();
    }
}
class IncreaseBrightness implements ICommand{
    Light light;

    public IncreaseBrightness(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.increase();
    }

    @Override
    public void unexecute() {
        this.light.decrease();
    }
}

class Light{ // Receiver
    boolean onStatus;
    int brightness=0;
    public void on(){
        this.onStatus = true;
        this.brightness = 7;
        System.out.println("Light bulb on");
    }
    public void off(){
        this.onStatus = false;
        this.brightness = 0;
        System.out.println("Light bulb off");
    }
    public void increase(){
        this.brightness += 1;
        System.out.println("Brightness level increased to " + this.brightness);
    }
    public void decrease(){
        if (this.brightness > 0){
            this.brightness -= 1;
            System.out.println("Brightness level decreased to " + this.brightness);
        }

    }
}

class Invoker{
    ICommand onCommand;
    ICommand increaseBrightness;
    Stack<ICommand> commands = new Stack<>();

    public Invoker(ICommand onCommand, ICommand increaseBrightness){
        this.onCommand = onCommand;
        this.increaseBrightness = increaseBrightness;
    }
    public void onButton(){
        this.onCommand.execute();
        commands.push(this.onCommand);
    }
    public void increaseBrightnessButton(){
        this.increaseBrightness.execute();
        commands.push(this.increaseBrightness);
    }
    public void undo(){
        ICommand lastCommand = commands.pop();
        lastCommand.unexecute();
    }
}