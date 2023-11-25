create table entity (
	ent_id int not null auto_increment,
    ent_name VARCHAR(60) not null,
	
    ent_creation_date datetime not null, 
	PRIMARY KEY (ent_id)
);


create table individual (
	#ID
	ind_id int not null auto_increment, 
    
    ind_cmp_id int,
    
    #LogIn Info
    ind_email VARCHAR(40) not null,
    ind_password VARCHAR(60) not null,
    
    #Personal Info
	ind_name VARCHAR(60) not null,
    ind_bdate date not null,
    ind_phone VARCHAR(15) not null,

    #Account Info
    ind_creation_date datetime not null, 
    ind_active bool not null default 1,
    
     CONSTRAINT ind_pk PRIMARY KEY (ind_id, ind_email)
);

create table client (
	cli_id int not null auto_increment,
    
    cli_cmp_id int,
    cli_ind_id int,
    
    PRIMARY KEY (cli_id)
);

create table entities_subscribed (
	ens_ent_id int not null,
    ens_sub_id int not null
);

create table events (
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
    PRIMARY KEY (etg_id)
);

create table events_facilities_list (
	evf_evt_id int not null,
    evf_fac_id int not null
);

create table events_type(
	ety_id int not null auto_increment,
    ety_type VARCHAR(20),
	PRIMARY KEY (ety_id)
);

create table cowork_spaces (
	#ID
	spc_id int not null auto_increment,
    
    #Basic Info
    spc_name VARCHAR(40) not null,
    spc_locations_list VARCHAR(80) not null,
    
    #Stats
    spc_max_capacity int not null,
    
    #Contacts
    spc_site VARCHAR(80),
    spc_phone VARCHAR(15),
    spc_email VARCHAR(40),
    
    spc_active bool not null default 1,
    PRIMARY KEY (spc_id)
);

create table cowork_space_facilities_list (
	cof_fac_id int not null,
    cof_spc_id int not null
);

create table company (
	cmp_id int not null auto_increment,
    
    cmp_name VARCHAR(20) not null,
    cmp_phone VARCHAR(15) not null,
    cmp_email VARCHAR(40) not null,
    PRIMARY KEY (cmp_id)
);

create table company_employees (
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


create table subscriptions_facilities_list (
	suf_fac_id int not null,
    suf_sub_id int not null
);

create table users_subscriptions (
	uss_cli_id int not null,
    uss_sub_id int not null,
    
    uss_init_date date not null
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
    PRIMARY KEY (wsp_id)
);

create table workstations_group (
	wgr_id int not null auto_increment,
    wgr_wsp_id int not null,
    PRIMARY KEY (wsg_id)
);

create table workstation (
	wks_id int not null auto_increment,
	wks_wrg_id int not null
);

create table workstations_uses (
	wus_ind_id int not null,
    wus_wks_id int not null,
    wus_init_time datetime not null,
    wus_final_time datetime
);



