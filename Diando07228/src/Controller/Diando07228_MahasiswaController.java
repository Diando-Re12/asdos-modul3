/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Diando07228_MahasiswaEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author irfan
 */
public class Diando07228_MahasiswaController {
    int indexLogin;
    public Diando07228_MahasiswaEntity getDataMahasiswa(int index) {
        return Diando07228_AllObjectModel.mahasiswa.getProfileMahasiswa(index);
    }
    
    public Diando07228_MahasiswaEntity mahasiswaEntity(int index) {
        return Diando07228_AllObjectModel.mahasiswa.getProfileMahasiswa(index);
    }
    
    public void insertDataMahasiswa(String npm, String nama, Date tanggal_lahir, int index_jurusan, String no_telp, String password) {
        Diando07228_MahasiswaEntity mahasiswa = new Diando07228_MahasiswaEntity(npm, nama, tanggal_lahir, index_jurusan, no_telp, password);
        Diando07228_AllObjectModel.mahasiswa.insertMahasiswaModel(mahasiswa);
    }
    
    public void deleteDataMahasiswa(int index) {
        Diando07228_AllObjectModel.mahasiswa.hapusMahasiswaModel(index);
    }
    
    public ArrayList<Diando07228_MahasiswaEntity> getDataMahasiswa() {
        return Diando07228_AllObjectModel.mahasiswa.getAllMahasiswa();
    }
    
    public void updateDataMahasiswa(int index, String data, String ubah, String tipe) throws ParseException {
        switch(tipe) {
            case "string" :
                switch(ubah) {
                    case "npm":
                        Diando07228_AllObjectModel.mahasiswa.editNpmMahasiswaModel(index, data);
                        break;
                    case "nama":
                        Diando07228_AllObjectModel.mahasiswa.editNamaMahasiswaModel(index, data);
                        break;
                    case "noTelp":
                        Diando07228_AllObjectModel.mahasiswa.editNoTelpMahasiswaModel(index, data);
                        break;
                    case "password":
                        Diando07228_AllObjectModel.mahasiswa.editPasswordMahasiswaModel(index, data);
                        break;
                }
                break;
            case "date" :
                Diando07228_AllObjectModel.mahasiswa.editMahasiswaModel(index, new SimpleDateFormat("dd/MM/yyyy").parse(data));
                break;
            case "int":
                Diando07228_AllObjectModel.mahasiswa.editMahasiswaModel(index, Integer.parseInt(data));
                break;
        }
    }
}
