package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String content;
    private static ArrayList<Post> instances = new ArrayList<Post>();
    private boolean published;
    private int id;
    private LocalDateTime createdAt;

    public Post(String content) {
        this.content = content;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();

    }

    public String getContent() {
        return content;
    }

    public static ArrayList<Post> getAll(){
        return instances;
    }

    public static void clearAllPosts() {
        instances.clear();
    }

    public boolean getPublished() {
        return this.published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public static Post findById(int id) {
        return instances.get(id-1);
    }
}
