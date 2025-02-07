package org.mercatordigital.technicaltask.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage{

    private final Locator usernameTextBox;
    private final Locator passwordTextBox;
    private final Locator loginButton;

    public HomePage(Page page) {
        super(page);
        this.usernameTextBox = page.locator("#user-name");
        this.passwordTextBox = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public void enterUserName(String username) { usernameTextBox.fill(username); }

    public void enterPassword(String password) { passwordTextBox.fill(password); }

    public void clickLogIn() { loginButton.click(); }

}
