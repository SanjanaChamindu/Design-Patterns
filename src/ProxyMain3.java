import java.util.HashMap;
import java.util.Map;

public class ProxyMain3 {
    public static void main(String[] args) {
        VideoDownloader videoDownloader = new ProxyVideoDownloader();
        Video video1 = videoDownloader.getVideo("Hello");
        videoDownloader.getVideo("World");
        videoDownloader.getVideo("Hello");
        videoDownloader.getVideo("Hello");
        video1.play();
        video1.pause();
    }
}

interface VideoDownloader{
    Video getVideo(String videoName);
}

class RealVideoDownloader implements VideoDownloader{
    @Override
    public Video getVideo(String videoName) {
        System.out.println("Connecting to https://www.youtube.com/");
        System.out.println("Downloading video");
        System.out.println("Retrieving Video Metadata");
        return new Video(videoName);
    }
}

class ProxyVideoDownloader implements VideoDownloader{
    private final Map<String, Video> videoMap = new HashMap<>();
    private final VideoDownloader downloader = new RealVideoDownloader();
    @Override
    public Video getVideo(String videoName) {
        if (!videoMap.containsKey(videoName)){
            videoMap.put(videoName, downloader.getVideo(videoName));
        }
        return videoMap.get(videoName);
    }
}

class Video{
    String videoName;
    public Video(String videoName){
        this.videoName = videoName;
    }
    public void play(){
        System.out.println("Playing :" + videoName);
    }
    public void pause(){
        System.out.println("Paused");
    }
}