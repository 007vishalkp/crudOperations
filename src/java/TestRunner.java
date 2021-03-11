

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
        features = {"src/features/"},
        glue = "steps",
//        plugin = {"json:target/cucumber-report/cucumber.json"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true,

        tags = "@CRUDoperations"

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
