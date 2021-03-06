package ${project}.service.impl<#if model?exists>.${model}</#if>;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.gurms.entity.PageRequest;
import org.gurms.entity.PageResult;
import org.gurms.entity.PropertyFilter;
import ${project}.entity<#if model?exists>.${model}</#if>.${entity};
import ${project}.service<#if model?exists>.${model}</#if>.${entity}Service;
import ${project}.dao.hibernate<#if model?exists>.${model}</#if>.${entity}Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<#assign dao = entity?uncap_first + "Dao">
@Service
@Transactional
public class ${entity}ServiceImpl implements ${entity}Service {

	@Autowired
	private ${entity}Dao ${dao};
	
	public ${entity}Dao get${entity}Dao() {
		return ${dao};
	}

	public void set${entity}Dao(${entity}Dao ${dao}) {
		this.${dao} = ${dao};
	}

	@Override
	@Transactional(readOnly = true)
	public List<${entity}> query(Map<String, Object> request){
		return ${dao}.find(PropertyFilter.buildFromRequestMap(request));
	}
	
	@Override
	@Transactional(readOnly = true)
	public PageResult<${entity}> query(Map<String, Object> request, PageRequest page){
		return ${dao}.findPage(page, PropertyFilter.buildFromRequestMap(request));
	}
	
	@Override
	@Transactional(readOnly = true)
	public ${entity} get(String id){
		return ${dao}.get(id);
	}
	
	@Override
	public PageResult<${entity}> save(${entity} entity){
		PageResult<${entity}> result = new PageResult<${entity}>();
		${dao}.save(entity);
		return result;
	}

	@Override
	public PageResult<${entity}> delete(String id){
		PageResult<${entity}> result = new PageResult<${entity}>();
		if(StringUtils.isBlank(id)){
			result.setSuccess(false);
			result.setReturnmsg("ID不能为空");
		}else{
			${dao}.delete(id);
		}
		return result;
	}
}
