package pl.sda.springdemo.video;

import java.util.Arrays;
import java.util.List;

public class VideoService {

    final static List<String> VALID_CATEGORIES = Arrays.asList(
        "Action", "Horror", "Thriller", "XXX", "Adventure"
    );

    public void edit(Video current, String title, String category, int rating) {
        validateTitle(title);
        validateCategory(category);
        validateRating(rating);

        current.setTitle(title);
        current.setCategory(category);
        current.setRating(rating);
    }

    private void validateRating(int rating) {
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("Invalid rating value");
        }
    }

    private void validateCategory(String category) {
        if(!VALID_CATEGORIES.contains(category)){
            throw new IllegalArgumentException("Invalid category name");
        }
    }

    private void validateTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title can't be empty");
        }
    }
}
