package org.wecancodeit.reviewsitefullstack;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewSitePopulator implements CommandLineRunner {

	    @Resource
	    private ReviewRepository reviewRepo;
	    
	    @Resource
	    private CategoryRepository categoryRepo;
	    
	    @Resource
	    private TagRepository tagRepo;
	    
	    @Override
	    public void run(String... args) throws Exception {
	    	
	    	 Tag hot = new Tag("Hot"); 
	    	 hot = tagRepo.save(hot); 
	    	 Tag cold = new Tag("Cold"); 
	    	 cold = tagRepo.save(cold); 
	    	 Tag nonAlcoholic = new Tag("Non-alcoholic"); 
	    	 nonAlcoholic = tagRepo.save(nonAlcoholic); 
	    	 Tag alcoholic = new Tag("Alcoholic"); 
	    	 alcoholic = tagRepo.save(alcoholic); 
	    	 
	    	 Category coffee = new Category("Coffee"); 
	    	 coffee = categoryRepo.save(coffee); 
	    	 Category beer = new Category ("Beer"); 
	    	 beer = categoryRepo.save(beer); 
	    	 Category tea = new Category("Tea"); 
	    	 tea = categoryRepo.save(tea); 
	    	 Category wine = new Category("Wine"); 
	    	 wine = categoryRepo.save(wine); 
	    	 
	    	 reviewRepo.save(new Review("Dunkin Donuts", "Great value, for the great price!", "/images/dunkin.jpg", coffee, hot, cold, nonAlcoholic));
	    	 reviewRepo.save(new Review("Starbucks", "I will pay the extra for the greatest pumpkin spice latte!", "/images/starbucks.jpg", coffee, hot, cold, nonAlcoholic)); 
	    	 reviewRepo.save(new Review("Budweiser", "AMERICA!!", "/images/bud.jpg", beer, cold, alcoholic)); 
	    	 reviewRepo.save(new Review("Miller Lite", "Smooth, crisp, refreshing!", "/images/miller.jpg", beer, cold, alcoholic));
	    	 reviewRepo.save(new Review("Tazo Green Tea", "Great for weight loss and great replacement for coffee to give you energy!", "/images/tazo.jpg", tea, hot, cold, nonAlcoholic)); 
	    	 reviewRepo.save(new Review("Lipton", "A little sweet, but very refreshing!", "/images/lipton.jpg", tea, hot, cold, nonAlcoholic)); 
	    	 reviewRepo.save(new Review("Saviogn blanc", "One glass a day keeps the doctor away!", "/images/white.jpg", wine, cold, alcoholic)); 
	    	 reviewRepo.save(new Review("Cabernet", "Perfect paired with a steak or desert", "/images/red.jpg", wine, cold, alcoholic)); 
	    	 
	    
	    }
}
