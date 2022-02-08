package com.jwt.util.user.getUser;

public class GetPanelUser {
    private Long id;
    private String name;
    private Long interviewed;
    private Long pending;
    private Long total;

    public GetPanelUser() {
    }

    public GetPanelUser(Long id, String name, Long interviewed, Long pending, Long total) {
        this.id = id;
        this.name = name;
        this.interviewed = interviewed;
        this.pending = pending;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInterviewed() {
        return interviewed;
    }

    public void setInterviewed(Long interviewed) {
        this.interviewed = interviewed;
    }

    public Long getPending() {
        return pending;
    }

    public void setPending(Long pending) {
        this.pending = pending;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
