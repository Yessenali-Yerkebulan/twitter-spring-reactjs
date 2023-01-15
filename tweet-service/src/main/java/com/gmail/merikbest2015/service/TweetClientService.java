package com.gmail.merikbest2015.service;

import com.gmail.merikbest2015.client.tweet.TweetPageableRequest;
import com.gmail.merikbest2015.client.tweet.TweetUserIdsRequest;
import com.gmail.merikbest2015.commons.models.Tweet;
import com.gmail.merikbest2015.commons.projection.TweetImageProjection;
import com.gmail.merikbest2015.commons.projection.TweetProjection;
import com.gmail.merikbest2015.commons.projection.TweetsUserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TweetClientService {

    Optional<Tweet> getTweetById(Long userId);

    List<TweetsUserProjection> getTweetsByUserId(Long userId);

    Optional<TweetsUserProjection> getPinnedTweetByUserId(Long userId);

    Page<TweetProjection> getAllUserMediaTweets(TweetPageableRequest request);

    Page<TweetProjection> getUserMentions(TweetPageableRequest request);

    List<TweetImageProjection> getUserTweetImages(TweetPageableRequest request);

    List<TweetsUserProjection> getRepliesByUserId(Long userId);

    List<TweetProjection> getNotificationsFromTweetAuthors(Long userId);

    List<TweetProjection> getTweetsByIds(List<Long> tweetIds);

    Page<TweetProjection> getTweetsByUserIds(TweetUserIdsRequest request, Pageable pageable);
}