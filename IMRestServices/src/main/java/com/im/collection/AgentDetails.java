package com.im.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agentDetails")
public class AgentDetails {
@Id
private String id;
private String userName;
private int age;
private String lastQualification;
private String presentOccupation;
private String rewards;
private String workExperience;
private String userType;



public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getLastQualification() {
	return lastQualification;
}
public void setLastQualification(String lastQualification) {
	this.lastQualification = lastQualification;
}
public String getPresentOccupation() {
	return presentOccupation;
}
public void setPresentOccupation(String presentOccupation) {
	this.presentOccupation = presentOccupation;
}
public String getRewards() {
	return rewards;
}
public void setRewards(String rewards) {
	this.rewards = rewards;
}
public String getWorkExperience() {
	return workExperience;
}
public void setWorkExperience(String workExperience) {
	this.workExperience = workExperience;
}
public AgentDetails(String userName, int age, String lastQualification,
		String presentOccupation, String rewards, String workExperience, String userType) {
	super();
	this.userName = userName;
	this.age = age;
	this.lastQualification = lastQualification;
	this.presentOccupation = presentOccupation;
	this.rewards = rewards;
	this.workExperience = workExperience;
	this.userType = userType;
}
@Override
public String toString() {
	return "AgentDetails [id=" + id + ", userName=" + userName + ", age=" + age + ", lastQualification="
			+ lastQualification + ", presentOccupation=" + presentOccupation + ", rewards=" + rewards
			+ ", workExperience=" + workExperience + "]";
}





}
