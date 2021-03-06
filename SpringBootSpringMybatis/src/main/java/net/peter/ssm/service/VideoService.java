package net.peter.ssm.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/8 10:44
 * @Description:
 */

import net.peter.ssm.model.entity.Video;
import net.peter.ssm.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
