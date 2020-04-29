package record.learn.rpc.bean;

import java.io.Serializable;

public class ReqInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String mobiled;
	private String id;
	
	public ReqInfo(String name, String mobiled, String id) {
		super();
		this.name = name;
		this.mobiled = mobiled;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobiled() {
		return mobiled;
	}
	public void setMobiled(String mobiled) {
		this.mobiled = mobiled;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
