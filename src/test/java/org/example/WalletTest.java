package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet dompet = new Wallet("Budi");
    @Test
    void testSetOwnerValid() {
        dompet.setOwner("Ahmad");
        Assertions.assertEquals("Ahmad",dompet.getOwner(),"Jika ada berubah Ahmad");
    }
    @Test
    void testSetOwnerNull() {
        dompet.setOwner("");
        Assertions.assertEquals("Budi",dompet.getOwner(),"Jika Kosong tetap Budi");
    }

    @Test
    void testSambahKartuValid() {
        dompet.tambahKartu("ATM");
        Assertions.assertEquals(1,dompet.getKartus().toArray().length);
    }
    @Test
    void testTambahKartuMultiple() {
        dompet.tambahKartu("ATM");
        dompet.tambahKartu("KTM");
        Assertions.assertEquals(2,dompet.getKartus().toArray().length);
    }
    @Test
    void testTambahKartuNull() {
        dompet.tambahKartu("");
        Assertions.assertEquals(0,dompet.getKartus().toArray().length);
    }

    @Test
    void testAmbilKartuValid() {
        dompet.tambahKartu("ATM");
        dompet.tambahKartu("KTM");
        dompet.ambilKartu("KTM");
        Assertions.assertEquals(1,dompet.getKartus().toArray().length);
    }
    @Test
    void testAmbilKartuNull() {
        dompet.tambahKartu("ATM");
        dompet.tambahKartu("KTM");
        dompet.ambilKartu("");
        Assertions.assertEquals(2,dompet.getKartus().toArray().length);
    }

    @Test
    void testTambahUangRupiahValid() {
        dompet.tambahUangRupiah(1500);
        assertAll(
                ()->Assertions.assertEquals(1000,dompet.getUangLemabarans().toArray()[0]),
                ()->Assertions.assertEquals(500,dompet.getUangKoins().toArray()[0])
        );
    }
    @Test
    void testTambahUangRupiahMinus() {
        Assertions.assertThrows(Error.class, () -> {
            dompet.tambahUangRupiah(-1);
        });
    }

    @Test
    void testAmbilUangValid() {
        dompet.tambahUangRupiah(1500);
        dompet.ambilUang(1000);
        assertAll(
                ()-> Assertions.assertEquals(0, dompet.getUangLemabarans().toArray().length),
                ()->Assertions.assertEquals(1, dompet.getUangKoins().toArray().length)
        );
    }

    @Test
    void testAmbilUangValidDouble() {
        dompet.tambahUangRupiah(1500);
        dompet.tambahUangRupiah(1000);
        dompet.ambilUang(1000);
        assertAll(
                ()-> Assertions.assertEquals(1, dompet.getUangLemabarans().toArray().length),
                ()->Assertions.assertEquals(1, dompet.getUangKoins().toArray().length)
        );
    }

    @Test
    void testAmbilUangRupiahMinus() {
        Assertions.assertThrows(Error.class, () -> {
            dompet.ambilUang(-1);
        });
    }

    @Test
    void testJumlah() {
        dompet.tambahUangRupiah(1500);
        dompet.tambahUangRupiah(3000);
        Assertions.assertEquals(4500,dompet.jumlah());

    }
}