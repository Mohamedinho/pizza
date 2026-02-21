package com.example.pizzaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PizzaRecipeAdapter extends BaseAdapter {
    private final Context context;
    private List<Pizza> pizzaList;
    private final List<Pizza> pizzaListFull;
    private final LayoutInflater inflater;

    public PizzaRecipeAdapter(Context context, List<Pizza> pizzaList) {
        this.context = context;
        this.pizzaList = pizzaList;
        this.pizzaListFull = new ArrayList<>(pizzaList);
        this.inflater = LayoutInflater.from(context);
    }

    @Override public int getCount() { return pizzaList.size(); }
    @Override public Object getItem(int position) { return pizzaList.get(position); }
    @Override public long getItemId(int position) { return pizzaList.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_pizza_recipe, parent, false);
            holder = new ViewHolder();
            holder.pizzaImage = convertView.findViewById(R.id.img_pizza_thumb);
            holder.pizzaName = convertView.findViewById(R.id.txt_pizza_name);
            holder.pizzaDetails = convertView.findViewById(R.id.txt_pizza_info);
            holder.ratingBar = convertView.findViewById(R.id.rating_bar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pizza pizza = pizzaList.get(position);
        holder.pizzaImage.setImageResource(pizza.getImageRes());
        holder.pizzaName.setText(pizza.getName());
        holder.pizzaDetails.setText(String.format(Locale.getDefault(), "%s • %.2f €", pizza.getDuration(), pizza.getPrice()));
        holder.ratingBar.setRating(pizza.getRating());

        return convertView;
    }

    public void filter(String text) {
        text = text.toLowerCase(Locale.getDefault());
        pizzaList = new ArrayList<>();
        if (text.length() == 0) {
            pizzaList.addAll(pizzaListFull);
        } else {
            for (Pizza pizza : pizzaListFull) {
                if (pizza.getName().toLowerCase(Locale.getDefault()).contains(text)) {
                    pizzaList.add(pizza);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class ViewHolder {
        ImageView pizzaImage;
        TextView pizzaName;
        TextView pizzaDetails;
        RatingBar ratingBar;
    }
}
