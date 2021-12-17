package model;

import java.io.Serializable;

public class Game implements Serializable {
	
 private int user;
 private int com;
 private String Msg;
 
 public Game() {}
 public Game(int user, int com, String Msg) { //Gameのuserにセットしている
	 this.user = user;
	 this.com = com;
	 this.Msg = Msg;
 }
 
public int getUser() {
	return user;
}
public void setUser(int user) {
	this.user = user;
}
public int getCom() {
	return com;
}
public void setCom(int com) {
	this.com = com;
}
public String getMsg() {
	return Msg;
}
public void setMsg(String msg) {
	Msg = msg;
}
 
	
}
