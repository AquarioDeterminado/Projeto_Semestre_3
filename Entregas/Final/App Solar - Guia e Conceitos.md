# Projeto Solar

#### Alunos (D1)
 - João Coelho, nº20220753
 - Ricardo Dias, nº20220494

#### Contexto

- O Projeto Solar consiste numa aplicação que facilita a comunicação entre espaços de *cowork* e os seus clientes. Como tal ela oferece as seguintes funcionalidades:

	- Vizualização de espaços cowork perto do utilizador (nome, localização, subscrioções, *facilities*)
	- Gerir as varias subscrições ou planos que o utilizador possa adquirir 
	- Convidar os utilizadores a eventos promovidos pelos espaços de cowork
	- Reserva de lugares "Hot Desk" por parte dos utilizadores


#### Conceitos

- ##### Cowork:
  Um espaço CoWork é um espaço de trabalho comum, atendido por varios utilizadores, acessivel atraves de um tipo de **subscrição**.
  Cada espaço tem um nome, uma localização (e só uma localização, espaços da mesma empressa são listados como espaços diferentes), a sua capacidade de utilizadores inscritos e metodos de contacto.
  Um espaço é estabelecido por varias **salas e áreas de trabalho** e ***facilities***.
  De momento, eventos só podem ser criados através de cowork.
 
- ##### Salas e Áreas de Trabalho: 
  Um Cowork pode disponibilizar o *layout* das suas salas de trabalho. Essas salas são divididas em "ilhas" e as ilhas em estações de trabalho.
  As estações de trabalho podem ser reservaveis ou não.

- ##### Subscrições:
  Subcrições estão ligadas a um **cowork** e podem ser adquiridas por um **cliente**. Essas subcrições dão acesso aos utilizadores á **eventos**, **espaços de trabalho** e outros beneficios que o cowork possa providenciar.

- ##### Clientes: 
  Existem clientes individuais e empressas. Os dois podem adquirir subscrições qualquer tipo de subscrição, tendo as empressas que esplanar quais são os colaboradores que desfrutam das mesmas.

- #### Utilizadores: 
  Utilizador são **entidades** que usam a aplicação Solar. Podem se tornar clientes, ao adquirirem subscrições. 

- ##### Eventos: 
  Eventos são eventos promovidos por um espaço de cowork. Podem ser públicos (incluir pessoas não inscritas) ou privados. Os mesmos são descritos por um "tipo de evento", que nos permite notificar um utilizador interessado quando outro evento do mesmo tipo for marcado. 


#### Dicionario de Dados

 ##### entity

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|ent_id|int|ID de uma Entidade|yes|Primary |
|ent_name|VARCHAR|Nome de uma Entidade|yes||
|ent_creation_name|datetime|Data de Criacao de uma Entidade|yes||


 ##### individual

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|ind_id|int|ID de um Individuo|yes|Primary |
|ind_ent_id|int|ID de uma Entidade|yes|Foreign|
|ind_cmp_id|int|ID de uma Empresa|no|Foreign|
|ind_email|VARCHAR|Email de um Individuo|yes|Primary |
|ind_password|VARCHAR| Password de um Individuo|yes||
|ind_name|VARCHAR|Nome  de um Individuo|yes||
|ind_bdate|datetime|Data de Nascimento  de um Individuo|yes||
|ind_phone|VARCHAR|Telemóvel de um Individuo|yes||
|ind_creation_date|datetime|Data de Criacao da conta de um Individuo|yes||
|ind_active|bool|Utilizador Ativo|no||


 ##### client

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|cli_id|int|ID do Cliente|yes|Primary |
|cli_cmp_id|int|ID da Empresa|no|Foreign|
|cli_ind_id|int|ID do Individuo|no|Foreign|


 ##### entities_subscribed||||||

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|ens_id|Int|Id|Yes|Primary |
|ens_ent_id|int|ID de uma Entidade|yes|Foreign|
|ens_sub_id|int|ID de uma Subscrição|yes|Foreign|


 ##### events

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|evt_id|int|ID de um Evento|yes|Primary |
|evt_name|VARCHAR|Nome de um Evento|yes||
|evt_description|VARCHAR|Descrição de um Evento|no||
|evt_space_id|int|ID do Espaco do Evento|yes|Foreign|
|evt_location|VARCHAR|Localização do Evento|yes||
|evt_ety_id|int|ID do tipo de Evento|yes|Foreign|
|evt_start|datetime|Data de Inicio do evento|yes||
|evt_finish|datetime|Data de Fim do evento|yes||
|evt_min_capacity|int|Capacidade Máxima de um Evento|no||
|evt_max_capacity|int|Capacidade Máxima de um Evento|no||
|evt_was_canceled|bool|Marcador de evento cancelado |yes||
|evt_create|datetime|Data de Criação do Evento|yes||


 ##### facility

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|fac_id|int|ID de um Edificio|yes|Primary |
|fac_name|VARCHAR|Nome de um Edificio|yes||


  ##### events_facilities_list

 |Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|evf_id|Int|Id|Yes|Primary |
|evf_evt_id|int|ID de um Evento|yes|Foreign|
|evf_fac_id|int|ID de um Edificio|yes|Foreign|


 ##### events_type

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|ety_id|int |ID de um tipo de evento|no|Primary |
|ety_type|VARCHAR|Tipo de Evento|no||


 ##### cowork_spaces

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|spc_id|int|ID de um Espaço de Cowork|yes|Primary |
|spc_name|VARCHAR|Nome de um Espaço de Cowork|yes||
|spc_locations_list|VARCHAR|Lista de localizações dos edificios do Espaço de Cowork|yes||
|spc_max_capacity|int|Capacidade Máxima de um spaço de Cowork|yes||
|spc_site|VARCHAR|Website Do Espaço De Cowork|no||
|spc_phone|VARCHAR|Telefone de um Espaço de Cowork|no||
|spc_email|VARCHAR|Email de um Espaço de Cowork|no||
|spc_active|bool|Espaço de Cowork Ativo|yes||


 ##### cowork_space_facilities_list

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|cof_id| int | Id | yes|Primary|
|cof_fac_id|int|ID de um Edificio|yes|Foreign|
|cof_spc_id|int|ID de um Espaço de Cowork|yes|Foreign|
 

  ##### company

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|cmp_id|int|ID de uma Empresa|yes|Primary |
|cmp_name|VARCHAR|Nome de uma Empresa|yes||
|cmp_phone|VARCHAR|Telefone de uma Empresa|yes||
|cmp_email|VARCHAR|Email de uma Empresa|yes||


 ##### company_employees

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|coe_id|Int|Id|Yes|Primary |
|coe_cmp_id|int|ID de uma Empresa|yes|Foreign|
|coe_ent_id|int|ID de uma Entidade|yes|Foreign|


 ##### subscription

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|sub_id |int|ID de uma Subscrição|yes|Primary |
|sub_name |VARCHAR|Nome de uma Subscrição|yes||
|sub_price|double|Preço de uma Subscrição|yes||
|sub_spc_id|int|ID de um Espaço de Cowork|yes|Foreign|


 ##### subscriptions_facilities_list|

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|suf_id|Int|ID|Yes|Primary |
|suf_fac_id|int|ID de um Edificio|yes|Foreign|
|suf_sub_id|int|ID de uma Subscrição|yes|Foreign|


 ##### users_subscriptions

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|uss_id|Int|Id |Yes|Primary |
|uss_cli_id|int|ID do Cliente|yes|Foreign|
|uss_sub_id|int|ID de uma Subscrição|yes|Foreign|
|uss_init_date|date|Data de Inicio da compra da Subscrição|yes||


 ##### rsvp

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|rsvp_id|Int|Id de uma resposta a convite|Yes|Primary |
|rsvp_ind_id|int|ID de um Individuo|yes|Foreign|
|rsvp_evt_id |int|ID de um Evento|yes|Foreign|
|rsvp_is_goin|bool|Confirmação se o indivíduo confirmou o rsvp|yes||
|rsvp_wants_notification |bool|Confirmação se o indivíduo quer receber notificações|yes||
|rsvp_was_notified|bool|Confirmação para se o individuo foi notificado|yes||


 ##### workstations_space

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|wsp_id|int|ID de uma WorkStation|yes|Primary |
|wsp_spc_id |int|ID de um Espaço de Cowork|yes|Foreign|


 ##### workstations_group

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|wgr_id |int|ID de um grupo de WorkStations|yes|Primary |
|wgr_wsp_id |int|Data de entrada da utilização da WorkStation|yes|Foreign|


 ##### workstation|

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|wks_id|int|ID de uma WorkStation|yes|Primary |
|wks_wrg_id|int|ID de um grupo de WorkStations|yes|Foreign|


 ##### workstations_uses

|Variable Name|Data Type|Description|Not NULL|Primary Key or Foreign Key|
|:---         | :---:   | :---      | :---:  | :---:                    |
|wus_id|Int|ID de um Uso||Primary |
|wus_ind_id |int|ID de um Individuo|yes|Foreign|
|wus_wks_id|int|ID de uma WorkStation|yes|Foreign|
|wus_init_time |datetime|Data de entrada da utilização da WorkStation|yes||
|wus_final_time|datetime|Data de saída da utilização da WorkStation|no||
