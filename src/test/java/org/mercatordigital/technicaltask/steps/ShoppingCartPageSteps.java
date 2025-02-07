package org.mercatordigital.technicaltask.steps;

import org.mercatordigital.technicaltask.pages.ShoppingCartPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ShoppingCartPageSteps extends BaseSteps{

    private final ShoppingCartPage shoppingCartPage;
    private final List<String> expectedItems;

    public ShoppingCartPageSteps(Page page, List<String> itemsInShoppingCart) {
        super(page);
        this.shoppingCartPage = new ShoppingCartPage(page);
        this.expectedItems = itemsInShoppingCart;
    }

    @Step("Verify expected items exist in the cart")
    public void assertShoppingCartItems() {

        Assertions.assertTrue(shoppingCartPage.getCartItemsNamesList().containsAll(expectedItems),
                "Some expected items were not found in the cart");
    }
}
