package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {
    private String name;
    
    @JsonProperty("open_issues_count")
    private int openIssuesCount;
    
    @JsonProperty("stargazers_count")
    private int stargazersCount;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getOpenIssuesCount() { return openIssuesCount; }
    public void setOpenIssuesCount(int openIssuesCount) { this.openIssuesCount = openIssuesCount; }

    public int getStargazersCount() { return stargazersCount; }
    public void setStargazersCount(int stargazersCount) { this.stargazersCount = stargazersCount; }
}
