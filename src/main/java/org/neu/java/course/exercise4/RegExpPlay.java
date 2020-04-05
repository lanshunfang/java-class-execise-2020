package org.neu.java.course.exercise4;

import java.util.regex.*;

public class RegExpPlay {

  public void test1Zip() {

    String pattern = "^\\d{5}(-\\d{4})?$";
    String matcher = "95132";

    myMatch(pattern, matcher);
  }

  private void myMatch(String pattern, String matcher) {

    Pattern p = Pattern.compile(pattern);//. represents single character
    Matcher m = p.matcher(matcher);

    boolean isMatched = m.matches();

    System.out.println(String.format("Use Regexp pattern `%s` to match `%s`; the result is `%s`", pattern, matcher, isMatched));
  }

  public static void main(String... args) {


    RegExpPlay regExpPlay = new RegExpPlay();

    regExpPlay.test1Zip();


  }
}
