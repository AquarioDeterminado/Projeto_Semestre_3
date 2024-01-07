package pt.iade.ricardodiasjoaocoelho.projetosolar.controllers;

import java.net.URL;
import java.util.ArrayList;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event.Event;
import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;
import pt.iade.ricardodiasjoaocoelho.projetosolar.utils.WebRequest;

public class EventController {

    public static ArrayList<Event> getCurrentEvents(User_Info user)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        // This is a brand new object and must be a INSERT in the database.
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/saveNote/"));
                        Log.i("WebRequest", "Post made to API:" + newNote.toString());
                        String response = req.performPostRequest(newNote);

                        // Get the new ID from the server's response.
                        NoteItem respItem = new Gson().fromJson(response, NoteItem.class);
                        returnNote.response(respItem);

                    } catch (Exception e) {
                        Log.e("TodoItem", e.toString());
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
