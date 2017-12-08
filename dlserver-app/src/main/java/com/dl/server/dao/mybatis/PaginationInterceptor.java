package com.dl.server.dao.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dl.base.utils.ReflectionUtil;

@Intercepts({@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})})
public class PaginationInterceptor implements Interceptor {
    private static Logger log = LoggerFactory.getLogger(PaginationInterceptor.class);
    private String dialect = null;
    private String sqlId = null;
    
    @Override
    public Object intercept(Invocation invock) throws Throwable {
        if(invock.getTarget() instanceof RoutingStatementHandler){
            RoutingStatementHandler handler = (RoutingStatementHandler) invock.getTarget();
            //通过反射获取到当前RoutingStatementHandler对象的delegate属性
            StatementHandler delegate = (StatementHandler)ReflectionUtil.getFieldValue(handler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectionUtil.getFieldValue(delegate, "mappedStatement");
            if (mappedStatement.getId().matches(sqlId)) {
                BoundSql boundSql = delegate.getBoundSql();
                Object parameterObject = boundSql.getParameterObject();
                if (parameterObject == null) {
                    throw new NullPointerException("分页查询传入参数为空");
                }
                Connection connection = (Connection) invock.getArgs()[0];
                String sql = boundSql.getSql();
                String countSql = "select count(1) from (" + sql + ")";
                log.info("分页查询[" + mappedStatement.getId() + "]统计总数SQL ： " + countSql);

                PreparedStatement countStmt = connection.prepareStatement(countSql);
                BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                ResultSet rs = countStmt.executeQuery();
                int count = 0;
                if (rs.next()) {
                    count = rs.getInt(1);
                }
                rs.close();
                countStmt.close();
            }
        }
        return invock.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties p) {
        dialect = p.getProperty("dialect");
        if(dialect == null || "".equals(dialect)){
            log.info("property 'dialect' is not exists, use default value 'mysql' ");
            dialect = "mysql";
        }
        
        sqlId = p.getProperty("sqlId");
        if(sqlId == null || "".equals(sqlId)){
            log.info("property 'sqlId' is not exists, use default value '*Page' ");
            sqlId = "*Page";
        }
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }
}
