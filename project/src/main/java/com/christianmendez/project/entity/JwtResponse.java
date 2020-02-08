package com.christianmendez.project.entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = -2146413047134728702L;
	
	private final String jwttoken;

    public JwtResponse(String jwttoken) {

        this.jwttoken = jwttoken;

    }

    public String getToken() {

        return this.jwttoken;

    }

}
