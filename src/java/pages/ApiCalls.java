package pages;

import pages.ApiMethods;
import support.Config;

import java.io.IOException;

public class ApiCalls {
    private ApiMethods apiMethods = new ApiMethods();
    private String json = "";

    //It uses POST method
    public void login() throws IOException {
        System.out.print("\nFor login: ");
        json = "{\"school_id\":23698,\"device_type\":4,\"device_id\":\"web-123456\",\"email\":\"lessonplayer@yopmail.com\",\"password\":\"learnyst\",\"username\":null}";
        apiMethods.postMethodCall("https://api.learnyst.com/learner/v4/login?device_type=4", json);//For login
    }

    //It uses POST method
    public void signup() throws IOException {
        System.out.print("\nFor Signup: ");
        json = "{\"user\":{\"school_id\":23698,\"device_type\":4,\"device_id\":\"web-123456\",\"email\":\"" + Config.randomEmail(Config.SIGNUP_EMAIL_LENGTH) + "\",\"password\":\"learnyst\",\"username\":null},\"device_type\":4}";
        apiMethods.postMethodCall("https://api.learnyst.com/learner/v4/signup?device_type=4", json);//For signup
    }

    //It uses PATCH method
    public void enroll(String apiWithCourseId) throws IOException {
        System.out.print("\nFor enroll: ");
        json = "{\"is_enrolled\":true,\"is_from_classroom\":true,\"school_id\":23698,\"device_type\":4}";
        apiMethods.patchMethodCall(apiWithCourseId, json);//calling enroll api
    }

    //It uses POST method
    public void writeDiscussion() throws IOException {
        String discussionText = "Hi, This discussion is posted through api automation";
        System.out.print("\nFor discussions: ");
        //Discussion course
        json = "{\"attachment_url\":null,\"course_id\":\"60662\",\"discussion_link\":\"/learn/null/Discussions-review-bookmark-course/94500/482887?link:0:0:avengers_lyst1920.mp4\",\"message\":\"" + discussionText + "\\n\",\"tag\":\"Free learnyst video (Attachments)\",\"title\":\"Discussions, Reviews and bookmark course\",\"lesson_id\":482887,\"school_id\":23698,\"device_type\":4}";
        apiMethods.postMethodCall("https://api.learnyst.com/learner/v6/discussion_boards?device_type=4", json);
        //Discussion mocktest
//        json = "{\"attachment_url\":null,\"course_id\":\"65180\",\"discussion_link\":\"/learn/null/Discussion--Reviews-and-Bookmark-mock-test\",\"message\":\"" + discussionText + "\",\"tag\":\"Discussion, Reviews and Bookmark mock test\",\"title\":\"Discussion, Reviews and Bookmark mock test\",\"school_id\":23698,\"device_type\":4}";
//        apiMethods.postMethodCall("https://api.learnyst.com/learner/v6/discussion_boards?device_type=4", json);
//        //Discussion test series
//        json = "{\"attachment_url\":null,\"course_id\":\"65181\",\"discussion_link\":\"/learn/null/Discussion--Reviews-and-Bookmark-test-series/104878/535883?link:0:0:\",\"message\":\""+discussionText+"\",\"tag\":null,\"title\":\"Discussion, Reviews and Bookmark test series\",\"lesson_id\":535883,\"school_id\":23698,\"device_type\":4}";
//        apiMethods.postMethodCall("https://api.learnyst.com/learner/v6/discussion_boards?device_type=4", json);
    }

    public void takeAndSubmitTest() throws IOException {
        System.out.print("\nFor for test: ");
        apiMethods.getMethodCall("https://api.learnyst.com/learner/v8/quiz/93830?device_type=4");//take test in dash board
        json = "{\"quiz_id\":93830,\"device_type\":4}";
        apiMethods.postMethodCall("https://api.learnyst.com/learner/v8/user_quiz?device_type=4", json);//start test from instructions page
        json = "{\"answers\":{\"4213812\":{\"answer\":1,\"time_spent\":48.908,\"questionStatus\":3,\"mark\":0},\"4213814\":{\"answer\":2,\"time_spent\":3.374,\"questionStatus\":3,\"mark\":0},\"4213815\":{\"answer\":0,\"time_spent\":11.328,\"questionStatus\":3,\"mark\":0}},\"quiz_id\":93830,\"quiz_section_id\":null,\"device_type\":4}";
        apiMethods.patchMethodCall("https://api.learnyst.com/learner/v8/user_quiz/" + apiMethods.getUserQuizId() + "?device_type=4", json);//For quiz submit
    }

    public void getAllProducts() throws IOException {
        System.out.print("\nChecking products present: ");
        apiMethods.getAllProducts();//To check if enrolled or not
    }

    public void adminLogin() {

    }

    public void writeBookmark() throws IOException {
        String bookmarkText = "Hi, This bookmark is posted through api automation";
        System.out.print("\nFor bookmarks: ");
        //Discussion course
        json = "{\"lesson_id\":482887,\"section_id\":94500,\"course_id\":\"60662\",\"note_type\":0,\"product_type\":0,\"link\":\"/learn/Discussions-review-bookmark-course/94500/482887?link:0:0:avengers_lyst1920.mp4\",\"notes\":\"" + bookmarkText + "\",\"tag\":\"Free learnyst video (Attachments)\",\"content_type\":1,\"device_type\":4}";
        apiMethods.postMethodCall("https://api.learnyst.com/learner/v9/notebooks?device_type=4", json);
    }

}
