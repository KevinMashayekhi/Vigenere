public class Vigenere {

    
    //Encryption method; takes x and the key and generates the ciphertext
    static String encrypt(String x, String key) {
        String cipherText = "";

        for(int i = 0; i < x.length(); i++) {
            int j = (x.charAt(i) + key.charAt(i)) % 26;
            j += 'A';
            cipherText += (char)(j);
        }

        return cipherText;
    }

    //Decryption method, takes the ciphertext and the key and generates what the original plaintext was
    static String decrypt(String cipherText, String key) {
        String originalText = "";

        for(int i = 0; i < cipherText.length() && i < key.length(); i++) {
            int j = (cipherText.charAt(i) - key.charAt(i) + 26 ) % 26;

            j += 'A';
            originalText += (char)(j);
        }

        return originalText;
    }

    //This method takes the key and makes the key length equal to the length of message we are encrypting
    static String generateKey(String x, String key) {
        int length = x.length();

        for(int i = 0; ; i++) {
            if(length == i)
                i = 0;
            if(key.length() == length)
                break;
            key += (key.charAt(i));
        }

        return key;
    }

    //Generate a random string with a length of 17
    static String randomString() {
        String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(17);

        for(int i = 0; i < 17; i++) {
            int index = (int) (alphaString.length() * Math.random());
            sb.append(alphaString.charAt(index));
        }

        return sb.toString();
    }

    public static void main (String [] args) {

        //Message plaintext
        String plainText = "THESUNANDTHEMOON";

        //Randomly generated string of values A-Z with length of 17
        String randomString = randomString();

        //Concatenation of the randomString and the plaintext; this is the message that will be encrypted. First 17 chars are the randomly generated string
        //and the following is the plaintext
        String x = randomString + plainText;

        //Key to be used in encryption
        String keyWord = "GLOVE";

        //Make key the length of the string x
        String key = generateKey(x, keyWord);
        
        //Call the encryption method to get the ciphertext
        String cipherText = encrypt(x, key);    
        
        //Print statements
        System.out.println("Plaintext: " + plainText);
        System.out.println("Randomly generated string: " + randomString);
        System.out.println("x: " + x);
        System.out.println("KeyWord: " + keyWord);
        System.out.println("Key: " + key);
        System.out.println();  
        System.out.println(); 

        for(int i = 1; i < 4; i++) {
            System.out.println("Number of times encrypted: " + i);
            System.out.println("Ciphertext: " + cipherText);
            System.out.println("After decrypting ciphertext: " + decrypt(cipherText, key));

            System.out.println();  
            System.out.println(); 
            if(i == 3)
                break;
            randomString = randomString();
            System.out.println("Newly random generated string: " + randomString);
            x = randomString + plainText;
            System.out.println("New x: " + x);
            cipherText = encrypt(x, key); 
        }
    }
}
