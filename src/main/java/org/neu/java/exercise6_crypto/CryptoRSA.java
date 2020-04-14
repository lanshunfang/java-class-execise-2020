package org.neu.java.exercise6_crypto;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class CryptoRSA {

    static KeyPair keyPair;

    static class RSA {

        static int RSALength = 2048;

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
                generator.initialize(RSALength, new SecureRandom());
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

        private Signature getSignature(byte[] anyByte, boolean isSign) {

            try {
                Signature privateSignature = Signature.getInstance("SHA256withRSA");

                if (isSign) {
                    privateSignature.initSign(keyPair.getPrivate());

                } else {
                    privateSignature.initVerify(keyPair.getPublic());
                }

                privateSignature.update(anyByte);

                return privateSignature;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        public String getSignedMessage(String message) {

            try {
                return Base64.getEncoder().encodeToString(
                        getSignature(message.getBytes(), true).sign()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        public boolean isMessageVerified(String message, String signature) {

            try {
                return getSignature(
                        message.getBytes(),
                        false
                ).verify(
                        Base64.getDecoder().decode(signature)
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
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

        public String sign(String plainText) {
            return new RSA().getSignedMessage(plainText);
        }

        public boolean verify(String plainText, String signature) {
            return new RSA().isMessageVerified(plainText, signature);
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

        String signature = alice.sign(rawText);
        System.out.println("Signed: " + signature);

        boolean isSignatureVerified = alice.verify(rawText, signature);
        System.out.println("Is Verified: " + isSignatureVerified);


    }

}
