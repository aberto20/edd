# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table back_home (
  id                        bigint auto_increment not null,
  province                  varchar(255),
  district                  varchar(255),
  sector                    varchar(255),
  cellure                   varchar(255),
  received_by               varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_back_home primary key (id))
;

create table child (
  id                        bigint auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  sure_name                 varchar(255),
  province                  varchar(255),
  district                  varchar(255),
  sector                    varchar(255),
  cellure                   varchar(255),
  dob                       datetime,
  photo                     varchar(255),
  gender                    varchar(255),
  weight                    double,
  height                    double,
  nation_id                 varchar(255),
  delete_status             tinyint(1) default 0,
  done_by                   varchar(255),
  done_at                   datetime,
  constraint pk_child primary key (id))
;

create table child_behavior (
  id                        bigint auto_increment not null,
  with_others               varchar(255),
  to_facilitators           varchar(255),
  behavioral_disorder       varchar(255),
  others                    varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_child_behavior primary key (id))
;

create table child_history (
  id                        bigint auto_increment not null,
  q1                        varchar(255),
  a1                        varchar(255),
  q2                        varchar(255),
  a2                        varchar(255),
  q3                        varchar(255),
  a3                        varchar(255),
  q4                        varchar(255),
  a4                        varchar(255),
  child_historyother        varchar(255),
  street_location           varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_child_history primary key (id))
;

create table consultation (
  id                        bigint auto_increment not null,
  weight                    double,
  complains                 varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_consultation primary key (id))
;

create table dignostic (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_dignostic primary key (id))
;

create table education (
  id                        bigint auto_increment not null,
  subject                   varchar(255),
  level                     varchar(255),
  year_class                varchar(255),
  marks                     double,
  term                      varchar(255),
  school_year               varchar(255),
  school_report             varchar(255),
  done_by                   varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_education primary key (id))
;

create table employee (
  id                        bigint auto_increment not null,
  names                     varchar(255),
  address                   varchar(255),
  phone                     varchar(255),
  title                     varchar(255),
  photo                     varchar(255),
  document_cv               varchar(255),
  document_certificate      varchar(255),
  active                    tinyint(1) default 0,
  status                    varchar(255),
  done_by                   varchar(255),
  system_user_id            bigint,
  constraint pk_employee primary key (id))
;

create table employee_role (
  id                        bigint auto_increment not null,
  role_id                   bigint,
  employee_id               bigint,
  done_at                   datetime,
  constraint pk_employee_role primary key (id))
;

create table followup (
  id                        bigint auto_increment not null,
  is_study                  tinyint(1) default 0,
  is_study_finish           tinyint(1) default 0,
  has_got_job               tinyint(1) default 0,
  job_type                  varchar(255),
  date                      datetime,
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_followup primary key (id))
;

create table medecines (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  qty                       integer,
  comment                   varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_medecines primary key (id))
;

create table neighbours (
  id                        bigint auto_increment not null,
  neighb_names              varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_neighbours primary key (id))
;

create table parent_info (
  id                        bigint auto_increment not null,
  father_names              varchar(255),
  father_status             varchar(255),
  mather_names              varchar(255),
  mather_status             varchar(255),
  nearest_parent            varchar(255),
  others                    varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_parent_info primary key (id))
;

create table role (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_role primary key (id))
;

create table schooling (
  id                        bigint auto_increment not null,
  studies_level             varchar(255),
  school_name               varchar(255),
  read_and_write            tinyint(1) default 0,
  current_capacity          tinyint(1) default 0,
  rescolarisable            tinyint(1) default 0,
  learning_difficulties     tinyint(1) default 0,
  refuse_school             tinyint(1) default 0,
  refuse_school_name        varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_schooling primary key (id))
;

create table siblings (
  id                        bigint auto_increment not null,
  sibling_names             varchar(255),
  siblinggender             varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_siblings primary key (id))
;

create table sical_social (
  id                        bigint auto_increment not null,
  dignostic                 varchar(255),
  symptoms                  varchar(255),
  progress                  varchar(255),
  description               varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_sical_social primary key (id))
;

create table statistic_child (
  id                        bigint auto_increment not null,
  reg_child                 double,
  desertedreg_child         double,
  month                     varchar(255),
  done_at                   datetime,
  constraint pk_statistic_child primary key (id))
;

create table system_user (
  id                        bigint auto_increment not null,
  user_name                 varchar(255),
  password                  varchar(255),
  done_at                   datetime,
  constraint pk_system_user primary key (id))
;

create table transfer_hospital (
  id                        bigint auto_increment not null,
  destination               varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_transfer_hospital primary key (id))
;

create table usage_drugs (
  id                        bigint auto_increment not null,
  drug_name1                varchar(255),
  drug_name2                varchar(255),
  drug_name3                varchar(255),
  drug_name4                varchar(255),
  other                     varchar(255),
  usage_state1              varchar(255),
  usage_state2              varchar(255),
  usage_state3              varchar(255),
  usage_state4              varchar(255),
  usage_state5              varchar(255),
  q1                        varchar(255),
  druga1                    varchar(255),
  q2                        varchar(255),
  druga2                    varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_usage_drugs primary key (id))
;

create table visit (
  id                        bigint auto_increment not null,
  date                      datetime,
  familly_work              varchar(255),
  field                     tinyint(1) default 0,
  cultivated                tinyint(1) default 0,
  field_holder              varchar(255),
  house                     tinyint(1) default 0,
  house_holder              varchar(255),
  father_altitude           varchar(255),
  mather_altitude           varchar(255),
  done_by                   varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_visit primary key (id))
;

create table hygiene (
  id                        bigint auto_increment not null,
  on_body                   varchar(255),
  on_clothes                varchar(255),
  sugestion                 varchar(255),
  comment                   varchar(255),
  done_by                   varchar(255),
  done_at                   datetime,
  child_id                  bigint,
  constraint pk_hygiene primary key (id))
;

alter table back_home add constraint fk_back_home_child_1 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_back_home_child_1 on back_home (child_id);
alter table child_behavior add constraint fk_child_behavior_child_2 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_child_behavior_child_2 on child_behavior (child_id);
alter table child_history add constraint fk_child_history_child_3 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_child_history_child_3 on child_history (child_id);
alter table consultation add constraint fk_consultation_child_4 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_consultation_child_4 on consultation (child_id);
alter table dignostic add constraint fk_dignostic_child_5 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_dignostic_child_5 on dignostic (child_id);
alter table education add constraint fk_education_child_6 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_education_child_6 on education (child_id);
alter table employee add constraint fk_employee_systemUser_7 foreign key (system_user_id) references system_user (id) on delete restrict on update restrict;
create index ix_employee_systemUser_7 on employee (system_user_id);
alter table employee_role add constraint fk_employee_role_role_8 foreign key (role_id) references role (id) on delete restrict on update restrict;
create index ix_employee_role_role_8 on employee_role (role_id);
alter table employee_role add constraint fk_employee_role_employee_9 foreign key (employee_id) references employee (id) on delete restrict on update restrict;
create index ix_employee_role_employee_9 on employee_role (employee_id);
alter table followup add constraint fk_followup_child_10 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_followup_child_10 on followup (child_id);
alter table medecines add constraint fk_medecines_child_11 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_medecines_child_11 on medecines (child_id);
alter table neighbours add constraint fk_neighbours_child_12 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_neighbours_child_12 on neighbours (child_id);
alter table parent_info add constraint fk_parent_info_child_13 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_parent_info_child_13 on parent_info (child_id);
alter table schooling add constraint fk_schooling_child_14 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_schooling_child_14 on schooling (child_id);
alter table siblings add constraint fk_siblings_child_15 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_siblings_child_15 on siblings (child_id);
alter table sical_social add constraint fk_sical_social_child_16 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_sical_social_child_16 on sical_social (child_id);
alter table transfer_hospital add constraint fk_transfer_hospital_child_17 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_transfer_hospital_child_17 on transfer_hospital (child_id);
alter table usage_drugs add constraint fk_usage_drugs_child_18 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_usage_drugs_child_18 on usage_drugs (child_id);
alter table visit add constraint fk_visit_child_19 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_visit_child_19 on visit (child_id);
alter table hygiene add constraint fk_hygiene_child_20 foreign key (child_id) references child (id) on delete restrict on update restrict;
create index ix_hygiene_child_20 on hygiene (child_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table back_home;

drop table child;

drop table child_behavior;

drop table child_history;

drop table consultation;

drop table dignostic;

drop table education;

drop table employee;

drop table employee_role;

drop table followup;

drop table medecines;

drop table neighbours;

drop table parent_info;

drop table role;

drop table schooling;

drop table siblings;

drop table sical_social;

drop table statistic_child;

drop table system_user;

drop table transfer_hospital;

drop table usage_drugs;

drop table visit;

drop table hygiene;

SET FOREIGN_KEY_CHECKS=1;

