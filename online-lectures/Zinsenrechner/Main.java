public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Darlehen: ");
        double darlehen = scanner.nextDouble();
        System.out.print("Zinssatz: ");
        double zinssatz = scanner.nextDouble();
        zinssatz*=0.01;
        zinssatz/=12; //da monatlich ändernd
        System.out.print("Monatsrate: ");
        double monatsrate = scanner.nextDouble();
        scanner.close();

        double gesamtzins = 0.0;
        int monat = 1;
        double restschuld = darlehen;
        double jetztzins;
        double tilgung;
        // Tabellenüberschrift erzeugen
        System.out.printf("Monat      Rate    Zinsen   Tilgung     Restschuld\n");

        // Tabelle in Schleife erzeugen: je Durchlauf ein Tilgungsmonat
        while (true) {
            jetztzins=restschuld*zinssatz;
            
            gesamtzins+=jetztzins;
            tilgung=monatsrate-jetztzins; 
            if (restschuld<monatsrate){
                tilgung=restschuld;
                monatsrate=tilgung;
            }
            restschuld-=tilgung;
            System.out.printf("%5d%10.2f%10.2f%10.2f%15.2f\n",monat,monatsrate,jetztzins,tilgung,restschuld);
            if (restschuld==0){
                break;
            }
            monat++;
        }
        // Gesamtzins ausgeben
        System.out.printf("Gesamtzins: %.2f%n", gesamtzins);
    }
}