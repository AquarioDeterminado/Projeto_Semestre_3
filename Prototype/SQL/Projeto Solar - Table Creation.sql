create table entity (
	#ID's
	ent_id int not null auto_increment,
    ent_name VARCHAR(60) not null,
    
    #Contacts
	ent_phone VARCHAR(15) not null,
    ent_email VARCHAR(40) not null,
	
    #Account Info
    ent_creation_date datetime not null, 
	PRIMARY KEY (ent_id)
);

create table individual (
	#ID
	ind_id int not null auto_increment, 
    ind_ent_id int not null,
    
    #LogIn Info
    ind_email VARCHAR(40) not null,
    ind_password VARCHAR(60) not null,
    
    #Personal Info
	ind_name VARCHAR(60) not null,
    ind_bdate date not null,

    #Account Info
    ind_account_creation_date datetime not null, 
    ind_active bool not null default 1,
    
     CONSTRAINT ind_pk PRIMARY KEY (ind_id, ind_email)
);

create table company (
	cmp_id int not null auto_increment,

	cmp_location VARCHAR(40),
    PRIMARY KEY (cmp_id)
);

create table client (
	cli_id int not null auto_increment,
    PRIMARY KEY (cli_id)
);

create table entities_subscribed (
	ens_ent_id int not null,
    ens_sub_id int not null
);

create table event (
	#ID
	evt_id int not null auto_increment,
    
    #Basic Info
    evt_name VARCHAR(40) not null,
    evt_description VARCHAR(100),
	evt_space_id int not null,
	evt_location VARCHAR(80) not null,
    evt_ety_id int not null,

    #Duration Info
    evt_start datetime not null,
    evt_finish datetime not null,
    
    #Capacity
    evt_min_capacity int,
    evt_max_capacity int,
    
    evt_was_canceled bool not null default 0,

    evt_create datetime not null,
    
    PRIMARY KEY (evt_id)
);

create table facility (
	fac_id int not null auto_increment,
    fac_name VARCHAR(40) not null,
    PRIMARY KEY (fac_id)
);

create table events_facilities (
	evf_evt_id int not null,
    evf_fac_id int not null
);

create table event_type(
	ety_id int not null auto_increment,
    ety_type VARCHAR(20),
	PRIMARY KEY (ety_id)
);

create table cowork_space (
	#ID
	spc_id int not null auto_increment,
    
    #Basic Info
    spc_name VARCHAR(40) not null,
    spc_locations VARCHAR(80) not null,
    
    #Stats
    spc_max_capacity int not null,
    
    #Contacts
    spc_site VARCHAR(80),
    spc_phone VARCHAR(15),
    spc_email VARCHAR(40),
    
    spc_active bool not null default 1,
    PRIMARY KEY (spc_id)
);

create table cowork_spaces_facilities (
	cof_fac_id int not null,
    cof_spc_id int not null
);

create table company_employee (
	coe_cmp_id int not null,
    coe_ent_id int not null
);

create table subscription (
	#ID
	sub_id int not null auto_increment,
    
    #Customer Info
    sub_name VARCHAR(30) not null,
    sub_price double not null,
    
    sub_spc_id int not null,
    PRIMARY KEY (sub_id)
);

create table subscriptions_facilities (
	suf_fac_id int not null,
    suf_sub_id int not null
);

create table subscriptions (
	sus_id int not null auto_increment,
	sus_cli_id int not null,
    sus_sub_id int not null,
    
    sus_init_date date not null,
    sus_is_active boolean not null default 1,
    PRIMARY KEY (sus_id)
);

create table subscribed (
	sud_sus_id int not null,
    sud_ent_id int not null,
    
    sud_is_active bool not null default 1
);

create table rsvp (
	rsvp_ind_id int not null,
    rsvp_evt_id int not null,
    
    rsvp_is_goin bool not null default 0,
    rsvp_wants_notification bool not null default 1,
    rsvp_was_notified bool not null default 0
);

create table workstations_space (
	wsp_id int not null auto_increment,
    wsp_spc_id int not null,
    
    #SVG of the floor plan
    wsp_floor_plan VARCHAR(400),
    PRIMARY KEY (wsp_id)
);

create table workstations_group (
	wgr_id int not null auto_increment,
    wgr_wsp_id int not null,
    PRIMARY KEY (wgr_id)
);

create table workstation (
	wks_id int not null auto_increment,
	wks_wrg_id int not null,
    
    PRIMARY KEY (wks_id)
);

create table workstation_uses (
	wus_ind_id int not null,
    wus_wks_id int not null,
    wus_init_time datetime not null,
    wus_final_time datetime
);

	wus_ind_id int not null,
    wus_wks_id int not null,
    wus_init_time datetime not null,
    wus_final_time datetime
);



