public class AbstractFactoryMain {
    public static void main(String[] args) {
        String osType = "Windows";
        AbstractFactory factory = new AbstractFactory();
        IFactory iFactory = factory.CreateFactory(osType);
        IButton button = iFactory.createButton();
        ITextBox textBox = iFactory.createTextBox();
        button.press();
        textBox.showText();
    }
}

interface IButton{
    void press();
}

class MacButton implements IButton{
    @Override
    public void press() {
        System.out.println("Mac Button pressed");
    }
}

class WindowsButton implements IButton{
    @Override
    public void press() {
        System.out.println("Windows Button pressed");
    }
}

interface ITextBox{
    void showText();
}

class MacTextBox implements ITextBox{
    @Override
    public void showText() {
        System.out.println("Mac Text Box");
    }
}

class WindowsTextBox implements ITextBox{
    @Override
    public void showText() {
        System.out.println("Windows Text Box");
    }
}

abstract class IFactory{
    public abstract IButton createButton();
    public abstract ITextBox createTextBox();
}

class MacFactory extends IFactory{
    @Override
    public IButton createButton() {
        return new MacButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new MacTextBox();
    }
}

class WindowsFactory extends IFactory{
    @Override
    public IButton createButton() {
        return new WindowsButton();
    }

    @Override
    public ITextBox createTextBox() {
        return new WindowsTextBox();
    }
}

class AbstractFactory{
    public IFactory CreateFactory(String OsType){
        if (OsType.equals("Windows")){
            return new WindowsFactory();
        } else if (OsType.equals("Mac")){
            return new MacFactory();
        } else {
            return null;
        }
    }
}