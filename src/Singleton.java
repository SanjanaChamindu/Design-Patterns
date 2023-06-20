// Used when a class must have single instance available
// Disables all means of creating objects of a class except for the special static creation method
// Return the existing instance if it has already been created
// The code needs to be adapted to handle multiple threads
public class Singleton {
    private static volatile Singleton instance;
    // The volatile keyword prevent using partially created instance when multi threading occasion happen
    private String data;

    private Singleton(String data){
        this.data = data;
    }
    // Because the constructor is private this cannot be called directly

    public static Singleton getInstance(String data){
        // Calls the constructor. If already an instance has created return the existing value
        // If there is no instance create a new instance and return its value

        Singleton result = instance;
        // For memory efficiency. Now only once memory is reached by the program

        if (result == null){
            // Use synchronized key word inside the if to prevent the waiting of multiple threads
            synchronized (Singleton.class){
                // Now constructor can be called by only one thread if it is not created already
                instance = new Singleton(data);
            }
        }
        return result;
    }
}
