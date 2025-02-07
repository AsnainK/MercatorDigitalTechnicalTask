package org.mercatordigital.technicaltask.steps;

import org.mercatordigital.technicaltask.pages.HomePage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePageSteps extends BaseSteps{

    private final HomePage homePage;

    public HomePageSteps(Page page) {
        super(page);
        this.homePage = new HomePage(page);
    }

    @Step("Navigate to the home page")
    public HomePageSteps navigateToHomePage() {

        navigateTo(configUtils.getProperty("base.url"));
        return this;
    }

    @Step("Log in to the home page")
    public InventoryPageSteps logInToHomePage() {

        String inventoryPageUrl = configUtils.getProperty("base.url") + "/inventory.html";

        homePage.enterUserName(configUtils.getProperty("username"));
        homePage.enterPassword(configUtils.getProperty("password"));
        homePage.clickLogIn();
        assertUrl(inventoryPageUrl);

        return new InventoryPageSteps(page);
    }
}
