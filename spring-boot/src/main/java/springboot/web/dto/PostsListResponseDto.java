package springboot.web.dto;

import springboot.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto {
    private Long id;
    private String title;
    private LocalDateTime modifiedDate;
    private String author;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.modifiedDate = entity.getModifiedDate();
        this.author = entity.getAuthor();
    }
}
