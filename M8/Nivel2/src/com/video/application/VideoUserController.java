package com.video.application;

import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.view.VideoUserView;


public class VideoUserController {

    private final User userModel;
    private final Video videoModel;
    private final VideoUserView view;

    public VideoUserController(User userModel, Video videoModel, VideoUserView view) {
        this.userModel = userModel;
        this.videoModel = videoModel;
        this.view = view;
    }

    public void setVideoUrl(String url) {
        videoModel.setUrl(url);
    }
    public String getVideoUrl() {
        return videoModel.getUrl();
    }

    public void setVideoTitle(String title){
        videoModel.setTitle(title);
    }
    public String getVideoTitle() {
        return videoModel.getTitle();
    }

    public void setVideoTags(Tag tags){
        videoModel.setTags(tags);
    }
    public Tag getVideoTags() {
        return videoModel.getTags();
    }

    public void setUserName(String userName) { userModel.setName(userName); }
    public String getUserName() { return userModel.getName(); }

    public void setUserSurname(String userSurname) { userModel.setSurname(userSurname); }
    public String getUserSurname() { return userModel.getSurname(); }

    public void setUserPassword(String userPassword) { userModel.setPassword(userPassword); }
    public String getUserPassword() { return userModel.getPassword(); }

    public void showUserVideos() {

        view.listUserVideos(userModel.getMyVideos());

    }


    public void updateView() {

        view.showUser(userModel.getName(), userModel.getSurname(), userModel.getPassword(), userModel.getRegisterDate(), userModel.getMyVideos());

        view.showVideo(videoModel.getUrl(), videoModel.getTitle(), videoModel.getTags());

    }


    public void showNewVideo(Video videoModel) {

        view.showNewAddedVideo(userModel.getName(), userModel.getSurname(), userModel.getMyVideos(), videoModel.getUrl(), videoModel.getTitle(), videoModel.getTags());

    }

}