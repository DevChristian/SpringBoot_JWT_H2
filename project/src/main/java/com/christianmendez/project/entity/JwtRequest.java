package com.christianmendez.project.entity;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -5384846160616785023L;

	private String email;

    private String password;

    public JwtRequest()

    {

    }

    public JwtRequest(String email, String password) {

        this.setEmail(email);

        this.setPassword(password);

    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {

        return this.password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

}