package com.rakuten.training.service;
import java.util.List;

import com.rakuten.training.domain.Review;

public interface ReviewService {

	public int addReviewToProduct(int productId, Review toBeSaved);
	public List <Review> getByProductId(int id);
	
}
