package ie.gmit.dip;

public class Test {
    
    String keyVal = "JAVABO";
    String textVal = "ATTACK THE CASTLE WALL AT DAWN TOMORROW";
    
    public void runTest() {
        System.out.println("Running test round with default settings...\n");
        System.out.println("Original message test --> ATTACK THE CASTLE WALL AT DAWN TOMORROW\n");
        try {
            Cypher currentCypher = new Cypher(keyVal);
            //currentCypher.setKey(keyVal);
            System.out.println("Here is your encoded message \n");
            currentCypher.encode(textVal);
            String crypted = currentCypher.codeOutGoing;
            System.out.println(crypted);
            System.out.println("\n");
            System.out.println("Here is your decoded back message");
            System.out.println("\n");
            currentCypher.decode(crypted);
            String unCrypted = currentCypher.deCodeOutGoing;
            System.out.println(unCrypted);
            
        }catch (Exception e){
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        }finally {
            System.out.println("\n\nCleaning up....");
        }
    }
}
