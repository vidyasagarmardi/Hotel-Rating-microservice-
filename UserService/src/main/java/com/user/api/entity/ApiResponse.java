package com.user.api.entity;

import java.util.List;

public class ApiResponse {
	
	private String status;
	private List<?> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}

}
