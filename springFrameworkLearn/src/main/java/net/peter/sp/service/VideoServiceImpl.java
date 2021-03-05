package net.peter.sp.service;
/*
 * @Author: Haoran
 * @Date: 2021/3/4 9:30
 * @Description:
 */

import net.peter.sp.dao.VideoDao;
import net.peter.sp.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("videoService")
@Service("videoService")
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoDao videoDao;

    @Override
    public int save(Video video) {
        System.out.println("保存video");
        return 1;
    }

    @Override
    public Video findById(int id) {
        System.out.println("根据id查询视频");
        videoDao.test();
        return new Video();
    }
}