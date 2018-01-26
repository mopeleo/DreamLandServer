package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysArticle;
import java.util.List;

public interface SysArticleDao{

    int insert(SysArticle entity);

    List<SysArticle> selectAll(SysArticle where);

    SysArticle selectById(Long artid);

    int deleteById(Long artid);

    int updateById(SysArticle entity);
	
    int dynamicUpdateById(SysArticle entity);
}
