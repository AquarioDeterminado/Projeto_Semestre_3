package pt.iade.ricardodiasjoaocoelho.projetosolar.models.Event;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

import pt.iade.ricardodiasjoaocoelho.projetosolar.R;

public class Event implements Parcelable {
    private final int id;
    private String title;
    private Date initDate;
    private Date endDate;
    private String descrip;
    private String location;
    private boolean full;
    private boolean reachedMin;


    public String getTitle()
    {
        return title;
    }

    public int getId() {
        return id;
    }

    public Date getStartTime() {
        return initDate;
    }

    public Date getEndTime() {
        return endDate;
    }

    public String getDescrip() {
        return descrip;
    }


    public int getImage() {
        return R.drawable.ic_launcher_background;
    }

    /* --- Parcelable --- */
    @Override
    public int describeContents() {
        return 0;
    }

    protected Event(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.descrip = in.readString();
        this.initDate = new Date(in.readLong());
        this.endDate = new Date(in.readLong());
        this.location = in.readString();
        this.full = in.readInt() == 1;
        this.reachedMin = in.readInt() == 1;
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(descrip);
        dest.writeLong(initDate.getTime());
        dest.writeLong(endDate.getTime());
        dest.writeString(location);
        dest.writeInt(full ? 1 : 0);
        dest.writeInt(reachedMin ? 1 : 0);
    }
}
