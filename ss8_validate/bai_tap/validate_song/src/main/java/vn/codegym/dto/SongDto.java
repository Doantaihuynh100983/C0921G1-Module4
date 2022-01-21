package vn.codegym.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {

    @NotEmpty
    @Size(min = 5,max = 800)
    @Pattern(regexp = "[a-zA-Z0-9 ]*")
    private String tenBaiHat;

    @NotEmpty
    @Size(min = 5,max = 300)
    @Pattern(regexp = "[a-zA-Z0-9 ]*")
    private String ngheSiTheHien;


    @NotEmpty
    @Size(min = 5,max = 1000)
    @Pattern(regexp = "^[a-zA-z0-9,]*$")
    private String theLoaiNhac;

    public SongDto(String tenBaiHat, String ngheSiTheHien, String theLoaiNhac) {
        this.tenBaiHat = tenBaiHat;
        this.ngheSiTheHien = ngheSiTheHien;
        this.theLoaiNhac = theLoaiNhac;
    }

    public SongDto() {
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
}
