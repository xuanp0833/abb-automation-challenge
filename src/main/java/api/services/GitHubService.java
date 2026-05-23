package api.services;

import api.common.BaseAPI;
import api.models.Repository;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GitHubService extends BaseAPI {

    public List<Repository> getAllRepositories(String orgName) {
        List<Repository> allRepos = new ArrayList<>();
        int page = 1;
        int perPage = 100;

        while (true) {
            Response response = RestAssured.given()
                    .spec(getRequestSpec())
                    .queryParam("per_page", perPage)
                    .queryParam("page", page)
                    .when()
                    .get("/orgs/" + orgName + "/repos")
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

            Repository[] repos = response.as(Repository[].class);

            if (repos.length == 0) {
                break;
            }

            allRepos.addAll(Arrays.asList(repos));
            page++;
        }

        return allRepos;
    }
}
