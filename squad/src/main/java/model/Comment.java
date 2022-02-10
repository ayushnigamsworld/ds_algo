package model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {

    private String id; // PK
    private String entityId;  // FK -- Clustered-Index
    private String parentCommentId;

    private Content content;

    private Person createdBy;
    private LocalDateTime createdAt;
    private Person updatedBy;
    private LocalDateTime updatedAt;
    private Boolean active;
}
