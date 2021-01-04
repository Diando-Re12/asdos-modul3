/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Diando07228_JurusanEntity;
import Entity.Diando07228_MahasiswaEntity;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Diando07228_MahasiswaModel{
    private ArrayList<Diando07228_MahasiswaEntity> mahasiswaEntityArrayList;
    
    public Diando07228_MahasiswaModel() {
        mahasiswaEntityArrayList = new ArrayList<Diando07228_MahasiswaEntity>();
    }
    
    public Diando07228_MahasiswaEntity getProfileMahasiswa(int index) {
        return mahasiswaEntityArrayList.get(index);
    }
    
    public ArrayList<Diando07228_MahasiswaEntity> getAllMahasiswa() {
        return mahasiswaEntityArrayList;
    }
    
    public void insertMahasiswaModel(Diando07228_MahasiswaEntity profileMahasiswa) {
        mahasiswaEntityArrayList.add(profileMahasiswa);
    }
    
    public void editNpmMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setNpm(data);
    }
    
    public void editNamaMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setNama(data);
    }
    
    public void editNoTelpMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setNo_telp(data);
    }
    
    public void editPasswordMahasiswaModel(int index, String data) {
        mahasiswaEntityArrayList.get(index).setPassword(data);
    }
    
    public void editMahasiswaModel(int index, Date data) {
        mahasiswaEntityArrayList.get(index).setTglLahir(data);
    }
    
    public void editMahasiswaModel(int index, int data) {
        mahasiswaEntityArrayList.get(index).setIndex_jurusan(data);
    }
    
    public void hapusMahasiswaModel(int index) {
        mahasiswaEntityArrayList.remove(mahasiswaEntityArrayList.get(index));
    }
}
