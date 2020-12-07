package bukuku.tubes_paw;

import java.util.ArrayList;

public class DaftarBooks {

    public ArrayList<Book> BOOK;

    public DaftarBooks()
    {
        BOOK = new ArrayList();
        BOOK.add(dilan);// nanti ditambah sendiri yak, ini nama buku yang mau dimasukkin ke array
        BOOK.add(crazyrich);
        BOOK.add(konspirasi);
        BOOK.add(mariposa);
        BOOK.add(perahu);
        BOOK.add(plagiarism);
        BOOK.add(sangpenari);
        BOOK.add(seniberbicara);
        BOOK.add(summer);
    }

    public static final Book dilan = new Book ("Dilan 1990", "Pidi Baiq","https://pbs.twimg.com/media/EkQDJNnUYAAbN45?format=jpg&name=360x360"); //nanti ini diisi sesuai jumlah array list ya
    public static final Book crazyrich = new Book ("Crazy Rich Asian", "Kevin Kwan","https://pbs.twimg.com/media/EkQDTMZUwAEhEL8?format=jpg&name=360x360");
    public static final Book konspirasi = new Book ("Konspirasi Alam Semesta", "Fiersa Bestari","https://pbs.twimg.com/media/EkQDZHOVgAAKoAs?format=jpg&name=360x360");
    public static final Book mariposa = new Book ("Mariposa", "Tulus","https://pbs.twimg.com/media/EkQDgZ9UcAEu4Ks?format=jpg&name=360x360");
    public static final Book perahu = new Book ("Perahu Kertas 2", "Dee Lestari","https://pbs.twimg.com/media/EkQDlx2U8AAfbGt?format=jpg&name=360x360");
    public static final Book plagiarism = new Book ("Strategi Menghindari Plagiarisme", "Etty Indriaty","https://pbs.twimg.com/media/EkQDrXkVcAAOvDj?format=jpg&name=360x360");
    public static final Book sangpenari = new Book ("Sang Penari", " Ahmad Tohari ","https://pbs.twimg.com/media/EkQD-19UcAAttt-?format=jpg&name=360x360");
    public static final Book seniberbicara = new Book ("Sebuah Seni untuk Bersikap Bodo Amat", "Mark Manson","https://pbs.twimg.com/media/EkQEDEKVkAA4UU9?format=jpg&name=360x360");
    public static final Book summer = new Book ("Summer Triangle", "Hara Hope","https://pbs.twimg.com/media/EkQEEy8U8AEsr1T?format=jpg&name=360x360");
}