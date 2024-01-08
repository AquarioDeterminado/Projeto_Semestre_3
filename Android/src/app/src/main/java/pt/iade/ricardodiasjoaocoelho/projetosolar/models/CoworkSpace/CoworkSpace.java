package pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace;

import android.os.Parcelable;

import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;

public class CoworkSpace implements Parcelable {

    private final int id;
    private String name;
    //private ImageView logo;
    private Subscription[] subscriptions = new Subscription[0];
    private String location;
    private Tag[] tags = new Tag[0];

    public CoworkSpace(int id, String name, ArrayList<Subscription> subscriptions, String location, ArrayList<Tag> tags)
    {
        this.id = id;
        this.name = name;
        this.subscriptions = subscriptions.toArray(new Subscription[0]);
        this.location = location;
        this.tags = tags.toArray(new Tag[0]);
    }

    /*public  ImageView getLogo() {
        return logo;
    }*/

    /*public  void setLogo(ImageView logo) {
        this.logo = logo;
    }*/

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation() {return location;}

    public ArrayList<Tag> getTags()
    {
        ArrayList<Tag> tags = new ArrayList<>();
        for (Tag tag : tags) {
            tags.add(tag);
        }
        return tags;
    }

    /* --- Parcelable --- */


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CoworkSpace> CREATOR = new Creator<CoworkSpace>() {
        @Override
        public CoworkSpace createFromParcel(android.os.Parcel in) {
            return new CoworkSpace(in);
        }

        @Override
        public CoworkSpace[] newArray(int size) {
            return new CoworkSpace[size];
        }
    };

    public CoworkSpace(android.os.Parcel in) {
        id = in.readInt();
        name = in.readString();
        location = in.readString();
        //subscriptions = in.createTypedArray(Subscription.CREATOR);
        //tags = in.createTypedArray(Tag.CREATOR);
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(location);
        //dest.writeTypedArray(subscriptions, 0);
        //dest.writeTypedArray(tags, 0);
    }

    public void setSubscriptions(ArrayList<Subscription> subscriptions) {
        this.subscriptions = subscriptions.toArray(new Subscription[0]);
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags.toArray(new Tag[0]);
    }

    public ArrayList<Subscription> getSubscriptions() {
        ArrayList<Subscription> subscriptionsArrayList = new ArrayList<>();
        for (Subscription subscription : subscriptions) {
            subscriptionsArrayList.add(subscription);
        }
        return subscriptionsArrayList;
    }
}