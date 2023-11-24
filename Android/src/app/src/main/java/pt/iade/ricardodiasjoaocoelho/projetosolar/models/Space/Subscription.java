package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space;

import android.graphics.drawable.Icon;
import android.media.Image;

public class Subscription {
    private String id;
    private String spaceId;
    private String userId;
    private String title;
    private Icon subIcon;
    private String locationAccessId;


    public Subscription(String id, String userId) {
        this.id = id;
        this.userId = userId;

        if(userId == "1") {
            if (id == "1"){
                title = "All Day, Every Day";
                spaceId = "1";
            } else if (id == "2"){
                title = "One time a month";
                spaceId = "2";
            }
        }
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getSpaceId() {
        return spaceId;
    }
    public String getUserId() {
        return userId;
    }

    public Icon getImage() {
        return subIcon;
    }
}
