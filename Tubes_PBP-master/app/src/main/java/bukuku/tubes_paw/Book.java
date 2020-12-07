package bukuku.tubes_paw;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class Book {
    public String nama;
    public String penulis;
    public String imgUrl;

    public Book(String nama, String penulis, String imgUrl)
    {
        this.penulis = penulis;
        this.imgUrl = imgUrl;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return penulis;
    }

    public void setDeskripsi(String penulis) {
        this.penulis = penulis;
    }

    public String getImgURL() {
        return imgUrl;
    }

    public void setImgURL(String imgURL) {
        this.imgUrl = imgURL;
    }


    @BindingAdapter("android:loadImage")
    public static void loadImage(ImageView imageView, String imgURL){
        Glide.with(imageView)
                .load(imgURL)
                .into(imageView);
    }
}

