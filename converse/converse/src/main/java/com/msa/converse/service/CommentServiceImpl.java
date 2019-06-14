package com.msa.converse.service;

import com.msa.converse.model.Comment;
import com.msa.converse.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "commentServicer")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> listAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findBySentTo(String sentTo) {
        return commentRepository.findBySentTo(sentTo);
    }

    @Override
    public List<Comment> findByTextContains(String text) {
        return commentRepository.findByTextContains(text);
    }
}
