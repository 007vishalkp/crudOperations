package pages;

public class Trial {
    public static void main(String[] args) throws Exception {

        ApiMethods apiMethods = new ApiMethods();
        for (int i = 1; i <= 1; i++) {
            System.out.println("--------------------------------------------------------------------------");
            //Login
//            apiCalls.login();//Uses POST done
            //Signup
            apiMethods.getMethodCall("https://jsonplaceholder.typicode.com/posts/");
            apiMethods.postMethodCall("https://jsonplaceholder.typicode.com/posts/", "{\"userId\": 1,\"id\": 1,\"title\": \"wassup\"}");
            apiMethods.patchMethodCall("https://jsonplaceholder.typicode.com/posts/1", "{\"userId\": 200,\"id\": 1,\"title\": \"wassup\"}");
//            apiMethods.putMethodCall("https://jsonplaceholder.typicode.com/posts/1", "{\"userId\": 200,\"id\": 1,\"title\": \"wassup\"}");
            apiMethods.deleteMethodCall("https://jsonplaceholder.typicode.com/posts/1");

//            apiCalls.signup();//Uses POST done
//            //Enroll //Uses PATCH
//            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/60662?device_type=4");//free discussions course done
////            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/65180?device_type=4");//free discussion mock test
////            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/65181?device_type=4");// free discussion test series
////            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/60866?device_type=4");// free mock test
////            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/65857?device_type=4");// for api automation mock test
//            //Discussions
////            apiCalls.writeDiscussion();//Uses POST
////            apiCalls.writeBookmark();
//            //Take test
////            apiCalls.takeAndSubmitTest();
////            apiCalls.getAllProducts();
            System.out.println("---------------------Completed api calls for: " + i + " times---------------------");
        }
    }
}
