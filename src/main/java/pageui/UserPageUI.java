package pageui;

public class UserPageUI {
    // ---- TRANG DANH SÁCH USER (SYSTEM USERS) ----
    public static final String ADD_BUTTON = "//button[contains(.,'Add')]";
    public static final String SEARCH_USERNAME_INPUT = "//label[text()='Username']/parent::div/following-sibling::div//input";
    public static final String SEARCH_BUTTON = "//button[@type='submit' and contains(.,'Search')]";
    public static final String FIRST_ROW_USERNAME = "//div[@class='oxd-table-card']//div[@role='row']/div[2]";
    
    // ---- TRANG TẠO MỚI USER (ADD USER) ----
    public static final String USER_ROLE_DROPDOWN = "//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String USER_ROLE_ADMIN_OPTION = "//div[@role='listbox']//span[text()='Admin']";
    
    // Ô gợi ý tên nhân viên (Auto-complete)
    public static final String EMPLOYEE_NAME_INPUT = "//label[text()='Employee Name']/parent::div/following-sibling::div//input";
    public static final String EMPLOYEE_NAME_FIRST_SUGGESTION = "//div[@role='listbox']//div[@role='option']";
    
    public static final String STATUS_DROPDOWN = "//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String STATUS_ENABLED_OPTION = "//div[@role='listbox']//span[text()='Enabled']";
    
    public static final String USERNAME_INPUT = "//label[text()='Username']/parent::div/following-sibling::div//input";
    
    public static final String PASSWORD_INPUT = "//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='password']";
    public static final String CONFIRM_PASSWORD_INPUT = "//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='password']";
    
    public static final String SAVE_BUTTON = "//button[contains(.,'Save')]";
    
    // Thông báo Toast thành công khi lưu thành công
    public static final String SUCCESS_TOAST = "//p[contains(@class, 'oxd-text--toast-message') and text()='Successfully Saved']";
}
