import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Post;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: show new post form
        get("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newpost-form.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all posts
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Post> posts = Post.getAll();
            model.put("posts", posts);
            return new ModelAndView(model, "index2.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new post form
        post("/posts/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String content = request.queryParams("content");
            Post newPost = new Post(content);
            model.put("post", newPost);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual post
        get("/posts/:id", (req, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params("id"));
            Post foundPost = Post.findById(idOfPostToFind);
            model.put("post", foundPost);
            return new ModelAndView(model, "post-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a post

        //get: process a form to update a post

        //get: delete an individual post

        //get: delete all posts
    }
}
