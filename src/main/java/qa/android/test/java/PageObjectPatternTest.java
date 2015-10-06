package main.java.qa.android.test.java;

import main.java.qa.android.page.HomePage;
import main.java.qa.android.util.AppiumTest;
import static main.java.qa.android.util.Helpers.back;

public class PageObjectPatternTest extends AppiumTest {

    @org.junit.Test
    public void pageObject() throws Exception {
        HomePage.accessibilityClick();
        back();

        HomePage.animationClick();
        back();
    }
}