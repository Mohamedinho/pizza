package com.example.myrecipeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myrecipeapp.model.Pizza;
import com.example.pizzaapp.R;

import java.util.List;

public class PizzaRecipeAdapter extends BaseAdapter {
    private final Context context;
    private final List<Pizza> pizzaList;
    private final LayoutInflater inflater;

    public PizzaRecipeAdapter(Context context, List<Pizza> pizzaList) {
        this.context = context;
        this.pizzaList = pizzaList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pizzaList.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzaList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_pizza_recipe, parent, false);
            holder = new ViewHolder();
            holder.pizzaImage = convertView.findViewById(R.id.img_pizza_thumb);
            holder.pizzaName = convertView.findViewById(R.id.txt_pizza_name);
            holder.pizzaDetails = convertView.findViewById(R.id.txt_pizza_info);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Pizza pizza = pizzaList.get(position);
        holder.pizzaImage.setImageResource(pizza.getImageRes());
        holder.pizzaName.setText(pizza.getName());
        holder.pizzaDetails.setText(String.format("%s • %.2f €", pizza.getDuration(), pizza.getPrice()));

        return convertView;
    }

    static class ViewHolder {
        ImageView pizzaImage;
        TextView pizzaName;
        TextView pizzaDetails;
    }
}
