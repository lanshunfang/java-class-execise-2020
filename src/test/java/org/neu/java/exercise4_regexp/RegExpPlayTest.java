package org.neu.java.exercise4_regexp;

import org.junit.*;

import static org.junit.Assert.*;

public class RegExpPlayTest {


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

  }

  @Test
  public void testZip_PassInZipCode_ReturnTrue() {

    assertEquals(
            new RegExpPlay().testZip("95132"),
            true
    );

  }

  @Test
  public void testZip_PassInNonZipCode_ReturnFalse() {

    assertEquals(
            new RegExpPlay().testZip("20200414"),
            true
    );
  }

  @Test
  public void testYear_PassInYear_ReturnTrue() {

    assertEquals(
            new RegExpPlay().testYear("1984"),
            true
    );

  }

  @Test
  public void testChineseChar_PassInChineseChar_ReturnTrue() {

    assertEquals(
            new RegExpPlay().testChineseChar("你好"),
            true
    );

  }

  @Test
  public void testNeuEmail_PassInChineseChar_ReturnTrue() {

    assertEquals(
            new RegExpPlay().testNeuEmail("lan.sh@northeastern.edu"),
            true
    );

  }
  @Test
  public void testHtmlLinkTag_PassInChineseChar_ReturnTrue() {

    assertEquals(
            new RegExpPlay().testHtmlLinkTag("<a href=\"page2\"></a>"),
            true
    );

  }


}
