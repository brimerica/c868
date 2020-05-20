package com.example.c868.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private CallRecord callRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    private File attachment;

    public Comment(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CallRecord getCallRecord() {
        return callRecord;
    }

    public void setCallRecord(CallRecord callRecord) {
        this.callRecord = callRecord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }
}
