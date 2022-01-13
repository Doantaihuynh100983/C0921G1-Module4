package vn.codegym.model;

import java.util.Date;

public class Medical {
    private String hoTen;
    private String ngaySinh;
    private Integer gioiTinh;
    private String quocTich;
    private Integer cmnd;
    private String thongTinDiLai;
    private String soHieuPhuongTien;
    private Integer soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String thongTin14Ngay;
    private String tinhThanh;
    private String quanHuyen;
    private String phuongXa;
    private String diaChiNoiO;
    private Integer dienThoai;
    private String Email;
    private String trieuChung;
    private String lichSuPhoiNhiem;

    public Medical(String hoTen, String ngaySinh, Integer gioiTinh, String quocTich,
                   Integer cmnd, String thongTinDiLai, String soHieuPhuongTien, Integer soGhe, String ngayKhoiHanh,
                   String ngayKetThuc, String thongTin14Ngay, String tinhThanh, String quanHuyen, String phuongXa,
                   String diaChiNoiO, Integer dienThoai, String email, String trieuChung, String lichSuPhoiNhiem) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.cmnd = cmnd;
        this.thongTinDiLai = thongTinDiLai;
        this.soHieuPhuongTien = soHieuPhuongTien;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.thongTin14Ngay = thongTin14Ngay;
        this.tinhThanh = tinhThanh;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.diaChiNoiO = diaChiNoiO;
        this.dienThoai = dienThoai;
        this.Email = email;
        this.trieuChung = trieuChung;
        this.lichSuPhoiNhiem = lichSuPhoiNhiem;
    }

    public Medical() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public Integer getCmnd() {
        return cmnd;
    }

    public void setCmnd(Integer cmnd) {
        this.cmnd = cmnd;
    }

    public String getThongTinDiLai() {
        return thongTinDiLai;
    }

    public void setThongTinDiLai(String thongTinDiLai) {
        this.thongTinDiLai = thongTinDiLai;
    }

    public String getSoHieuPhuongTien() {
        return soHieuPhuongTien;
    }

    public void setSoHieuPhuongTien(String soHieuPhuongTien) {
        this.soHieuPhuongTien = soHieuPhuongTien;
    }

    public Integer getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Integer soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getThongTin14Ngay() {
        return thongTin14Ngay;
    }

    public void setThongTin14Ngay(String thongTin14Ngay) {
        this.thongTin14Ngay = thongTin14Ngay;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getDiaChiNoiO() {
        return diaChiNoiO;
    }

    public void setDiaChiNoiO(String diaChiNoiO) {
        this.diaChiNoiO = diaChiNoiO;
    }

    public Integer getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(Integer dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getLichSuPhoiNhiem() {
        return lichSuPhoiNhiem;
    }

    public void setLichSuPhoiNhiem(String lichSuPhoiNhiem) {
        this.lichSuPhoiNhiem = lichSuPhoiNhiem;
    }
}
