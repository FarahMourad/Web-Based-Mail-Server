package com.example.hidwig;
//immutable
public class Mail {
private String sender;
private String receiver;
private String subject;
private String dates;
private String  attachment;
private String content;
private String key;
private String id;


public Mail(){}
    public Mail(String key,String receiver,String subject,String attachment, String content, String dates, String id){
        this.key = key; //1 important 2 default
        //this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.attachment = attachment;
        this.content = content;
        this.dates = dates;
        this.id = id ;//id of sender
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getId() { return id; }
    public String getKey() { return key; }
    public String getContent() { return content; }
    public String getReceiver() {
        return receiver;
    }
    public String getAttachment() {
        return attachment;
    }
    public String getSender() {
        return sender;
    }
    public String getSubject() {
        return subject;
    }
    public String getDates() { return dates; }
}
