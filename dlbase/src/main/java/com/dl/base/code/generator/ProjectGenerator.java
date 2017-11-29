package com.dl.base.code.generator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ProjectGenerator {
    private static final ResourceBundle rb = ResourceBundle.getBundle("config");

	public static final String TABLE_SEPATATOR = "_";

	public static final String TEMPLATE_DIR = getConfig("template_dir");

	public static final String TEMPLATE_DAO = getConfig("template_dao");
    public static final String TEMPLATE_ENTITY = getConfig("template_entity");
    public static final String TEMPLATE_SERVICE = getConfig("template_service");
    public static final String TEMPLATE_SERVICEIMPL = getConfig("template_serviceimpl");
	
    public static final String PACKAGE_DAO = getConfig("package_dao");
    public static final String PACKAGE_ENTITY = getConfig("package_entity");
    public static final String PACKAGE_SERVICE = getConfig("package_service");
    public static final String PACKAGE_SERVICEIMPL = getConfig("package_serviceimpl");

    public static final String OUTPUT_DAO = getConfig("output_dao");
    public static final String OUTPUT_ENTITY = getConfig("output_entity");
    public static final String OUTPUT_SERVICE = getConfig("output_service");
    public static final String OUTPUT_SERVICEIMPL = getConfig("output_serviceimpl");

    public static final String FILETYPE_DAO = "DAO.java";
    public static final String FILETYPE_ENTITY = "DTO.java";
    public static final String FILETYPE_SERVICE = "Service.java";
    public static final String FILETYPE_SERVICEIMPL = "ServiceImpl.java";

    public static final String MODEL_FILE = getConfig("model_file");

    public static String getConfig(String key) {
//        Properties prop = new Properties();
//        try {
//            InputStream in = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "config.properties"));
//            prop.load(in);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return prop.getProperty(key);
        String val = "";
        try{
            val = rb.getString(key);
        }catch(MissingResourceException e){
            val = "";
        }
        return val;
    }

    public static void generate(Map params, String templateFile, String outFile){
		CodeGenerator.generate(TEMPLATE_DIR, templateFile, params, outFile);
	}
	
	public static void entityGenerate(Map params, String outFile){
		generate(params, TEMPLATE_ENTITY, outFile);
	}	
	
    public static void daoGenerate(Map params, String outFile){
        generate(params, TEMPLATE_DAO, outFile);
    }   
    
    public static void serviceGenerate(Map params, String outFile){
        generate(params, TEMPLATE_SERVICE, outFile);
    }   
    
    public static void serviceImplGenerate(Map params, String outFile){
        generate(params, TEMPLATE_SERVICEIMPL, outFile);
    }   
    
	private static String getJavaOutFile(Map params, String outDir, String pkgName, String fileSuffix){
        String outFileName = outDir;
	    if(!outDir.endsWith(File.separator)){
	        outFileName += File.separator;
	    }
        outFileName += pkgName.replace('.', File.separatorChar);
		File file = new File(outFileName);
		if(!file.exists()){
			file.mkdirs();
		}
		outFileName += File.separator + params.get("entity").toString() + fileSuffix;

		return outFileName;
	}
	
	public static void projectGenerate(String modelFile){
		Model model = null;
		if(modelFile.toLowerCase().endsWith(".pdm")){
		   model =  PDMParser.parse(new File(modelFile));
		}else if(modelFile.toLowerCase().endsWith(".cdm")){
	       model =  CDMParser.parse(new File(modelFile));
		}else{
		    throw new RuntimeException("暂不支持的文件类型");
		}
		
		String outFile = null;
		Map params = new HashMap();

		List<Table> tables = model.getTables();
		params.put("tables", tables);
		params.put("entity", "");

		for(Table table : tables){
			String tableCode = table.getCode();
			String entity = "";
			if(tableCode.indexOf(TABLE_SEPATATOR) > 0){
				String[] parts = tableCode.split(TABLE_SEPATATOR);
				params.put("model", parts[0]);
				for(int i = 0; i< parts.length; i++){
					entity += parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
				}
			}else{
				entity = tableCode.substring(0, 1).toUpperCase() + tableCode.substring(1);
			}
			params.put("entity", entity);
            params.put("table", table);
			
			System.out.println("---------生成 ["+table.getName() + "(" + table.getCode() + ")] 代码开始----------");
			if(!"".equals(OUTPUT_DAO)&&!"".equals(PACKAGE_DAO)&&!"".equals(FILETYPE_DAO)){
	            params.put("package", PACKAGE_DAO);
	            outFile = getJavaOutFile(params, OUTPUT_DAO, PACKAGE_DAO, FILETYPE_DAO);
	            daoGenerate(params, outFile);
			}
			
            if(!"".equals(OUTPUT_ENTITY)&&!"".equals(PACKAGE_ENTITY)&&!"".equals(FILETYPE_ENTITY)){
                params.put("package", PACKAGE_ENTITY);
                outFile = getJavaOutFile(params, OUTPUT_ENTITY, PACKAGE_ENTITY, FILETYPE_ENTITY);
                entityGenerate(params, outFile);
            }
            
            if(!"".equals(OUTPUT_SERVICE)&&!"".equals(PACKAGE_SERVICE)&&!"".equals(FILETYPE_SERVICE)){
                params.put("package", PACKAGE_SERVICE);
                params.put("package_entity", PACKAGE_ENTITY);
                outFile = getJavaOutFile(params, OUTPUT_SERVICE, PACKAGE_SERVICE, FILETYPE_SERVICE);
                serviceGenerate(params, outFile);
            }
            
            if(!"".equals(OUTPUT_SERVICEIMPL)&&!"".equals(PACKAGE_SERVICEIMPL)&&!"".equals(FILETYPE_SERVICEIMPL)){
                params.put("package", PACKAGE_SERVICEIMPL);
                outFile = getJavaOutFile(params, OUTPUT_SERVICEIMPL, PACKAGE_SERVICEIMPL, FILETYPE_SERVICEIMPL);
                serviceImplGenerate(params, outFile);
            }
            
			System.out.println("---------生成 ["+table.getName() + "(" + table.getCode() + ")] 代码结束----------");
		}
	}
	
	public static void main(String[] args) {
//	    String filepath = "D:\\My Projects\\model\\tongfa.pdm";
//	    String cdmpath = "D:\\KingdomProject\\ZHLC4.5\\trunk\\src\\SQL\\cdm_files\\lcpt_fms.cdm";
		projectGenerate(MODEL_FILE);
		
//	    String pdm = args[0];
//	    System.out.println("pdm : " + pdm);
//	    String pkgprefix = args[1];
//	    System.out.println("package prefix : " + pkgprefix);
//	    String javaoutpath = args[2];
//	    System.out.println("java outpath : " + javaoutpath);
//	    String weboutpath = args[3];
//	    System.out.println("web outpath : " + weboutpath);
//		projectGenerate(pdm, pkgprefix, javaoutpath, weboutpath);
	    
	}
}
