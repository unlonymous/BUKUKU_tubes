package bukuku.tubes_paw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bukuku.tubes_paw.databinding.ActivityAdapterRecyclerViewBinding;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder> {
    private Context context;
    private List<Book> result;
    private ActivityAdapterRecyclerViewBinding adapterRecyclerViewBinding;


    public AdapterRecyclerView() {
    }

    public AdapterRecyclerView(Context context, List<Book> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        adapterRecyclerViewBinding = ActivityAdapterRecyclerViewBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(adapterRecyclerViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Book bk = result.get(position);
        holder.adapterbinding.setBook(bk);
        holder.adapterbinding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ActivityAdapterRecyclerViewBinding adapterbinding;


        public MyViewHolder(@NonNull ActivityAdapterRecyclerViewBinding adapterbinding) {
            super(adapterbinding.getRoot());
            this.adapterbinding = adapterbinding;

        }

        public void onClick(View view) {
            Toast.makeText(context, "You touch me?", Toast.LENGTH_SHORT).show();
        }
    }
}
