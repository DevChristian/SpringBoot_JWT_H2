package com.christianmendez.project.util;

public enum ConstantsEnum {

	REGEXEMAIL("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"),
	REGEXPASSWORD("^(?=.*?[0-9].*?[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{7,}$"),
	INVALIDMAIL("Do you need enter a valid email"),
	INVALIDPASSWORD("Do you need enter a valid password for example = Hunter21"),
	EXISTSMAIL("This email exists in the DataBase"),
	USERNOTFOUND("User not found in database");
	
	private String value;

	ConstantsEnum(String value){
	    this.value = value;
	 }
	
	@Override
    public String toString() {
        return value;
    }
}
