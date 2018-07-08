package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private ReviewRepository reviewRepo;

	@MockBean
	private CategoryRepository categoryRepo;

	@MockBean
	private TagRepository tagRepo;

	@Mock
	private Review review;

	@Mock
	private Category category;

	@Mock
	private Category category2;

	@Mock
	private Tag tag;

	@Mock
	private Tag tag2;

	@Test
	public void shouldRouteToSingleReviewView() throws Exception {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("reviewTemplate")));
	}

	@Test
	public void shouldRouteToSingleCategoryView() throws Exception {
		long categoryId = 1;
		when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category));
		mvc.perform(get("/category?id=1")).andExpect(view().name(is("categoryTemplate")));

	}

	@Test
	public void shouldRouteToSingleTagView() throws Exception {
		long tagId = 1;
		when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag));
		mvc.perform(get("/tag?id=1")).andExpect(view().name(is("tagTemplate")));

	}

	@Test
	public void shouldRouteToAllReviewView() throws Exception {
		mvc.perform(get("/reviews")).andExpect(view().name(is("reviewsTemplate")));

	}

	@Test
	public void shouldRouteToAllCategoryView() throws Exception {
		mvc.perform(get("/categories")).andExpect(view().name(is("categoriesTemplate")));
	}

	@Test
	public void shouldRouteToAllTagView() throws Exception {
		mvc.perform(get("/tags")).andExpect(view().name(is("tagsTemplate")));
	}

	@Test
	public void shouldBeOkforSingleReview() throws Exception {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}

	@Test 
	public void shouldBeOkForSingleCategory() throws Exception{
	long categoryId = 1;
	when(categoryRepo.findById(categoryId)).thenReturn(Optional.of(category)); 
	mvc.perform(get("/category?id=1")).andExpect(status().isOk());
}
	@Test
	public void shouldBeOkForSingleTag() throws Exception{
		long tagId = 1; 
		when(tagRepo.findById(tagId)).thenReturn(Optional.of(tag)); 
		mvc.perform(get("/tag?id=1")).andExpect(status().isOk());
	}

 @Test 
 public void shouldBeOkForAllReviews() throws Exception {
		mvc.perform(get("/reviews")).andExpect(status().isOk());
 }
 
 @Test 
 public void shouldBeOkForAllCategories() throws Exception {
		mvc.perform(get("/categories")).andExpect(status().isOk());
 }
 
 @Test
 public void shouldBeOkForAllTags() throws Exception {
		mvc.perform(get("/tags")).andExpect(status().isOk());
 }
 }
