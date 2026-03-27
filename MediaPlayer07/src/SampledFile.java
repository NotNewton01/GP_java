
public abstract class SampledFile extends AudioFile {

    public SampledFile() {
        super(); //uses constructor of super
    }
    public SampledFile(String path){
        super(path);
    }

    /*public void play(){}

    public void togglePause(){}

    public void stop(){}

    public void formatDuration(){}

    public void formatPosition(){}
    */ //isn't exactly this given by the abstract class? 
    //In the umc diagramm, this was shown to be specifically in this class to?
    public static String timeFormatter(long timeinMicroSeconds){
        return "";
    }

    public long getDuration(){
        return 0;
    }
    public static void main(String[] args) {
        /*SampledFile sample = new SampledFile("String");
        sample.play();*/
    }
}