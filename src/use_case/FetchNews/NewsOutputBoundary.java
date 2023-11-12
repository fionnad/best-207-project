package use_case.FetchNews;

import java.util.List;

public interface NewsOutputBoundary {
    void presentNews(List<NewsOutputData> newsList);
}