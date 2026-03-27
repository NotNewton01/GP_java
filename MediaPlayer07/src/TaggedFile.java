
public class TaggedFile extends SampledFile{
    private String album;

    public TaggedFile(){
        super();
    }
    public TaggedFile(String path){
        super(path);
    }

    public String getAlbum(){
        return album;
    }

    public void readAndStoreTags(){

    }

    @Override
    public String toString(){
        return "";
    }
}