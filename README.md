# AdfgvxCipher
Columnar Transposition Cipher used by Germany during WWI defeated by French Cryptanalyst Gorges Painvin

-----------------------------
Simple Polybius Cypher V1.0
-----------------------------

In cryptography, the ADFGVX cipher was a field cipher used by the German Army during World War I. ADFGVX was in fact an extension 
of an earlier cipher called the ADFGX cipher. 
Invented by Colonel Fritz Nebel and introduced in March 1918, the cipher was a fractionating transposition cipher which combined a 
modified Polybius square with a single columnar transposition. 
The cipher is named after the six possible letters used in the ciphertext: A, D, F, G, V and X. These letters were chosen 
deliberately because they sound very different from each other when transmitted via morse code. The intention was to reduce the 
possibility of operator error.

From Kahn's 'The CodeBreakers':


This polybius cypher in java uses the techniques originally developed in the ADFGVX by filling a 2d matrix array with character 
values and then performing columnar transposition on the members to cypher the text. Originally the ADFGVX then converted the 
values to morse characters however this is not done so much in modern implementations.

There is a simple menu which allows the user to select from a test run or go for a user input encrypt or decrypt session. The 
cypher returns the more modern cypher output (non-morse) and also retruns the morse value sets for encryption and decryption as 
an homage to the origins of this Cypher. Just enter the crypted string from an encrypt round to get the message and morse back. 

The menu is simply traversed by selecting the required option from the list. This is essentially a beta version as the 
learning curve was steep so hopefully a more fully featured release will be available in the not too distant future with a 
view to implementing an option for file parsing and standalone classic ADFGVX mode. 

The Simple Polybius Cypher can be launched by navigating to the containing folder and can be found under the package structure 
ie.gmit.dip
To comple navigate to -> ProjectPolybius/src

Then at the command prompt enter --> javac ie/gmit/dip/*.java
To run type --> ie.gmit.dip.Runner

Note: This cipher adds a salt during to the encryption process - for purposes of visibility/learning salt characters are 
lowercase. You would not do this in the field, you can refactor the code to use all upper or lower case characters with 
toUpperCase or toLowerCase methods.



