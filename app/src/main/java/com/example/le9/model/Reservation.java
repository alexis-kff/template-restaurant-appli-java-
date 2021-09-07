package com.example.le9.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private String name;
    private String day_res;
    private String hour_res;
    private String phone;
    private String nbr_pers;
    private String coment;
    private String date_res;
    private int id_res;
    private String comfirm;

    public Reservation() {

    }

    public Reservation(String name, String day_res, String hour_res, String phone, String nbr_pers, String coment, String date_res, int id_res, String comfirm) {
        this.name = name;
        this.day_res = day_res;
        this.hour_res = hour_res;
        this.phone = phone;
        this.nbr_pers = nbr_pers;
        this.coment = coment;
        this.date_res = date_res;
        this.id_res = id_res;
        this.comfirm = comfirm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay_res() {
        return day_res;
    }

    public void setDay_res(String day_res) {
        this.day_res = day_res;
    }

    public String getHour_res() {
        return hour_res;
    }

    public void setHour_res(String hour_res) {
        this.hour_res = hour_res;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNbr_pers() {
        return nbr_pers;
    }

    public void setNbr_pers(String nbr_pers) {
        this.nbr_pers = nbr_pers;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getDate_res() {
        return date_res;
    }

    public void setDate_res(String date_res) {
        this.date_res = date_res;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public String getComfirm() {
        return comfirm;
    }

    public void setComfirm(String comfirm) {
        this.comfirm = comfirm;
    }

    @Override
    public String toString() {
        return
                name + ' ' +
                day_res + ' ' +
                hour_res + ' ' +
                phone + ' ' +
                nbr_pers + ' ' +
                 coment + ' ' +
                date_res + ' ' +
                  comfirm ;
    }
}
