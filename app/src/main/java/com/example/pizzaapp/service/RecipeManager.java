package com.example.pizzaapp.service;

import com.example.pizzaapp.data.Repository;
import com.example.pizzaapp.model.Pizza;
import com.example.pizzaapp.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeManager implements Repository<Pizza> {

    private static RecipeManager INSTANCE;
    private final List<Pizza> recipes = new ArrayList<>();

    private RecipeManager() {
        populate();
    }

    public static RecipeManager getInstance() {
        if (INSTANCE == null) INSTANCE = new RecipeManager();
        return INSTANCE;
    }

    private void populate() {
        recipes.add(new Pizza("BARBECUED CHICKEN PIZZA", 3.0, R.mipmap.pizza1, "35 min", 
                "- 2 boneless skinless chicken breast halves\n- 1 cup barbecue sauce\n- 1 tube refrigerated pizza crust\n- 2 cups shredded Gouda cheese\n- 1 small red onion", 
                "Une pizza savoureuse au poulet grillé et à la sauce barbecue fumée, parfaite pour une soirée d'été à Marrakesh.", 
                "STEP 1: Griller le poulet.\nSTEP 2: Étaler la pâte.\nSTEP 3: Garnir et cuire 15 min.", 4.8f));

        recipes.add(new Pizza("BRUSCHETTA PIZZA", 5.0, R.mipmap.pizza2, "35 min", 
                "- 1/2 pound pork sausage\n- 1 pizza crust\n- 2 cups mozzarella\n- 1-1/2 cups tomatoes\n- 1/2 cup fresh basil", 
                "Le goût frais de l'Italie avec des tomates fraîches, du basilic et de la mozzarella fondante sur une croûte croustillante.", 
                "STEP 1: Cuire la saucisse.\nSTEP 2: Garnir la pâte.\nSTEP 3: Cuire jusqu'à ce que le fromage fonde.", 4.5f));

        recipes.add(new Pizza("SPINACH PIZZA", 2.0, R.mipmap.pizza3, "25 min", 
                "- Pizza crust mix\n- 1/2 cup Alfredo sauce\n- 2 tomatoes\n- 4 cups spinach\n- 2 cups Italian cheese", 
                "Une option saine et délicieuse avec des épinards frais et une sauce Alfredo onctueuse.", 
                "STEP 1: Préparer la pâte.\nSTEP 2: Étaler la sauce.\nSTEP 3: Ajouter les épinards et le fromage.", 4.2f));

        recipes.add(new Pizza("DEEP-DISH SAUSAGE PIZZA", 8.0, R.mipmap.pizza4, "45 min", 
                "- Yeast and flour\n- Vegetable oil\n- Oregano and basil\n- Mozzarella and sausage", 
                "Une pizza épaisse style Chicago, généreusement garnie de saucisses et d'herbes aromatiques.", 
                "STEP 1: Faire lever la pâte.\nSTEP 2: Garnir généreusement.\nSTEP 3: Cuire à haute température.", 4.9f));

        recipes.add(new Pizza("HOMEMADE PIZZA", 4.0, R.mipmap.pizza5, "50 min", 
                "- 1/2 pound ground beef\n- 1 small onion\n- 1 can tomato sauce\n- 1 medium green pepper\n- 2 cups mozzarella", 
                "La recette classique de grand-mère, faite maison avec amour et des ingrédients simples.", 
                "STEP 1: Préparer la pâte maison.\nSTEP 2: Ajouter la sauce et le bœuf.\nSTEP 3: Cuire 30 min.", 4.0f));

        recipes.add(new Pizza("PESTO CHICKEN PIZZA", 3.0, R.mipmap.pizza6, "50 min", 
                "- 1/2 pound chicken breasts\n- 1 small onion\n- Green and red peppers\n- 3 tablespoons pesto", 
                "Un mélange raffiné de poulet tendre et de pesto de basilic frais.", 
                "STEP 1: Cuire le poulet.\nSTEP 2: Étaler le pesto.\nSTEP 3: Ajouter les légumes et cuire.", 4.7f));

        recipes.add(new Pizza("LOADED MEXICAN PIZZA", 3.0, R.mipmap.pizza7, "30 min", 
                "- 1 can black beans\n- 1 medium red onion\n- Chili powder and cumin\n- 1/2 cup cheddar cheese", 
                "Un voyage au Mexique avec des haricots noirs, du piment et du fromage fondu.", 
                "STEP 1: Écraser les haricots.\nSTEP 2: Garnir la pâte.\nSTEP 3: Ajouter le fromage et cuire.", 4.3f));

        recipes.add(new Pizza("BACON CHEESEBURGER PIZZA", 2.0, R.mipmap.pizza8, "20 min", 
                "- 1/2 pound ground beef\n- 6 bacon strips\n- 20 dill pickle slices\n- 2 cups mozzarella and cheddar", 
                "Le mariage parfait entre un cheeseburger juteux et une pizza croustillante.", 
                "STEP 1: Cuire le bœuf.\nSTEP 2: Ajouter le bacon et les cornichons.\nSTEP 3: Gratiner au four.", 4.6f));

        recipes.add(new Pizza("PIZZA MARGHERITA", 1.0, R.mipmap.pizza9, "30 min", 
                "- Yeast and flour\n- 2 tablespoons olive oil\n- Fresh tomatoes and basil\n- Mozzarella cheese", 
                "La reine des pizzas, simple et élégante aux couleurs de l'Italie.", 
                "STEP 1: Faire lever la pâte.\nSTEP 2: Ajouter les tomates fraîches.\nSTEP 3: Parsemer de basilic.", 4.9f));

        recipes.add(new Pizza("PEPPERONI STUFFED PIZZA", 5.0, R.mipmap.pizza10, "45 min", 
                "- Pizza dough\n- Stuffed crust\n- Pepperoni slices\n- Tomato sauce and mozzarella", 
                "Une pizza gourmande avec une croûte fourrée au fromage et généreuse en pepperoni.", 
                "STEP 1: Préparer la croûte.\nSTEP 2: Ajouter le pepperoni.\nSTEP 3: Cuire jusqu'à dorure.", 4.8f));
    }

    @Override public Pizza create(Pizza p) { recipes.add(p); return p; }
    @Override public Pizza update(Pizza p) { return p; }
    @Override public boolean delete(long id) { return recipes.removeIf(x -> x.getId() == id); }
    @Override public Pizza findById(long id) {
        for (Pizza p : recipes) if (p.getId() == id) return p;
        return null;
    }
    @Override public List<Pizza> findAll() { return Collections.unmodifiableList(recipes); }
}
