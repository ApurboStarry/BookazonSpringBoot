package com.starryinc.Bookazon.tag;

import org.springframework.stereotype.Service;

@Service
public class TagService {
    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag addTag(String tag) {
        return tagRepository.save(new Tag(tag));
    }
}
