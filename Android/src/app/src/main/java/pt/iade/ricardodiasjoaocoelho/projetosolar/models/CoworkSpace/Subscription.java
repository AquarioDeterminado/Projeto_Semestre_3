package pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace;

import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.User.User_Info;

public class Subscription implements Parcelable {
    private final int id;
    private User_Info user;
    private String title;
    double price;
    private Icon subIcon;
    private Date nextRenewalDate;
    private String locationAccessId;
    private String spaceName;

    public static boolean equals(Subscription sub1, Subscription sub2) {
        return sub1.getId() == sub2.getId();
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
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
        id = in.readInt();
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
        dest.writeInt(id);
        dest.writeParcelable(user, 0);
        dest.writeString(title);
        dest.writeParcelable(subIcon, 0);
        dest.writeLong(nextRenewalDate.getTime());
        dest.writeString(locationAccessId)  ;
    }

    public double getPrice() {
        return price;
    }

    public String getSpaceName() {
        return this.spaceName;
    }
}
