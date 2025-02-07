package org.mercatordigital.technicaltask.steps;

import org.mercatordigital.technicaltask.pages.InventoryPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class InventoryPageSteps extends BaseSteps{

    private final InventoryPage inventoryPage;
    private final List<String> itemsInShoppingCart = new ArrayList<>();

    public InventoryPageSteps(Page page) {
        super(page);
        this.inventoryPage = new InventoryPage(page);
    }

    @Step("Add the highest priced item from the inventory to cart")
    public InventoryPageSteps addHighestPriceItemToCart() {

       String highestPriceItem = inventoryPage.getInventoryItemList()
               .stream()
               .max((item1, item2) -> {
                   double price1 = Double.parseDouble(inventoryPage.getItemPrice(item1).innerText().replace("$",""));
                   double price2 = Double.parseDouble(inventoryPage.getItemPrice(item2).innerText().replace("$",""));
                   return Double.compare(price1, price2); })
               .map( item -> {
                   inventoryPage.getAddToCartButton(item).click();
                   return inventoryPage.getItemName(item).innerText(); })
               .orElseThrow();

       itemsInShoppingCart.add(highestPriceItem);
       return this;
    }

    @Step("Click the shopping cart button")
    public ShoppingCartPageSteps clickShoppingCartButton() {

        inventoryPage.clickShoppingCartButton();
        return new ShoppingCartPageSteps(page, itemsInShoppingCart);
    }
}
