package com.dhenton9000.wicket.pages.form.sample;

import java.io.Serializable;

public class User implements Serializable{

	private String name = "<please add>";
        private String nickName = "nick";
	private int age = 21;
        private Integer userNumber = 3;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age +", nick="+nickName+"]";
	}

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the userNumber
     */
    public Integer getUserNumber() {
        return userNumber;
    }

    /**
     * @param userNumber the userNumber to set
     */
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    
     

}
