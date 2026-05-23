package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Khởi tạo thời gian chờ mặc định là 15 giây
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openPageUrl(String url) {
        driver.get(url);
    }
    public WebDriver getBrowserDriver(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        return driver;
    }
    public void closeBrowserDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    // Đợi phần tử hiển thị trên giao diện (Smart Wait)
    public WebElement waitForElementVisible(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public WebElement getElement(String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public void clickToElement(String locator) {
        waitForElementVisible(locator).click();
    }
    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickToElementByJS(String locator) {
    org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", waitForElementVisible(locator));
    }


    public void sendKeyToElement(String locator, String keyToSend) {
        WebElement element = waitForElementVisible(locator);
        element.clear(); // Xóa dữ liệu cũ trước khi nhập
        element.sendKeys(keyToSend);
    }

    public String getElementText(String locator) {
        return waitForElementVisible(locator).getText();
    }
}
