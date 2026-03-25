
public class Vigenere{
    private int decoded[];
    private int encoded[];
    final private int code[];

    public Vigenere(String code){
        this.code=toIntArr(code);
    }
    
    public String encode(String decodedString){
        this.decoded=toIntArr(decodedString);
        this.encoded = new int[decodedString.length()];
        for (int i = 0; i < this.decoded.length; i++) {
            this.encoded[i]=this.decoded[i]+this.code[i%this.code.length]-'a';
            if (encoded[i]>'z'){
                encoded[i]-=('z'-'a');
                encoded[i]--;
            }
        }
        decodedString=IntArrString(encoded);
        System.out.println(decodedString);
        return decodedString;
    }
    
    public String decode(){
        return this.decode(IntArrString(encoded));
    }
    public String decode(String encodedString){
        this.encoded=toIntArr(encodedString);
        this.decoded = new int[encodedString.length()];
        for (int i = 0; i < this.encoded.length; i++) {
            this.decoded[i]=this.encoded[i]-this.code[i%this.code.length]+'a';
            if (decoded[i]<'a'){
                decoded[i]+='z'-'a';
                decoded[i]++;
            }
        }
        encodedString=IntArrString(decoded);
        System.out.println(encodedString);
        return encodedString;
    }

    static public void main (){
        //System.out.println("Please input your password");
        //Scanner scan = new Scanner(System.in);
        Vigenere vig = new Vigenere("Ingolstadt_Stadt");
        vig.encode("Dies ist ein Test, ob dies funktioniert");
        vig.decode();
    }
    
    
    
    
    public String IntArrString(int[] intArr){
        char charArr[]= new char[intArr.length];
        for (int i = 0; i < intArr.length; i++) {
            charArr[i]=(char) intArr[i];
        }
        String str = new String(charArr);
        return str;
    }  
    
    private int[] toIntArr(String input){
        input=input.replaceAll("[^A-Za-z]", "");
        char charArr[]=input.toCharArray();
        int intArr[]= new int[charArr.length];
        for ( int i = 0; i<charArr.length ; i++) {
            if ((charArr[i]>='a')&&(charArr[i]<='z')){
                intArr[i]=charArr[i];
            } else if ((charArr[i]>='A')&&(charArr[i]<='Z')){
                intArr[i]=charArr[i]-('A'-'a');
            } else{
                System.out.println("Error, a weird char was found: "+charArr[i]);
            }
        }

        return intArr;
    }
}