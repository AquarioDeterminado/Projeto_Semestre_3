package pt.iade.ricardodiasjoaocoelho.projetosolar.models.User;

import android.os.Parcelable;

import java.sql.Date;

public class UserInfo implements Parcelable {
    //ID
    int usr_id;
    //LogIn Info
    String usr_email;
    //Personal Info
    String usr_name;

    /* --- Constructors --- */
    public UserInfo(String usr_email, String usr_password, String usr_name, Date usr_bdate, String usr_phone, int usr_legal_document_id_num, int usr_legal_document_type_id, Date usr_creation_date, boolean usr_active)
    {
        this.usr_email = usr_email;
        this.usr_name = usr_name;
    }

    public static UserInfo getUserById(int id, String usr_password) {
        //TODO: Get user info from database; Verify password;
        return new UserInfo("a@gmail.com",
                "123456",
                "",
                new Date(0),
                "910000000",
                0,
                0,
                new Date(0),
                false);
    }

    /* --- Getters --- */
    public int getId() {
        return usr_id;
    }

    public String getUsername() { return usr_name; }

    /* --- Methods --- */
    /*public Bitmap getQrCode() {
        QREncoder qrEncoder = new QREncoder();
    }*/

    /* --- Parcelable --- */
    protected UserInfo(android.os.Parcel in) {
        usr_id = in.readInt();
        usr_email = in.readString();
        usr_name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(android.os.Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(usr_id);
        dest.writeString(usr_email);
        dest.writeString(usr_name);
    }

    public String getEmail() {
        return usr_email;
    }
}
