package org.mercatordigital.technicaltask.tests;

import org.mercatordigital.technicaltask.hooks.WebHooks;
import org.mercatordigital.technicaltask.steps.HomePageSteps;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

public class QaTechnicalTaskTests extends WebHooks {

    @Test
    @Description("Add Highest Priced Item From The Inventory To Cart And Verify")
    public void addHighestPriceItemTest(){

        new HomePageSteps(page).navigateToHomePage()
                .logInToHomePage()
                .addHighestPriceItemToCart()
                .clickShoppingCartButton()
                .assertShoppingCartItems();
    }
}
