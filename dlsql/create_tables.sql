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
   actorid              varchar(16) not null comment '角色ID',
   actorname            varchar(32) not null comment '角色名称',
   aptitude             int not null default 0 comment '资质',
   attack               int not null default 0 comment '攻击值',
   defense              int not null default 0 comment '物防值',
   hp                   int not null default 0 comment '生命值',
   mp                   int not null default 0 comment '魔法值',
   ep                   int not null default 0 comment '能量值',
   initrank             int not null default 0 comment '初始星级',
   maxrank              int not null default 0 comment '最大星级',
   attr                 int not null default 0 comment '属性',
   primary key (actorid)
);

/*==============================================================*/
/* Table: game_actor_skill                                      */
/*==============================================================*/
create table game_actor_skill
(
   actorid              varchar(16) not null comment '角色ID',
   skillid              varchar(16) not null comment '技能ID',
   primary key (actorid, skillid)
);

/*==============================================================*/
/* Table: game_dict_index                                       */
/*==============================================================*/
create table game_dict_index
(
   dictcode             int not null default 0 comment '字典代码',
   dictname             varchar(32) not null comment '字典名称',
   dftitem              varchar(8) comment '默认值',
   primary key (dictcode)
);

/*==============================================================*/
/* Table: game_dict_value                                       */
/*==============================================================*/
create table game_dict_value
(
   dictcode             int not null default 0 comment '字典代码',
   itemcode             varchar(8) not null comment '选项代码',
   itemvalue            varchar(32) not null comment '选项值',
   primary key (dictcode, itemcode)
);

/*==============================================================*/
/* Table: game_equip_info                                       */
/*==============================================================*/
create table game_equip_info
(
   equipid              varchar(16) not null comment '装备ID',
   equipname            varchar(32) not null comment '装备名称',
   icon                 varchar(32) not null comment '图标',
   remark               varchar(256) not null comment '描述',
   position             char(1) not null default '0' comment '部位',
   rank                 char(1) not null default '0' comment '等级',
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
   itemid               varchar(16) not null comment '道具ID',
   itemname             varchar(32) not null comment '道具名称',
   icon                 varchar(32) not null comment '图标',
   remark               varchar(256) not null comment '描述',
   type                 int not null default 0 comment '道具类型',
   rank                 char(1) not null default '0' comment '等级',
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

alter table game_promotion_info comment '促销活动';

/*==============================================================*/
/* Table: game_scene_info                                       */
/*==============================================================*/
create table game_scene_info
(
   sceneid              int not null default 0 comment '场景ID',
   scenename            varchar(32) not null comment '场景名称',
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
   serverid             varchar(8) not null comment '服务器ID',
   servername           varchar(32) not null comment '服务器名称',
   sno                  int not null default 0 comment '开服序号',
   opendate             varchar(8) not null comment '开服日期',
   opentime             varchar(6) not null comment '开服时间',
   maxplayer            int not null default 0 comment '最大玩家数',
   regplayer            int not null default 0 comment '注册玩家数',
   onlineplayer         int not null default 0 comment '在线玩家数',
   primary key (serverid)
);

/*==============================================================*/
/* Table: game_skill_info                                       */
/*==============================================================*/
create table game_skill_info
(
   skillid              varchar(16) not null comment '技能ID',
   skillname            varchar(32) not null comment '技能名称',
   icon                 varchar(32) not null comment '技能图标',
   remark               varchar(256) not null comment '技能描述',
   type                 char(1) not null default '0' comment '技能类型（角色，装备）',
   primary key (skillid)
);

/*==============================================================*/
/* Table: server_bulletin                                       */
/*==============================================================*/
create table server_bulletin
(
   serverid             varchar(8) not null comment '服务器ID',
   title                varchar(32) not null comment '公告标题',
   content              varchar(1024) not null comment '公告内容',
   startdate            varchar(8) not null comment '开始日期',
   enddate              varchar(8) not null comment '结束日期',
   issuer               varchar(32) not null comment '发布者',
   primary key (title)
);

alter table server_bulletin comment '公告板';

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

alter table server_league_info comment '联盟';

/*==============================================================*/
/* Table: server_player_actor                                   */
/*==============================================================*/
create table server_player_actor
(
   playerid             varchar(32) not null comment '玩家ID',
   actorid              varchar(16) not null comment '角色ID',
   rank                 int not null default 0 comment '星级',
   level                int not null default 0 comment '等级',
   primary key (playerid, actorid)
);

/*==============================================================*/
/* Table: server_player_friend                                  */
/*==============================================================*/
create table server_player_friend
(
   playerid             varchar(32) not null comment '玩家ID',
   friendlist           varchar(2048) not null comment '好友列表逗号分隔',
   friendnum            int not null default 0 comment '好友数量，上限60',
   primary key (playerid)
);

/*==============================================================*/
/* Table: server_player_info                                    */
/*==============================================================*/
create table server_player_info
(
   playerid             varchar(32) not null comment '玩家ID，serverid+custno',
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

alter table server_promotion comment '服务器活动';

/*==============================================================*/
/* Table: sys_article                                           */
/*==============================================================*/
create table sys_article
(
   artid                int not null default 0 comment '文章ID',
   title                varchar(32) not null comment '标题',
   author               int not null comment '作者',
   content              varchar(2048) not null comment '内容',
   pubflag              char(1) not null default '0' comment '发表标志',
   pubdate              varchar(8) comment '发表日期',
   pubtime              varchar(6) comment '发表时间',
   lastreplydate        varchar(8) comment '最新回复日期',
   lastreplytime        varchar(6) comment '最新回复时间',
   readtimes            int not null default 0 comment '阅读次数',
   replytimes           int not null default 0 comment '回复次数',
   topflag              char(1) not null default '0' comment '置顶标志',
   checkflag            char(1) not null default '0' comment '复核标志',
   checker              int not null comment '复核人',
   closeflag            char(1) not null default '0' comment '关闭标志',
   closer               int not null comment '关闭人',
   primary key (artid)
);

alter table sys_article comment '论坛帖子';

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

alter table sys_article_reply comment '帖子回复';

/*==============================================================*/
/* Table: sys_cust                                              */
/*==============================================================*/
create table sys_cust
(
   custno               int not null comment '客户号，自动生成',
   loginid              varchar(32) not null comment '登录ID',
   loginpwd             char(32) not null comment '登录密码',
   nickname             varchar(32) not null comment '用户昵称',
   idtype               char(1) not null default '0' comment '证件类型',
   idcode               varchar(32) comment '证件号码',
   idname               varchar(32) comment '证件姓名',
   birthday             varchar(8) comment '出生日期',
   email                varchar(64) comment '电子邮件',
   mobile               varchar(16) not null comment '手机号码',
   regdate              varchar(8) comment '注册日期',
   primary key (custno)
);

/*==============================================================*/
/* Table: sys_cust_message                                      */
/*==============================================================*/
create table sys_cust_message
(
   custno               int not null comment '客户号',
   msgid                int not null default 0 comment '消息ID',
   isread               char(1) not null default '0' comment '已读标志',
   primary key (custno, msgid)
);

/*==============================================================*/
/* Table: sys_message                                           */
/*==============================================================*/
create table sys_message
(
   msgid                int not null default 0 comment '消息ID',
   content              varchar(1024) not null comment '消息内容',
   author               int not null default 0 comment '作者',
   senddate             varchar(8) comment '发送日期',
   sendtime             varchar(6) comment '发送时间',
   primary key (msgid)
);

