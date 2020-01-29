package ie.gmit.dip;
import java.util.*;

public class Menu {
    private Scanner in;
    private Scanner input;
    private boolean keepRunning = true;

      
    public void start(){
        in = new Scanner(System.in);
        
        while(keepRunning){
            
            showOptions();
            int selection = Integer.parseInt(in.next());
            
            if(selection == 1){         //Add
                Test currentTest = new Test();
                currentTest.runTest();
                //in.next();
            }else if(selection == 2){   //Run encryption             
                runEncrypt();
                //in.next();
            }else if (selection == 3){  //Run decry
                runDecrypt();
            }
            //else if (selection == 4){  //Search by Name
                //Classic OldRunner = new Classic();
                //OldRunner.runClassic();
                //searchByName();
            //}
            else if (selection == 4){  //Quit
                in.close();
                keepRunning = false;    //Exit graceful
            }else {
                System.out.println("Invalid input - Select from options 1 - 4.");//Invalid input
                //in.next();
            }
        }
    }
    
    private void showOptions(){
            System.out.println("##########################################");
            System.out.println("###\tPolybus Square Cypher 1.0   ###");
            System.out.println("##########################################");
            System.out.println("(1)  Run Test.");
            System.out.println("(2)  Encrypt Message");
            System.out.println("(3)  Decrypt Cyphertext");
            System.out.println("(4)  Exit");
            System.out.println("Select an Option[1-4]>");
        
    }
    
    private String runDecrypt() {
        input = new Scanner(System.in);
        String kW = null;
        String pT = null;
        String outPlain = null;
        //cM = input.nextLine();
        System.out.println("Please enter text for decryption: \n");
        pT = input.nextLine();
        System.out.println("Please enter a keyword for cypher: \n");
        kW = input.next();
        
        try {
                Cypher cypherThis = new Cypher(kW);
                cypherThis.decode(pT);
                System.out.println("\n");
                outPlain = cypherThis.deCodeOutGoing;
                System.out.println("\n");
                System.out.println("Your decrypted string is -> \n");
                System.out.println(outPlain);
                System.out.println("\n\n");
                System.out.println("Your morse cypher message is\n");
                System.out.println(cypherThis.wangOut);
            
            }catch (Exception e) {
                System.out.println("Message: " + e.getMessage());
                e.printStackTrace();
            }finally{
                System.out.println("\n\nCleaning up....");
                }
            return outPlain;
        }
        
    
    private String runEncrypt() {
        input = new Scanner(System.in);
        String kW = null;
        String pT = null;
        String outCrypt = null;
        System.out.println("Please enter a message to encrypt: \n");
        pT = input.nextLine();
        System.out.println("Please enter a keyword for cypher: \n");
        kW = input.nextLine();

            try {
                    Cypher cypherThat = new Cypher(kW);
                    //if(classMode == "C" || classMode =="c"){         //Add
                    //cypherThat.classicWize = true;}else{cypherThat.classicWize = false;}
                    cypherThat.encode(pT);
                    outCrypt = cypherThat.codeOutGoing;
                    System.out.println("\n");
                    System.out.println("Your crypted string is -> ");
                    System.out.println(outCrypt);
                    System.out.println("\n");
                    System.out.println("Your morse cypher message is ->");
                    String BB = cypherThat.wangOut;
                    System.out.println(BB);
                }catch (Exception e) {
                    System.out.println("Message: " + e.getMessage());
                    e.printStackTrace();
                }finally{
                System.out.println("\n\nCleaning up....");
                }

                return outCrypt;                  //pipe out to parser
                     
                } 
        
        }

    
