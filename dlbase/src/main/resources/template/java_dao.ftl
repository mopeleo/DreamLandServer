<#macro type datatype precision><#if datatype?contains("A")>String<#elseif datatype=="INT">Int<#elseif precision != "">Double<#else>Int</#if></#macro>
package com.szkingdom.lcpt.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ${entity}Op{
    public static boolean select( ${entity} ${table.code?lower_case} , String where, Object ... args )throws SQLException{
        String sWhere = String.format(where, args);
        String sqlStr = "select <#list table.columns as column>${column.code}<#if column_has_next>, </#if></#list> from ${table.code?lower_case} " + sWhere;
        Connection conn = KTBase.getConn();
        PreparedStatement stmt = conn.prepareStatement( sqlStr);
        ResultSet rst = stmt.executeQuery();
        if( !rst.next() )
        {
            rst.close();
            stmt.close();
            return false;
        }
<#list table.columns as column>
        ${table.code?lower_case}.${column.code} = rst.get<@type datatype=column.datatype precision=column.precision />(${column_index + 1});
</#list>
        rst.close();
        stmt.close();
    
        ${table.code?lower_case}.clearBFlag();
        return true;
    }
    
    public static int update( String updateSQL, Object ... args )throws SQLException{
        String sqlStr = String.format(updateSQL, args);
        Connection conn = KTBase.getConn();
        PreparedStatement stmt = conn.prepareStatement( sqlStr);
        int rst = stmt.executeUpdate();
        stmt.close();
        return rst;
    }
    
    public static int insert( String insertSQL, Object ... args )throws SQLException{
        String sqlStr = String.format(insertSQL, args);
        Connection conn = KTBase.getConn();
        PreparedStatement stmt = conn.prepareStatement( sqlStr);
        int rst = stmt.executeUpdate();
        stmt.close();
        return rst;
    }
    
    public static ArrayList<${entity}> selectBatch( int batchNum , String where, Object ... args )throws SQLException{
        String sWhere = String.format(where, args);
        String sqlStr = "select <#list table.columns as column>${column.code}<#if column_has_next>, </#if></#list> from ${table.code?lower_case} " + sWhere;
        Connection  conn = KTBase.getConn();
        PreparedStatement stmt = conn.prepareStatement( sqlStr);
        stmt.setFetchSize( batchNum );
        
        ResultSet rst = stmt.executeQuery();
        rst.setFetchSize( batchNum );
        
        ArrayList<${entity}> array${entity} = new ArrayList<${entity}>();
        while( rst.next() )
        {
            ${entity} ${table.code?lower_case} = new ${entity}();
<#list table.columns as column>
            ${table.code?lower_case}.${column.code} = rst.get<@type datatype=column.datatype precision=column.precision />(${column_index + 1});
</#list>
           
            array${entity}.add( ${table.code?lower_case} );
        }
        rst.close();
        stmt.close();
        return array${entity};
    }
    
    public static int updateBatch( ArrayList<${entity}> array${entity} ,String sqlStr , int batchNum )throws SQLException{
        Connection  conn = KTBase.getConn();
        PreparedStatement stmt = conn.prepareStatement( sqlStr );
        
        int batchIndex = 1;
        Iterator<${entity}> itor= array${entity}.iterator();
        while( itor.hasNext() )
        {
            ${entity} ${table.code?lower_case}  = itor.next();
        
<#list table.columns as column>
            if( ${table.code?lower_case}.isb${column.code?cap_first}()){
                stmt.set<@type datatype=column.datatype precision=column.precision />( ${table.code?lower_case}.geti${column.code?cap_first}() ,${table.code?lower_case}.${column.code?lower_case} );
            }
</#list>
            
            stmt.addBatch();
            batchIndex++;
            if( batchIndex > batchNum )
            {
                stmt.executeBatch();
                batchIndex = 1;
            }
            
            ${table.code?lower_case}.clearBFlag();
        }
        stmt.executeBatch();
        int rpcNum = stmt.getUpdateCount();
        stmt.close();
        return rpcNum;
    }
    
    public static int insertBatch( ArrayList<${entity}> array${entity} , int batchNum )throws SQLException{
        String sqlStr = "insert into ${table.code?lower_case}(<#list table.columns as column>${column.code}<#if column_has_next>, </#if></#list>) values (<#list table.columns as column>?<#if column_has_next>, </#if></#list>)";
        
        Connection  conn = KTBase.getConn();
        PreparedStatement stmt = conn.prepareStatement( sqlStr );
        
        int batchIndex = 1;
        Iterator<${entity}> itor= array${entity}.iterator();
        while( itor.hasNext() )
        {
            ${entity} ${table.code?lower_case}  = itor.next();
            
<#list table.columns as column>
            stmt.set<@type datatype=column.datatype precision=column.precision />(${column_index + 1}, ${table.code?lower_case}.${column.code});
</#list>
            
            stmt.addBatch();
            batchIndex++;
            if( batchIndex > batchNum )
            {
                stmt.executeBatch();
                batchIndex = 1;
            }
            ${table.code?lower_case}.clearBFlag();
        }
        
        stmt.executeBatch();
        int rpcNum = stmt.getUpdateCount();
        stmt.close();
        return rpcNum;
    }
}
