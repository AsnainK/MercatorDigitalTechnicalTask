package org.mercatordigital.technicaltask.hooks;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHooks {

    private static BrowserContext context;
    public Page page;

    @BeforeAll
    public static void initialisePlaywright() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
    }

    @BeforeEach
    public void createPage() {

        page = context.newPage();
    }
}
