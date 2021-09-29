import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
	RestaurantService service = new RestaurantService();
	 Restaurant restaurant;
	 private List<Item> menu = new ArrayList<Item>();
	 private List<String> customMenu = new ArrayList<String>();
	    //REFACTOR ALL THE REPEATED LINES OF CODE
	    
	    public void add_restaurant_for_testing(){
	    	LocalTime openingTime = LocalTime.parse("10:30:00");
	        LocalTime closingTime = LocalTime.parse("22:00:00");
	        restaurant = service.addRestaurant("Amelie's cafe","chennai",openingTime,closingTime);
	        service.addRestaurant("paris cafe","chennai",LocalTime.parse("09:30:00"),LocalTime.parse("22:00:00"));
	        restaurant.addToMenu("Sweet corn soup",119);
	        restaurant.addToMenu("Vegetable lasagne", 269);
	        restaurant.addToMenu("Cheese Toast", 220);
	    }
	  //>>>>>>>>>>>>>>>>>>>>>>>>>>>ORDER VALUE<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	    @Test
	    public void order_value_should_get_cumulative_total_when_collection_of_items_selected(){
	    	add_restaurant_for_testing();
	    	customMenu.add("Sweet corn soup");
	        assertEquals(119,restaurant.getOrderValue(customMenu));
	    }
//	    @Test
//	    public void order_value_should_get_incorrect_total_when_collection_of_items_selected(){
//	    	add_restaurant_for_testing();
//	    	customMenu.add("Sweet corn soup");
//	        assertNotEquals(360,restaurant.getOrderValue(customMenu));
//	    }
	    @Test
	    public void order_value_should_get_cumulative_total_when_no_items_selected(){
	    	add_restaurant_for_testing();
	        assertEquals(0,restaurant.getOrderValue(customMenu));
	    }
	    //<<<<<<<<<<<<<<<<<<<<<<<<<ORDER VALUE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 
	   
}
