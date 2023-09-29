Algorithmic Prediction Application

This Algorithmic Prediction App will focus in the domain of Finance, and it analyses companies in the New York Stock Exchange and Hong Kong Stock Exchange to predict which companies could see the highest stock price jump within an hourly, daily, weekly and monthly window.

The first page of the application will be a summary page.
- At the top, the user will be able to choose which time frame to work in (hourly, weekly, etc.).
- Below this, the user will be able to see the stocks that the application predicts will grow within this time period. The user can also see the current stock price and predicted price.

The second page of the application will be an analysis page.
- At the top, the user will once again be able to choose which time frame to view.
- Below this, the summarised stocks from the previous page will appear, with an in depth analysis of what the prediction app found. It will be based on some financial models and ratios, such as Equity to Debt Ratios, Price to Earnings Ratios, EBITDA to Asset ratios, and much more.

The third page is a settings page.
- The user can choose what settings to view. In particular, which stock exchange to analyse, and other features.

We will be using this API for our application:

https://rapidapi.com/sparior/api/yahoo-finance15

We will be using Insomnia to make API Requests. Here is a screenshot of us doing so:

![Insomnia API Requests](https://github.com/fionnad/best-207-project/assets/144710186/2d8a515e-de82-4847-8d5c-45d75156ddd3)

As shown below, our current output is a JSON with information pulled from the Apple Stock. The information on Apple was pulled on Friday, 29 September, and is shown below:

{

    "financialData": {
        "maxAge": 86400,
        "currentPrice": {
            "raw": 171.21,
            "fmt": "171.21"
        },
        "targetHighPrice": {
            "raw": 240,
            "fmt": "240.00"
        },
        "targetLowPrice": {
            "raw": 149,
            "fmt": "149.00"
        },
        "targetMeanPrice": {
            "raw": 199.58,
            "fmt": "199.58"
        },
        "targetMedianPrice": {
            "raw": 200,
            "fmt": "200.00"
        },
        "recommendationMean": {
            "raw": 2,
            "fmt": "2.00"
        },
        "recommendationKey": "buy",
        "numberOfAnalystOpinions": {
            "raw": 37,
            "fmt": "37",
            "longFmt": "37"
        },
        "totalCash": {
            "raw": 62482001920,
            "fmt": "62.48B",
            "longFmt": "62,482,001,920"
        },
        "totalCashPerShare": {
            "raw": 3.996,
            "fmt": "4"
        },
        "ebitda": {
            "raw": 123957002240,
            "fmt": "123.96B",
            "longFmt": "123,957,002,240"
        },
        "totalDebt": {
            "raw": 109280002048,
            "fmt": "109.28B",
            "longFmt": "109,280,002,048"
        },
        "quickRatio": {
            "raw": 0.814,
            "fmt": "0.81"
        },
        "currentRatio": {
            "raw": 0.982,
            "fmt": "0.98"
        },
        "totalRevenue": {
            "raw": 383932989440,
            "fmt": "383.93B",
            "longFmt": "383,932,989,440"
        },
        "debtToEquity": {
            "raw": 181.305,
            "fmt": "181.30%"
        },
        "revenuePerShare": {
            "raw": 24.22,
            "fmt": "24.22"
        },
        "returnOnAssets": {
            "raw": 0.20896,
            "fmt": "20.90%"
        },
        "returnOnEquity": {
            "raw": 1.60093,
            "fmt": "160.09%"
        },
        "grossProfits": {
            "raw": 170782000000,
            "fmt": "170.78B",
            "longFmt": "170,782,000,000"
        },
        "freeCashflow": {
            "raw": 90680500224,
            "fmt": "90.68B",
            "longFmt": "90,680,500,224"
        },
        "operatingCashflow": {
            "raw": 113071996928,
            "fmt": "113.07B",
            "longFmt": "113,071,996,928"
        },
        "earningsGrowth": {
            "raw": 0.05,
            "fmt": "5.00%"
        },
        "revenueGrowth": {
            "raw": -0.014,
            "fmt": "-1.40%"
        },
        "grossMargins": {
            "raw": 0.43449003,
            "fmt": "43.45%"
        },
        "ebitdaMargins": {
            "raw": 0.32286,
            "fmt": "32.29%"
        },
        "operatingMargins": {
            "raw": 0.29231,
            "fmt": "29.23%"
        },
        "profitMargins": {
            "raw": 0.24681,
            "fmt": "24.68%"
        },
        "financialCurrency": "USD"
    }
}
