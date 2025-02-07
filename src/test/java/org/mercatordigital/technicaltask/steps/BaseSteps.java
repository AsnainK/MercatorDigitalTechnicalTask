package org.mercatordigital.technicaltask.steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.mercatordigital.technicaltask.utils.ConfigUtils;

public class BaseSteps {

    protected Page page;
    public final ConfigUtils configUtils;

    public BaseSteps(Page page) {
        this.page = page;
        this.configUtils = new ConfigUtils();
    }

    public void navigateTo(String url) {

        page.navigate(url);
    }

    public void assertUrl(String url) {

        PlaywrightAssertions.assertThat(page).hasURL(url);
    }
}
