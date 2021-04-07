// Time-stamp: <2021-04-07 12:44:57 stefan>
//

// import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
// import java.math.BigInteger;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.Scanner;

//import java.lang.Math;

public class Uppgift {
    static Scanner Tangentbordsläsare;
    static boolean iReverse = false;    // används för reverse-video delen

    //
    // 1
    //
    private static void Helloworld()
    {
	System.out.println();
	System.out.println( "Hello world");
	System.out.println();
    }
    //
    // 2
    //
    private static void InputNamn() {
	String namn = "";

	if (Tangentbordsläsare.hasNextLine()) // rensa bort kvarstående radmatningar
	    Tangentbordsläsare.nextLine();

	System.out.println();
	System.out.print( "Mata in ett namn: ");

	while (true) {
	    if ( Tangentbordsläsare.hasNextLine() ) {
		if (namn=="") {
		    namn = Tangentbordsläsare.nextLine();
		} else {
		    namn = namn + " " + Tangentbordsläsare.nextLine();
		}
		break;
	    }
	}
	System.out.println(namn);
    }
    //
    // 3
    //
    // i XTerm (ursprunget är VT100)
    //     DECSCNM
    //      ESC[?5;h (aktivering)
    //      ESC[?5;l (avaktivering)
    //
    private static void BytFärg() {
	if ( iReverse ) {
	    System.out.print( "\033[?5;l");
	    iReverse=false;
	} else {
	    System.out.print( "\033[?5;h");
	    iReverse=true;
	}
    }
    //
    // 4
    //
    private static void DagensDatum()
    {
	Locale standardlokalisering = Locale.getDefault();
	Date idag = new Date();
	DateFormat datumformatterare = DateFormat.getDateInstance( DateFormat.DEFAULT, standardlokalisering);
	String klockslaget = datumformatterare.format(idag);

	System.out.println();
	System.out.println( "Dagens datum : " + klockslaget);
	System.out.println();
    }
    //
    // 5
    //
    // läs in två tal (rella/naturliga etc) och ange vilket som är störst
    //
    private static void StörstTal() {
	Double förstaTalet=0.0;
	Double andraTalet=0.0;

	System.out.println();
	System.out.println( "Mata in två tal och få som svar vilket av dem som är störst (reella tal med \",\" som separering mot decimalerna)");

	System.out.print( "Första talet:");
	if ( Tangentbordsläsare.hasNextDouble())
	    förstaTalet = Tangentbordsläsare.nextDouble();

	System.out.print( "Andra talet:");
	if ( Tangentbordsläsare.hasNextDouble())
	    andraTalet = Tangentbordsläsare.nextDouble();

	System.out.print( "Det största talet är: ");
	System.out.println( Math.max(förstaTalet,andraTalet));
	System.out.println();
    }
    //
    // 6
    //
    private static void GissaEttNummer() {
	System.out.println( "Gissningsleken: gissa ett tal!");

    }
    //
    // 7
    //
    private static void SkrivEnRadTillFil() {
	String dumpFilNamn = "./en_datasamling";
	String radsomskrivs;

	while (true) {
	    if (Tangentbordsläsare.hasNextLine()) {
		radsomskrivs = Tangentbordsläsare.nextLine();
		break;
	    }
	}
	System.out.println( "skriven rad" + radsomskrivs);

	try {
	    File dump = new File(dumpFilNamn);
	    Formatter dumpström = new Formatter(dump);

	    dumpström.format( "%s\n", radsomskrivs);
	    dumpström.close();
	} catch (Exception någotFel) {
	    System.out.println( någotFel.getMessage());
	}
    }
    //
    // 8
    //
    private static void LäsEnRadFrånFil() {
	String dumpFilNamn = "en_datasamling";

	// använd scanner
	try
	    {
		Scanner läsFrånFil = new Scanner( new File( "en_datasamling"));

		// while ( läsFrånFil.hasNextLong())
		//     {
		//	//string rad = läsfrånfil.
		//	//System.out.println( rad);
		//     }
	    }
	catch (Exception ickeExisterandeFil) {
	    System.out.println( ickeExisterandeFil.getMessage());
	}
	System.out.println();
    }

    //
    // 9
    //
    private static void RäkningPåReellaTal() {
	double talet=0.0;

	System.out.println();
	System.out.println( "Beräkning av roten av och 10-potens för ett decimaltal");

	System.out.print( "Vilket tal: ");
	if ( Tangentbordsläsare.hasNextDouble())
	    talet = Tangentbordsläsare.nextDouble();

	System.out.println( "Talets rot: " + Math.sqrt(talet));
	System.out.println( "Talets 10:exponent: " + Math.pow( talet, 10.0));
	System.out.println();
    }

    //
    // 10
    //
    private static void MultiplikationsTabell() {
	//
	// multiplikationstabell för talen 1-10
	//
	int max=10;
	int tal1 = 1, tal2 = 1;
	// radhuvud
	System.out.print( "   ");
	for (tal1 = 1; tal1 <= 10; tal1++)
	    if ( tal1 >= 10 )
		System.out.print( "   "+ tal1);
	    else
		System.out.print( "    "+ tal1);
	System.out.println();

	for (tal2 = 1; tal2 <= 10; tal2++)
	    {
		if (tal2<10)
		    System.out.print( " ");
		System.out.print( " " + tal2);

		for (tal1 = 1; tal1 <= 10; tal1++)
		    {
			if ( ( tal1 * tal2 ) < 100)
			    System.out.print( " ");
			if ( ( tal1 * tal2 ) < 10)
			    System.out.print( " ");

			System.out.print( "  "+ tal1 * tal2 );
		    }
		System.out.println();
	    }

	System.out.println();
    }
    //
    // 11
    //
    // två matriser med slumpvist innehåll
    // en av dem har den andres innehåll men i sorterad ordning
    //
    private static void TvåMatriser() {
	System.out.println();
	System.out.print( "Mata in originalmatrisens storlek: ");
	int längd;

	while (true) {
	    if ( Tangentbordsläsare.hasNextInt() ) {
		längd = Tangentbordsläsare.nextInt();
		break;
	    }
	}

	Random slumptalKälla = new Random();
	int[] original=null;
	original = new int[längd];
	int[] sorterad=null;
	sorterad = new int[längd];

	for (int i=0;i<längd; i++)
	    original[i]=slumptalKälla.nextInt();
	for (int i=0;i<längd; i++)
	    sorterad[i]=original[i];

	Arrays.sort(sorterad);

	for (int i=0;i<längd; i++) {
	    System.out.print( "index: "+i+" värde: "+original[i]);
	    System.out.println( "\tvärde: "+sorterad[i]);
	};

	System.out.println();
    }

    //
    // 12
    //
    private static void ÄrEttOrdEttPalidrom() {
	//
	// ex ProtorP
	//
	if (Tangentbordsläsare.hasNextLine()) // rensa bort kvarstående radmatningar
	    Tangentbordsläsare.nextLine();

	String ord="";

	System.out.println();
	System.out.print( "Mata in ett ord: ");

	while (true) {
	    if ( Tangentbordsläsare.hasNextLine() ) {
		ord = Tangentbordsläsare.nextLine();
		break;
	    }
	}

	int ordetsLängd = ord.length();
	String[] isärslagetOrd = ord.split("");
	boolean kanskePalindrom = true;
	int iterator=0;

	while ( kanskePalindrom && (iterator < ordetsLängd/2)) {
	    System.out.println(iterator + " " + isärslagetOrd[iterator] + isärslagetOrd[ord.length()-(iterator+1)] );

	    if ( ! isärslagetOrd[iterator].equalsIgnoreCase( isärslagetOrd[ord.length()-(iterator+1)] ) )
		kanskePalindrom=false;

	    iterator++;;
	}

	if ( kanskePalindrom ) {
	    System.out.println("ordet \"" + ord + "\" är ett palindrom" );
	} else {
	    System.out.println("ordet \"" + ord + "\" är INTE ett palindrom" );
	}
    }
    //
    // 13
    //
    private static void TalIntervall() {
    }
    //
    // 14
    //
    private static void SorteringAvTalföljd() {
	System.out.println( "SorteringAvTalföljd Hello world");

    }
    //
    // 15
    //
    private static void SummeringAvTalföljd() {
	long summa=0;
	boolean fortsätt = true;
	String rad = "";

	System.out.println();
	System.out.println( "Summering av en heltalsföljd");

	while ( true) {
	    if ( Tangentbordsläsare.hasNext()) {
		rad = Tangentbordsläsare.next();
		break;
	    }
	}

	Scanner radläsare = new Scanner(rad).useDelimiter(",");
	int maxantal = 10;

	while ( radläsare.hasNext() ) {
	    System.out.println("läser raden");
	    if ( radläsare.hasNextInt() ) {
		summa = summa+radläsare.nextInt();
	    } else if ( radläsare.hasNextLong() ) {
		summa = summa+radläsare.nextLong();
	    } else if ( radläsare.hasNext() ) {
		String slask = radläsare.next();
	    }

	    if (maxantal == 0) {
		break;
	    }
	    maxantal=maxantal-1;
	}
	radläsare.close();

	// Tangentbordsläsare.useDelimiter(" ,\\p{javaWhitespace}");

	//while( Tangentbordsläsare.hasNext() )
	// {
	//	tal = Tangentbordsläsare.nextInt();
	//	summa = summa + tal;
	// }
	// while( fortsätt){
	//     if ( Tangentbordsläsare.hasNextInt()) {
	//	tal = Tangentbordsläsare.nextInt();
	//	summa = summa + tal;
	//     }
	//     else if( Tangentbordsläsare.hasNextLine()) {
	//	fortsätt = false;
	//     }
	// }
	//
	// inmatningsraden är på formen:
	//   32453,34534,43,36,6,345
	//

	System.out.println( "Summa: "+ summa);
	System.out.println( "rad: "+ rad);
	System.out.println();
    }

    //
    // 16
    //
    private static void TvåKlasser() {
	System.out.println();
	System.out.println( "TvåKlasser");
	System.out.println();
    }

    private static int VäljFunktion()
    {
	String[] TillgängligaVal = {
	    "Avsluta",
	    "Hello world",
	    "Mata in ett namn",
	    "Byt konsollens färg",
	    "Dagens datum",
	    "Största Talet",
	    "Gissningsleken: gissa ett tal",
	    "Spara en rad i en fil",
	    "Läs samma rad från filen",
	    "Rot- och 10-potensberäkning",
	    "Multiplikationstabell 1-10",
	    "Matriser",
	    "Palindromtest",
	    "Uppräkning av tal",
	    "Sortering av talföljd",
	    "Summering av talföljd",
	    "Två figurklasser"
	};

	int ValLoop = 1;
	while ( true ) {
	    if ( ValLoop==0   ) System.out.println(); // tom rad mellan övriga och '0 avsluta'
	    if ( ValLoop < 10 )	{
		System.out.println( "\t" + " " + ValLoop + "\t" + TillgängligaVal[ValLoop]);
	    } else {
		System.out.println( "\t" + ValLoop + "\t" + TillgängligaVal[ValLoop]);
	    }
	    if ( ValLoop==0 )  // knäck while:loopen när alternativet '0 avsluta' är utskrivet
		break;
	    else
		ValLoop = ValLoop+1;

	    if (ValLoop==TillgängligaVal.length)  // avsluta ska vara sist, starta om loopen på index 0
		ValLoop=0;
	}
	System.out.println(); // tom rad mellan '0 avsluta' och markören

	int ValdFunktion=0;
	boolean Inmatningsfel=true;
	while (Inmatningsfel) {
	    System.out.print( "välj siffrorna för något av alternativen: ");
	    if ( Tangentbordsläsare.hasNextInt()) {
		ValdFunktion = Tangentbordsläsare.nextInt();

		if (( ValdFunktion >= 0) && ( ValdFunktion < TillgängligaVal.length)) {
		    Inmatningsfel=false;
		} else {
		    Inmatningsfel=true;
		}
	    } else if ( Tangentbordsläsare.hasNextLine()) {
		Tangentbordsläsare.next();
	    }
	}

	return ValdFunktion;
    }

    public static void main(String[] args)
	throws IOException
    {
	// reader = new BufferedReader(new InputStreamReader(System.in));
	Tangentbordsläsare = new Scanner(System.in);

	// InputNamn();

	int ValdFunktion = 1;
	while (ValdFunktion != 0) {
	    ValdFunktion = VäljFunktion();

	    switch(ValdFunktion)
		{
		case 1:
		    Helloworld();
		    break;
		case 2:
		    InputNamn();
		    break;
		case 3:
		    BytFärg();
		    break;
		case 4:
		    DagensDatum();
		    break;
		case 5:
		    StörstTal();
		    break;
		case 6:
		    GissaEttNummer();
		    break;
		case 7:
		    SkrivEnRadTillFil();
		    break;
		case 8:
		    LäsEnRadFrånFil();
		    break;
		case 9:
		    RäkningPåReellaTal();
		    break;
		case 10:
		    MultiplikationsTabell();
		    break;
		case 11:
		    TvåMatriser();
		    break;
		case 12:
		    ÄrEttOrdEttPalidrom();
		    break;
		case 13:
		    TalIntervall();
		    break;
		case 14:
		    SorteringAvTalföljd();
		    break;
		case 15:
		    SummeringAvTalföljd();
		    break;
		case 16:
		    TvåKlasser();
		    break;
		}
	}
    }
}


// Local Variables:
// compile-command: javac Uppgift.java
// End:
