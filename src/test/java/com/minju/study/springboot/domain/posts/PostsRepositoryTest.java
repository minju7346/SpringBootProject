package com.minju.study.springboot.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 논문";

        postsRepository.save(Posts.builder().title(title).content(content).author("minju@gmail.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.of(2022,2,8,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>creteDate="+posts.getCretedDate()+",modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCretedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
