package com.example.pizzaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pizzaapp.model.MarrakeshItem;
import com.example.pizzaapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MarrakeshGalleryAdapter extends BaseAdapter {
    private final Context ctx;
    private List<MarrakeshItem> galleryList;
    private final List<MarrakeshItem> masterList; // Liste complète pour filtrage
    private final LayoutInflater builder;

    public MarrakeshGalleryAdapter(Context context, List<MarrakeshItem> initialData) {
        this.ctx = context;
        this.galleryList = initialData;
        this.masterList = new ArrayList<>(initialData);
        this.builder = LayoutInflater.from(context);
    }

    @Override public int getCount() { return galleryList.size(); }
    @Override public Object getItem(int pos) { return galleryList.get(pos); }
    @Override public long getItemId(int pos) { return galleryList.get(pos).getUniqueId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EntryHolder holder;
        if (convertView == null) {
            convertView = builder.inflate(R.layout.item_pizza_recipe, parent, false);
            holder = new EntryHolder();
            holder.thumbnail = convertView.findViewById(R.id.img_pizza_thumb);
            holder.mainLabel = convertView.findViewById(R.id.txt_pizza_name);
            holder.metaInfo = convertView.findViewById(R.id.txt_pizza_info);
            holder.stars = convertView.findViewById(R.id.rating_bar);
            convertView.setTag(holder);
        } else {
            holder = (EntryHolder) convertView.getTag();
        }

        MarrakeshItem itemData = galleryList.get(position);
        holder.thumbnail.setImageResource(itemData.getVisualResource());
        holder.mainLabel.setText(itemData.getLabel());
        holder.metaInfo.setText(String.format(Locale.getDefault(), "%s • %.2f €", itemData.getPrepTime(), itemData.getUnitPrice()));
        holder.stars.setRating(itemData.getUserRating());

        return convertView;
    }

    // Recherche adaptative
    public void executeSearch(String query) {
        query = query.toLowerCase(Locale.getDefault()).trim();
        galleryList = new ArrayList<>();
        if (query.isEmpty()) {
            galleryList.addAll(masterList);
        } else {
            for (MarrakeshItem entry : masterList) {
                if (entry.getLabel().toLowerCase(Locale.getDefault()).contains(query)) {
                    galleryList.add(entry);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class EntryHolder {
        ImageView thumbnail;
        TextView mainLabel;
        TextView metaInfo;
        RatingBar stars;
    }
}
