package com.server.information.system.dto;

public class ServerDTO {

    private String id;
    private String name;
    private String language;
    private String framework;

    public ServerDTO() {
    }

    public ServerDTO(String id, String name, String framework, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.framework = framework;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

   

}
