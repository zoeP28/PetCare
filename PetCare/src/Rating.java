public class Rating {

    private int score;
    private String comment;

    public Rating(int score, String comment) {
        this.score = score;
        this.comment = comment;
    }

    public int getScore() {
        return this.score;
    }

    public String getComment() {
        return this.comment;
    }
}