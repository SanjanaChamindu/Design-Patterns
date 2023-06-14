public class FactoryMain {
    public static void main(String[] args) {
        OSFactory osf = new OSFactory();
        OS obj = osf.getInstance("Open");
        obj.spec();
    }
}

interface OS{
    void spec();
}

class Android implements OS{
    @Override
    public void spec() {
        System.out.println("Powerful OS");
    }
}

class IOS implements OS{
    @Override
    public void spec() {
        System.out.println("Secure OS");
    }
}

class Windows implements OS{
    @Override
    public void spec() {
        System.out.println("Not using in mobile");
    }
}

class OSFactory{
    public OS getInstance(String str){
        if (str.equals("Open")) return new Android();
        else if (str.equals("Closed")) return new IOS();
        else return new Windows();
    }
}
