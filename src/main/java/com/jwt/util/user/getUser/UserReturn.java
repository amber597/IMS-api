package com.jwt.util.user.getUser;

public class UserReturn {
    private Long userId;
    private String userName;
    private String passWord;
    private String level;

    public UserReturn(Long userId, String userName, String passWord, String level) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.level = level;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
