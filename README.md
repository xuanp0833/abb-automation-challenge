# Quality Engineer (Automation) - Development Challenge

Dự án Automation Test hoàn chỉnh bao gồm cả UI Automation Testing (Selenium WebDriver) và API Automation Testing (RestAssured) sử dụng ngôn ngữ Java và TestNG framework theo mô hình Page Object Model (POM) và Service Object Model.

## 🛠️ Yêu cầu môi trường (Prerequisites)
- **Java JDK**: Phiên bản 17 (hoặc cao hơn).
- **Maven**: Phiên bản 3.6.0 hoặc cao hơn.
- **Trình duyệt**: Google Chrome (phiên bản mới nhất).

## 🚀 Hướng dẫn cài đặt & chạy thử (Setup & Execution)

### 1. Tải dự án và cài đặt thư viện
Mở thư mục dự án trên Terminal và chạy lệnh sau để tải toàn bộ thư viện cần thiết:
```bash
mvn clean compile
```
### 2. Chạy toàn bộ Test Suite (Cả UI & API Tests)
Mở thư mục dự án trên Terminal và chạy lệnh sau để tải toàn bộ thư viện cần thiết:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```
### 3. Hướng dẫn chạy riêng từng bài kiểm thử
Chạy riêng UI Test (Bài 1 - OrangeHRM):
```bash
mvn test -Dtest=LoginTest
```
Chạy riêng API Test (Bài 2 - GitHub API):
```bash
    mvn test -Dtest=GitHubAPITest
```