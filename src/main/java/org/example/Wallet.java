package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Wallet {
    private String owner;
    private ArrayList<String> kartus = new ArrayList<>();
    private List<Integer> uangKoins = new ArrayList<>();
    private List<Integer> uangLemabarans = new ArrayList<>();

    public Wallet(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner.equals("")) {
            return;
        }
        this.owner = owner;
    }

    public List<String> getKartus() {
        return kartus;
    }

    public void tambahKartu(String kartu){
        if (kartu.equals("")) {
            return;
        }
        this.kartus.add(kartu);
    }

    public String ambilKartu(String kartu){
        return this.kartus.remove(kartu)?kartu:null;
    }

    public void tambahUangRupiah(Integer uang){
        if(uang <0){
            throw new Error("Ngga boleh minus");
        }
        int lembar = uang/1000*1000;
        int koin = uang -lembar;
        this.uangLemabarans.add(lembar);
        this.uangKoins.add(koin);
    }

    public List<Integer> getUangKoins() {
        return uangKoins;
    }

    public List<Integer> getUangLemabarans() {
        return uangLemabarans;
    }

    public void ambilUang(Integer uang){
        if(uang <0){
            throw new Error("Ngga boleh minus");
        }
        int lembar = uang/1000*1000;
        int koin = uang -lembar;
        Iterator<Integer> iterator = uangKoins.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == koin) {
                iterator.remove();
                break;
            }
        }
        Iterator<Integer> iterator2 = uangLemabarans.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next() == lembar) {
                iterator2.remove();
                break;
            }
        }
    }

    public int jumlah(){
        return uangLemabarans.stream().mapToInt(Integer::intValue).sum() +
                uangKoins.stream().mapToInt(Integer::intValue).sum();
    }
}
