package ifi.internaltool.allocation.model;


public class Payload {
	private String Code;
	private String Status;
	private String Description;
	private Object Data;

	public Payload() {

	}

	public void  setPayload(String code, String status, String Description,Object data) {
		this.Code=code;
		this.Data= data;	
		this.Status=status;
		this.Description= Description;
			
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

}