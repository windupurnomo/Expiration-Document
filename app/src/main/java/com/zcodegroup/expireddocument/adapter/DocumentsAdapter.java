package com.zcodegroup.expireddocument.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zcodegroup.expireddocument.R;
import com.zcodegroup.expireddocument.model.Document;

import java.util.List;

/**
 * Created by windupurnomo on 3/2/17.
 */
public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.MyViewHolder> {
    private List<Document> documentsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }


    public DocumentsAdapter(List<Document> documentsList) {
        this.documentsList = documentsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_document, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Document document = documentsList.get(position);
        holder.title.setText(document.getCompany());
        holder.genre.setText(document.getProduct());
        holder.year.setText(document.getExpiredDate());
    }

    @Override
    public int getItemCount() {
        return documentsList.size();
    }
}
