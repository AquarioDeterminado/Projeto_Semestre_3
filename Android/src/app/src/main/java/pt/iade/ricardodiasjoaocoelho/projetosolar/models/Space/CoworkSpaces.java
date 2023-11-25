package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Space;

import android.os.Parcelable;
import android.widget.ImageView;
import java.util.ArrayList;

import pt.iade.ricardodiasjoaocoelho.projetosolar.models.Utils.Tag;

public class CoworkSpaces implements Parcelable {

    private final String id;
    private String name;
    private static ImageView logo;

    public CoworkSpaces(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public static ImageView getLogo() {
        return logo;
    }

    public static void setLogo(ImageView logo) {
        CoworkSpaces.logo = logo;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Tag> getTags()
    {
        ArrayList<Tag> tags = new ArrayList<>();

        ArrayList<String> descrips = new ArrayList<>();//not  Final
        descrips.add("Tag1");
        descrips.add("Tag2");
        descrips.forEach(descrip -> {
            Tag tag = new Tag(descrip);
            tags.add(tag);
        });
        return tags;
    }

    /* --- Parcelable --- */
    protected Space(android.os.Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Space> CREATOR = new Creator<Space>() {
        @Override
        public Space createFromParcel(android.os.Parcel in) {
            return new Space(in);
        }

        @Override
        public Space[] newArray(int size) {
            return new Space[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}