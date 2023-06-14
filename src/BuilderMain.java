public class BuilderMain {
    public static void main(String[] args) {
        Phone p = new PhoneBuilder().setProcessor("Intel").setOs("Android").setBattery(3000).getPhone();
        System.out.println(p);
    }
}

class Phone{
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public Phone(String os, int ram, String processor, double screenSize, int battery) {
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
    }
    public String toString(){
        return "Phone [Os: " + os + ", Ram: " + ram + ", Processor: " + processor +
                ", Screen size: " + screenSize + ", Battery: " + battery + "]";
    }
}

class PhoneBuilder{
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }
    public Phone getPhone(){
        return new Phone(os, ram, processor, screenSize, battery);
    }
}
