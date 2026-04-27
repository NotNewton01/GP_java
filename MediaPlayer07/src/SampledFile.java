
public abstract class SampledFile extends AudioFile {

    public SampledFile() {
        super(); //uses constructor of super
    }
    public SampledFile(String path){
        super(path);
    }

    @Override
    public void play(){}

    @Override
    public void togglePause(){}

    @Override
    public void stop(){}

    @Override
    public String formatDuration(){
        return "";
    }

    @Override
    public String formatPosition(){
        return "";
    }

    public static String timeFormatter(long timeInMicroSeconds){
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