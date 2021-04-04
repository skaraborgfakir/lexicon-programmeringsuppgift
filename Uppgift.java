import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.Calendar;
// import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;
import java.time.ZonedDateTime;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;

public class Uppgift {
    // BufferedReader reader;
    static Scanner tangentbordsläsare;

    //
    // 1
    //
    private static void Helloworld()
    {
	System.out.println( "Hello world");
    }
    //
    // 2
    //
    private static void InputNamn() {
	System.out.print("Mata in ett namn:");
	String namn = tangentbordsläsare.nextLine();
    }
    //
    // 3
    //
    private static void BytFärg() {
	System.out.println( "BytFärg Hello world");
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

	System.out.println( "Dagens datum : " + klockslaget);

	System.out.println();
    }
    //
    // 5
    //
    private static void StörstTal() {
    }
    //
    // 6
    //
    private static void GissaEttNummer() {
    }
    //
    // 7
    //
    private static void SkrivEnRadTillFil() {
    }
    //
    // 8
    //
    private static void LäsEnRadFrånFil() {
    }
    //
    // 9
    //
    private static void RäkningPåReellaTal() {
    }
    //
    // 10
    //
    private static void MultiplikationsTabell() {
	//
	// multiplikationstabell för talen 1-10
	//
    }
    //
    // 11
    //
    private static void TvåMatriser() {
    }
    //
    // 12
    //
    private static void ÄrEttOrdEnPalidrom() {
	//
	// ex ProtorP
	//
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
	System.out.println( "SummeringAvTalföljd Hello world");
    }
    //
    // 16
    //
    private static void TvåKlasser() {
	System.out.println( "TvåKlasser Hello world");

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

	};

	int ValLoop = 1;
	boolean Klart = false;
	while ( !Klart ) {
	    if ( ValLoop==0 )
		System.out.println();
	    System.out.print( ValLoop);
	    System.out.print( " ");
	    System.out.println( TillgängligaVal[ValLoop]);
	    if ( ValLoop==0 )
		Klart = true;
	    ValLoop = ValLoop+1;
	    if (ValLoop==TillgängligaVal.length) {
		ValLoop=0;
	    }
	};
	System.out.println();

	int valdFunktion=0;
	boolean inputfel=true;
	while (inputfel) {
	    System.out.print( "välj siffrorna för något av alternativen: ");
	    if ( tangentbordsläsare.hasNextInt())
		valdFunktion = tangentbordsläsare.nextInt();
	    else
		{
		    tangentbordsläsare.next();
		    continue;
		}

	    inputfel=false;
	}

	return valdFunktion;
    }

    public static void main(String[] args)
	throws IOException
    {
	// reader = new BufferedReader(new InputStreamReader(System.in));
	tangentbordsläsare = new Scanner(System.in);

	int ValdFunktion = 1;
	while (ValdFunktion != 0)
	    {
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
			ÄrEttOrdEnPalidrom();
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
	    };
    }
}


// Local Variables:
// compile-command: javac Uppgift.java
// End:
