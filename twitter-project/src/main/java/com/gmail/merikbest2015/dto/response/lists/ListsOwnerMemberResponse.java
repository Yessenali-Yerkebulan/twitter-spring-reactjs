package com.gmail.merikbest2015.dto.response.lists;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gmail.merikbest2015.dto.response.ImageResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListsOwnerMemberResponse {
    private Long id;
    private String fullName;
    private String username;
    private String about;
    private ImageResponse avatar;

    @JsonProperty("isMemberInList")
    private boolean isMemberInList;

    @JsonProperty("isPrivateProfile")
    private boolean privateProfile;
}