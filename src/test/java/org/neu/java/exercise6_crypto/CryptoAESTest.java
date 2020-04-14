package org.neu.java.exercise6_crypto;

import org.junit.*;

import static org.junit.Assert.*;

public class CryptoAESTest {


    private CryptoAES cryptoPlay;

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
        CryptoAES.clearSecretKey();

    }

    @Test
    public void getEncryptedMessage_AESPassInPlainText_EncryptSuccess() {

        CryptoAES.People studentA = new CryptoAES.People("Student 1");
        String rawText = "My ID is ****";
//        CryptoPlay.People studentB = new CryptoPlay.People("Student 2");
        assertNotEquals(
                "The message should be encrypted",
                studentA.speak(rawText),
                rawText
        );

    }

    @Test
    public void getUnEncryptedMessage_AESPassInEncryptedText_UnEncryptSuccess() {
        CryptoAES.People studentA = new CryptoAES.People("Student 1");
        String rawText = "My ID is ****";
        CryptoAES.People studentB = new CryptoAES.People("Student 2");
        assertEquals(
                "The message should be decrypted",
                studentB.listen(studentA.speak(rawText)),
                rawText
        );

    }
}
