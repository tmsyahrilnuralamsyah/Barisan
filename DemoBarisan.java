import java.util.Scanner;
/**
 * Program Barisan (Tugas 3 PBO)
 * @author  T.M. Syahril Nur Alamsyah (1808107010032)
 * @since   23 Des 2019
 */
public class DemoBarisan {
    /**
     * method main berfungsi untuk menjalankan program
     * @param args
     */
    public static void main(String[] args) {
        DemoBarisan db = new DemoBarisan();
        boolean play = true;
        Scanner user = new Scanner(System.in);
        int temp1, temp2;
        
        while (play) {
            System.out.println("Pilih Barisan :");
            System.out.println("1. Barisan Aritmetika");
            System.out.println("2. Barisan Geometri");
            System.out.println("3. Barisan Fibonacci");
            System.out.println("4. Barisan Pangkat");
            System.out.print("Masukkan Pilihan Anda : ");
            int pilihan = user.nextInt();
            user.close();
            switch (pilihan) {
                case 1 :
                    System.out.println("\n- Barisan Aritmetika -");
                    System.out.print("Nilai Awal    :  ");
                    temp1 = user.nextInt();
                    System.out.print("Kenaikan      :  ");
                    temp2 = user.nextInt();
                    Barisan aritmetika = new BarisanAritmatika(temp1, temp2);
                    db.cetakUrutan20(aritmetika);
                    break;
        
                case 2 :
                    System.out.println("\n- Barisan Geometri -");
                    System.out.print("Nilai Awal  : ");
                    temp1 = user.nextInt();
                    System.out.print("Rasio       : ");
                    temp2 = user.nextInt();
                    Barisan geometri = new BarisanGeometri(temp1, temp2);
                    db.cetakUrutan20(geometri);
                    break;
        
                case 3 :
                    System.out.println("\n- Barisan Fibonacci -");
                    Barisan fibonacci = new BarisanFibonacci();
                    db.cetakUrutan20(fibonacci);
                    break;
        
                case 4 :
                    System.out.println("\n- Barisan Pangkat -");
                    System.out.print("Pangkat       : ");
                    temp1 = user.nextInt();
                    Barisan pangkat = new BarisanPangkat(temp1);
                    db.cetakUrutan20(pangkat);
                    break;
        
                default :
                    System.out.println("\nTidak ada dipilihan");
            }
            
            System.out.println("\nApakah ingin melihat barisan lain ? [Y/n]");
            String x = user.next();
            if (x.equalsIgnoreCase("Y")) {
                play = true;
            } else {
                play = false;
            }
            System.out.println();
        }
    }

    /**
     * method ini yang berfungsi untuk memproses perulangan barisan sebanyak 20 kali
     * @param baris jenis barisan yang dipilih user
     */
    public void cetakUrutan20(Barisan baris) {
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print(baris.nilaiBerikutnya+"  ");
            baris.berikutnya();
        }
    }
}

abstract class Barisan {
    protected int nilaiBerikutnya;

    /**
	 * Constructor method class Barisan tanpa parameter hanya memberi nilai awal
	 */
    public Barisan() {
        this.nilaiBerikutnya = 0;
    }

    /**
	 * Constructor method class Barisan dengan parameter yang akan menjadikan nilaiAwal menjadi nilaiBerikutnya
	 * @param nilaiAwal
	 */
    public Barisan(int nilaiAwal) {
        this.nilaiBerikutnya = nilaiAwal;
    }

    /**
	 * Method ini digunakan untuk mengambilakan nilai berikutnya pada barisan
	 * @return nilaiBerikutnya
	 */
    public int berikutnya() {
        this.naik();
        return nilaiBerikutnya;
    }

    /**
	 * Abstrak method untuk diimplementasikan pada subclass
	 */
    public abstract void naik();
}

class BarisanAritmatika extends Barisan { // penambahan
    int kenaikan;
    
    /**
     * Constructor method class BarisanAritmatika untuk memanggil
     * Constructor superclass dengan keyword super()
     * @param nilaiAwal nilai awal barisan
     * @param kenaikan kenaikan barisan
     */
    public BarisanAritmatika(int nilaiAwal, int kenaikan) {
        super(nilaiAwal);
        this.kenaikan = kenaikan;
    }
    
   /**
     * Method implementasi dari method abstract pada superclass
     */ 
    @Override
    public void naik() {
        super.nilaiBerikutnya += kenaikan;
    }
}

class BarisanGeometri extends Barisan { // pemangkatan 
    int rasioPengali;

    /**
     * Constructor method class BarisanGeometri untuk memanggil
     * Constructor superclass dengan keyword super()
     * @param nilaiAwal
     * @param rasioPengali
     */
    public BarisanGeometri(int nilaiAwal, int rasioPengali) {
        super(nilaiAwal);
        this.rasioPengali = rasioPengali;
    }

    /**
     * Method implementasi dari method abstract pada superclass
     */
    @Override
    public void naik() {
        super.nilaiBerikutnya *= rasioPengali;
    }
}

class BarisanFibonacci extends Barisan { // 0,1,1,2,3,5 ... 0, 0+1=1, 1+1=2, 1+2=3, 2+3=5 ...
    int nilaiSebelumnya;

    /**
     * Constructor method class BarisanFibonacci untuk memanggil
     * Constructor superclass dengan keyword super() dan memberi nilai awal 1 untuk nilaiSebelumnya
     */
    public BarisanFibonacci() {
        super(0);
        this.nilaiSebelumnya = 1;
    }

    /**
     * Method implementasi dari method abstract pada superclass
     */
    @Override
    public void naik() {
        int temp = super.nilaiBerikutnya;
        super.nilaiBerikutnya = nilaiSebelumnya + temp;
        nilaiSebelumnya = temp;
    }
}

class BarisanPangkat extends Barisan { // pemangkatan 2
    int pangkat, nilai, simpan;

    /**
     * Constructor method class BarisanPangkat untuk memanggil
     * Constructor superclass dengan keyword super() dan memberi nilai awal 2 untuk nilai
     * @param nilaiAwal nilai mula-mula barisan
     * @param pangkat dikasih nilai 2
     */
    public BarisanPangkat(int pangkat) {
        super(1);
        this.pangkat = pangkat;
        nilai = 2;
    }

    /**
     * Method implementasi dari method abstract pada superclass
     */
    @Override
    public void naik() {
        super.nilaiBerikutnya = (int) Math.pow(nilai, pangkat);
        this.simpan = nilai++;
    }
}