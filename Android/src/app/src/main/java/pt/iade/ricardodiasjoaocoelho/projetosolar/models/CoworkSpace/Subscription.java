package pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace;

import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.time.Instant;
import java.util.Date;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class Subscription implements Parcelable {
    private final String id;
    private CoworkSpace space;
    private User_Info user;
    private String title;
    double price;
    private Icon subIcon;

    private Date nextRenewalDate;
    private String locationAccessId;


    public Subscription(String id, User_Info user) {
        this.id = id;
        this.user = user;
        int userId = user.getId();


        if(userId == 1) {
            if (id.equals("1")){
                title = "All Day, Every Day";
                space = new CoworkSpace(1, "Space1");
                Instant instant1 = Instant.parse("2021-05-01T10:15:30.00Z");
                nextRenewalDate = Date.from(instant1);
            } else if (id.equals("2")){
                title = "One time a month";
                space = new CoworkSpace(2, "Space2");
                Instant instant2 = Instant.parse("2026-02-01T10:15:30.00Z");
                nextRenewalDate = Date.from(instant2);
            }
        }
    }

    public static boolean equals(Subscription sub1, Subscription sub2) {
        return sub1.getId().equals(sub2.getId());
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public CoworkSpace getSpace() {
        return space;
    }

    public Icon getImage() {
        return subIcon;
    }

    public Date getNextRenewalDate() { return nextRenewalDate; }

    /* --- Parcelable --- */
    @Override
    public int describeContents() {
        return 0;
    }

    protected Subscription(Parcel in) {
        id = in.readString();
        space = in.readParcelable(CoworkSpace.class.getClassLoader());
        user = in.readParcelable(User_Info.class.getClassLoader());
        title = in.readString();
        subIcon = in.readParcelable(Icon.class.getClassLoader());
        nextRenewalDate = new Date(in.readLong());
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
        dest.writeLong(nextRenewalDate.getTime());
        dest.writeString(locationAccessId)  ;
    }

    public double getPrice() {
        return price;
    }
}
