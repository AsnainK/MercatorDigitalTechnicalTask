package org.mercatordigital.technicaltask.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class InventoryPage extends BasePage{

    private final Locator inventoryItem;
    private final Locator shoppingCartButton;

    public InventoryPage(Page page) {
        super(page);
        this.inventoryItem = page.locator(".inventory_item");
        this.shoppingCartButton = page.locator(".shopping_cart_link");
    }

    public List<Locator> getInventoryItemList() {

        return inventoryItem.all();
    }

    public Locator getItemPrice(Locator item) {

        return item.locator(".inventory_item_price");
    }

    public Locator getAddToCartButton(Locator item) {

        return item.locator(".btn_inventory");
    }

    public Locator getItemName(Locator item) {

        return item.locator(".inventory_item_name");
    }

    public void clickShoppingCartButton() {

        shoppingCartButton.click();
    }
}
