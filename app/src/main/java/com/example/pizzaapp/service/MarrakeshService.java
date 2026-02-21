package com.example.pizzaapp.service;

import com.example.pizzaapp.data.DataAccessVault;
import com.example.pizzaapp.model.MarrakeshItem;
import com.example.pizzaapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarrakeshService implements DataAccessVault<MarrakeshItem> {

    private static MarrakeshService singletonInstance;
    private final List<MarrakeshItem> dataBank = new ArrayList<>();

    private MarrakeshService() {
        injectData();
    }

    public static MarrakeshService getAccess() {
        if (singletonInstance == null) singletonInstance = new MarrakeshService();
        return singletonInstance;
    }

    private void injectData() {
        dataBank.add(new MarrakeshItem("CHICKEN FEAST", 3.0, R.mipmap.pizza1, "35 min", "Chicken, BBQ sauce, Gouda", "Savoureuse pizza au poulet grillé.", 4.8f));
        dataBank.add(new MarrakeshItem("ITALIAN CLASSIC", 5.0, R.mipmap.pizza2, "35 min", "Sausage, Mozzarella, Basil", "Le goût authentique de la bruschetta.", 4.5f));
        dataBank.add(new MarrakeshItem("POPEYE SPECIAL", 2.0, R.mipmap.pizza3, "25 min", "Spinach, Alfredo sauce, Tomatoes", "Mélange onctueux d'épinards.", 4.2f));
        dataBank.add(new MarrakeshItem("DEEP-DISH SAUSAGE", 8.0, R.mipmap.pizza4, "45 min", "Sausage, Mozzarella, Oregano", "Style Chicago, généreusement garnie.", 4.9f));
        dataBank.add(new MarrakeshItem("GRANDMA'S PIE", 4.0, R.mipmap.pizza5, "50 min", "Beef, Onion, Tomato sauce", "Recette maison traditionnelle.", 4.0f));
        dataBank.add(new MarrakeshItem("PESTO CHICKEN", 3.0, R.mipmap.pizza6, "50 min", "Chicken, Pesto, Peppers", "Mélange raffiné poulet et pesto.", 4.7f));
        dataBank.add(new MarrakeshItem("MEXICAN LOADED", 3.0, R.mipmap.pizza7, "30 min", "Beans, Onion, Chili powder", "Voyage au Mexique avec haricots noirs.", 4.3f));
        dataBank.add(new MarrakeshItem("BACON BURGER", 2.0, R.mipmap.pizza8, "20 min", "Beef, Bacon, Pickles", "Le mariage parfait burger et pizza.", 4.6f));
        dataBank.add(new MarrakeshItem("ROYAL MARGHERITA", 1.0, R.mipmap.pizza9, "30 min", "Tomatoes, Mozzarella, Olive oil", "L'élégance de la simplicité.", 4.9f));
        dataBank.add(new MarrakeshItem("STUFFED PEPPERONI", 5.0, R.mipmap.pizza10, "45 min", "Pepperoni, Mozzarella, Sauce", "Croûte fourrée généreuse.", 4.8f));
    }

    @Override public MarrakeshItem addEntry(MarrakeshItem entry) { dataBank.add(entry); return entry; }
    @Override public MarrakeshItem getById(long id) {
        for (MarrakeshItem item : dataBank) if (item.getUniqueId() == id) return item;
        return null;
    }
    @Override public List<MarrakeshItem> getAllEntries() { return Collections.unmodifiableList(dataBank); }
}
