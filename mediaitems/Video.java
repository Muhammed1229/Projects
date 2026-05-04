package mediaitems;
import mediahub.Media;

public class Video extends Media {
    String title;
    int durationinmins;

    public Video (String title, int durationinmins) {
    super (title);
    this.title = title;
    this.durationinmins = durationinmins;
    }
    @Override
    public void play () {
        IO.println ("Adjusting video resolution...");
    }
    public void title () {
        IO.println (super.title);
    }
    public static void hubrules () {
        IO.println ("Please do not scratch the disc!");
    }
}
class Book extends Media {
    String booktitle;
    int pages;
    
    public Book (String booktitle,int pages) {
        this.booktitle = booktitle;
        this.pages = pages;
    }
    public void author () {
        IO.println ("Book Author: " + title);
    }
    public static void location () {
        IO.println ("Location: Aisle 8, Bookshelf 3");
    }
}

class Animeshows extends Video {
    boolean iscannon;
    public Animeshows (String title, int durationinmins, boolean iscannon){
       super (title , durationinmins);
       this.iscannon = iscannon;
    }
}
final class Thrillershows extends Video {
    int rating;
    public Thrillershows (String title, int durationinmins, int rating) {
        super (title, durationinmins);
        this.rating = rating;
    }
}

// class Horrorshows extends Thrillershows {}
// won't run since you can't inherit from a final class

// class Entertainment extends Video, Book {}
// won't run due to multiple inheritance restriction {}

