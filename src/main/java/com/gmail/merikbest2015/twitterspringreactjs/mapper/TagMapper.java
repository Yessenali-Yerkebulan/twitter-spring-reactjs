package com.gmail.merikbest2015.twitterspringreactjs.mapper;

import com.gmail.merikbest2015.twitterspringreactjs.dto.request.TagRequest;
import com.gmail.merikbest2015.twitterspringreactjs.dto.response.TagResponse;
import com.gmail.merikbest2015.twitterspringreactjs.dto.response.TweetResponse;
import com.gmail.merikbest2015.twitterspringreactjs.model.Tag;
import com.gmail.merikbest2015.twitterspringreactjs.service.TagService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TagMapper {

    private final ModelMapper modelMapper;
    private final TagService tagService;
    private final TweetMapper tweetMapper;

    private TagResponse convertToTagResponse(Tag tag) {
        return modelMapper.map(tag, TagResponse.class);
    }

    private List<TagResponse> convertTagsListToResponseDto(List<Tag> tags) {
        return tags.stream()
                .map(this::convertToTagResponse)
                .collect(Collectors.toList());
    }

    public List<TagResponse> getTags() {
        return convertTagsListToResponseDto(tagService.getTags());
    }

    public List<TweetResponse> getTweetsByTag(String tagName) {
        return tweetMapper.convertListToResponseDto(tagService.getTweetsByTag(tagName));
    }
}