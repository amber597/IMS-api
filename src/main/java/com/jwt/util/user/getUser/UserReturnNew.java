package com.jwt.util.user.getUser;

public class UserReturnNew {

    private Long userId;
    private String userName;
    private String level;

    public UserReturnNew() {
    }

    public UserReturnNew(Long userId, String userName, String level) {
        this.userId = userId;
        this.userName = userName;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
