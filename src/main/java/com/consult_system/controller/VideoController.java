package com.consult_system.controller;

import com.consult_system.service.VideoService;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 插入视频信息
     *
     * @param videoUrl
     * @param fileName
     * @param fileOperate
     * @return
     */
    @RequestMapping(value = "/video/insert", method = RequestMethod.POST)
    public ApiResult videoInsert(String videoUrl, String fileName, String fileOperate) {
        return ApiResult.ok(videoService.videoInsert(videoUrl, fileName, fileOperate));
    }

    /**
     * 更新视频信息
     *
     * @param videoUrl
     * @param fileName
     * @param fileOperate
     * @param id
     * @return
     */
    @RequestMapping(value = "/video/update", method = RequestMethod.POST)
    public ApiResult videoUpdate(String videoUrl, String fileName, String fileOperate, Integer id) {
        return ApiResult.ok(videoService.videoUpdate(videoUrl, fileName, fileOperate, id));
    }

    /**
     * 查询视频列表
     *
     * @return
     */
    @RequestMapping(value = "/video/list", method = RequestMethod.POST)
    public ApiResult videoList() {
        return ApiResult.ok(videoService.videoList());
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/video/getById", method = RequestMethod.POST)
    public ApiResult videoList(Integer id) {
        return ApiResult.ok(videoService.getOneById(id));
    }
}
