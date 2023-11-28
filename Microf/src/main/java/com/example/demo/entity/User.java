package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//↓「name="xxx"」の「xxx」の部分に模倣したいテーブル名を書く
@Table(name = "miclogin")
public class User {

	//主キーには「@Id」を設定する！
	@Id
	//カラム名(列名)を書く。
	@Column(name = "loginid")
	private String loginid;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password")
	private String password;

	public String getId() {
		return loginid;
	}

	public void setId(String loginid) {
		this.loginid = loginid;
	}

}