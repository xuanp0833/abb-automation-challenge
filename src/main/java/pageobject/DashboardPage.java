package pageobject;

// import common.BasePage;
// import org.openqa.selenium.WebDriver;

// public class DashboardPage extends BasePage {

//     // public DashboardPage(WebDriver driver) {
//     //     super(driver);
//     // }

//     // // Ví dụ kiểm tra xem đã chuyển trang thành công chưa
//     // public boolean isDashboardHeaderDisplayed() {
//     //     // Ví dụ: return getElement(DashboardUI.HEADER).isDisplayed();
//     //     return true; 
//     // }
// }

import common.BasePage;
import org.openqa.selenium.WebDriver;
import pageui.DashboardPageUI;
public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    // Bước 3: Điều hướng tới mục Admin
    public void clickToAdminMenu() {
        clickToElement(DashboardPageUI.ADMIN_MENU);
    }
}
