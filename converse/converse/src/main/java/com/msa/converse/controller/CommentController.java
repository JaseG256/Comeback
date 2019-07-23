package com.msa.converse.controller;

import com.msa.converse.model.Comment;
import com.msa.converse.model.User;
import com.msa.converse.repository.CommentRepository;
import com.msa.converse.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    @Qualifier("commentServicer")
    private CommentService commentService;

    @GetMapping(path = "/comments")
    public List<Comment> findAll(){
        return commentService.listAll();
    }

    @PostMapping("/newComment")
    public Comment newComment(@RequestBody Comment comment) { return commentService.saveOrUpdate(comment);}
}
