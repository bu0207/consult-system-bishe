package com.consult_system.service;

import com.consult_system.entity.Image;
import com.consult_system.repo.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ImageService {
    @Autowired
    private ImageRepo imageRepo;

    public boolean saveImage(String url){
        Image image = new Image();
        image.setImageUrl(url);
        image.setCreateTime(new Date());
        image.setUpdateTime(new Date());
        imageRepo.save(image);
        return true;
    }
}
