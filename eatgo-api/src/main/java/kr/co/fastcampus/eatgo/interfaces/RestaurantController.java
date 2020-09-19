package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantRepositoryImpl restaurantRepository;
    @Autowired
    private MenuItemRepositoryImpl menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        /*
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "BOB ZIP", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
*/ //아래 코드로 분리 작업
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }
    @GetMapping("/restaurant/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        //기본정보 + 메뉴정보

        /*List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(new Restaurant(1004L, "BOB ZIP", "Seoul"));
        restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));*/ // 하단 코드로 분리 작업 함
        Restaurant restaurant = restaurantRepository.findById(id);
        // 하단 작업은 컨트롤러에서 하면 비효율적이므로 빼줌
        //Restaurant restaurant = restaurants.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        /*list 없이 수동으로 체크 하여 받아올때 작업 하는 코드
        if (id == 1004L) {
            restaurant = new Restaurant(1004L, "BOB ZIP", "Seoul");
        }
        if (id == 2020L) {
            restaurant = new Restaurant(2020L, "Cyber Food", "Seoul");
        }*/
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        restaurant.addMenuItem(new MenuItem("Kimchi"));
        return restaurant;
    }



}
