package interface_adapter.FirstPage;

import interface_adapter.ViewModel;
import use_case.FetchNews.NewsOutputBoundary;
import use_case.FetchNews.NewsOutputData;
import use_case.FetchNews.NewsInteractor;

import java.util.List;

public class FirstPageViewModel extends ViewModel implements NewsOutputBoundary {
    private NewsInteractor newsInteractor;
    public static final String TITLE_LABEL = "Trending Articles and News";

    public FirstPageViewModel() {
        super("Articles");
        this.newsInteractor = new NewsInteractor(this);
    }
    public void fetchNews() {
        newsInteractor.fetchNews();
    }

    @Override
    public void presentNews(List<NewsOutputData> newsList) {

    }
}

