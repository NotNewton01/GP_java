import java.io.File;

public abstract class AudioFile{
    private String pathname;
    private String filename;
    private String author;
    private String title;
    
    
    public AudioFile(){
    }
    @SuppressWarnings("OverridableMethodCallInConstructor") //else Visual studio code just likes to protest
    public AudioFile(String path) {
        this.parsePathname(path);
    }
    
    public void parsePathname(String path){
        //remove starting spaces
        path=removeStrTra(path, ' ');
        if (path.equals("")){
            this.filename="";
            this.pathname="";
            this.parseFilename(this.filename); //isn't explicity said so, but is better as then you just have to run one command
            return;
        } 
        
        if (isWindows()){ 
            path=path.replace("/","\\"); //replace every / with \
            while (path.contains("\\\\")){
                path=path.replace("\\\\","\\"); //replaces duplicates
            }
            this.pathname=path;

            int startOfFile= path.lastIndexOf('\\'); //if no \ is found, lastblabla return a -1, which means that the next substring works as expected
            this.filename=path.substring(startOfFile+1);

        } else { //is linux
            path=path.replace("\\","/"); //replaces \ with /
            while (path.contains("//")){
                path=path.replace("//","/"); //replaces all duplicates
            }
            if (path.toLowerCase().charAt(0)>='a' && path.toLowerCase().charAt(0)<='z'){
                if (path.charAt(1)==':'){ //it is in different disk for windi
                    char disk = path.charAt(0);
                    path=path.substring(2);
                    path= "/" + disk + path; //change complete
                }
            }
        
            //checks if it is even readable
            File testfile = new File(this.pathname);
            if (!testfile.canRead()){
                throw new RuntimeException("File could not be read");
            }

            this.pathname=path;

            int startOfFile= path.lastIndexOf('/'); //if no \ is found, lastblabla return a -1, which means that the next substring works as expected
            this.filename=removeStrTra(path.substring(startOfFile+1),' ');  //removes all spaces a last time

        }


        pathname=path;

        this.parseFilename(this.filename); //isn't explicity said so, but is better as then you just have to run one command
    }

    public void parseFilename(String file){
        if (file.equals("")){
            this.author="";
            this.title="";
            return;
        }
        file=file.replace(" ", " "); //This is so that the INVISIBLE character U+00a0 is changed to a space
        //U+00a0 is invisible, why the    was this put into our stuff?!
        
        int dividor = file.indexOf(" - ");
        dividor ++;
        if (dividor <= 1){
            this.author="";
        } else {
            this.author=file.substring(0,dividor-1);
            this.author=removeStrTra(this.author, ' ');
        }
        
        
        file=file.substring(dividor); //still has - at the beginning
        int startExtension = file.lastIndexOf('.');
        if (startExtension==0){
            this.title="";
            return; //everything is extension
        }
        
        if (startExtension!=-1){
            file=file.substring(0, startExtension);
        } //now it does not have any extension in it
        //file=removeStrTra(file, ' ');
        if (file.equals("-")){
            this.title=file; //this is for the special case where the argument is -.Extension. And NOT just an empty title
        } else {
            if (!(file.equals("")) && file.charAt(0)=='-'){
                file=file.substring(1);
            }
            this.title=removeStrTra(file, ' ');
        }


    }

    private String removeStrTra(String haystack, char needle){ //removes STaRting and TRAiling needles from haystack
        //remove starting spaces
        if (haystack.equals("")){
            return ""; //else haystack.charAt(0) outputs an error
        }
        while (!(haystack.equals("")) && haystack.charAt(0)==needle){
            haystack=haystack.substring(1);
        }
        //remove trailing spaces
        while (!(haystack.equals("")) && haystack.charAt(haystack.length()-1)==needle){                
            haystack=haystack.substring(0, haystack.length()-1);
        }
        return haystack;
    }
    public String getPathname(){
        return this.pathname;
    }
    public String getFilename(){
        return this.filename;
    }
    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    @Override
    public String toString(){
        if (getAuthor().equals("")){
            return getTitle();
        } else {
            return getAuthor() + " - " + getTitle();
        }
    }

    private boolean isWindows(){
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public abstract void play();
    public abstract void togglePause();
    public abstract void stop();
    public abstract void formatDuration();
    public abstract void formatPosition();


    public static void main (String[] args){
		/*AudioFile audio = new AudioFile("/part1/mymusic/ -");
        //audio.parseFilename(" ");
        System.out.println("Pathname: \"" +audio.getPathname() + "\"");
        System.out.println("Filename: \"" +audio.getFilename() + "\"");
        System.out.println("Author:   \"" +audio.getAuthor()   + "\"");
        System.out.println("Title:    \"" +audio.getTitle()    + "\"");
        System.out.println("toString: \"" +audio.toString()    + "\"");
         //So that Apa doesn't flag it as wrong */
    }
}