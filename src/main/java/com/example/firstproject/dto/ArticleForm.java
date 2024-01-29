package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor // 클래스 안쪽의 모든 필드를 매개변수로 하는 생성자 자동생성.
@NoArgsConstructor
@Setter
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

//    @AllArgsConstructor 대체됨.
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }


//    @ToString 대체됨.
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
