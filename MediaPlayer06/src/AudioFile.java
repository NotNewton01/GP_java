

public class AudioFile{
    private String pathname;
    public String filename;

    public AudioFile() {
    }
    
    public void parsePathname(String path){
        if (isWindows()){
            path=path.replace("/","\\"); //replace every / with \
            path=path.replace("\\\\","\\"); //replaces duplicates
        } else {
            path=path.replace("\\","/"); //replaces \ with /
            path=path.replace("//","/"); //replaces duplicates
        }


        pathname=path;
    }

    public String getPathname(){
        return pathname;
    }
    public String getFilename(){
        return filename;
    }

    private boolean isWindows(){
        return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }


    public static void main (String[] args){
		AudioFile audio = new AudioFile();
        audio.parsePathname("path");
	}
}