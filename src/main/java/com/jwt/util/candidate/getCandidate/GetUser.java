package com.jwt.util.candidate.getCandidate;

import com.jwt.model.Stream;

import java.util.List;

public class GetUser {
    private Long userId;
    private String userName;
    private Long userScore;
    private String userStatus;
    private List<Stream> userStreams;

    public List<Stream> getUserStreams() {
        return userStreams;
    }

    public void setUserStreams(List<Stream> userStreams) {
        this.userStreams = userStreams;
    }

    public GetUser(Long userId, String userName, Long userScore, String userStatus, List<Stream> userStreams) {
        this.userId = userId;
        this.userName = userName;
        this.userScore = userScore;
        this.userStatus = userStatus;
        this.userStreams = userStreams;
    }

    @Override
    public String toString() {
        return "GetUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userScore=" + userScore +
                ", userStatus='" + userStatus + '\'' +
                '}';
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

    public Long getUserScore() {
        return userScore;
    }

    public void setUserScore(Long userScore) {
        this.userScore = userScore;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
