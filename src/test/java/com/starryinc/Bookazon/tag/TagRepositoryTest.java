package com.starryinc.Bookazon.tag;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagRepositoryTest {
    private final TagRepository tagRepository;

    @Autowired
    public TagRepositoryTest(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Test
    public void addTag() {
        Tag tag = new Tag("machine learning");
        Tag t = tagRepository.save(tag);
        System.out.println(t);
    }
}