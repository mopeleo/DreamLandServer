package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysArticleReply;
import java.util.List;

public interface SysArticleReplyDao{

    int insert(SysArticleReply entity);

    List<SysArticleReply> selectAll(SysArticleReply where);

    SysArticleReply selectById(Long artid, Long replyid);

    int deleteById(Long artid, Long replyid);

    int updateById(SysArticleReply entity);
	
    int dynamicUpdateById(SysArticleReply entity);
}
