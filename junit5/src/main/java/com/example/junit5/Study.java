package com.example.junit5;

public class Study {

    private Long id;

    private StudyStatus status;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public void setStatus(StudyStatus status) {
        this.status = status;
    }
}
