package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysArticleReply;
import java.util.List;

public interface SysArticleReplyDao{

    SysArticleReply findUnique(SysArticleReply entity);
    
    int insert(SysArticleReply entity);

    List<SysArticleReply> selectAll();

    SysArticleReply selectById(Integer artid, Integer replyid);

    int deleteById(Integer artid, Integer replyid);

    int updateById(SysArticleReply entity);
}
