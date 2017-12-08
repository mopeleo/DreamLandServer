<#macro type datatype precision><#if datatype?contains("A")>String<#elseif datatype=="INT">int<#elseif precision != "">double<#else>int</#if></#macro>
<#macro initNull datatype precision><#if datatype?contains("A")>null<#elseif datatype=="INT">0<#elseif precision != "">0<#else>0</#if></#macro>
package ${package};

import com.dl.server.entity.DLEntity;

public class ${entity} extends DLEntity{

<#list table.columns as column>
	private <@type datatype=column.datatype precision=column.precision /> ${column.code};    //${column.comment}
</#list>

<#list table.columns as column>
	public <@type datatype=column.datatype precision=column.precision /> get${column.code?cap_first}() {
		return this.${column.code};
	}

	public void set${column.code?cap_first}(<@type datatype=column.datatype precision=column.precision /> ${column.code}) {
		this.${column.code} = ${column.code};
	}

</#list>
    public boolean hasId(){
        return <#if (table.keys?size > 0)>true<#else>false</#if>;
    }
    
<#if (table.keys?size > 0)>
	public String getEntityKey(){
		StringBuilder build = new StringBuilder("${entity}");
		return build<#list table.keys as column>.append(this.${column.code})</#list>.toString();
	}

    public static String buildEntityKey(<#list table.keys as column><@type datatype=column.datatype precision=column.precision /> ${column.code}<#if column_has_next>, </#if></#list>){
        StringBuilder build = new StringBuilder("${entity}");
        return build<#list table.keys as column>.append(${column.code})</#list>.toString();
    }
</#if>
	
	public void clear(){
<#list table.columns as column>
		this.${column.code} = <@initNull datatype=column.datatype precision=column.precision />;
</#list>
	}
}
