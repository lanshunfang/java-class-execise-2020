package org.neu.java.exercise6_crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class CryptoAES {

    static SecretKey secretKey;

    static class AES {

        static private KeyGenerator keyGenerator;

        private int GCM_TAG_LENGTH = 16;

        // GCM_IV_LENGTH = 12
        static byte[] IV = new byte[12];

        AES() {
        }

        public static void initSecretKey() {
            if (secretKey == null) {
                generateSecretKey();

                SecureRandom random = new SecureRandom();
                random.nextBytes(IV);
            }
        }

        private byte[] getByteArrayWithAes(byte[] anyByte, int cipherMode) {

            // Get Cipher Instance
            Cipher cipher = null;

            try {
                cipher = Cipher.getInstance("AES/GCM/NoPadding");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }

            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);

            try {
//                cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
//                cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
                cipher.init(cipherMode, keySpec, gcmParameterSpec);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }

            byte[] cipherText = new byte[0];
            try {
                cipherText = cipher.doFinal(anyByte);
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }

            return cipherText;
        }

        static void generateSecretKey() {
            try {
                keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(256);

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            secretKey = keyGenerator.generateKey();
        }

        public String getEncryptedMessage(String message) {

            return Base64.getEncoder().encodeToString(
                    this.getByteArrayWithAes(
                            message.getBytes(),
                            Cipher.ENCRYPT_MODE)
            );


        }

        public String getUnEncryptedMessage(String encryptedMessage) {
            return new String(this.getByteArrayWithAes(
                    Base64.getDecoder().decode(encryptedMessage),
                    Cipher.DECRYPT_MODE
            ));
        }

    }

    public static class People {
        public final String name;

        public People(String name) {
            this.name = name;
            AES.initSecretKey();
        }

        public String speak(String classifiedText) {
            return new AES().getEncryptedMessage(classifiedText);
        }

        public String listen(String encryptedText) {
            return new AES().getUnEncryptedMessage(encryptedText);
        }
    }

    public static void clearSecretKey() {
        secretKey = null;
    }

    public static void main(String[] args) {

        People alice = new People("Alice");
        People bob = new People("Bob");

        String rawText = "Hello, my SSN is 078-05-1120";
        String myth = alice.speak(rawText);

        System.out.println("Raw: " + rawText);
        System.out.println("Encrypted: " + myth);

        String info = bob.listen(myth);
        System.out.println("Decrypted: " + info);
    }

}
