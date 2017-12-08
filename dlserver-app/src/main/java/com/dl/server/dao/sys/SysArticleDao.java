package com.dl.server.dao.sys;

import com.dl.server.entity.sys.SysArticle;
import java.util.List;

public interface SysArticleDao{

    SysArticle findUnique(SysArticle entity);
    
    int insert(SysArticle entity);

    List<SysArticle> selectAll();

    SysArticle selectById(Integer artid);

    int deleteById(Integer artid);

    int updateById(SysArticle entity);
}
