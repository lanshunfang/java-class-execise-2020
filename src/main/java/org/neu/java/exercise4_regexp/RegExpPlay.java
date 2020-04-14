package org.neu.java.exercise4_regexp;

import java.util.regex.*;

public class RegExpPlay {

    public boolean testZip(String matcher) {

        String pattern = "^\\d{5}(-\\d{4})?$";
//    String matcher = "95132";

        return match(pattern, matcher);
    }

    public boolean testYear(String matcher) {

        String pattern = "^(19|20)\\d{2}$";
//    String matcher = "1984";

        return match(pattern, matcher);
    }

    public boolean testChineseChar(String matcher) {

        String pattern = "[\\u4e00-\\u9fa5]+";
//    String matcher = "你好";

        return match(pattern, matcher);
    }

    public boolean testNeuEmail(String matcher) {

        String pattern = "^[A-Z0-9+_.-]+@(husky\\.neu|northeastern)\\.edu$";
//    String matcher = "lan.sh@northeastern.edu";

        return match(pattern, matcher, true);
    }

    public boolean testHtmlLinkTag(String matcher) {

        String pattern = "<a[^>]*>(.*?)</a>";
//    String matcher = "<a href="page2></a>";

        return match(pattern, matcher, true);
    }

    private boolean match(String pattern, String matcher) {

        return match(pattern, matcher, false);

    }

    private boolean match(String pattern, String matcher, boolean isCaseInSensitive) {

        Pattern p = isCaseInSensitive ? Pattern.compile(pattern, Pattern.CASE_INSENSITIVE) : Pattern.compile(pattern);//. represents single character
        Matcher m = p.matcher(matcher);

        boolean isMatched = m.matches();

        System.out.println(String.format("Use Regexp pattern `%s` to match `%s`; the result is `%s`", pattern, matcher, isMatched));

        return isMatched;

    }

    public static void main(String... args) {

        RegExpPlay regExpPlay = new RegExpPlay();

        regExpPlay.testZip("95132");
        regExpPlay.testZip("Hello");

        regExpPlay.testYear("1984");
        regExpPlay.testYear("0011");

        regExpPlay.testChineseChar("你好");
        regExpPlay.testChineseChar("Hello");

        regExpPlay.testNeuEmail("lan.sh@northeastern.edu");
        regExpPlay.testNeuEmail("lan.sh@gmail.com");
        regExpPlay.testNeuEmail("lan.sh@husky.neu.edu");
        regExpPlay.testNeuEmail("www.example.com");
        regExpPlay.testNeuEmail("@www.example.com");

        regExpPlay.testHtmlLinkTag("<a href=\"page2\"></a>");
        regExpPlay.testHtmlLinkTag("Plain text");

    }
}
