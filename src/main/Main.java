package main;

import Controller.KelompokGenerator;
import java.util.Arrays;

public class Main {
    
    private static final int INDEKS_JUMLAH_KELOMPOK = 0;
    private static final int INDEKS_JUMLAH_ANGGOTA = 1;
    private static final int INDEKS_CALON_ANGGOTA = 2;
    
    public static void main(String[] args){
        int jumlahKelompok = Integer.parseInt(args[INDEKS_JUMLAH_KELOMPOK]);
        int jumlahAnggota = Integer.parseInt(args[INDEKS_JUMLAH_ANGGOTA]);
        String[] calonAnggota = Arrays.copyOfRange(args, INDEKS_CALON_ANGGOTA, args.length);
        
        KelompokGenerator generator = new KelompokGenerator(jumlahKelompok, jumlahAnggota);
        generator.generate(calonAnggota);
        generator.printKelompok();
    }
    
}
