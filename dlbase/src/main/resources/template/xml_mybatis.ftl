<#macro type datatype precision><#if datatype?contains("A")>VARCHAR<#elseif datatype=="INT">INTEGER<#elseif precision != "">DOUBLE<#else>VARCHAR</#if></#macro>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${dao_package}.${entity}Dao">
    <resultMap id="BaseResultMap" type="${entity_package}.${entity}">
<#list table.keys as column>
        <id column="${column.code}" jdbcType="<@type datatype=column.datatype precision=column.precision />" property="${column.code}" />
</#list>
<#list table.columns as column>
	<#if !table.keys?seq_contains(column)>
        <result column="${column.code}" jdbcType="<@type datatype=column.datatype precision=column.precision />" property="${column.code}" />
	</#if>
</#list>
    </resultMap>
  
    <insert id="insert" parameterType="${entity_package}.${entity}">
        insert into ${table.code?lower_case} (<#list table.columns as column>${column.code}<#if column_has_next>, </#if></#list>)
        values (<#list table.columns as column>#${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype precision=column.precision />}<#if column_has_next>, </#if></#list>)
    </insert>
  
    <select id="selectAll" resultMap="BaseResultMap">
        select <#list table.columns as column>${column.code}<#if column_has_next>, </#if></#list>
          from ${table.code?lower_case}
    </select>
  
<#if (table.keys?size > 0)>
    <select id="selectById" parameterType="map" resultMap="BaseResultMap">
        select <#list table.columns as column>${column.code}<#if column_has_next>, </#if></#list>
          from ${table.code?lower_case}
         where 1=1<#list table.keys as column> and ${column.code} = #${r'{arg'}${column_index}}</#list>
    </select>

    <delete id="deleteById" parameterType="map">
        delete from ${table.code?lower_case}
         where 1=1<#list table.keys as column> and ${column.code} = #${r'{arg'}${column_index}}</#list>
    </delete>
  
	<#if (table.colsExceptKey?size > 0)>
    <update id="updateById" parameterType="${entity_package}.${entity}">
        update ${table.code?lower_case} set 
<#list table.colsExceptKey as column>
               ${column.code} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype precision=column.precision />}<#if column_has_next>, </#if>
</#list>
         where 1=1<#list table.keys as column> and ${column.code} = #${r'{'}${column.code}, jdbcType=<@type datatype=column.datatype precision=column.precision />}</#list>
    </update>
	</#if>
</#if>
</mapper>