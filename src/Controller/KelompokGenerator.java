package Controller;

import java.util.Arrays;
import model.Kelompok;

public class KelompokGenerator {
    
    private final Kelompok[] kelompok;
    private final int jumlahAnggota;
    
    public KelompokGenerator(int jumlahKelompok, int jumlahAnggota){
        this.kelompok = new Kelompok[jumlahKelompok];
        this.jumlahAnggota = jumlahAnggota;
        buatKelompok(jumlahKelompok);
    }
    
    private void buatKelompok(int jumlahKelompok){
        for (int i = 0; i < jumlahKelompok; i++) {
            kelompok[i] = new Kelompok(jumlahAnggota);
        }
    }
    
    public void generate(String[] calonAnggota){
        int jumlahKelompok = kelompok.length;
        int calon = calonAnggota.length;
        int[] sudahAnggota = new int[calon];
        int n = 0;
        
        for (int baris = 0; baris < jumlahAnggota; baris++){
            for (int kolom = 0; kolom < jumlahKelompok; kolom++) {
                try{
                    int anggotaRandom = getCalonAnggota(sudahAnggota, calon);
                    kelompok[kolom].setAnggotaKe(baris, calonAnggota[anggotaRandom - 1]);
                    sudahAnggota[n++] = anggotaRandom;
                } catch(ArrayIndexOutOfBoundsException e){
                    break;
                }
            }
        }
    }
    
    private int getCalonAnggota(int[] sudahAnggota, int calon){
        int calonAnggota;
        do{
            calonAnggota = getRandom(calon);
        }while(cekAnggota(calonAnggota, sudahAnggota)); 
        
        return calonAnggota;
        
    }
    
    private boolean cekAnggota(int calonAnggota, int[] sudahAnggota){
        boolean ketemu = false;
        for(int anggota : sudahAnggota){
            if(anggota == calonAnggota){
                ketemu = true;
                break;
            }
        }
        
        return ketemu;
    }
    
    private int getRandom(int calon){
        return (int) (Math.random() * (calon + 1));
    }
 
    public void printKelompok(){
        int jumlahKelompok = kelompok.length;
        for(int baris = 0; baris < jumlahKelompok; baris++){
            int anggota = kelompok[baris].getJumlahAnggota();
            System.out.println("Kelompok " + (baris + 1) + " : ");
            for(int kolom = 0; kolom < anggota; kolom++){
                System.out.println((kolom + 1) + ". " + kelompok[baris].getAnggotaKe(kolom));
            }
        }
    }
    
}
