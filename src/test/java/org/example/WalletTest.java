package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class WalletTest {
    private static Wallet dompet;
    private static int count =1;

    @BeforeAll
    static void setup(){
        System.out.println("Start test");
    }
    @BeforeEach
    void init(){
        dompet = new Wallet("Budi");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Test "+count+" done");
        count++;
    }

    @AfterAll
    static void tearDownAll(){
        dompet = null;
        System.out.println("End test");
    }

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