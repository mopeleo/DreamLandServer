<#macro type datatype precision><#if datatype?contains("A")>String<#elseif datatype=="INT">int<#elseif precision != "">double<#else>int</#if></#macro>
<#macro initNull datatype precision><#if datatype?contains("A")>null<#elseif datatype=="INT">0<#elseif precision != "">0<#else>0</#if></#macro>
package ${package};

public class ${entity}{

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
	public void clear(){
<#list table.columns as column>
		this.${column.code} = <@initNull datatype=column.datatype precision=column.precision />;
</#list>
	}
}
