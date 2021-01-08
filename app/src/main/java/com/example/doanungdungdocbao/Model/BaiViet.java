package com.example.doanungdungdocbao.Model;

public class BaiViet {
    private Integer id;
    private String tieude;
    private String tieudekhongdau;
    private String tomtat;
    private String noidung;
    private String hinh;
    private Integer noibat;
    private Integer soluotxem;

    public BaiViet(Integer id, String tieude, String tieudekhongdau, String tomtat, String noidung, String hinh, Integer noibat, Integer soluotxem) {
        this.id = id;
        this.tieude = tieude;
        this.tieudekhongdau = tieudekhongdau;
        this.tomtat = tomtat;
        this.noidung = noidung;
        this.hinh = hinh;
        this.noibat = noibat;
        this.soluotxem = soluotxem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getTieudekhongdau() {
        return tieudekhongdau;
    }

    public void setTieudekhongdau(String tieudekhongdau) {
        this.tieudekhongdau = tieudekhongdau;
    }

    public String getTomtat() {
        return tomtat;
    }

    public void setTomtat(String tomtat) {
        this.tomtat = tomtat;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Integer getNoibat() {
        return noibat;
    }

    public void setNoibat(Integer noibat) {
        this.noibat = noibat;
    }

    public Integer getSoluotxem() {
        return soluotxem;
    }

    public void setSoluotxem(Integer soluotxem) {
        this.soluotxem = soluotxem;
    }
}
