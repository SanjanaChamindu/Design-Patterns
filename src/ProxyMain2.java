import java.util.ArrayList;
import java.util.List;

public class ProxyMain2 {
    public static void main(String[] args) {
        ProxyInternet proxyInternet = new ProxyInternet();
        proxyInternet.connectTo("http://youtube.com");
        proxyInternet.connectTo("BannedSites.com");
    }
}

interface Internet{
    void connectTo(String host);
}

class RealInternet implements Internet{
    @Override
    public void connectTo(String host) {
        System.out.println("Connected to " + host);
    }
}

class ProxyInternet implements Internet{
    private static final List<String> bannedSites;
    private final Internet internet = new RealInternet();

    static{
        bannedSites = new ArrayList<>();
        bannedSites.add("BannedSites.com");
    }
    @Override
    public void connectTo(String host) {
        if (bannedSites.contains(host))
            System.out.println("Access Denied");
        else
            internet.connectTo(host);
    }
}