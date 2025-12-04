import java.util.Scanner;

import inv.*;

public class Main {
    public static void main(String[] args) {
        Inventaris inv = new Inventaris();
        Scanner input = new Scanner(System.in);

        // Data awal inventaris
        inv.tambahBarang(new Item(1, "Laptop", 8000000, 10));
        inv.tambahBarang(new Item(2, "Mouse", 150000, 25));
        inv.tambahBarang(new Item(3, "Keyboard", 300000, 15));
        inv.tambahBarang(new Item(4, "Monitor", 2000000, 5));
        inv.tambahBarang(new Item(5, "Headphone", 500000, 8));

        while (true) {
            System.out.println("\n=== SISTEM MANAJEMEN INVENTARIS ===");
            System.out.println("1. Tampilkan Inventaris");
            System.out.println("2. Urutkan Berdasarkan Harga");
            System.out.println("3. Urutkan Berdasarkan Stok");
            System.out.println("4. Urutkan berdasarkan Nama");
            System.out.println("5. Cari Barang berdasarkan Nama");
            System.out.println("6. Jual Barang");
            System.out.println("7. Keluar");
            System.out.print("Pilih Menu : ");
            int pilih = input.nextInt(); input.nextLine();

            switch(pilih) {
                case 1 -> inv.tampilkanBarang();
                case 2 -> { 
                    inv.urutkanHarga(); 
                    System.out.println("\nBarang telah diurutkan berdasarkan HARGA"); 
                    inv.tampilkanBarang(); }
                case 3 -> { 
                    inv.urutkanStok(); 
                    System.out.println("\nBarang telah diurutkan berdasarkan STOK"); 
                    inv.tampilkanBarang(); }
                case 4 -> { 
                    inv.urutkanNama(); 
                    System.out.println("\nBarang telah diurutkan berdasarkan NAMA"); 
                    inv.tampilkanBarang(); }
                case 5 -> {
                    System.out.print("\nMasukkan nama barang: ");
                    String nama = input.nextLine();
                    System.out.println(inv.cariNama(nama));
                }
                case 6 -> {
                    inv.urutkanNama();   
                    System.out.print("Nama barang: ");
                    String nama = input.nextLine();
                    System.out.print("Jumlah jual: ");
                    int jml = input.nextInt();
                    inv.jualBarang(nama, jml);
                }
                case 7 -> { 
                    System.out.println("\nProgram selesai."); 
                    return; }
                default -> System.out.println("Menu tidak tersedia!\n");
            }
        }
    }
}
