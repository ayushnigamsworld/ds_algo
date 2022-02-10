package service;

import model.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getAllComments(String entityId);
    public Comment getComment(String commentId);
    public Comment createComment(String entityId, Comment comment);
    public int updateComment(Comment comment);
}
