package ${package};

import java.util.List;
import ${package_entity}.${entity}DTO;

public interface ${entity}Service{

	public ResultDTO<${entity}DTO> query(${entity}DTO request);
	
	public ResultDTO<${entity}DTO> getById(String id);
	
    public ResultDTO<${entity}DTO> save(${entity}DTO dto);

	public ResultDTO<${entity}DTO> delete(String id);
}
