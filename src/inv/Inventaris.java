package inv;

import java.util.ArrayList;

public class Inventaris {

    // Menyimpan daftar barang dalam struktur data ArrayList (dinamis, efisien)
    ArrayList<Item> daftarBarang = new ArrayList<>();

    // Menambahkan barang baru ke daftar inventaris — O(1)
    public void tambahBarang(Item barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan seluruh barang dalam inventaris
    public void tampilkanBarang() {
        for (Item b : daftarBarang) {
            System.out.println(b);
        }
    }

    /* ==============================
       SORTING 1 → QUICK SORT HARGA
       ==============================
       - Kompleksitas rata-rata O(n log n)
       - Paling cepat dibanding bubble/insertion O(n²)
       - Menggunakan rekursi → sesuai syarat UAS
    */

    public void urutkanHarga() {
        quickSortHarga(0, daftarBarang.size() - 1);
    }

    // Fungsi QuickSort berdasarkan harga
    public void quickSortHarga(int kiri, int kanan) {
        if (kiri < kanan) {
            int pivot = pembagianHarga(kiri, kanan);
            quickSortHarga(kiri, pivot - 1);  // rekursi kiri
            quickSortHarga(pivot + 1, kanan); // rekursi kanan
        }
    }

    // Partisi quicksort → membandingkan harga
    public int pembagianHarga(int kiri, int kanan) {
        double pivot = daftarBarang.get(kanan).harga;
        int i = kiri - 1;
        for (int j = kiri; j < kanan; j++) {
            if (daftarBarang.get(j).harga < pivot) {  // jika harga lebih kecil → tukar
                i++;
                Item temp = daftarBarang.get(i);
                daftarBarang.set(i, daftarBarang.get(j));
                daftarBarang.set(j, temp);
            }
        }
        Item temp = daftarBarang.get(i + 1);
        daftarBarang.set(i + 1, daftarBarang.get(kanan));
        daftarBarang.set(kanan, temp);
        return i + 1;
    }


    /* ==============================
       SORTING 2 → QUICK SORT STOK
       ==============================
       - Mengurutkan dari stok terkecil → terbesar
       - Still O(n log n) karena masih QuickSort
    */

    public void urutkanStok() {
        quickSortStok(0, daftarBarang.size() - 1);
    }

    public void quickSortStok(int kiri, int kanan) {
        if (kiri < kanan) {
            int pivot = pembagianStok(kiri, kanan);
            quickSortStok(kiri, pivot - 1);
            quickSortStok(pivot + 1, kanan);
        }
    }

    public int pembagianStok(int kiri, int kanan) {
        int pivot = daftarBarang.get(kanan).stok;
        int i = kiri - 1;
        for (int j = kiri; j < kanan; j++) {
            if (daftarBarang.get(j).stok < pivot) {
                i++;
                Item temp = daftarBarang.get(i);
                daftarBarang.set(i, daftarBarang.get(j));
                daftarBarang.set(j, temp);
            }
        }
        Item temp = daftarBarang.get(i + 1);
        daftarBarang.set(i + 1, daftarBarang.get(kanan));
        daftarBarang.set(kanan, temp);
        return i + 1;
    }

    // ===============================
// SORTING BERDASARKAN NAMA
// ===============================
    public void urutkanNama() {
        quickSortNama(0, daftarBarang.size() - 1);
    }

    private void quickSortNama(int kiri, int kanan) {
        if (kiri < kanan) {
            int pivot = pembagianNama(kiri, kanan);
            quickSortNama(kiri, pivot - 1);
            quickSortNama(pivot + 1, kanan);
        }
    }

    private int pembagianNama(int kiri, int kanan) {
        String pivot = daftarBarang.get(kanan).nama.toLowerCase();
        int i = kiri - 1;

        for (int j = kiri; j < kanan; j++) {
            if (daftarBarang.get(j).nama.toLowerCase().compareTo(pivot) < 0) {
                i++;
                Item temp = daftarBarang.get(i);
                daftarBarang.set(i, daftarBarang.get(j));
                daftarBarang.set(j, temp);
            }
        }

        Item temp = daftarBarang.get(i + 1);
        daftarBarang.set(i + 1, daftarBarang.get(kanan));
        daftarBarang.set(kanan, temp);

        return i + 1;
    }


    /* ======================================================
       SEARCH → BINARY SEARCH BERDASARKAN NAMA (REKURSIF)
       ======================================================
       - Jauh lebih cepat dari linear search
       - Kompleksitas hanya O(log n)
       - Syarat: Data harus diurutkan lebih dulu (harga/stok)
    */

    public Item cariNama(String nama) {
        return binarySearchNama(nama.toLowerCase(), 0, daftarBarang.size() - 1);
    }

    // Rekursi terjadi terus membagi data menjadi 2 bagian
    private Item binarySearchNama(String nama, int kiri, int kanan) {
        if (kiri > kanan) return null;

        int tengah = (kiri + kanan) / 2;
        String cekNama = daftarBarang.get(tengah).nama.toLowerCase();

        if (cekNama.equals(nama)) return daftarBarang.get(tengah);
        if (cekNama.compareTo(nama) > 0) 
            return binarySearchNama(nama, kiri, tengah - 1);  // rekursi ke kiri
        return binarySearchNama(nama, tengah + 1, kanan);     // rekursi ke kanan
    }

    // Mengurangi stok ketika barang dijual
    public void jualBarang(String nama, int jumlah) {
        Item barang = cariNama(nama);
        if (barang == null) {
            System.out.println("Barang tidak ditemukan!\n");
            return;
        }

        if (barang.stok >= jumlah) {
            barang.stok -= jumlah;
            System.out.println("Barang " + barang.nama + " terjual! Sisa stok: " + barang.stok + "\n");
        } else {
            System.out.println("Stok tidak cukup!\n");
        }
    }
}
