package cz17a.gamification.restserver.resource.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="users")
public class User {

	@Id
	int ID;
	@Column(name="mail")
	String mail;
	@Column(name="nickname")
	String nickname;
	@Column(name="password")
	String password;
	@Column(name="salt")
	String salt;
	@Column(name="last_login")
	Timestamp last_login;
	@Column(name="registration")
	Timestamp registation;
	@Column(name="admin")
	boolean admin;
	@Column(name="playtime")
	float playtime;
	
	
	public User() {
		
	}
	
	public User(int ID, String mail, String nickname, String password, String salt, Timestamp last_login, Timestamp registation, float playtime, boolean admin) {
		this.ID = ID;
		this.mail = mail;
		this.nickname = nickname;
		this.password = password;
		this.last_login = last_login;
		this.registation = registation;
		this.playtime = playtime;	
		this.admin = admin;
		this.salt = salt;
		
	}
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getLast_login() {
		return last_login;
	}
	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}
	public Timestamp getRegistation() {
		return registation;
	}
	public void setRegistation(Timestamp registation) {
		this.registation = registation;
	}
	public float getPlaytime() {
		return playtime;
	}
	public void setPlaytime(float playtime) {
		this.playtime = playtime;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin =  admin;
	}
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
}