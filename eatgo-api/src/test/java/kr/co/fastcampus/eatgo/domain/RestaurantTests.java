package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantTests {
    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant(1004L,"BOB ZIP","Seoul");
        assertThat(restaurant.getId(), is(1004L));
        assertThat(restaurant.getName(), is("BOB ZIP"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }
    @Test
    public void infomation(){
        Restaurant restaurant = new Restaurant(1004L,"BOB ZIP", "Seoul");
        assertThat(restaurant.getInformation(), is("BOB ZIP in Seoul"));
    }
}