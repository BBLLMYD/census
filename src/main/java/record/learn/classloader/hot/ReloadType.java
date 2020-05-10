package record.learn.classloader.hot;

public enum ReloadType {

	CLAZZ(System.getProperty("user.dir") + "/bin/",".class"), JAR(System.getProperty("user.dir") + "/lib/",".jar");
	
	private String path;  
    private String type; 
    
    public String getType() {
    	return type;
    }
    
    public void setType(String type) {
    	this.type = type;
    }
    
	private ReloadType(String name,String type){
		this.setPath(name);
		this.setType(type);
	}
	
	@Override
	public String toString() {
		return getType();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
