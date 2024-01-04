package pt.iade.ricardodiasjoaocoelho.projetosolar.models.User;

import android.os.Parcelable;

import java.sql.Date;

public class User_Info implements Parcelable {
    //ID
    int usr_id;
    int usr_cmp_id;

    //LogIn Info
    String usr_email;
    String usr_password;

    //Personal Info
    String usr_name;
    Date usr_bdate;
    String usr_phone;

    //Legal Info
    LegalId usr_legal_document;

    //Account Info
    Date usr_creation_date;
    boolean usr_active;

    /* --- Constructors --- */
    public User_Info(String usr_email, String usr_password, String usr_name, Date usr_bdate, String usr_phone, int usr_legal_document_id_num, int usr_legal_document_type_id, Date usr_creation_date, boolean usr_active)
    {
        this.usr_email = usr_email;
        this.usr_password = usr_password;
        this.usr_name = usr_name;
        this.usr_bdate = usr_bdate;
        this.usr_phone = usr_phone;
        this.usr_creation_date = usr_creation_date;
        this.usr_active = usr_active;

        this.usr_legal_document = new LegalId(usr_legal_document_id_num, usr_legal_document_type_id);
    }

    public static User_Info getUserById(int id, String usr_password) {
        //TODO: Get user info from database; Verify password;
        return new User_Info("a@gmail.com",
                "123456",
                "",
                new Date(0),
                "910000000",
                0,
                0,
                new Date(0),
                false);
    }

    public static User_Info getUserByCredentials(String usr_email, String usr_password)
    {
        User_Info user =new User_Info("a@gmail.com",
                "123456",
                "",
                new Date(0),
                "910000000",
                0,
                0,
                new Date(0),
                false);
        return user;
    }

    /* --- Getters --- */
    public int getId() {
        return usr_id;
    }

    public String getUsername() { return usr_name; }


    /* --- Parcelable --- */
    protected User_Info(android.os.Parcel in) {
        usr_id = in.readInt();
        usr_cmp_id = in.readInt();
        usr_email = in.readString();
        usr_password = in.readString();
        usr_name = in.readString();
        usr_phone = in.readString();
        usr_legal_document = in.readParcelable(LegalId.class.getClassLoader());
        usr_creation_date = new Date(in.readLong());
        usr_active = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User_Info> CREATOR = new Creator<User_Info>() {
        @Override
        public User_Info createFromParcel(android.os.Parcel in) {
            return new User_Info(in);
        }

        @Override
        public User_Info[] newArray(int size) {
            return new User_Info[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(usr_id);
        dest.writeInt(usr_cmp_id);
        dest.writeString(usr_email);
        dest.writeString(usr_password);
        dest.writeString(usr_name);
        dest.writeString(usr_phone);
        dest.writeParcelable(usr_legal_document, 0);
        dest.writeLong(usr_creation_date.getTime());
        dest.writeByte((byte) (usr_active ? 1 : 0));
    }

}
