package com.dl.server.dao.forum;

import com.dl.server.entity.forum.ForumArticle;
import java.util.List;

public interface ForumArticleDao{

    int insert(ForumArticle entity);

    List<ForumArticle> selectAll(ForumArticle where);

    ForumArticle selectById(String artid);

    int deleteById(String artid);

    int updateById(ForumArticle entity);
	
    int dynamicUpdateById(ForumArticle entity);
}
