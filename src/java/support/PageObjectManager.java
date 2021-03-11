package support;

import org.openqa.selenium.support.PageFactory;
import pages.ApiMethods;

public class PageObjectManager {
    private static PageObjectManager pageObjectManager = null;
    private ApiMethods apiMethods = null;

    public static PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    public ApiMethods getApiMethods() {
        if (apiMethods == null) {
            apiMethods = new ApiMethods();
        }
        return apiMethods;
    }
}
