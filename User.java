import java.util.HashMap;

public class User {
    String user_name;
    int number_of_reviews_given;
    String user_type;
    HashMap<String,Integer> user_rating=new HashMap<>();
    User(String user_name){
        this.user_name=user_name;
        this.number_of_reviews_given=0;
        this.user_type="Viewer";
    }
    public void add_review(String user_name,String movie_name,int rating) {
        if(user_rating.containsKey(movie_name)){
            System.out.println("Alert rating entered for this movie");
            return;
        }
        else{
            if(user_type.equals("Critic")){
                user_rating.put(movie_name,rating*2);
                this.number_of_reviews_given++;
                System.out.println("critic entered the rating");
            }
            else{
                user_rating.put(movie_name,rating);
                this.number_of_reviews_given++;
                System.out.println("Viewer entred the rating");
            }
        }
        if(this.number_of_reviews_given>=3){
            this.user_type="Critic";
            System.out.println("USer has upgraded");
        }
    }
}
