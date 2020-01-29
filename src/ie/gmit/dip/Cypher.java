package ie.gmit.dip;
import java.util.*;
//import java.lang.Math;

public class Cypher {
    
    private String keyText = null;
    private String textIn = null;
    String morseReadyA = null;
    String morseReadyB = null;
    private char[] cryptOut = null;
    String wangOut = "";
    Scanner inward;
    String codeOutGoing;
    String deCodeOutGoing;
    boolean classicWize = false;
    
    private char[][] tabulaPolybus = {
		{'P','H','0','Q','G','6'},
		{'4','M','E','A','1','Y'},
		{'L','2','N','O','F','D'},
		{'X','K','R','3','C','V'},
		{'S','5','Z','W','7','B'},
		{'J','9','U','T','I','8'}
    };
    
    private char[] morse = {'A','F','D','G','V','X'};
    
    //(String plainMessage, String keyWord)(String plainMessage, String keyWord)   
    public Cypher(String kIn) throws Exception{
        if (kIn == null) throw new Exception("Invalid key. ");
        //if (tIn == null) throw new Exception("Invalid message - please enter something. ");
        setKey(kIn);
        //setText(tIn);
        
    }
    
    //Getters and Setters
    
     public void setKey(String keySet) throws Exception{
        String keySetter = keySet.replaceAll("\\s+","");;
        this.keyText = keySetter.trim().toUpperCase();
     
    }
    
       
    public void setText(String textSet) throws Exception{
        if (textSet == null) throw new Exception("Invalid key. ");
        String textSetter = textSet.replaceAll("\\s+","");;
        this.textIn = textSetter.trim().toUpperCase();
     
    }
  
  
    public String getKey() {
        return keyText;
        }
        
    public String getText() {
        return textIn;
        } 
        
    public String getMorseReadyA() {
        return morseReadyA;
        }
    public String getMorseReadyB() {
        return morseReadyB;
        }    
        
    public char[] getCryptOut() {
        return cryptOut;
        } 
        
    
    //public String getWangOut() {  -> !lol
    //    return wangOut;
    //    } 
        

      public String encode(String tIn)  throws Exception{       //  Main encryption function
            if (tIn == null) throw new Exception("Invalid message - please enter something. ");
            setText(tIn);
            //int textLen = textIn.length() + 1; 
            char[] encCharIn = getText().toCharArray();
            char[] keyEnc = getKey().toCharArray();
            String sb = "";
            int row = Math.round((encCharIn.length/keyEnc.length)+2);     //using +2 to salt w/randomAlpha
    		int column = keyEnc.length;
    		int countCharIn = 0;
            //int insertRandHere = 0;
            char [][] gridMatrix = new char [row][column];              //create populate matrix
                for(int i = 0 ; i < row ; i++){
        			for(int j = 0; j < column ; j++){
        				if(countCharIn < encCharIn.length) {
        					gridMatrix[i][j] = encCharIn[countCharIn];
        					countCharIn++;
        				}
        				else{
        					gridMatrix[i][j] = RandomAlpha();
        					
        				}
        			}
        		}
            int sortRef = 0;                                    //use sortRef to arrange matrix below
            char[] sortedKey = new char[keyEnc.length];
                for(int i = 0; i < keyEnc.length; i++) {
                    sortedKey[i] = keyEnc[i];
                }
            Arrays.sort(sortedKey);
                String kS = getKey().toString();
                for(int i = 0; i < column; i++) {
                    sortRef = kS.indexOf(sortedKey[i]);
                        for(int j = 0; j < row; j++) {
                            sb += gridMatrix[j][sortRef];
                        }
                }
            codeOutGoing = sb.toString();
            morseReadyA = sb.toString();
            uberTransposeChars(morseReadyA);
            return sb.toString();
        }
        
        private void uberTransposeChars(String charsIn) {         //uses morse array for classic output
            
            char[] cryptoidOut = new char[charsIn.length()];
            cryptoidOut = charsIn.toCharArray();
            //String wangOut = "";
                for(char zh: cryptoidOut) {
                    for(int z = 0; z < tabulaPolybus.length; z++) {
                        for(int y = 0; y < tabulaPolybus[z].length; y++) {
                            if(tabulaPolybus[z][y] == zh) {
                                wangOut += String.valueOf(morse[z]) + String.valueOf(morse[y]) + " ";
                                }
                            }
                        }
                    }
                   //return wangOut; 
                }
                
                

        public String decode(String tI)  throws Exception{              //main decode - reverses the process
            if (tI == null) throw new Exception("Invalid message - please enter something. ");
            setText(tI);
            String pB = "";
            int row = Math.round(textIn.length()/keyText.length());
            int column = keyText.length();
            int count = 0;
            int reference;
            char[][] deCryptMatrix = new char[row][column];
            char[] inputArray = getText().toCharArray();
            char[] transposeKey = getKey().toCharArray();
            Arrays.sort(transposeKey);
            String sK = getKey().toString();                        //marker ref with colwise outer!!
                for (int i = 0; i < column; i++) {
                    reference = sK.indexOf(transposeKey[i]);
                        for(int j = 0; j < row; j++) {
                            deCryptMatrix[j][reference] = inputArray[count];
                            count++;
                        }
                    
                }
                
                for(int i = 0; i < row; i++) {
                    for(int j = 0; j < column; j++) {
                        pB += deCryptMatrix[i][j];
                        
                    }
                    
                }
              deCodeOutGoing = pB.toString();
              morseReadyB = pB.toString();
              uberTransposeChars(morseReadyB);
              //String a = uberTransposeChars(morseReadyB);
              
              return pB.toString();        
            
        }
        
        //Helper methods below
        
        
        public static char RandomAlpha() {         //Random char generator
            Random r = new Random();
            return (char)(r.nextInt(26) + 'a');
        }
    
    
	
}

    

    

    
    

