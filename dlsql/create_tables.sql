/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/27 11:40:48                           */
/*==============================================================*/


drop table if exists cust_info;

drop table if exists cust_info_ext;

drop table if exists cust_pay_acct;

drop table if exists cust_pay_log;

drop table if exists forum_article;

drop table if exists forum_article_reply;

drop table if exists game_actor_info;

drop table if exists game_actor_skill;

drop table if exists game_equip_info;

drop table if exists game_equip_skill;

drop table if exists game_item_info;

drop table if exists game_level_info;

drop table if exists game_meun_info;

drop table if exists game_promotion_info;

drop table if exists game_scene_info;

drop table if exists game_scene_menu;

drop table if exists game_skill_info;

drop table if exists server_bulletin;

drop table if exists server_info;

drop table if exists server_league_info;

drop table if exists server_msg_receive;

drop table if exists server_msg_send;

drop table if exists server_param;

drop table if exists server_player_actor;

drop table if exists server_player_friend;

drop table if exists server_player_info;

drop table if exists server_player_item;

drop table if exists server_promotion;

drop table if exists sys_dict_index;

drop table if exists sys_dict_value;

drop table if exists sys_param;

/*==============================================================*/
/* Table: cust_info                                             */
/*==============================================================*/
create table cust_info
(
   custno               numeric(10,0) not null default 0 comment '客户号，自动生成',
   loginpwd             char(32) not null comment '登录密码',
   salt                 varchar(32) not null comment '密码盐，随机生成',
   nickname             varchar(32) not null comment '用户昵称',
   status               char(1) not null default '0' comment '客户状态，0-正常，1-密码错误锁定，2-账号锁定，3-账号冻结',
   level                char(1) not null default '0' comment '客户级别',
   idtype               char(1) default '0' comment '证件类型',
   idcode               varchar(32) comment '证件号码',
   idname               varchar(32) comment '证件姓名',
   email                varchar(64) not null comment '电子邮件',
   mobile               varchar(16) not null comment '手机号码',
   regdate              varchar(8) comment '注册日期',
   lastlogindate        varchar(8) comment '上次登录日期',
   lastlogintime        varchar(6) comment '上次登录时间',
   primary key (custno)
);

/*==============================================================*/
/* Table: cust_info_ext                                         */
/*==============================================================*/
create table cust_info_ext
(
   custno               numeric(10,0) not null default 0,
   birthday             varchar(8) comment '出生日期',
   province             varchar(8) comment '所在省份',
   city                 varchar(8) comment '所在城市',
   address              varchar(64) comment '联系地址',
   profession           varchar(8) comment '职业'
);

alter table cust_info_ext comment ' 客户信息扩展表';

/*==============================================================*/
/* Table: cust_pay_acct                                         */
/*==============================================================*/
create table cust_pay_acct
(
   acctno               numeric(10,0) not null default 0 comment '账户编号',
   custno               numeric(10,0) not null default 0,
   paytype              char(1) not null default '0' comment '支付方式，0，银行卡，1微信，2，支付宝',
   payno                varchar(32) not null comment '支付账号',
   primary key (acctno)
);

alter table cust_pay_acct comment '客户支付账户';

/*==============================================================*/
/* Table: cust_pay_log                                          */
/*==============================================================*/
create table cust_pay_log
(
   logid                char(32) not null,
   custno               numeric(10,0) not null default 0,
   acctno               numeric(10,0) not null default 0,
   serverid             varchar(8) not null,
   direction            char(1) not null default '0' comment '方向，0 支付，1，退款',
   amt                  numeric(16,2) not null default 0.00 comment '金额',
   otheracct            varchar(32) not null comment '对方账户',
   paytype              char(1) not null default '0' comment '支付类型：1，充值，2，购买XX',
   status               char(1) not null default '0' comment '状态，0，支付中，1，成功，2，失败',
   paydate              varchar(8) not null,
   paytime              varchar(6) not null,
   summary              varchar(32) comment '备注',
   primary key (logid)
);

alter table cust_pay_log comment '客户支付流水';

/*==============================================================*/
/* Table: forum_article                                         */
/*==============================================================*/
create table forum_article
(
   artid                char(32) not null comment '文章ID',
   title                varchar(32) not null comment '标题',
   author               numeric(10,0) not null default 0 comment '作者',
   content              varchar(2048) not null comment '内容',
   pubflag              char(1) not null default '0' comment '发表标志',
   pubdate              varchar(8) comment '发表日期',
   pubtime              varchar(6) comment '发表时间',
   lastreplydate        varchar(8) comment '最新回复日期',
   lastreplytime        varchar(6) comment '最新回复时间',
   readtimes            decimal not null default 0 comment '阅读次数',
   replytimes           numeric(8,0) not null default 0 comment '回复次数',
   topflag              char(1) not null default '0' comment '置顶标志',
   checkflag            char(1) not null default '0' comment '复核标志',
   checker              numeric(10,0) not null default 0 comment '复核人',
   closeflag            char(1) not null default '0' comment '关闭标志',
   closer               numeric(10,0) not null default 0 comment '关闭人',
   primary key (artid)
);

alter table forum_article comment '论坛帖子';

/*==============================================================*/
/* Table: forum_article_reply                                   */
/*==============================================================*/
create table forum_article_reply
(
   artid                char(32) not null,
   replyid              numeric not null default 0,
   content              varchar(1024) not null,
   replyer              numeric(10,0) not null default 0,
   replydate            varchar(8) not null,
   replytime            varchar(6) not null,
   primary key (artid, replyid)
);

alter table forum_article_reply comment '帖子回复';

/*==============================================================*/
/* Table: game_actor_info                                       */
/*==============================================================*/
create table game_actor_info
(
   actorid              varchar(16) not null comment '角色ID',
   actorname            varchar(32) not null comment '角色名称',
   aptitude             numeric(8,0) not null default 0 comment '资质',
   attack               numeric(8,0) not null default 0 comment '攻击值',
   defense              numeric(8,0) not null default 0 comment '物防值',
   hp                   numeric(8,0) not null default 0 comment '生命值',
   mp                   numeric(8,0) not null default 0 comment '魔法值',
   ep                   numeric(8,0) not null default 0 comment '能量值',
   initrank             numeric(8,0) not null default 0 comment '初始星级',
   maxrank              numeric(8,0) not null default 0 comment '最大星级',
   attr                 numeric(8,0) not null default 0 comment '属性',
   primary key (actorid)
);

alter table game_actor_info comment '角色信息表';

/*==============================================================*/
/* Table: game_actor_skill                                      */
/*==============================================================*/
create table game_actor_skill
(
   actorid              varchar(16) not null comment '角色ID',
   skillid              varchar(16) not null comment '技能ID',
   primary key (actorid, skillid)
);

alter table game_actor_skill comment '角色技能表';

/*==============================================================*/
/* Table: game_equip_info                                       */
/*==============================================================*/
create table game_equip_info
(
   equipid              varchar(16) not null comment '装备ID',
   equipname            varchar(32) not null comment '装备名称',
   icon                 varchar(32) not null comment '图标',
   position             char(1) not null default '0' comment '部位',
   rank                 char(1) not null default '0' comment '等级',
   remark               varchar(256) not null comment '描述',
   primary key (equipid)
);

alter table game_equip_info comment '装备信息表';

/*==============================================================*/
/* Table: game_equip_skill                                      */
/*==============================================================*/
create table game_equip_skill
(
   equipid              varchar(16) not null,
   skillid              varchar(16) not null,
   primary key (equipid, skillid)
);

alter table game_equip_skill comment '装备技能表';

/*==============================================================*/
/* Table: game_item_info                                        */
/*==============================================================*/
create table game_item_info
(
   itemid               varchar(16) not null comment '道具ID',
   itemname             varchar(32) not null comment '道具名称',
   icon                 varchar(32) not null comment '图标',
   type                 char(1) not null default '0' comment '道具类型',
   rank                 char(1) not null default '0' comment '等级',
   remark               varchar(256) not null comment '描述',
   primary key (itemid)
);

/*==============================================================*/
/* Table: game_level_info                                       */
/*==============================================================*/
create table game_level_info
(
   levelid              numeric(8,0) not null default 0 comment '等级ID',
   levelname            varchar(32) not null comment '等级名称',
   nextlevel            numeric(8,0) not null default 0 comment '下一等级',
   icon                 varchar(32) not null comment '等级图标',
   minpoint             numeric(8,0) not null default 0 comment '经验下限（包含）',
   maxpoint             numeric(8,0) not null default 0 comment '等级上限（不包含）',
   type                 char(1) not null default '0' comment '0，会员等级，1角色等级，2工会等级，3装备等级，4技能等级',
   remark               varchar(256),
   primary key (levelid)
);

/*==============================================================*/
/* Table: game_meun_info                                        */
/*==============================================================*/
create table game_meun_info
(
   menuid               varchar(8) not null,
   menuname             varchar(32) not null,
   icon                 varchar(32) not null,
   url                  varchar(32) not null,
   primary key (menuid)
);

alter table game_meun_info comment '功能点菜单表';

/*==============================================================*/
/* Table: game_promotion_info                                   */
/*==============================================================*/
create table game_promotion_info
(
   promid               numeric(8,0) not null default 0,
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
   sceneid              numeric(8,0) not null default 0 comment '场景ID',
   scenename            varchar(32) not null comment '场景名称',
   primary key (sceneid)
);

/*==============================================================*/
/* Table: game_scene_menu                                       */
/*==============================================================*/
create table game_scene_menu
(
   sceneid              numeric(8,0) not null default 0,
   menuid               varchar(8) not null,
   primary key (sceneid, menuid)
);

/*==============================================================*/
/* Table: game_skill_info                                       */
/*==============================================================*/
create table game_skill_info
(
   skillid              varchar(16) not null comment '技能ID',
   skillname            varchar(32) not null comment '技能名称',
   icon                 varchar(32) not null comment '技能图标',
   type                 char(1) not null default '0' comment '技能类型（角色，装备）',
   remark               varchar(256) not null comment '技能描述',
   primary key (skillid)
);

alter table game_skill_info comment '技能信息表';

/*==============================================================*/
/* Table: server_bulletin                                       */
/*==============================================================*/
create table server_bulletin
(
   id                   numeric(16,0) not null default 0,
   serverid             varchar(8) not null comment '服务器ID',
   title                varchar(32) not null comment '公告标题',
   content              varchar(1024) not null comment '公告内容',
   startdate            varchar(8) not null comment '开始日期',
   enddate              varchar(8) not null comment '结束日期',
   issuer               varchar(32) not null comment '发布者',
   primary key (id)
);

alter table server_bulletin comment '公告板';

/*==============================================================*/
/* Table: server_info                                           */
/*==============================================================*/
create table server_info
(
   serverid             varchar(8) not null comment '服务器ID',
   servername           varchar(32) not null comment '服务器名称',
   opendate             varchar(8) not null comment '开服日期',
   opentime             varchar(6) not null comment '开服时间',
   maxplayer            numeric(8,0) not null default 0 comment '最大玩家数',
   regplayer            numeric(8,0) not null default 0 comment '注册玩家数',
   onlineplayer         numeric(8,0) not null default 0 comment '在线玩家数',
   status               numeric(1,0) not null default 0 comment '服务器状态0，未开，1，以开，2，维护中',
   primary key (serverid)
);

/*==============================================================*/
/* Table: server_league_info                                    */
/*==============================================================*/
create table server_league_info
(
   leagueid             varchar(32) not null,
   serverid             varchar(8) not null,
   leaguename           varchar(32) not null comment '联盟名称',
   maxleaguer           numeric(8,0) not null default 0 comment '最大成员数',
   level                numeric(8,0) not null default 0 comment '联盟等级',
   creator              numeric(10,0) not null default 0 comment '盟主',
   createdate           varchar(8),
   createtime           varchar(6),
   remark               varchar(256) not null,
   primary key (leagueid)
);

alter table server_league_info comment '联盟';

/*==============================================================*/
/* Table: server_msg_receive                                    */
/*==============================================================*/
create table server_msg_receive
(
   msgid                numeric not null default 0 comment '消息ID',
   serverid             varchar(8) not null,
   custno               numeric(10,0) not null default 0 comment '客户号',
   isread               char(1) not null default '0' comment '已读标志',
   primary key (msgid, serverid)
);

alter table server_msg_receive comment '收到消息表';

/*==============================================================*/
/* Table: server_msg_send                                       */
/*==============================================================*/
create table server_msg_send
(
   msgid                numeric not null default 0 comment '消息ID',
   serverid             varchar(8) not null,
   custno               numeric(10,0) not null default 0 comment '作者',
   content              varchar(1024) not null comment '消息内容',
   type                 char(1) not null default '0' comment '类型，0-所有人可见，1，公会可见，2，指定人可见',
   receiver             numeric(10,0) default 0,
   senddate             varchar(8) comment '发送日期',
   sendtime             varchar(6) comment '发送时间',
   primary key (msgid)
);

alter table server_msg_send comment '消息发送表';

/*==============================================================*/
/* Table: server_param                                          */
/*==============================================================*/
create table server_param
(
   serverid             varchar(8) not null,
   paramid              varchar(8) not null,
   paramvalue           varchar(8) not null,
   primary key (serverid, paramid)
);

alter table server_param comment '服务器系统参数表';

/*==============================================================*/
/* Table: server_player_actor                                   */
/*==============================================================*/
create table server_player_actor
(
   serverid             varchar(8) not null,
   custno               numeric(10,0) not null default 0,
   actorid              varchar(16) not null comment '角色ID',
   rank                 numeric(8,0) not null default 0 comment '星级',
   level                numeric(8,0) not null default 0 comment '等级',
   primary key (actorid, serverid, custno)
);

/*==============================================================*/
/* Table: server_player_friend                                  */
/*==============================================================*/
create table server_player_friend
(
   serverid             varchar(8) not null,
   custno               numeric(10,0) not null default 0,
   friendlist           varchar(2048) not null comment '好友列表逗号分隔',
   friendnum            numeric(8,0) not null default 0 comment '好友数量，上限60',
   primary key (serverid, custno)
);

/*==============================================================*/
/* Table: server_player_info                                    */
/*==============================================================*/
create table server_player_info
(
   serverid             varchar(8) not null,
   custno               numeric(10,0) not null default 0,
   nickname             varchar(32) not null,
   logindate            varchar(8) not null,
   logintime            varchar(6) not null,
   playerlevel          numeric(8,0) not null default 0 comment '玩家等级',
   viplevel             numeric(8,0) not null default 0 comment '会员等级',
   crystal              numeric(8,0) not null default 0 comment '水晶数量，游戏货币',
   primary key (serverid, custno)
);

/*==============================================================*/
/* Table: server_player_item                                    */
/*==============================================================*/
create table server_player_item
(
   serverid             varchar(8) not null,
   custno               numeric(10,0) not null default 0,
   itemid               varchar(16) not null,
   num                  numeric(8,0) not null default 0,
   primary key (itemid, serverid, custno)
);

/*==============================================================*/
/* Table: server_promotion                                      */
/*==============================================================*/
create table server_promotion
(
   serverid             varchar(8) not null,
   promid               numeric(8,0) not null default 0,
   startdate            varchar(8) not null,
   starttime            varchar(6) not null,
   enddate              varchar(8) not null,
   endtime              varchar(6) not null,
   primary key (serverid, promid)
);

alter table server_promotion comment '服务器活动';

/*==============================================================*/
/* Table: sys_dict_index                                        */
/*==============================================================*/
create table sys_dict_index
(
   dictcode             numeric(8,0) not null default 0 comment '字典代码',
   dictname             varchar(32) not null comment '字典名称',
   dftitem              varchar(8) comment '默认值',
   primary key (dictcode)
);

/*==============================================================*/
/* Table: sys_dict_value                                        */
/*==============================================================*/
create table sys_dict_value
(
   dictcode             numeric(8,0) not null default 0 comment '字典代码',
   itemcode             varchar(8) not null comment '选项代码',
   itemvalue            varchar(32) not null comment '选项值',
   primary key (dictcode, itemcode)
);

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   paramid              varchar(8) not null,
   paramname            varchar(32) not null,
   paramvalue           varchar(8) not null,
   initvalue            varchar(8) not null,
   remark               varchar(64),
   primary key (paramid)
);

alter table sys_param comment '系统参数表';

