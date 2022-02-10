package service.impl;

import model.Comment;
import model.Entity;
import service.StorageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageServiceImpl implements StorageService {

    private Map<String, Comment> commentStorage;
    private Map<String, Entity> entityStorage;
    private Map<String, List<Comment>> entityCommentStorage;

    public StorageServiceImpl() {
        commentStorage = new HashMap<>();
        entityStorage = new HashMap<>();
        entityCommentStorage = new HashMap<>();
    }

    @Override
    public Entity getEntity(String entityId) {
        if (entityStorage.containsKey(entityId)) {
            return entityStorage.get(entityId);
        }
        return null;
    }

    @Override
    public Entity createEntity(Entity entity) {
        entityStorage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Comment> getAllComments(String entityId) {
        return null;
    }

    @Override
    public Comment getComment(String commentId) {
        if (commentStorage.containsKey(commentId)) {
            return commentStorage.get(commentId);
        }
        return null;
    }

    @Override
    public Comment createComment(Comment comment) {
        String entityId = comment.getEntityId();
        commentStorage.put(comment.getId(), comment);
        if (entityCommentStorage.containsKey(entityId)) {
            List<Comment> commentList = entityCommentStorage.get(entityId);
            commentList.add(comment);
            entityCommentStorage.put(entityId, commentList);
        } else {
            List<Comment> newList = new ArrayList<>();
            newList.add(comment);
            entityCommentStorage.put(entityId, newList);
        }
        return comment;
    }

    @Override
    public int updateComment(Comment commentId) {
        return 0;
    }
}
