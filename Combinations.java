package day4;

import java.util.ArrayList;

public class Combinations {
    private StringBuilder output = new StringBuilder();
    private final String inputstring;
    public ArrayList<String> combinations;
    public Combinations( final String str ){
        inputstring = str;
        combinations = new ArrayList<String> ();
        this.combine();
    }
        
    public void combine() { combine( 0 ); }
    private void combine(int start ){
        for ( int i = start; i < inputstring.length(); ++i ){
        	if(inputstring.charAt(i) == ' ') {
        		for(int j = 'a'; j <= 'z'; ++j) {
        			output.append( (char)(j - 'a' + 'A'));
                    combinations.add(output.toString());
                    if ( i < inputstring.length() )
                    combine( i + 1);
                    output.setLength( output.length() - 1 );
        		}
        	}
        	else {
	            output.append( inputstring.charAt(i) );
	            combinations.add(output.toString());
	            if ( i < inputstring.length() )
	            combine( i + 1);
	            output.setLength( output.length() - 1 );
        	}
        }
    }
} 