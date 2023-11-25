package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space;

import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class Subscription implements Parcelable {
    private String id;
    private Space space;
    private User_Info user;
    private String title;
    private Icon subIcon;
    private String locationAccessId;


    public Subscription(String id, User_Info user) {
        this.id = id;
        this.user = user;
        String userId = user.getId();

        if(userId == "1") {
            if (id == "1"){
                title = "All Day, Every Day";
                space = new Space("1");
            } else if (id == "2"){
                title = "One time a month";
                space = new Space("2");
            }
        }
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Space getSpace() {
        return space;
    }
    public User_Info getUser() {
        return user;
    }

    public Icon getImage() {
        return subIcon;
    }

    /* --- Parcelable --- */
    @Override
    public int describeContents() {
        return 0;
    }

    protected Subscription(Parcel in) {
        id = in.readString();
        space = in.readParcelable(Space.class.getClassLoader());
        user = in.readParcelable(User_Info.class.getClassLoader());
        title = in.readString();
        subIcon = in.readParcelable(Icon.class.getClassLoader());
        locationAccessId = in.readString();
    }

    public static final Creator<Subscription> CREATOR = new Creator<Subscription>() {
        @Override
        public Subscription createFromParcel(Parcel in) {
            return new Subscription(in);
        }

        @Override
        public Subscription[] newArray(int size) {
            return new Subscription[size];
        }
    };

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(space, 0);
        dest.writeParcelable(user, 0);
        dest.writeString(title);
        dest.writeParcelable(subIcon, 0);
        dest.writeString(locationAccessId)  ;
    }
}
