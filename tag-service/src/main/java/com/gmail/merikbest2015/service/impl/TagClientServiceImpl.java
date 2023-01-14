package com.gmail.merikbest2015.service.impl;

import com.gmail.merikbest2015.model.Tag;
import com.gmail.merikbest2015.model.TweetTag;
import com.gmail.merikbest2015.repository.TagRepository;
import com.gmail.merikbest2015.repository.TweetTagRepository;
import com.gmail.merikbest2015.service.TagClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class TagClientServiceImpl implements TagClientService {

    private final TagRepository tagRepository;
    private final TweetTagRepository tweetTagRepository;

    @Override
    @Transactional
    public void parseHashtagsInText(String text, Long tweetId) {
        Pattern pattern = Pattern.compile("(#\\w+)\\b");
        Matcher match = pattern.matcher(text);
        List<String> hashtags = new ArrayList<>();

        while (match.find()) {
            hashtags.add(match.group(1));
        }

        if (!hashtags.isEmpty()) {
            hashtags.forEach(hashtag -> {
                Tag tag = tagRepository.findByTagName(hashtag);

                if (tag != null) {
                    TweetTag tweetTag = new TweetTag(tag.getId(), tweetId);
                    tweetTagRepository.save(tweetTag);
                    tagRepository.updateTagQuantity(tag.getId(), true);
                } else {
                    Tag newTag = new Tag(hashtag, 1L);
                    tagRepository.save(newTag);
                }
            });
        }
    }

    @Override
    @Transactional
    public void deleteTagsByTweetId(Long tweetId) {
        List<Long> tagsIds = tweetTagRepository.getTagIdsByTweetId(tweetId);
        List<Tag> tags = tagRepository.getTagsBuIds(tagsIds);
        tags.forEach(tag -> {
            if (tag.getTweetsQuantity() - 1 == 0) {
                tagRepository.delete(tag);
                tweetTagRepository.deleteTag(tag.getId());
            } else {
                tagRepository.updateTagQuantity(tag.getId(), false);
            }
        });
    }
}
