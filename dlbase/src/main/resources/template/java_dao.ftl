<#macro type datatype precision><#if datatype?contains("A")>String<#elseif datatype=="INT">Integer<#elseif precision != "">Double<#else>Integer</#if></#macro>
package ${package};

import ${entity_package}.${entity};
import java.util.List;

public interface ${entity}Dao{

    //int dynamicUpdate(${entity} entity);
    
    //int updateWhere(${entity} entity);
    
    int insert(${entity} entity);

    List<${entity}> selectAll(${entity} where);

<#if (table.keys?size > 0)>
    ${entity} selectById(<#list table.keys as column><@type datatype=column.datatype precision=column.precision /> ${column.code}<#if column_has_next>, </#if></#list>);

    int deleteById(<#list table.keys as column><@type datatype=column.datatype precision=column.precision /> ${column.code}<#if column_has_next>, </#if></#list>);

<#if (table.colsExceptKey?size > 0)>
    int updateById(${entity} entity);
</#if>
</#if>
}
