package com.consult_system.service;

import com.consult_system.entity.Video;
import com.consult_system.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VideoService {
    @Autowired
    private VideoRepo videoRepo;

    /**
     * 插入信息
     *
     * @param videoUrl
     * @param fileName
     * @param fileOperate
     * @return
     */
    public String videoInsert(String videoUrl, String fileName, String fileOperate) {
        Video video = new Video();
        video.setFileName(fileName);
        video.setFileOperate(fileOperate);
        video.setVideoUrl(videoUrl);
        video.setCreateTime(new Date());
        video.setUpdateTime(new Date());
        videoRepo.save(video);
        return "成功";

    }

    /**
     * 更新信息
     *
     * @param videoUrl
     * @param fileName
     * @param fileOperate
     * @param id
     * @return
     */
    public String videoUpdate(String videoUrl, String fileName, String fileOperate, Integer id) {
        Video video = videoRepo.findOneByKeyId(id);
        if (null != video) {
            video.setFileName(fileName);
            video.setFileOperate(fileOperate);
            video.setVideoUrl(videoUrl);
            video.setUpdateTime(new Date());
            videoRepo.save(video);
            return "成功";
        }
        return "失败";
    }

    /**
     * 查询视频列表
     *
     * @return
     */
    public List<Map<String, Object>> videoList() {
        List<Video> list = videoRepo.findList();
        List<Map<String, Object>> resultList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Video video : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("videoUrl", video.getVideoUrl());
            map.put("fileName", video.getFileName());
            map.put("updateTime", simpleDateFormat.format(video.getUpdateTime()));
            resultList.add(map);
        }
        return resultList;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Video getOneById(Integer id) {
        return videoRepo.findOneByKeyId(id);
    }
}
