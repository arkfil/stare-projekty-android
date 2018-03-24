package com.example.arek.testbasic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class WpisyAdapter extends RecyclerView.Adapter<WpisyAdapter.ViewHolder> {

    private List<Wpis> listaWpisow;
    private Context mContext;


    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback=itemClickCallback;
    }

    public WpisyAdapter(Context context, List<Wpis> wpisy) {
        listaWpisow = wpisy;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public WpisyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View viewWpisu = inflater.inflate(R.layout.item_wpis, parent, false);
        ViewHolder viewHolder = new ViewHolder(viewWpisu);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WpisyAdapter.ViewHolder viewHolder, int position) {
        Wpis wpis = listaWpisow.get(position);

        viewHolder.tematWpisuTextView.setText(wpis.pobierzTemat());
        viewHolder.autorWpisuTextView.setText(wpis.pobierzAutora());
        viewHolder.trescWpisuTextView.setText(wpis.pobierzTresc());
        viewHolder.dataWpisuTextView.setText(wpis.pobierzDate());
    }

    @Override
    public int getItemCount() {
        return listaWpisow.size();
    }




    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tematWpisuTextView;
        public TextView trescWpisuTextView;
        public TextView dataWpisuTextView;
        public TextView autorWpisuTextView;
        public View kontener;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tematWpisuTextView = (TextView) itemView.findViewById(R.id.temat);
            trescWpisuTextView = (TextView) itemView.findViewById(R.id.tresc);
            autorWpisuTextView = (TextView) itemView.findViewById(R.id.autor);
            dataWpisuTextView = (TextView) itemView.findViewById(R.id.data);

            kontener = itemView.findViewById(R.id.kontener);
            kontener.setOnClickListener(this);

        }
        public void onClick(View view){
            if(view.getId()==R.id.kontener){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }


}