package org.mercatordigital.technicaltask.hooks;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {

    private static BrowserContext context;
    private static Browser browser;
    public Page page;

    @BeforeAll
    public static void initialisePlaywright() {

        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @BeforeEach
    public void createPage() {

        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void tearDown() {

        if (context != null) {
            context.close();
        }

        if (page != null) {
            page.close();
        }
    }
}
