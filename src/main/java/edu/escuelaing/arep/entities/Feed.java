package edu.escuelaing.arep.entities;

import java.util.ArrayList;

public class Feed {

    ArrayList<Post> posts = new ArrayList<Post>();

    /**
     * Creates a new feed.
     * @param posts - Posts list.
     */
    public Feed(ArrayList<Post> posts) {
        this.posts = posts;
    }

    /**
     * Add a new post.
     * @param post - new post to add.
     */
    public void addNewPost(Post post){
        posts.add(post);
    }

}
