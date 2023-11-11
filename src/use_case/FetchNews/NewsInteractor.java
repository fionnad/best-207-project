package use_case.FetchNews;

import java.util.ArrayList;
import java.util.List;

public class NewsInteractor implements NewsInputBoundary {
    private NewsOutputBoundary outputBoundary;

    public NewsInteractor(NewsOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void fetchNews() {
        // TODO: Call an API
        List<NewsOutputData> newsList = new ArrayList<>();
        outputBoundary.presentNews(newsList);
    }
}