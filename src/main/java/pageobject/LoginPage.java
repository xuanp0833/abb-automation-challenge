package pageobject;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.LoginPageUI; // Import lớp chứa locators

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Nhập Email sử dụng locator từ LoginPageUI
    public void enterEmail(String email) {
        sendKeyToElement(LoginPageUI.EMAIL_INPUT, email);
    }

    // Nhập Password sử dụng locator từ LoginPageUI
    public void enterPassword(String password) {
        sendKeyToElement(LoginPageUI.PASSWORD_INPUT, password);
    }

    // Click nút Login
    public void clickLoginButton() {
        clickToElement(LoginPageUI.LOGIN_BUTTON);
    }

    // Thực hiện luồng Login hoàn chỉnh
    public void loginToSystem(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    // Lấy thông báo lỗi
    // public String getErrorMessageText() {
    //     return getElementText(LoginPageUI.ERROR_MESSAGE);
    // }
}
