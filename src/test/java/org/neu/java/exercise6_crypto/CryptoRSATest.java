package org.neu.java.exercise6_crypto;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CryptoRSATest {

    
    @BeforeClass
    public static void beforeAll() {
        // class setup code here
    }

    @AfterClass
    public static void afterAll() {
        // class cleanup code here

    }

    @Before
    public void before() {

    }

    @After
    public void after() {
        CryptoRSA.clearKeyPair();

    }

    @Test
    public void getEncryptedMessage_RSAPassInPlainText_EncryptSuccess() {

        CryptoRSA.People studentA = new CryptoRSA.People("Student 1");
        String rawText = "My bank account is 123321, BoA";
//        CryptoPlay.People studentB = new CryptoPlay.People("Student 2");
        assertNotEquals(
                "The message should be encrypted",
                studentA.speak(rawText),
                rawText
        );

    }

    @Test
    public void getUnEncryptedMessage_RSAPassInEncryptedText_UnEncryptSuccess() {
        CryptoRSA.People studentA = new CryptoRSA.People("Student 1");
        String rawText = "My balance is USD100";
        CryptoRSA.People studentB = new CryptoRSA.People("Student 2");
        assertEquals(
                "The message should be decrypted",
                studentB.listen(studentA.speak(rawText)),
                rawText
        );

    }

    @Test
    public void getSignedMessage_RSAPassInPlainText_SignSuccess() {
        CryptoRSA.People studentA = new CryptoRSA.People("Student 1");
        String rawText = "My bank account is 001122, Citi";
//        CryptoPlay.People studentB = new CryptoPlay.People("Student 2");
        assertNotEquals(
                "The message should be signed",
                studentA.sign(rawText),
                rawText
        );

    }

    @Test
    public void isMessageVerified_RSAPassInSignature_VerifySuccess() {
        CryptoRSA.People studentA = new CryptoRSA.People("Student 1");
        String rawText = "My bank account is 003322, Citi";

        String signature = studentA.sign(rawText);

        CryptoRSA.People studentB = new CryptoRSA.People("Student 2");

        assertEquals(
                "The message should be verified",
                studentB.verify(rawText, signature),
                true
        );

        assertEquals(
                "Any other message should NOT be verified",
                studentB.verify(rawText + " ", signature),
                false
        );

    }
}
