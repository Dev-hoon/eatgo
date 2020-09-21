package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepo {
    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRepositoryImpl(){
        menuItems.add(new MenuItem("Kimchi"));
    }
    @Override
    public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
        //List<MenuItem> menuItems = new ArrayList<>();
        //menuItems.add(new MenuItem("Kimchi"));
        return menuItems;
    }
}
