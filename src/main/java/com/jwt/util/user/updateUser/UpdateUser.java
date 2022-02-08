package com.jwt.util.user.updateUser;

import java.util.List;

public class UpdateUser {
    private Long userId;
    private String level;
    private List<Long> streamIds;

    public UpdateUser() {
    }

    public UpdateUser(Long userId, String level, List<Long> streamIds) {
        this.userId = userId;
        this.level = level;
        this.streamIds = streamIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Long> getStreamIds() {
        return streamIds;
    }

    public void setStreamIds(List<Long> streamIds) {
        this.streamIds = streamIds;
    }
}
