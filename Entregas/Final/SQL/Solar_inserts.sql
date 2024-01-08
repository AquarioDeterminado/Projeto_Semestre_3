#Clients
insert into client (cli_ent_id) values (1);
insert into client (cli_ent_id) values (2);
insert into client (cli_ent_id) values (6);
insert into client (cli_ent_id) values (7);

#Company
insert into company (cmp_location, cmp_cli_id) values ("Rua Empressarial, nº34", 3);
insert into company (cmp_location, cmp_cli_id) values ("Sitio Real e Nada imaginatorio, nº3, 1ºB", 4);

#Company_employee
insert into company_employee (coe_cmp_id, coe_ent_id) values (1, 1);
insert into company_employee (coe_cmp_id, coe_ent_id) values (2, 1);
insert into company_employee (coe_cmp_id, coe_ent_id) values (1, 2);

#Cowork_space
insert into cowork_space (spc_name, spc_location, spc_max_capacity, spc_current_capacity, spc_site, spc_phone, spc_email, spc_active) 
values ("Space and Mind", "Rua Miguel ruas", 10, 0, "mindwork.com", "910000111", "geral@mindwork.com", true);
insert into cowork_space (spc_name, spc_location, spc_max_capacity, spc_current_capacity, spc_site, spc_phone, spc_email, spc_active) 
values ("Full Work Cowork", "Avenida da da rua, nº34", 10, 10, "fwc.com", "910012321", "geral@fw.com", true);
insert into cowork_space (spc_name, spc_location, spc_max_capacity, spc_current_capacity, spc_site, spc_phone, spc_email, spc_active) 
values ("O CoWork", "morada real, 2ºesq. ", 10, 10, "siteCowork.com", "900000000", "cowork@cowork.cowork", true);

#Cowork_Facilities
insert into cowork_spaces_facilities (cof_fac_id, cof_spc_id) values (1, 1);
insert into cowork_spaces_facilities (cof_fac_id, cof_spc_id) values (2, 1);
insert into cowork_spaces_facilities (cof_fac_id, cof_spc_id) values (3, 1);
insert into cowork_spaces_facilities (cof_fac_id, cof_spc_id) values (1, 2);
insert into cowork_spaces_facilities (cof_fac_id, cof_spc_id) values (4, 2);

#entities_subscribed
insert into entities_subscribed (ens_ent_id, ens_sub_id) values (1, 1);
insert into entities_subscribed (ens_ent_id, ens_sub_id) values (1, 2);
insert into entities_subscribed (ens_ent_id, ens_sub_id) values (2, 2);

#entity
insert into entity (ent_name, ent_phone, ent_email, ent_creation_date) values ("Clara", "910000000", "clarinha@gmail.com", now());
insert into entity (ent_name, ent_creation_date) values ("Carlos", now());
insert into entity (ent_name, ent_creation_date) values ("João", now());
insert into entity (ent_name, ent_creation_date) values ("Maria", now());
insert into entity (ent_name, ent_creation_date) values ("Afonso", now());
insert into entity (ent_name, ent_creation_date) values ("Tinteiros lda.", now());
insert into entity (ent_name, ent_creation_date) values ("Roupa Gira", now());

#event 
insert into event (evt_name, evt_description, evt_space_id, evt_location, evt_ety_id, evt_start, evt_finish, evt_min_capacity, evt_max_capacity, evt_was_canceled, evt_create, evt_is_public) 
values ("Suspended Yoga", "Come suspend your problems.", 1, "Space and Mind", 1, str_to_date("2024.01.20",'%Y.%m.%d'), str_to_date("2024.01.21",'%Y.%m.%d'), 0, 10, false, now(), true);
insert into event (evt_name, evt_description, evt_space_id, evt_location, evt_ety_id, evt_start, evt_finish, evt_min_capacity, evt_max_capacity, evt_was_canceled, evt_create, evt_is_public) 
values ("Hot Yoga", "Begginer's hot yoga class.", 2, "Santos Yoga Hub", 1, str_to_date("2024.01.22",'%Y.%m.%d'), str_to_date("2024.01.23",'%Y.%m.%d'), 5, 10, false, now(), true);
insert into event (evt_name, evt_description, evt_space_id, evt_location, evt_ety_id, evt_start, evt_finish, evt_min_capacity, evt_max_capacity, evt_was_canceled, evt_create, evt_is_public) 
values ("More Yoga", "All day Yoga Class.", 3, "Santos Yoga Hub", 1, str_to_date("2024.02.01",'%Y.%m.%d'), str_to_date("2024.02.02",'%Y.%m.%d'), 0, 2, false, now(), false);

#event_type
insert into event_type (ety_type) values ("Yoga Class");
insert into event_type (ety_type) values ("Group Dinner");
insert into event_type (ety_type) values ("Live Music Concert");
insert into event_type (ety_type) values ("Exhibition");

#events_facilities
insert into events_facilities (evf_evt_id, evf_fac_id) values (1, 1);
insert into events_facilities (evf_evt_id, evf_fac_id) values (1, 2);
insert into events_facilities (evf_evt_id, evf_fac_id) values (1, 3);
insert into events_facilities (evf_evt_id, evf_fac_id) values (2, 2);
insert into events_facilities (evf_evt_id, evf_fac_id) values (3, 1);

#facility 
insert into facility (fac_name) values ("Pet Frienly");
insert into facility (fac_name) values ("Outdoors Space");
insert into facility (fac_name) values ("Available Printer");
insert into facility (fac_name) values ("Bar");
insert into facility (fac_name) values ("Cafeteria");
insert into facility (fac_name) values ("WorkShop");
insert into facility (fac_name) values ("Monthly");
insert into facility (fac_name) values ("Yearly");



#individual
insert into individual (ind_ent_id, ind_email, ind_password, ind_name, ind_bdate, ind_account_creation_date, ind_active) 
values (1, "clarinha@carlinha.com", "carlinha2004!", "Clara", str_to_date("2004.01.20",'%Y.%m.%d'), now(), true);
insert into individual (ind_ent_id, ind_email, ind_password, ind_name, ind_bdate, ind_account_creation_date, ind_active) 
values (2, "carlos@gmail.com", "Carlos29$", "Carlos", str_to_date("2004.04.22",'%Y.%m.%d'), now(), true);
insert into individual (ind_ent_id, ind_email, ind_password, ind_name, ind_bdate, ind_account_creation_date, ind_active) 
values (3, "joão@nãoojoãoqueestaaapresentar.pt", "123j!", "João", str_to_date("2004.01.31",'%Y.%m.%d'), now(), false);

#rsvp
insert into rsvp (rsvp_ind_id, rsvp_evt_id, rsvp_is_going, rsvp_wants_notification, rsvp_was_notified) 
values (1, 1, false, true, false);
insert into rsvp (rsvp_ind_id, rsvp_evt_id, rsvp_is_going, rsvp_wants_notification, rsvp_was_notified) 
values (1, 3, true, true, false);
insert into rsvp (rsvp_ind_id, rsvp_evt_id, rsvp_is_going, rsvp_wants_notification, rsvp_was_notified) 
values (2, 3, true, true, false);

#subscribed
insert into subscribed (sud_sus_id, sud_ent_id, sud_is_active) values (1, 1, true);
insert into subscribed (sud_sus_id, sud_ent_id, sud_is_active) values (2, 1, true);
insert into subscribed (sud_sus_id, sud_ent_id, sud_is_active) values (2, 2, false);
insert into subscribed (sud_sus_id, sud_ent_id, sud_is_active) values (2, 3, true);

#subscription 
insert into subscription (sub_name, sub_price, sub_spc_id) values ("Mindful package", 20.99, 1);
insert into subscription (sub_name, sub_price, sub_spc_id) values ("Reserved Desk Subscription", 9.99, 2);
insert into subscription (sub_name, sub_price, sub_spc_id) values ("Reserved Studio", 350.00, 2);

#subscriptions
insert into subscriptions (sus_cli_id, sus_sub_id, sus_init_date, sus_is_active)
 values (1, 1, str_to_date("2002.01.02",'%Y.%m.%d'), true);
 insert into subscriptions (sus_cli_id, sus_sub_id, sus_init_date, sus_is_active)
 values (3, 3, str_to_date("2010.12.31",'%Y.%m.%d'), true);

#subscriptions_facilities
insert into subscriptions_facilities (suf_fac_id, suf_sub_id) values (8, 3);
insert into subscriptions_facilities (suf_fac_id, suf_sub_id) values (7, 2);
insert into subscriptions_facilities (suf_fac_id, suf_sub_id) values (7, 1);

#workstation
#Workstations 1-4 are from Group 1
insert into workstation (wks_wrg_id) values (1);
insert into workstation (wks_wrg_id) values (1);
insert into workstation (wks_wrg_id) values (1);
insert into workstation (wks_wrg_id) values (1);
#Workstations 5-8 are from Group 2
insert into workstation (wks_wrg_id) values (2);
insert into workstation (wks_wrg_id) values (2);
insert into workstation (wks_wrg_id) values (2);
insert into workstation (wks_wrg_id) values (2);
#Workstations 9-12 are from Group 3
insert into workstation (wks_wrg_id) values (3);
insert into workstation (wks_wrg_id) values (3);
insert into workstation (wks_wrg_id) values (3);
insert into workstation (wks_wrg_id) values (3);
#Workstations 13-16 are from Group 4
insert into workstation (wks_wrg_id) values (4);
insert into workstation (wks_wrg_id) values (4);
insert into workstation (wks_wrg_id) values (4);
insert into workstation (wks_wrg_id) values (4);

#workstation_uses
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time) 
values (1, 1, str_to_date("2019.01.02 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.02 00:00:00", '%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time) 
values (2, 2, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time)
 values (3, 3, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time)
 values (4, 4, str_to_date("2019.01.03 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.03 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time) 
values (5, 5, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time) 
values (6, 6, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time) 
values (7, 7, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time)
 values (8, 8, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time)
 values (9, 9, str_to_date("2019.01.03 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.03 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time)
 values (10, 10, str_to_date("2019.01.04 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.04 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time)
 values (11, 11, str_to_date("2019.01.05 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time)
 values (12, 12, str_to_date("2019.01.04 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.04 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time)
 values (13, 13, str_to_date("2019.01.06 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.06 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time) 
values (14, 14, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time, wus_final_time) 
values (15, 15, str_to_date("2019.01.03 00:00:00",'%Y.%m.%d %H:%i:%s'), str_to_date("2019.01.03 00:00:00",'%Y.%m.%d %H:%i:%s'));
insert into workstation_uses (wus_ind_id, wus_wks_id, wus_init_time)
values (16, 16, str_to_date("2019.01.01 00:00:00",'%Y.%m.%d %H:%i:%s'));

#workstations_group
insert into workstations_group (wgr_wsp_id) values (1);
insert into workstations_group (wgr_wsp_id) values (1);
insert into workstations_group (wgr_wsp_id) values (2);
insert into workstations_group (wgr_wsp_id) values (3);

#workstations_space
insert into workstations_space (wsp_spc_id) values (1);
insert into workstations_space (wsp_spc_id) values (2);
insert into workstations_space (wsp_spc_id) values (2);
