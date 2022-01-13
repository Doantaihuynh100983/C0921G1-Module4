package vn.codegym.model;

public class MailBox {
    private Integer id;
    private String laguages;
    private Integer pageSize;
    private Boolean spamfilter = true;
    private String signature;

    public MailBox(int id, String laguages, int pageSize, boolean spamfilter, String signature) {
        this.id = id;
        this.laguages = laguages;
        this.pageSize = pageSize;
        this.spamfilter = spamfilter;
        this.signature = signature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MailBox() {
    }

    public String getLaguages() {
        return laguages;
    }

    public void setLaguages(String laguages) {
        this.laguages = laguages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getSpamfilter() {
        return spamfilter;
    }

    public void setSpamfilter(boolean spamfilter) {
        this.spamfilter = spamfilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
