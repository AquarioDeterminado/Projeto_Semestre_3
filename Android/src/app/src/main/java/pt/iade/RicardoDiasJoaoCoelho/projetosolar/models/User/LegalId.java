package pt.iade.RicardoDiasJoaoCoelho.projetosolar.models.User;

public class LegalId {
    String usr_legal_document_id_num;
    int usr_legal_document_type_id;

    LegalId(String usr_legal_document_id_num, int usr_legal_document_type_id)
    {
        this.usr_legal_document_id_num = usr_legal_document_id_num;
        this.usr_legal_document_type_id = usr_legal_document_type_id;
    }
}
