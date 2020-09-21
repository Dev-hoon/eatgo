package kr.co.fastcampus.eatgo.domain;

import java.util.List;

public interface MenuItemRepo {
    List<MenuItem> findAllByRestaurantId(Long restaurantId);
}
