package vn.codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private static final List<String> listQuocTich;
    private static final List<String> thongTinDiLaiList;
    private static final List<String> tinhThanhList;
    private static final List<String> quanHuyenList;
    private static final List<String> phuongXaList;
    private static final List<String> trieuCHungList;
    static {
        listQuocTich = new ArrayList<>();
        listQuocTich.add("Viet Nam");
        listQuocTich.add("Anh");
        listQuocTich.add("Cu Ba");
        listQuocTich.add("Lao");
        listQuocTich.add("Hoa Ky");
        listQuocTich.add("Dong Timo");
        thongTinDiLaiList = new ArrayList<>();
        thongTinDiLaiList.add("Tau Bay");
        thongTinDiLaiList.add("Tau Thuyen");
        thongTinDiLaiList.add("O To");
        thongTinDiLaiList.add("Khac (Ghi Rõ)");
        tinhThanhList = new ArrayList<>();
        tinhThanhList.add("QN");
        tinhThanhList.add("ĐN");
        tinhThanhList.add("SG");
        tinhThanhList.add("HN");
        tinhThanhList.add("ND");
        quanHuyenList = new ArrayList<>();
        quanHuyenList.add("DX");
        quanHuyenList.add("DT");
        quanHuyenList.add("TO");
        quanHuyenList.add("DC");
        quanHuyenList.add("DB");
        quanHuyenList.add("DG");
        quanHuyenList.add("DR");
        phuongXaList= new ArrayList<>();
        phuongXaList.add("LL");
        phuongXaList.add("DD");
        phuongXaList.add("HH");
        phuongXaList.add("TT");
        phuongXaList.add("JJ");
        trieuCHungList = new ArrayList<>();
        trieuCHungList.add("Sốt");
        trieuCHungList.add("Ho");
        trieuCHungList.add("Khó Thở");
        trieuCHungList.add("Đau Họng");
        trieuCHungList.add("Nôn Buồn Nôn");
        trieuCHungList.add("Tiêu Chảy");
        trieuCHungList.add("Xuất Huyết Ngoài Da");
        trieuCHungList.add("Nổi Ban Ngoài Da");



    }
    @Override
    public List<String> quocTich() {
        return listQuocTich;
    }

    @Override
    public List<String> thongTinDiLai() {
        return thongTinDiLaiList;
    }

    @Override
    public List<String> tinhThanh() {
        return tinhThanhList;
    }

    @Override
    public List<String> quanHuyen() {
        return quanHuyenList;
    }

    @Override
    public List<String> phuongXa() {
        return phuongXaList;
    }

    @Override
    public List<String> trieuCHung() {
        return trieuCHungList;
    }
}
