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

	@Mock
	private Review review;

	@Test // also tag and category
	public void shouldRouteToSingleReviewView() throws Exception {
		long reviewId = 1;
		when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("reviewTemplate")));
	}
}

// @Test
// public void shouldRouteToSingleCategoryView() throws Exception {
// long reviewId = 1;
// when(reviewRepo.findById(reviewId)).thenReturn(Optional.of(review));
// mvc.perform(get("/review?id=1")).andExpect(view().name(is("reviewTemplate")));
//
// @Test // also tag and category
// public void shouldRouteToAllReviewView() throws Exception {
//
// }
//
// @Test // also tag and category
// public void shouldBeOkforSingleReview() throws Exception {
//
// }
//
// @Test // also tag and category
// public void shouldBeOkForAllReview() throws Exception {
// }
// }
