package se.lexicon.kevin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class spelet {

    String randomOrd;
    StringBuilder Gissa;
    ArrayList<String> gissningar = new ArrayList<String>();

    int Tak = 8;
    int forsok = 0;

    ArrayList<String> ordbok = new ArrayList<>();
    @SuppressWarnings("unused")
	private static FileReader fil;
    private static BufferedReader buff;

    public spelet() throws IOException {
        Filen();
        gissa = Gissa();
        randomOrd = val();
    }
    public void Filen() throws IOException{
        try {
            File fil = new File("ordbok.txt");
            FileReader lasare = new FileReader(fil);
            buff = new BufferedReader(lasare);
            String avlasare = buff.readLine();
            while (avlasare != null){
                gissningar.add(avlasare);
                avlasare = buff.readLine();
            }
            buff.close();
            lasare.close();
        }catch(IOException e) {
            System.out.println("Kunde inte hitta filen");
        }

    }

    public String val(){
        Random valet = new Random();
        int ord = Math.abs(valet.nextInt()) % ordbok.size();
        return ordbok.get(ord);
    }

    public StringBuilder Gissa() {
        StringBuilder strack = new StringBuilder();
        for (int i=0; i<randomOrd.length() + randomOrd.length(); i++) {
            if (i % 2 == 0) {
                strack.append("-");
            } else {
                strack.append(" ");
            }
        }
        return strack;
    }

    public boolean slut(){
        if (vunnit()) {
            System.out.println("Grattis du vann!");
        } else if (forlorade()) {
            System.out.println("Otur! Battre lycka nasta gang.");
            System.out.println("Det ratta order var: " + randomOrd + ".");
            return true;
        }
        return false;
    }

    public boolean forlorade() {
        return forsok >= Tak;
    }

    public boolean vunnit(){
        String gissningen = getCondensedCurrentGuess();
        return gissningen.equals(randomOrd);
    }
    public String getCondensedCurrentGuess() {
        String gissningen = gissa.toString();
        return gissningen.replace(" ", "");
    }

    @SuppressWarnings("unlikely-arg-type")
	public boolean gissatredan(char gissningen) {
    return gissningar.contains(gissningen);
    }

    public boolean gissningarna(char gissningen) {
        boolean rattgissning = false;
        gissningar.add(String.valueOf(gissningen));
        for (int i=0; i< randomOrd.length(); i++) {
            if (randomOrd.charAt(i) == gissningen) {
                gissa.setCharAt(i * 2, gissningen);
                rattgissning = true;

            }
        }
        if (!rattgissning) {
            forsok++;
        }
        return rattgissning;
    }


}
