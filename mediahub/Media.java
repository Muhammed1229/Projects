package mediahub;

public class Media {
    protected String title = "Leo Tolstoy";
    int releaseyr;

    public Media () {
        IO.println ("Searching for Book...");
    }
    public Media (String title) {
        this.title = title;
    }
    public void play () {
        IO.println ("Starting media...");
    }
    public final void copyrightnotice () {
        IO.println ("2026 MediaHub Corp. All rights reserved.");
    }
    public static void hubrules () {
        IO.println("Return item within 30 days, or you will be charged a fine!");
    }
    public static void location () {
        IO.println ("Location: Archives");
    }
}
