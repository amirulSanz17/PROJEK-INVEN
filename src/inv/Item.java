package inv;
// Kelas Barang sebagai struktur data untuk menyimpan informasi inventaris
public class Item {
    int id;          // menyimpan ID barang
    String nama;     // nama barang
    double harga;    // harga barang
    int stok;        // jumlah stok tersedia

    // Konstruktor untuk menginisialisasi barang baru
    public Item(int id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // settter dan getter untuk atribut barang
    public int getId() { 
        return id; }
    public String getNama() { 
        return nama; }
    public double getHarga() { 
        return harga; }
    public int getStok() { 
        return stok; }

    public void setId(int id) { 
        this.id = id; }
    public void setNama(String nama) { 
        this.nama = nama; } 
    public void setHarga(double harga) {
        this.harga = harga; }
    public void setStok(int stok) { 
        this.stok = stok; }


    // Fungsi untuk menampilkan data barang dalam format text
    @Override
    public String toString() {
        return "ID: " + id + " | Nama: " + nama + " | Harga: " + harga + " | Stok: " + stok;
    }
}
