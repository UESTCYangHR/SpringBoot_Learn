package net.peter.ssm.service.impl;
/*
 * @Author: Haoran
 * @Date: 2021/3/13 9:51
 * @Description:
 */

import net.peter.ssm.dao.UserMapper;
import net.peter.ssm.dao.VideoMapper;
import net.peter.ssm.dao.VideoOrderMapper;
import net.peter.ssm.model.entity.Video;
import net.peter.ssm.model.entity.VideoOrder;
import net.peter.ssm.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    /**
     * 下单操作
     * 未来可能会有优惠券等等其他的功能
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int save(int userId, int videoId) {

        // 判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.
                findByUserIdAndVideoIdAndState(userId, videoId, 1);

        if (videoOrder != null){
            return 0;
        }

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();

        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);

        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        return videoOrderMapper.saveOrder(newVideoOrder);
    }
}