package edu.escuelaing.arep.entities;

import java.time.LocalDate;

/**
 * Class that represents a post.
 * @author Camilo Pichimata - Zuly Vargas
 */
public class Post {
    LocalDate datePublication;
    String content;
    User author;

    /**
     * Creates a post.
     * @param content
     * @param author
     */
    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.datePublication = LocalDate.now();
    }

}

