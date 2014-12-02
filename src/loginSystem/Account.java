package loginSystem;

import java.io.IOException;

public class Account {
    private String name;
    private String userName;
    private String password;
    private int totalScore;

    public Account() {
	this.name = "";
	this.userName = "";
	this.password = "";
	this.totalScore = 0;
    }

    public Account(String name, String userName, String password, int totalScore) {
	super();
	this.name = name;
	this.userName = userName;
	this.password = password;
	this.totalScore = totalScore;
    }

    @Override
    public String toString() {
	return "Account [name=" + name + ", userName=" + userName + ", password=" + password + "]";
    }

    public String[] toCSVEntry() {
	String[] entry = new String[] { name, userName, password, Integer.toString(totalScore) };
	return entry;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getTotalScore() {
	return totalScore;
    }

    public void setTotalScore(int totalScore) {
	this.totalScore = totalScore;
    }

}
