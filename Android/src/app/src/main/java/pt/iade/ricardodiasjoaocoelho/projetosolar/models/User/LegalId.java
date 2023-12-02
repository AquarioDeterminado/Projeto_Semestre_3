package pt.iade.ricardodiasjoaocoelho.projetosolar.models.User;

import android.os.Parcelable;

public class LegalId implements Parcelable {
    int usr_legal_document_id_num;
    int usr_legal_document_type_id;

    LegalId(int usr_legal_document_id_num, int usr_legal_document_type_id)
    {
        this.usr_legal_document_id_num = usr_legal_document_id_num;
        this.usr_legal_document_type_id = usr_legal_document_type_id;
    }

    /* --- Parcelable --- */
    protected LegalId(android.os.Parcel in) {
        usr_legal_document_id_num = in.readInt();
        usr_legal_document_type_id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LegalId> CREATOR = new Creator<LegalId>() {
        @Override
        public LegalId createFromParcel(android.os.Parcel in) {
            return new LegalId(in);
        }

        @Override
        public LegalId[] newArray(int size) {
            return new LegalId[size];
        }
    };

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(usr_legal_document_id_num);
        dest.writeInt(usr_legal_document_type_id);
    }
}
