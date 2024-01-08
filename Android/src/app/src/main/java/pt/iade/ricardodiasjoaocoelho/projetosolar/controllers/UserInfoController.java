package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import android.util.Log;

import com.google.gson.Gson;

import java.net.URL;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.UserInfo;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.AuthChangeUserString;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.ChangeUserString;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Id;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class UserInfoController {

    private static final String BASE_URL = WebRequest.LOCALHOST + "/users";

    public static void getUserInfo(int userId, ReturnUserInfo returnUserInfo) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/getUser"));
                        Log.i("WebRequest", "Post made to API: RSVP to event");
                        Id id = new Id(userId);
                        String response = req.performPostRequest(id);
                        UserInfo user = new Gson().fromJson(response, UserInfo.class);
                        returnUserInfo.response(user);
                    } catch (Exception e) {
                        Log.e("TodoItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void changePassword(int userId, String oldPassword, String newPassword, ReturnErrorAndId returnUserInfo) {
        AuthChangeUserString body = new AuthChangeUserString(userId, oldPassword, newPassword);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/change/password"));
                        Log.i("WebRequest", "Post made to API: RSVP to event");
                        String response = req.performPostRequest(body);
                        IdAndErrorResponse idOrResponse = new Gson().fromJson(response, IdAndErrorResponse.class);
                        returnUserInfo.response(idOrResponse);
                    } catch (Exception e) {
                        Log.e("TodoItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void changeUserName(int userId, String newUserName, ReturnErrorAndId returnUserInfo) {
        ChangeUserString body = new ChangeUserString(userId, newUserName);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                BASE_URL + "/change/name"));
                        Log.i("WebRequest", "Post made to API: RSVP to event");
                        String response = req.performPostRequest(body);
                        IdAndErrorResponse idOrError = new Gson().fromJson(response, IdAndErrorResponse.class);
                        returnUserInfo.response(idOrError);
                    } catch (Exception e) {
                        Log.e("TodoItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public interface ReturnUserInfo {
        void response(UserInfo user);
    }

    public interface ReturnErrorAndId {
        void response(IdAndErrorResponse response);
    }
}
