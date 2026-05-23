package pageobject;

import common.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import pageui.UserPageUI;

public class UserPage extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    // Click nút Add User
    public void clickToAddButton() {
        clickToElement(UserPageUI.ADD_BUTTON);
    }

    // Chọn User Role là Admin
    public void selectUserRoleAdmin() {
        clickToElement(UserPageUI.USER_ROLE_DROPDOWN);
        clickToElement(UserPageUI.USER_ROLE_ADMIN_OPTION);
    }

    // Nhập tên nhân viên và tự động chọn gợi ý đầu tiên hiển thị
    // public void enterAndSelectEmployeeName(String employeeNamePart) {
    //     sendKeyToElement(UserPageUI.EMPLOYEE_NAME_INPUT, employeeNamePart);
    //     sleepInSecond(1000);
    //     // Đợi menu gợi ý hiển thị và click lựa chọn đầu tiên
    //      waitForElementVisible(UserPageUI.EMPLOYEE_NAME_FIRST_SUGGESTION);
    //      clickToElementByJS(UserPageUI.EMPLOYEE_NAME_FIRST_SUGGESTION);
    // }
    public void enterAndSelectEmployeeName(String employeeNamePart) {
        // 1. Click vào ô input trước để đảm bảo kích hoạt Focus của Vue.js
        clickToElement(UserPageUI.EMPLOYEE_NAME_INPUT);
        
        // 2. Nhập từ khóa ngắn (Ví dụ: "Ranga")
        sendKeyToElement(UserPageUI.EMPLOYEE_NAME_INPUT, employeeNamePart);
        
        // 3. Chờ hẳn 2 giây để API load xong và dropdown chạy xong hiệu ứng xuất hiện (Rất quan trọng!)
        sleepInSecond(2);
        
        // 4. Sử dụng bộ đợi Explicit Wait để đợi phần tử gợi ý thực sự sẵn sàng nhận click (Clickable)
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = explicitWait.until(
            ExpectedConditions.elementToBeClickable(By.xpath(UserPageUI.EMPLOYEE_NAME_FIRST_SUGGESTION))
        );
        
        // 5. Rê chuột vật lý và click chọn option
        Actions actions = new Actions(driver);
        actions.moveToElement(option).click().perform();
    }

    // Chọn Status là Enabled
    public void selectStatusEnabled() {
        clickToElement(UserPageUI.STATUS_DROPDOWN);
        clickToElement(UserPageUI.STATUS_ENABLED_OPTION);
    }

    // Nhập Username mới
    public void enterUsername(String username) {
        sendKeyToElement(UserPageUI.USERNAME_INPUT, username);
    }

    // Nhập Password và Confirm Password
    public void enterPasswordAndConfirm(String password) {
        sendKeyToElement(UserPageUI.PASSWORD_INPUT, password);
        sendKeyToElement(UserPageUI.CONFIRM_PASSWORD_INPUT, password);
    }

    // Click Save để tạo mới User
    public void clickSaveButton() {
        clickToElement(UserPageUI.SAVE_BUTTON);
    }

    // Kiểm tra xem User đã được tạo thành công chưa (thông qua Toast Message hiển thị)
    public boolean isUserCreatedSuccessfully() {
        return waitForElementVisible(UserPageUI.SUCCESS_TOAST).isDisplayed();
    }

    // Tìm kiếm User theo Username
    public void searchUserByUsername(String username) {
        sendKeyToElement(UserPageUI.SEARCH_USERNAME_INPUT, username);
        clickToElement(UserPageUI.SEARCH_BUTTON);
    }

    // Lấy tên Username hiển thị ở dòng đầu tiên của bảng kết quả
    public String getFirstRowUsernameText() {
        return getElementText(UserPageUI.FIRST_ROW_USERNAME);
    }
}
