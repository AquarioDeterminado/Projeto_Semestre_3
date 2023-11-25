package pt.iade.ricardodiasjoaocoelho.projetosolar.models.CoworkSpace;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Location implements Parcelable {

    private final String  id;
    private final String cowork_id;

    private final String name;
    private final String address;
    private final int floorPlan;

    public String getName() {
        return name;
    }

    public Location(String id) {
        this.id = id;
        if(id.equals("1")){
            cowork_id = "1";
            name = "Solar do Areal";
            address = "Rua do Areal, 1";
            floorPlan = R.drawable.mapa_teste___coworking_;
        } else if(id.equals("2")){
            cowork_id = "2";
            name = "Solar do Monte";
            address = "Rua do Monte, 1";
            floorPlan = R.drawable.mapa_teste___coworking_;
        } else {
            cowork_id = "3";
            name = "Solar do Terra";
            address = "Rua do Terra, 1";
            floorPlan = R.drawable.mapa_teste___coworking_;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(cowork_id);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeInt(floorPlan);
    }

    public static final Parcelable.Creator<Location> CREATOR = new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(@NonNull Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    private Location(Parcel in) {
        id = in.readString();
        cowork_id = in.readString();
        name = in.readString();
        address = in.readString();
        floorPlan = in.readInt();
    }

    public int getFloorPlan() {
        return floorPlan;
    }
}
