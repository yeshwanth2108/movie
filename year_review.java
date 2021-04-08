public class year_review {
    int year,count,total;
    double review;
    year_review(int year){
        this.year=year;
        this.count=0;
        this.total=0;
        this.review=0.0;
    }
    public void y_review(int rating){
        this.count++;
        this.total=this.total+rating;
        this.review=(double)(this.total)/this.count;
    }

}
