/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diando07228;

import Entity.Diando07228_JurusanEntity;
import Entity.Diando07228_MahasiswaEntity;
import Controller.Diando07228_MahasiswaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Diando07228_Main {

    public Diando07228_MahasiswaController mahasiswa = new Diando07228_MahasiswaController();
    public Scanner input = new Scanner(System.in);
    public String npm, nama, no_telp, password;
    public Date tgl_lahir;
    public int pil, index_jurusan, index_mhs;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Diando07228_Main umum = new Diando07228_Main();
        System.out.println("Selamat Datang di Aplikasi Pendataan Mahasiswa !!");
        do {
            System.out.println("1. Pendaftaran Mahasiswa");
            System.out.println("2. Lihat data Mahasiswa");
            System.out.println("3. Edit data Mahasiswa");
            System.out.println("4. Hapus data Mahasiswa");
            System.out.println("0. Exit");
            System.out.print("Pilih Menu : ");
            umum.pil = umum.input.nextInt();
            switch (umum.pil) {
                case 1:
                    umum.viewPendaftaran();
                    break;
                case 2:
                    umum.viewDataMahasiswa();
                    break;
                case 3:
                    umum.viewEditDataMahasiswa();
                    break;
                case 4:
                    umum.viewHapusDataMahasiswa();
                    break;
            }
        } while (umum.pil != 0);
    }

    public void viewPendaftaran() {
        try {
            System.out.print("Input NPM = ");
            npm = input.next();
            System.out.print("Input Nama = ");
            nama = input.next();
            System.out.print("Input Tanggal Lahir (dd/MM/yyyy) = ");
            tgl_lahir = new Date(input.next());
            System.out.print("Input No. Telp = ");
            no_telp = input.next();
            System.out.print("Input Password = ");
            password = input.next();
            for (int i = 0; i < Diando07228_JurusanEntity.jurusan.length; i++) {
                System.out.println(i + ". " + Diando07228_JurusanEntity.jurusan[i]);
            }
            System.out.print("Pilih Jurusan = ");
            index_jurusan = input.nextInt();
            mahasiswa.insertDataMahasiswa(npm, nama, tgl_lahir, index_jurusan, no_telp, password);
            System.out.println("Data Berhasil DiTambahkan");
        } catch (Exception e) {
            System.out.println("Format Pengisian Salah");
        }
    }

    public void viewDataMahasiswa() {
        int i=0;
        for (Diando07228_MahasiswaEntity mahasiswa : mahasiswa.getDataMahasiswa()) {
            System.out.println(i+". NPM : " + mahasiswa.getNpm() +
                                "\n   Nama : " + mahasiswa.getNama() +
                                "\n   Jurusan : " + Diando07228_JurusanEntity.jurusan[mahasiswa.getIndex_jurusan()] +
                                "\n   Tanggal Lahir : " + mahasiswa.getTglLahir() +
                                "\n   No. Telp : " + mahasiswa.getNo_telp() +
                                "\n   Password : " + mahasiswa.getPassword());
            i++;
        }
    }

    public void viewEditDataMahasiswa() throws ParseException {
        String jawab;
        viewDataMahasiswa();
        System.out.print("Pilih Nomor : ");
        index_mhs = input.nextInt();
        do {
            System.out.println("1. Npm : " + mahasiswa.getDataMahasiswa(index_mhs).getNpm());
            System.out.println("2. Nama : " + mahasiswa.getDataMahasiswa(index_mhs).getNama());
            System.out.println("3. Jurusan : " + Diando07228_JurusanEntity.jurusan[mahasiswa.getDataMahasiswa(index_mhs).getIndex_jurusan()]);
            System.out.println("4. Tanggal Lahir : " + mahasiswa.getDataMahasiswa(index_mhs).getTglLahir());
            System.out.println("5. No. Telp : " + mahasiswa.getDataMahasiswa(index_mhs).getNo_telp());
            System.out.println("6. PasswordS : " + mahasiswa.getDataMahasiswa(index_mhs).getPassword());
            System.out.print("Pilih Angka Untuk Edit : ");
            pil = input.nextInt();
            switch (pil) {
                case 1:
                    System.out.println("NPM Sekarang : " + mahasiswa.getDataMahasiswa(index_mhs).getNpm());
                    System.out.print("Input NPM Baru : ");
                    npm = input.next();
                    mahasiswa.updateDataMahasiswa(index_mhs, npm, "npm", "string");
                    System.out.println("Data Berhasil DiEdit");
                    break;
                case 2:
                    System.out.println("Nama Sekarang : " + mahasiswa.getDataMahasiswa(index_mhs).getNama());
                    System.out.print("Input Nama Baru : ");
                    nama = input.next();
                    mahasiswa.updateDataMahasiswa(index_mhs, nama, "nama", "string");
                    System.out.println("Data Berhasil DiEdit");
                    break;
                case 3:
                    for (int i = 0; i < Diando07228_JurusanEntity.jurusan.length; i++) {
                        System.out.println(i + ". " + Diando07228_JurusanEntity.jurusan[i]);
                    }
                    try {
                        System.out.println("Jurusan Sekarang : " + Diando07228_JurusanEntity.jurusan[mahasiswa.getDataMahasiswa(index_mhs).getIndex_jurusan()]);
                        System.out.print("Pilih Jurusan Baru : ");
                        String str_index_jurusan = input.next();
                        mahasiswa.updateDataMahasiswa(index_mhs, str_index_jurusan, "index_jurusan", "int");
                        System.out.println("Data Berhasil DiEdit");
                    } catch (Exception e) {
                        System.out.println("Inputan harus angka");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Tanggal Lahir Sekarang : " + mahasiswa.getDataMahasiswa(index_mhs).getTglLahir());
                        System.out.print("Input Tgl. Lahir Baru (dd/MM/yyyy) : ");
                        String Str_tgl_lahir = input.next();
                        mahasiswa.updateDataMahasiswa(index_mhs, Str_tgl_lahir, "tanggal", "date");
                        System.out.println("Data Berhasil DiEdit");
                    } catch (Exception e) {
                        System.out.println("Format Pengisian Salah");
                    }
                    break;
                case 5:
                    System.out.println("No. Telp Sekarang : " + mahasiswa.getDataMahasiswa(index_mhs).getNo_telp());
                    System.out.print("Input No. Telp Baru : ");
                    no_telp = input.next();
                    mahasiswa.updateDataMahasiswa(index_mhs, no_telp, "noTelp", "string");
                    System.out.println("Data Berhasil DiEdit");
                    break;
                case 6:
                    System.out.println("Password Sekarang : " + mahasiswa.getDataMahasiswa(index_mhs).getPassword());
                    System.out.print("Input Password Baru : ");
                    password = input.next();
                    mahasiswa.updateDataMahasiswa(index_mhs, password, "password", "string");
                    System.out.println("Data Berhasil DiEdit");
                    break;
            }
            System.out.println("Apakah Ingin Edit Lagi ? (y/t)");
            jawab = input.next();
        } while (jawab == "y" | jawab == "Y");
    }

    public void viewHapusDataMahasiswa() {
        viewDataMahasiswa();
        System.out.print("Pilih Nomor : ");
        index_mhs = input.nextInt();
        mahasiswa.deleteDataMahasiswa(index_mhs);
        System.out.println("Data Berhasil Dihapus");
    }
}
