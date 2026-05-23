package tests;

import api.models.Repository;
import api.services.GitHubService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class GitHubAPITest {
    private GitHubService gitHubService;
    private final String ORG_NAME = "SeleniumHQ";

    @BeforeClass
    public void setUp() {
        gitHubService = new GitHubService();
    }

    @Test(description = "Phân tích repositories của SeleniumHQ qua GitHub REST API")
    public void TC_01_Analyze_SeleniumHQ_Repositories() {
        List<Repository> repositories = gitHubService.getAllRepositories(ORG_NAME);
        
        Assert.assertNotNull(repositories, "Danh sách repositories trả về bị null!");
        Assert.assertFalse(repositories.isEmpty(), "Tổ chức " + ORG_NAME + " không có repository nào!");

        System.out.println("\n====== KẾT QUẢ PHÂN TÍCH GITHUB API (ORGANIZATION: " + ORG_NAME + ") ======");
        System.out.println("Tổng số Repositories tìm thấy: " + repositories.size());

        int totalOpenIssues = 0;
        Repository highestRatedRepo = null;

        for (Repository repo : repositories) {
            totalOpenIssues += repo.getOpenIssuesCount();

            if (highestRatedRepo == null || repo.getStargazersCount() > highestRatedRepo.getStargazersCount()) {
                highestRatedRepo = repo;
            }
        }

        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. Tổng số OPEN ISSUES trên tất cả repositories: " + totalOpenIssues);
        if (highestRatedRepo != null) {
            System.out.println("2. Repository được đánh giá cao nhất (Nhiều STARS nhất):");
            System.out.println("   - Tên Repository: " + highestRatedRepo.getName());
            System.out.println("   - Số lượng Stars: " + highestRatedRepo.getStargazersCount());
            System.out.println("   - Số lượng Open Issues hiện tại: " + highestRatedRepo.getOpenIssuesCount());
        }
        System.out.println("===================================================================\n");

        Assert.assertTrue(totalOpenIssues > 0, "Lỗi: Tổng số open issues phải lớn hơn 0!");
        Assert.assertNotNull(highestRatedRepo, "Lỗi: Không xác định được repository nhiều stars nhất!");
    }
}
