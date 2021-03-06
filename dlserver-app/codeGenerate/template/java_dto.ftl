<#macro type datatype precision><#if datatype?contains("A")>String<#elseif datatype=="INT">int<#elseif precision != "">double<#else>int</#if></#macro>
package ${package};

import com.dl.server.dto.BaseDTO;

public class ${entity}DTO extends BaseDTO {

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
