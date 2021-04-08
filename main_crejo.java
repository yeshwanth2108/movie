import java.util.*;
import java.lang.*;

public class main_crejo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //user class details
        HashMap<String,User> user_details=new HashMap<>();
        //movie class
        HashMap<String,Movie> movie_details=new HashMap<>();
        //genre class
        HashMap<String,Genre> genre_details=new HashMap<>();
        //year class
        HashMap<Integer,year_review> year_details=new HashMap<>();
        //list of movies
        ArrayList<String> movies_list=new ArrayList<>();
        //list of years
        ArrayList<Integer> year=new ArrayList<>();
        //start of movie creation
        System.out.println("enter number of movies");
        int movies_count=sc.nextInt();
        String buffer=sc.nextLine();
        //creating a hashmap to store movie class based on movie name
        for(int i=0;i<movies_count;i++)
        {
            String movie_data=sc.nextLine();
            String movie_result[]=movie_data.split(" ");
            String movie_name=movie_result[0].substring(1,movie_result[0].length()-1);
            movies_list.add(movie_name);
            ArrayList<String> movie_genre=new ArrayList<>();
            for(int j=movie_result.length-1;j>=0;j--){
                //System.out.println(movie_result[j]);
                if(movie_result[j].equals("Genres")||movie_result[j].equals("Genre")){
                    break;
                }
                else if(movie_result[j].equals("&")){
                    continue;
                }
                else{
                    String temp_genre=movie_result[j].substring(1,movie_result[j].length()-1);
                    movie_genre.add(temp_genre);
                    if(!genre_details.containsKey(temp_genre)){
                        genre_details.put(temp_genre,new Genre(temp_genre));
                    }
                    Genre temp_genre_class=genre_details.get(temp_genre);
                    temp_genre_class.add_movie(movie_name);
                    
                }
            }
            int release_year=Integer.parseInt(movie_result[4]);
            year.add(release_year);
            // System.out.println(moive_name);
            // System.out.println(movie_genre);
            // System.out.println(release_year);
            Movie new_movie=new Movie(movie_name,release_year,movie_genre);
            if(movie_details.containsKey(movie_name)){
                System.out.println("movie already registered");
            }
            else{
                movie_details.put(movie_name,new_movie);
            }
        }
        //System.out.println(movie_details);
        //end of user movie creation
        // System.out.println(movies_list);
        // System.out.println(year);

        //user creation
        System.out.println("enter number of users");
        int user_count=sc.nextInt();
        for(int i=0;i<user_count;i++){
            String user_name=sc.next();
            if(user_details.containsKey(user_name)){
                System.out.println("USER ALREADY EXISTS");
            }
            else{
                User new_user=new User(user_name);
                user_details.put(user_name, new_user);
            }
        }
        // end of user creation
        // System.out.println(user_details);

        //Start of adding review
        System.out.println("enter number of reviews");
        int review_count=sc.nextInt();
        for(int i=0;i<review_count;i++){
            String temp_username=sc.next();
            String temp_movie=sc.next();
            int temp_rating=sc.nextInt();
            Movie temp_movie_class=movie_details.get(temp_movie);
            if(user_details.containsKey(temp_username)){
                int release_year1=temp_movie_class.release_year;
                if(release_year1<=2021){
                User temp_user=user_details.get(temp_username);
                temp_user.add_review(temp_username,temp_movie,temp_rating);
                }
                else{
                    System.out.println("you cannt review for this movie ");
                }
            }
            else{
                System.out.println("User doesnot exist");
            }
            //to store review average based on movie
            temp_movie_class.review(temp_rating);

            //to  store review avarage based on year
            int temp_year=movie_details.get(temp_movie).release_year;
            if(year_details.containsKey(temp_year)){
                year_review temp_year_class=year_details.get(temp_year);
                temp_year_class.y_review(temp_rating);
            }
            else{
                year_details.put(temp_year,new year_review(temp_year));
            }

            //to store genre rating
            ArrayList<String> temp_genre_list=temp_movie_class.get_genre();
            for(int j=0;j<temp_genre_list.size();j++){
                String temp_genre=temp_genre_list.get(j);
                Genre temp_genre_class=genre_details.get(temp_genre);
                temp_genre_class.add_rating(temp_rating);
            }
        }
        //Average review based in mobiew name
        System.out.println("enter the movie name to find the average review");
        String result_name=sc.next();
        System.out.println(movie_details.get(result_name).movie_review);

        //System.out.println(movie_details.get(result_name).count);
        System.out.println("Enter the year to get average review of the year");
        int result_year=sc.nextInt();
        if(result_year<2021){
        System.out.println(year_details.get(result_year).review);}
        else{
            System.out.println("movie yet to be released");
        }
        //average rating based on genre
        System.out.println("Enter genre to get rating");
        String gnere=sc.next();
        System.out.println(genre_details.get(gnere).getreview());
    }
}
