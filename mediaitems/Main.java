package mediaitems;
import mediahub.Media;

public class Main {
    public static void main (String [] args) {
        IO.println ("Starting Video..."); 
        Video vid1 = new Video ("Oceans 11", 100);
        vid1.play ();
        IO.println ("Title: " + vid1.title + ", Duration: " + vid1.durationinmins + " minutes.");
        Media.hubrules ();
        Video.hubrules ();
        

        Book book1 = new Book ("Peace and War", 500);
        IO.println ("Title: " + book1.booktitle + ", Pages: " + book1.pages);
        book1.author (); 
        Media media1 = new Book ("Peace and War", 500);
        media1.location(); //hides the static method in the child class
        book1.location(); //prints the static method in the child class
       

    
        IO.println ("Streaming Shows...");
        Animeshows anime1 = new Animeshows ("Naruto ", 20 , false);
        IO.println ("Title: " + anime1.title + ", Duration: " + anime1.durationinmins + " minutes, " + "Cannon Only: " + anime1.iscannon);
 
        Thrillershows thriller1 = new Thrillershows ("From", 50, 9);
        IO.println ("Title: " + thriller1.title + ", Duration: " + thriller1.durationinmins + " minutes, " + "Rating Out of 10: " + thriller1.rating);
        thriller1.copyrightnotice();
    }
}