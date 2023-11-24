package pt.iade.ricardodiasjoaocoelho.projetosolar.models.User;

import java.sql.Date;

public class UserInfo {
    //ID
    String usr_id;
    String usr_cmp_id;

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

    public UserInfo(String usr_email, String usr_password, String usr_name, Date usr_bdate, String usr_phone, String usr_legal_document_id_num, int usr_legal_document_type_id, Date usr_creation_date, boolean usr_active)
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

    public UserInfo(String id) {
        this.usr_id = id;
        this.usr_password = "123456";
        this.usr_email = "";
        this.usr_name = "";
        this.usr_bdate = new Date(0);
        this.usr_phone = "";
        this.usr_legal_document = new LegalId("", 0);
        this.usr_creation_date = new Date(0);
        this.usr_active = false;
    }

    public String getId() {
        return usr_id;
    }
}
