package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tenBaiHat;
    private String ngheSiTheHien;
    private String theLoaiNhac;

    public Song() {
    }

    public Song( String tenBaiHat, String ngheSiTheHien, String theLoaiNhac) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSiTheHien = ngheSiTheHien;
        this.theLoaiNhac = theLoaiNhac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getNgheSiTheHien() {
        return ngheSiTheHien;
    }

    public void setNgheSiTheHien(String ngheSiTheHien) {
        this.ngheSiTheHien = ngheSiTheHien;
    }

    public String getTheLoaiNhac() {
        return theLoaiNhac;
    }

    public void setTheLoaiNhac(String theLoaiNhac) {
        this.theLoaiNhac = theLoaiNhac;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", tenBaiHat='" + tenBaiHat + '\'' +
                ", ngheSiTheHien='" + ngheSiTheHien + '\'' +
                ", theLoaiNhac='" + theLoaiNhac + '\'' +
                '}';
    }
}
