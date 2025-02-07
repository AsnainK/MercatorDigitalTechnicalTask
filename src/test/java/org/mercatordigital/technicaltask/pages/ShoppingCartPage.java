package org.mercatordigital.technicaltask.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class ShoppingCartPage extends BasePage{

    private final Locator itemInCartName;

    public ShoppingCartPage(Page page) {
        super(page);
        this.itemInCartName = page.locator(".inventory_item_name");
    }

    public List<String> getCartItemsNamesList() {

        return itemInCartName.allInnerTexts();
    }
}
