package service;

import model.Comment;
import model.Entity;

import java.util.List;

public interface StorageService {
    public Entity getEntity(String entityId);
    public Entity createEntity(Entity entity);
    public List<Comment> getAllComments(String entityId);
    public Comment getComment(String commentId);
    public Comment createComment(Comment comment);
    public int updateComment(Comment commentId);
}
