package com.gmail.merikbest2015.dto.response;

import com.gmail.merikbest2015.dto.TweetResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TweetUserResponse extends TweetResponse { // TODO DEL
    private List<Long> retweetsUserIds;
}
