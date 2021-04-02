import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uppgift {
    BufferedReader reader;

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
    void InputNamn() {
    }
    //
    // 3
    //
    void BytFärg() {
    }
    //
    // 4
    //
    void DagensDatum() {
    }
    //
    // 5
    //
    void StörstTal() {
    }
    //
    // 6
    //
    void GissaEttNummer() {
    }
    //
    // 7
    //
    void SkrivEnRadTillFil() {
    }
    //
    // 8
    //
    void LäsEnRadFrånFil() {
    }
    //
    // 9
    //
    void RäkningPåReellaTal() {
    }
    //
    // 10
    //
    void MultiplikationsTabell() {
	//
	// multiplikationstabell för talen 1-10
	//
    }
    //
    // 11
    //
    void TvåMatriser() {
    }
    //
    // 12
    //
    void ÄrEttOrdEnPalidrom() {
	//
	// ex ProtorP
	//
    }
    //
    // 13
    //
    void TalIntervall() {
    }

    private static int VäljFunktion()
    {
	String[] TillgängligaVal = {
	    "Avsluta",
	    "Hello world",
	    "Mata in ett namn"
	};

	int ValLoop = 1;
	boolean Klart = false;
	while ( !Klart ) {
	    System.out.print( ValLoop);
	    System.out.print( " ");
	    System.out.println( TillgängligaVal[ValLoop]);
	    if ( ValLoop==0 )
		Klart = true;
	    ValLoop = ValLoop+1;
	    if (ValLoop==3) {
		ValLoop=0;
	    }
	};

	int valdFunktion = reader.nextInt();
    }

    public static void main(String[] args)
	throws IOException
    {
	reader = new BufferedReader(new InputStreamReader(System.in));
	// String name = reader.readLine();
	int ValdFunktion = 1;
	while (ValdFunktion != 0)
	    {
		ValdFunktion = VäljFunktion();
	    };

	//	Helloworld(); // System.out.println(name);

    }
}


// Local Variables:
// compile-command: javac Uppgift.java
// End:
