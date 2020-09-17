package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {
    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant("BOB ZIP","Seoul");
        assertThat(restaurant.getName(), is("BOB ZIP"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }
    @Test
    public void infomation(){
        Restaurant restaurant = new Restaurant("BOB ZIP", "Seoul");
        assertThat(restaurant.getInformation(), is("BOB ZIP in Seoul"));
    }
}