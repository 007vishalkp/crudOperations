

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//
//@ExtendedCucumberOptions(
//        usageReport = true,
//        detailedReport = true,
//        detailedAggregatedReport = true,
//        overviewReport = true,
//        overviewChartsReport = true,
//        pdfPageSize = "A4 Landscape",
//        toPDF = true,
//        outputFolder = "target/81",
//        retryCount = 3
//)
@CucumberOptions(
        //mvn clean -D'cucumber.options=--glue Steps' -DargLine='-Dplatform="web"' test //for web app
        //mvn clean -D'cucumber.options=--glue Steps_Android' -DargLine='-Dplatform="android"' test //for android app
        features = {"src/features/"},
        glue = "steps",
        plugin = {"json:target/cucumber-report/cucumber.json"},
        monochrome = true,

        tags = "@CRUDoperations"

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
