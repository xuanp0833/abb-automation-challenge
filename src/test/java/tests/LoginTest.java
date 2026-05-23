package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import pageobject.DashboardPage;
import pageobject.UserPage;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private UserPage userPage;
    
    private final String APP_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private String newUsername;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Khởi tạo các đối tượng trang (Page Objects)
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        userPage = new UserPage(driver);
        
        // Bước 1: Mở ứng dụng theo đường dẫn URL
        loginPage.openPageUrl(APP_URL);
    }

    @Test(description = "Thực hiện luồng tạo mới và tìm kiếm User hoàn chỉnh theo đề bài")
    public void TC_01_Create_And_Verify_New_User() {
        // Nguyên tắc Test Data độc nhất: sinh tên tài khoản ngẫu nhiên để tránh lỗi trùng lặp khi chạy nhiều lần
        newUsername = "auto_user_" + System.currentTimeMillis();
        String password = "SecurePassword123@";

        // Bước 2: Đăng nhập thành công với tài khoản hiển thị sẵn trên web
        loginPage.loginToSystem("Admin", "admin123");

        // Bước 3: Điều hướng tới mục Admin -> User Management
        dashboardPage.clickToAdminMenu();

        // Bước 4: Tạo một user mới và nhập toàn bộ các trường bắt buộc
        userPage.clickToAddButton();
        userPage.selectUserRoleAdmin();
        
        // Nhập chữ cái gợi ý là "a" và tự động chọn nhân viên được gợi ý đầu tiên
        userPage.enterAndSelectEmployeeName("Ranga  Akunuri");
        
        userPage.selectStatusEnabled();
        userPage.enterUsername(newUsername);
        userPage.enterPasswordAndConfirm(password);
        userPage.clickSaveButton();

        // Bước 5: Kiểm tra xem User đã được tạo thành công hay chưa
        Assert.assertTrue(userPage.isUserCreatedSuccessfully(), "Lỗi: Tạo mới User không thành công!");

        // Chờ 3 giây để hệ thống lưu vào DB và chuyển hướng (Redirect) hoàn toàn về trang Danh sách! (Rất quan trọng!)
        userPage.sleepInSecond(3);

        // Bước 6: Nhập username vừa tạo vào ô tìm kiếm và bấm nút Search
        userPage.searchUserByUsername(newUsername);
        
        // Chờ 2 giây để bảng cập nhật kết quả tìm kiếm mới
        userPage.sleepInSecond(2);

        // Bước 7: Xác thực user hiển thị chính xác trong bảng kết quả (Records Found)
        String actualUsername = userPage.getFirstRowUsernameText();
        Assert.assertEquals(actualUsername, newUsername, "Lỗi: Tìm kiếm không khớp, Username không tồn tại trong bảng!");


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
