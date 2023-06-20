public class BridgeMain {
    public static void main(String[] args) {
        Artist artist1 = new Artist("Ed Sheeran", "British", "Image1", "http//:");
        ArtistResource artistResource1 = new ArtistResource(artist1);
        View longFormView = new LongForm(artistResource1);
        View imageFormView = new ImageForm(artistResource1);

        longFormView.show();
        imageFormView.show();
    }
}
abstract class View{
    IResource resource;
    public View(IResource iResource){
        this.resource = iResource;
    }
    public abstract void show();
}
class LongForm extends View{
    public LongForm(IResource iResource){
        super(iResource);
    }
    @Override
    public void show() {
        System.out.println("Long Form View");
        System.out.println(this.resource.snippet());
        System.out.println(this.resource.title());
        System.out.println(this.resource.image());
        System.out.println(this.resource.url());
    }
}

class ImageForm extends View{
    public ImageForm(IResource iResource){
        super(iResource);
    }
    @Override
    public void show() {
        System.out.println("Image Form View");
        System.out.println(this.resource.image());
        System.out.println(this.resource.title());
    }
}

interface IResource{
    String snippet();
    String title();
    String image();
    String url();
}
class ArtistResource implements IResource{
    Artist artist;
    public ArtistResource(Artist artist){
        this.artist = artist;
    }
    @Override
    public String snippet() {
        return this.artist.getBio();
    }

    @Override
    public String title() {
        return this.artist.getName();
    }

    @Override
    public String image() {
        return this.artist.getImage();
    }

    @Override
    public String url() {
        return this.artist.getUrl();
    }
}

class Artist{
    private String name;
    private String bio;
    private String image;
    private String url;

    public Artist(String name, String bio, String image, String url) {
        this.name = name;
        this.bio = bio;
        this.image = image;
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}

