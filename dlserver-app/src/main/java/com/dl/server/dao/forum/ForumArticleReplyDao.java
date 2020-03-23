package com.dl.server.dao.forum;

import com.dl.server.entity.forum.ForumArticleReply;
import java.util.List;

public interface ForumArticleReplyDao{

    int insert(ForumArticleReply entity);

    List<ForumArticleReply> selectAll(ForumArticleReply where);

    ForumArticleReply selectById(String artid, Long replyid);

    int deleteById(String artid, Long replyid);

    int updateById(ForumArticleReply entity);
	
    int dynamicUpdateById(ForumArticleReply entity);
}
