import java.util.ArrayList;

public class Genre {
    String genre_type;
    int count;
    int total;
    double review;
    ArrayList<String> movie_list;
    Genre(String genre_type){
        this.genre_type=genre_type;
        this.count=0;
        this.total=0;
        this.review=0.0;
        this.movie_list=new ArrayList<>();
    }
    public void add_movie(String movie) {
        movie_list.add(movie);
    }
    public void add_rating(int rating) {
        this.total=this.total+rating;
        this.count++;
        this.review=(double)(this.total)/this.count;
    }
    public double getreview(){
        return this.review;
    }

}
