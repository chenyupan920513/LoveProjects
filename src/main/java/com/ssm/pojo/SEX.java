package com.ssm.pojo;

public enum SEX {
	男(0), 女(1);
	  
    private Integer code;  
  
    SEX() {  
    }  
  
    SEX(int code) {  
		this.code = code;  
    }  
  
	public Integer getCode() {  
        return code;  
    }  
}
