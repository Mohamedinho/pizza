package com.example.pizzaapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzaapp.R;
import com.example.pizzaapp.adapter.MarrakeshGalleryAdapter;
import com.example.pizzaapp.model.MarrakeshItem;
import com.example.pizzaapp.service.MarrakeshService;
import java.util.List;

public class MarrakeshMenu extends AppCompatActivity {

    private MarrakeshGalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        ListView mainListView = findViewById(R.id.lv_recipe_list);
        SearchView searchBar = findViewById(R.id.search_view);

        List<MarrakeshItem> dataSet = MarrakeshService.getAccess().getAllEntries();
        galleryAdapter = new MarrakeshGalleryAdapter(this, dataSet);
        mainListView.setAdapter(galleryAdapter);

        // Configuration de la recherche visuelle
        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                galleryAdapter.executeSearch(text);
                return true;
            }
        });

        mainListView.setOnItemClickListener((p, v, pos, id) -> {
            MarrakeshItem picked = (MarrakeshItem) galleryAdapter.getItem(pos);
            Intent viewIntent = new Intent(MarrakeshMenu.this, MarrakeshVault.class);
            viewIntent.putExtra("target_id", picked.getUniqueId());
            startActivity(viewIntent);
        });
    }
}
