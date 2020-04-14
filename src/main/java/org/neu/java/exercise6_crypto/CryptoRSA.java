package org.neu.java.exercise6_crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class CryptoRSA {

    static KeyPair keyPair;

    static class RSA {

        public static void initKeyPair() {
            if (keyPair == null) {
                generateKeyPair();
            }
        }

        private byte[] getByteArrayWithRsa(byte[] anyByte, int cipherMode) {

            byte[] cipherText = new byte[0];

            try {
                Cipher cipher = Cipher.getInstance("RSA");

                if (cipherMode == Cipher.ENCRYPT_MODE) {
                    cipher.init(cipherMode, keyPair.getPublic());
                } else {
                    cipher.init(cipherMode, keyPair.getPrivate());
                }

                cipherText = cipher.doFinal(anyByte);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return cipherText;
        }

        static void generateKeyPair() {
            try {
                KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
                generator.initialize(2048, new SecureRandom());
                keyPair = generator.generateKeyPair();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }

        public String getEncryptedMessage(String message) {

            return Base64.getEncoder().encodeToString(
                    this.getByteArrayWithRsa(
                            message.getBytes(),
                            Cipher.ENCRYPT_MODE
                    )
            );


        }

        public String getUnEncryptedMessage(String encryptedMessage) {
            return new String(this.getByteArrayWithRsa(
                    Base64.getDecoder().decode(encryptedMessage),
                    Cipher.DECRYPT_MODE
            ));
        }

    }

    public static class People {
        public final String name;

        public People(String name) {
            this.name = name;
            RSA.initKeyPair();
        }

        public String speak(String classifiedText) {
            return new RSA().getEncryptedMessage(classifiedText);
        }

        public String listen(String encryptedText) {
            return new RSA().getUnEncryptedMessage(encryptedText);
        }
    }

    public static void clearKeyPair() {
        keyPair = null;
    }

    public static void main(String[] args) {

        People alice = new People("Alice");
        People bob = new People("Bob");

        String rawText = "Hello, my Address is 6024 Silver Creek, San Jose, CA.";
        String myth = alice.speak(rawText);

        System.out.println("Raw: " + rawText);
        System.out.println("Encrypted: " + myth);

        String info = bob.listen(myth);
        System.out.println("Decrypted: " + info);
    }

}
