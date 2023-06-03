import java.util.ArrayList;
import java.util.List;

public class Wall {
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public void displayPosts() {
        for(Post post : posts) {
            System.out.println(post.toString());
            System.out.println("-----");
        }
    }
}
