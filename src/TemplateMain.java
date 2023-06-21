public class TemplateMain {
    public static void main(String[] args) {
        User user = new User();
        user.save();

        Record game = new Game();
        game.save();
    }
}

abstract class Record{
    public void save(){
        this.validate();
        this.beforeSave();
        // Save to database
        System.out.println("Saved");
    }
    public abstract void validate();
    public abstract void beforeSave();
}

class User extends Record{
    @Override
    public void validate() {
        System.out.println("User Validating...");
    }

    @Override
    public void beforeSave() {
        System.out.println("User Not saved yet");
    }
}

class Game extends Record{
    @Override
    public void validate() {
        System.out.println("Game status analyzing...");
    }

    @Override
    public void beforeSave() {
        System.out.println("Not saved yet. Please don't close the window");
    }
}