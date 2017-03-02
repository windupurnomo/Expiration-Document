package com.zcodegroup.expireddocument;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.zcodegroup.expireddocument.adapter.DocumentsAdapter;
import com.zcodegroup.expireddocument.custom.DividerItemDecoration;
import com.zcodegroup.expireddocument.listener.ClickListener;
import com.zcodegroup.expireddocument.listener.RecyclerTouchListener;
import com.zcodegroup.expireddocument.model.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Document> documentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DocumentsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new DocumentsAdapter(documentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Document document = documentList.get(position);
                Toast.makeText(getApplicationContext(), document.getCompany() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareDocumentData();
    }

    private void prepareDocumentData(){
        Document d = new Document();
        d.setCompany("PT. Jaya Abadi");
        d.setProduct("Mesin Cuci");
        d.setExpired(new GregorianCalendar(2017, 3, 11).getTime());
        documentList.add(d);

        mAdapter.notifyDataSetChanged();
    }
}
