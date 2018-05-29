package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts();
    }

    @Test
    public void NewPostObjectGetsCreated_true() throws Exception {
        Post myPost = setUpNewPost();
        assertEquals(true, myPost instanceof Post);
    }

    @Test
    public void getContent_PostInstantiateswithContent_true() {
        Post myPost = setUpNewPost();
        assertEquals("Day 1: Intro", myPost.getContent());
    }

    @Test
    public void getAll_AllPostsAreCorrectlyReturned_true() {
        Post myPost = setUpNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void getAll_AllPostsContainsAllPosts_true() {
        Post myPost = setUpNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertTrue(Post.getAll().contains(myPost));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Post myPost = setUpNewPost();
        assertEquals(false, myPost.getPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Post myPost = setUpNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myPost.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() {
        Post myPost = setUpNewPost();
        assertEquals(1, myPost.getId());

    }

    @Test
    public void findReturnsCorrectPost() {
        Post post = setUpNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() {
        Post post = setUpNewPost();
        Post otherPost = setUpNewPost();
        assertEquals(2, Post.findById(otherPost.getId()).getId());
    }

    public Post setUpNewPost() {
        return new Post("Day 1: Intro");
    }
}