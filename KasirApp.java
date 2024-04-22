import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KasirApp {
    private static List<Item> daftarBarang = new ArrayList<>();
    private static final double DISKON = 0.1; // 10% diskon

    public static void main(String[] args) {
        initializeItems();
        Scanner scanner = new Scanner(System.in);
        Transaction transaction = new Transaction();

        // Menampilkan daftar barang
        System.out.println("Daftar Barang:");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBarang.get(i).getName() + " - $" + daftarBarang.get(i).getPrice());
        }

        // Memilih barang yang dibeli
        while (true) {
            System.out.println("Pilih barang (nomor barang, 0 untuk selesai):");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice < 1 || choice > daftarBarang.size()) {
                System.out.println("Pilihan tidak valid.");
                continue;
            }
            System.out.println("Masukkan jumlah barang:");
            int quantity = scanner.nextInt();
            transaction.addItem(daftarBarang.get(choice - 1), quantity);
        }

        // Menghitung total harga
        double totalHarga = transaction.getTotal();
        System.out.println("Total harga: $" + totalHarga);

        // Mengaplikasikan diskon jika total harga lebih dari $100
        if (totalHarga > 100) {
            double diskonAmount = totalHarga * DISKON;
            System.out.println("Anda mendapatkan diskon sebesar $" + diskonAmount);
            totalHarga -= diskonAmount;
        }

        // Menampilkan daftar barang yang dibeli
        System.out.println("Barang yang dibeli:");
        for (Item item : transaction.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }

        // Terima pembayaran dari pelanggan
        System.out.println("Masukkan jumlah uang yang diberikan oleh pelanggan:");
        double uangDiberikan = scanner.nextDouble();

        // Hitung kembalian
        double kembalian = uangDiberikan - totalHarga;

        // Tampilkan kembalian
        System.out.println("Kembalian: $" + kembalian);

        // Simpan riwayat transaksi
        // Di sini Anda bisa menyimpan riwayat transaksi ke file, basis data, atau penyimpanan lainnya

        scanner.close();
    }

    private static void initializeItems() {
        daftarBarang.add(new Item("Buku", 10.0));
        daftarBarang.add(new Item("Pensil", 5.0));
        daftarBarang.add(new Item("Penggaris", 3.0));
        // Menambahkan barang lainnya di sini
    }
}
