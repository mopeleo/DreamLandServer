/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/12/6 22:00:21                           */
/*==============================================================*/


drop table if exists game_actor_info;

drop table if exists game_actor_skill;

drop table if exists game_dict_index;

drop table if exists game_dict_value;

drop table if exists game_equip_info;

drop table if exists game_equip_skill;

drop table if exists game_item_info;

drop table if exists game_level_info;

drop table if exists game_menu_info;

drop table if exists game_promotion_info;

drop table if exists game_scene_info;

drop table if exists game_scene_menu;

drop table if exists game_server_info;

drop table if exists game_skill_info;

drop table if exists server_bulletin;

drop table if exists server_league_info;

drop table if exists server_player_actor;

drop table if exists server_player_friend;

drop table if exists server_player_info;

drop table if exists server_player_item;

drop table if exists server_promotion;

drop table if exists sys_article;

drop table if exists sys_article_reply;

drop table if exists sys_cust;

drop table if exists sys_cust_message;

drop table if exists sys_message;

/*==============================================================*/
/* Table: game_actor_info                                       */
/*==============================================================*/
create table game_actor_info
(
   actorid              varchar(16) not null comment '��ɫID',
   actorname            varchar(32) not null comment '��ɫ����',
   aptitude             int not null default 0 comment '����',
   attack               int not null default 0 comment '����ֵ',
   defense              int not null default 0 comment '���ֵ',
   hp                   int not null default 0 comment '����ֵ',
   mp                   int not null default 0 comment 'ħ��ֵ',
   ep                   int not null default 0 comment '����ֵ',
   initrank             int not null default 0 comment '��ʼ�Ǽ�',
   maxrank              int not null default 0 comment '����Ǽ�',
   attr                 int not null default 0 comment '����',
   primary key (actorid)
);

/*==============================================================*/
/* Table: game_actor_skill                                      */
/*==============================================================*/
create table game_actor_skill
(
   actorid              varchar(16) not null comment '��ɫID',
   skillid              varchar(16) not null comment '����ID',
   primary key (actorid, skillid)
);

/*==============================================================*/
/* Table: game_dict_index                                       */
/*==============================================================*/
create table game_dict_index
(
   dictcode             int not null default 0 comment '�ֵ����',
   dictname             varchar(32) not null comment '�ֵ�����',
   dftitem              varchar(8) comment 'Ĭ��ֵ',
   primary key (dictcode)
);

/*==============================================================*/
/* Table: game_dict_value                                       */
/*==============================================================*/
create table game_dict_value
(
   dictcode             int not null default 0 comment '�ֵ����',
   itemcode             varchar(8) not null comment 'ѡ�����',
   itemvalue            varchar(32) not null comment 'ѡ��ֵ',
   primary key (dictcode, itemcode)
);

/*==============================================================*/
/* Table: game_equip_info                                       */
/*==============================================================*/
create table game_equip_info
(
   equipid              varchar(16) not null comment 'װ��ID',
   equipname            varchar(32) not null comment 'װ������',
   icon                 varchar(32) not null comment 'ͼ��',
   remark               varchar(256) not null comment '����',
   position             char(1) not null default '0' comment '��λ',
   rank                 char(1) not null default '0' comment '�ȼ�',
   primary key (equipid)
);

/*==============================================================*/
/* Table: game_equip_skill                                      */
/*==============================================================*/
create table game_equip_skill
(
   equipid              varchar(16) not null,
   skillid              varchar(16) not null,
   primary key (equipid, skillid)
);

/*==============================================================*/
/* Table: game_item_info                                        */
/*==============================================================*/
create table game_item_info
(
   itemid               varchar(16) not null comment '����ID',
   itemname             varchar(32) not null comment '��������',
   icon                 varchar(32) not null comment 'ͼ��',
   remark               varchar(256) not null comment '����',
   type                 int not null default 0 comment '��������',
   rank                 char(1) not null default '0' comment '�ȼ�',
   primary key (itemid)
);

/*==============================================================*/
/* Table: game_level_info                                       */
/*==============================================================*/
create table game_level_info
(
   levelid              int not null default 0,
   levelname            varchar(32) not null,
   icon                 varchar(32) not null,
   minpoint             int not null default 0,
   maxpoint             int not null default 0,
   remark               varchar(256) not null,
   primary key (levelid)
);

/*==============================================================*/
/* Table: game_menu_info                                        */
/*==============================================================*/
create table game_menu_info
(
   menuid               varchar(8) not null,
   menuname             varchar(32) not null,
   icon                 varchar(32) not null,
   url                  varchar(32) not null,
   primary key (menuid)
);

/*==============================================================*/
/* Table: game_promotion_info                                   */
/*==============================================================*/
create table game_promotion_info
(
   promid               int not null default 0,
   promname             varchar(32) not null,
   remark               varchar(256),
   primary key (promid)
);

alter table game_promotion_info comment '�����';

/*==============================================================*/
/* Table: game_scene_info                                       */
/*==============================================================*/
create table game_scene_info
(
   sceneid              int not null default 0 comment '����ID',
   scenename            varchar(32) not null comment '��������',
   primary key (sceneid)
);

/*==============================================================*/
/* Table: game_scene_menu                                       */
/*==============================================================*/
create table game_scene_menu
(
   sceneid              int not null default 0,
   menuid               varchar(32) not null,
   primary key (sceneid, menuid)
);

/*==============================================================*/
/* Table: game_server_info                                      */
/*==============================================================*/
create table game_server_info
(
   serverid             varchar(8) not null comment '������ID',
   servername           varchar(32) not null comment '����������',
   sno                  int not null default 0 comment '�������',
   opendate             varchar(8) not null comment '��������',
   opentime             varchar(6) not null comment '����ʱ��',
   maxplayer            int not null default 0 comment '��������',
   regplayer            int not null default 0 comment 'ע�������',
   onlineplayer         int not null default 0 comment '���������',
   primary key (serverid)
);

/*==============================================================*/
/* Table: game_skill_info                                       */
/*==============================================================*/
create table game_skill_info
(
   skillid              varchar(16) not null comment '����ID',
   skillname            varchar(32) not null comment '��������',
   icon                 varchar(32) not null comment '����ͼ��',
   remark               varchar(256) not null comment '��������',
   type                 char(1) not null default '0' comment '�������ͣ���ɫ��װ����',
   primary key (skillid)
);

/*==============================================================*/
/* Table: server_bulletin                                       */
/*==============================================================*/
create table server_bulletin
(
   serverid             varchar(8) not null comment '������ID',
   title                varchar(32) not null comment '�������',
   content              varchar(1024) not null comment '��������',
   startdate            varchar(8) not null comment '��ʼ����',
   enddate              varchar(8) not null comment '��������',
   issuer               varchar(32) not null comment '������',
   primary key (title)
);

alter table server_bulletin comment '�����';

/*==============================================================*/
/* Table: server_league_info                                    */
/*==============================================================*/
create table server_league_info
(
   leagueid             varchar(32) not null,
   serverid             varchar(8) not null,
   leaguename           varchar(32) not null,
   remark               varchar(256) not null,
   maxleaguer           int not null default 0,
   primary key (leagueid)
);

alter table server_league_info comment '����';

/*==============================================================*/
/* Table: server_player_actor                                   */
/*==============================================================*/
create table server_player_actor
(
   playerid             varchar(32) not null comment '���ID',
   actorid              varchar(16) not null comment '��ɫID',
   rank                 int not null default 0 comment '�Ǽ�',
   level                int not null default 0 comment '�ȼ�',
   primary key (playerid, actorid)
);

/*==============================================================*/
/* Table: server_player_friend                                  */
/*==============================================================*/
create table server_player_friend
(
   playerid             varchar(32) not null comment '���ID',
   friendlist           varchar(2048) not null comment '�����б��ŷָ�',
   friendnum            int not null default 0 comment '��������������60',
   primary key (playerid)
);

/*==============================================================*/
/* Table: server_player_info                                    */
/*==============================================================*/
create table server_player_info
(
   playerid             varchar(32) not null comment '���ID��serverid+custno',
   serverid             varchar(8) not null,
   custno               int not null,
   playernick           varchar(32) not null,
   logindate            varchar(8) not null,
   logintime            varchar(6) not null,
   level                int not null default 0,
   primary key (playerid)
);

/*==============================================================*/
/* Table: server_player_item                                    */
/*==============================================================*/
create table server_player_item
(
   playid               varchar(32) not null,
   itemid               varchar(16) not null,
   num                  int not null default 0,
   primary key (playid, itemid)
);

/*==============================================================*/
/* Table: server_promotion                                      */
/*==============================================================*/
create table server_promotion
(
   serverid             varchar(8) not null,
   promid               int not null default 0,
   startdate            varchar(8) not null,
   starttime            varchar(6) not null,
   enddate              varchar(8) not null,
   endtime              varchar(6) not null,
   primary key (serverid, promid)
);

alter table server_promotion comment '�������';

/*==============================================================*/
/* Table: sys_article                                           */
/*==============================================================*/
create table sys_article
(
   artid                int not null default 0 comment '����ID',
   title                varchar(32) not null comment '����',
   author               int not null comment '����',
   content              varchar(2048) not null comment '����',
   pubflag              char(1) not null default '0' comment '�����־',
   pubdate              varchar(8) comment '��������',
   pubtime              varchar(6) comment '����ʱ��',
   lastreplydate        varchar(8) comment '���»ظ�����',
   lastreplytime        varchar(6) comment '���»ظ�ʱ��',
   readtimes            int not null default 0 comment '�Ķ�����',
   replytimes           int not null default 0 comment '�ظ�����',
   topflag              char(1) not null default '0' comment '�ö���־',
   checkflag            char(1) not null default '0' comment '���˱�־',
   checker              int not null comment '������',
   closeflag            char(1) not null default '0' comment '�رձ�־',
   closer               int not null comment '�ر���',
   primary key (artid)
);

alter table sys_article comment '��̳����';

/*==============================================================*/
/* Table: sys_article_reply                                     */
/*==============================================================*/
create table sys_article_reply
(
   artid                int not null default 0,
   replyid              int not null,
   content              varchar(1024) not null,
   replyer              int not null,
   replydate            varchar(8) not null,
   replytime            varchar(6) not null,
   primary key (artid, replyid)
);

alter table sys_article_reply comment '���ӻظ�';

/*==============================================================*/
/* Table: sys_cust                                              */
/*==============================================================*/
create table sys_cust
(
   custno               int not null comment '�ͻ��ţ��Զ�����',
   loginid              varchar(32) not null comment '��¼ID',
   loginpwd             char(32) not null comment '��¼����',
   nickname             varchar(32) not null comment '�û��ǳ�',
   idtype               char(1) not null default '0' comment '֤������',
   idcode               varchar(32) comment '֤������',
   idname               varchar(32) comment '֤������',
   birthday             varchar(8) comment '��������',
   email                varchar(64) comment '�����ʼ�',
   mobile               varchar(16) not null comment '�ֻ�����',
   regdate              varchar(8) comment 'ע������',
   primary key (custno)
);

/*==============================================================*/
/* Table: sys_cust_message                                      */
/*==============================================================*/
create table sys_cust_message
(
   custno               int not null comment '�ͻ���',
   msgid                int not null default 0 comment '��ϢID',
   isread               char(1) not null default '0' comment '�Ѷ���־',
   primary key (custno, msgid)
);

/*==============================================================*/
/* Table: sys_message                                           */
/*==============================================================*/
create table sys_message
(
   msgid                int not null default 0 comment '��ϢID',
   content              varchar(1024) not null comment '��Ϣ����',
   author               int not null default 0 comment '����',
   senddate             varchar(8) comment '��������',
   sendtime             varchar(6) comment '����ʱ��',
   primary key (msgid)
);

