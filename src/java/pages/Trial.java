package pages;

public class Trial {
    public static void main(String[] args) throws Exception {
        ApiCalls apiCalls = new ApiCalls();
        for (int i = 1; i <= 10; i++) {
            System.out.println("--------------------------------------------------------------------------");
            //Login
//            apiCalls.login();//Uses POST done
            //Signup
            apiCalls.signup();//Uses POST done
            //Enroll //Uses PATCH
            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/60662?device_type=4");//free discussions course done
//            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/65180?device_type=4");//free discussion mock test
//            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/65181?device_type=4");// free discussion test series
//            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/60866?device_type=4");// free mock test
//            apiCalls.enroll("https://api.learnyst.com/learner/v10/courses/65857?device_type=4");// for api automation mock test
            //Discussions
//            apiCalls.writeDiscussion();//Uses POST
//            apiCalls.writeBookmark();
            //Take test
//            apiCalls.takeAndSubmitTest();
//            apiCalls.getAllProducts();
            System.out.println("---------------------Completed api calls for: " + i + " times---------------------");
        }
    }
}
