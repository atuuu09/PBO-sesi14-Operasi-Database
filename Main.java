import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n===== MENU DATABASE MAHASISWA =====");
            System.out.println("1. Tampilkan Data Mahasiswa");
            System.out.println("2. Input Data Mahasiswa");
            System.out.println("3. Cari Data Mahasiswa");
            System.out.println("4. Ubah Data Mahasiswa");
            System.out.println("5. Hapus Data Mahasiswa");
            System.out.println("6. Exit");
            System.out.print("Pilih menu (1-6): ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1 -> tampilkanData();
                case 2 -> inputData();
                case 3 -> cariData();
                case 4 -> ubahData();
                case 5 -> hapusData();
                case 6 -> System.out.println("Program selesai.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);
    }

    private static void tampilkanData() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.println("\nDAFTAR MAHASISWA:");
            for (Mahasiswa mhs : daftarMahasiswa) {
                System.out.println(mhs);
            }
        }
    }

    private static void inputData() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = input.nextLine();
        daftarMahasiswa.add(new Mahasiswa(nim, nama, jurusan));
        System.out.println("Data berhasil ditambahkan.");
    }

    private static void cariData() {
        System.out.print("Masukkan NIM yang dicari: ");
        String nimCari = input.nextLine();
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equalsIgnoreCase(nimCari)) {
                System.out.println("Data ditemukan: " + mhs);
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    private static void ubahData() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diubah: ");
        String nimEdit = input.nextLine();
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equalsIgnoreCase(nimEdit)) {
                System.out.print("Masukkan nama baru: ");
                String namaBaru = input.nextLine();
                System.out.print("Masukkan jurusan baru: ");
                String jurusanBaru = input.nextLine();
                mhs.setNama(namaBaru);
                mhs.setJurusan(jurusanBaru);
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    private static void hapusData() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nimHapus = input.nextLine();
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getNim().equalsIgnoreCase(nimHapus)) {
                daftarMahasiswa.remove(mhs);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }
}
