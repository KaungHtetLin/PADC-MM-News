package net.kaunghtetlin.sfc.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kaung Htet Lin on 12/2/2017.
 */

public class NewsVO {

    @SerializedName("news-id")
    private String newsId;

    @SerializedName("brief")
    private String brief;

    @SerializedName("details")
    private String details;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;

    @SerializedName("publication")
    private PublicationVO publication;

    @SerializedName("favorites")
    private List<FavoriteActionVO> favoriteActions;

    @SerializedName("comments")
    private List<CommentVO> commentActions;

    @SerializedName("sent-tos")
    private List<SentTosVO> sentToActions;

}
