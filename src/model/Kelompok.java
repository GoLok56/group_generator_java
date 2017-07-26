package model;

public class Kelompok {
    
    private final String[] anggota;
    
    public Kelompok(int jumlahAnggota){
        this.anggota = new String[jumlahAnggota];
    }
    
    public String getAnggotaKe(int n){
        if(melebihiKapasitas(n)){
            return null;
        }
        
        return anggota[n];
    }
    
    public void setAnggotaKe(int n, String nama){
        if(melebihiKapasitas(n)){
            return;
        }
        
        anggota[n] = nama;
    }
    
    public int getJumlahAnggota(){
        int jumlah = 0;
        for (String currentAnggota : anggota) {
            if (currentAnggota == null) {
                break;
            }
            jumlah++;
        }
        return jumlah;
    }
    
    private boolean melebihiKapasitas(int n){
        return n > anggota.length;
    }
    
}
