import java.util.ArrayList;

public class Movie {
    String movie_name;
    int release_year;
    ArrayList<String> movie_genre;
    double movie_review;
    int total,count;

    Movie(String movie_name,int release_year,ArrayList<String> movie_genre){
        this.movie_name=movie_name;
        this.release_year=release_year;
        this.movie_genre=new ArrayList<>(movie_genre);
        this.movie_review=0.0;
        this.total=0;
        this.count=0;
    }
    public void review(int rating) {
        this.total=this.total+rating;
        this.count++;
        this.movie_review=(double)(this.total)/this.count;
    }
    public ArrayList<String> get_genre(){
        return this.movie_genre;
    }
}
