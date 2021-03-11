package support;

import cucumber.api.java.hu.Ha;

import java.util.HashMap;

/**
 * This class has all the apis in one place in a map structure.
 */
public class ApisCollection {
    private static HashMap<String, String> API_URLS = null;
    private static final String POST_API = "post";
    private static final String GET_API = "get";
    private static final String PUT_API = "put";
    private static final String PATCH_API = "patch";
    private static final String DELETE_API = "delete";


    public static HashMap<String, String> getApiUrl() {
        if (API_URLS != null) {
            return API_URLS;
        }
        API_URLS = new HashMap<>();
        API_URLS.put(ApisCollection.POST_API, "https://jsonplaceholder.typicode.com/posts/");
        API_URLS.put(ApisCollection.GET_API, "https://jsonplaceholder.typicode.com/posts/");
        API_URLS.put(ApisCollection.PUT_API, "https://jsonplaceholder.typicode.com/posts/");
        API_URLS.put(ApisCollection.PATCH_API, "https://jsonplaceholder.typicode.com/posts/1");
        API_URLS.put(ApisCollection.DELETE_API, "https://jsonplaceholder.typicode.com/posts/1");

        return API_URLS;
    }
}
