public class Adresse {
    private String strasse;
    private String hausnummer;
    private String ort;

    public Adresse(String strasse, String hausnummer, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ort = ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getOrt() {
        return ort;
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Adresse)){
            return false;
        }
        if (obj == this ){
            return true;
        }
        Adresse addr = (Adresse) obj; //casting from Object into Adresse
        if (!(getStrasse().equals(addr.getStrasse()))){
            return false;
        }
        if (!(getHausnummer().equals(addr.getHausnummer()))){
            return false;
        }if (!(getOrt().equals(addr.getOrt()))){
            return false;
        }
        return true;
    }
    
}
