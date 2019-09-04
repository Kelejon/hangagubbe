package se.lexicon.kevin;

import java.io.IOException;
import java.util.Scanner;



public class hangagubbe{



    @SuppressWarnings("resource")
	public static void main( String[] args ) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Valkommen till Hanga gubbe!");
        System.out.println("Du har atta chanser pa dig att gissa ratt, ratt chansning raknas ej som forsok.");
        System.out.println("Om du gissar samma sak tva ganger raknas det bara som en gissning.");
        System.out.println("Varje gang du gissar ratt uppenbarar sig den/de bokstaverna i ordet for dig.");
        System.out.println("Lycka till!");

        boolean spela = true;
        while(spela) {

            spelet spel = new spelet();

            do{

                System.out.println(spel.Gissa());
                System.out.println(spel.randomOrd);

                System.out.println("Vanligen gissa: ");
                char gissningen = (scanner.next().toLowerCase().charAt(0));

                while (spel.gissatredan(gissningen)) {
                    System.out.println("Samma gissning som forut. Vanligen forsok igen.");
            }
                if (spel.gissningarna(gissningen)) {
                    System.out.println("Grattis du hade ratt!");
                } else {
                    System.out.println("Otur! Forsok igen");
                }

            while(!spel.slut());
                System.out.println("Vill du spela igen? Y/N");
                Character svar = (scanner.next().toUpperCase().charAt(0));
                spela = (svar =='Y');
            } while(!spel.slut());


    }
    }
}

