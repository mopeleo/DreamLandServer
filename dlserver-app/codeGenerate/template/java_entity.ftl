<#macro type datatype precision><#if datatype?contains("A")>String<#elseif datatype=="INT">int<#elseif precision != "">double<#else>int</#if></#macro>
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
}
