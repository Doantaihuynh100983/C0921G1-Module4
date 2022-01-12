package vn.codegym.model;

public class Mailbox {
    private String languages;
    private int size;
    private Boolean fillter;
    private String signature;

    public Mailbox(String languages, int size, Boolean fillter, String signature) {
        this.languages = languages;
        this.size = size;
        this.fillter = fillter;
        this.signature = signature;
    }

    public Mailbox() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Boolean getFillter() {
        return fillter;
    }

    public void setFillter(Boolean fillter) {
        this.fillter = fillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
