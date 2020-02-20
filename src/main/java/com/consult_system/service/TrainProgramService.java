package com.consult_system.service;

import com.consult_system.entity.TrainProgram;
import com.consult_system.repo.TrainProgramRepo;
import com.consult_system.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class TrainProgramService {

    @Autowired
    private TrainProgramRepo trainProgramRepo;

    /**
     * 培养方案页面初始化数据获取
     * @return
     */
    public List<TrainProgram> trainProgramPageInit() {
        return trainProgramRepo.trainProgramPageInit();
    }

    /**
     * 后台 --培养方案增加
     * @param jsonData
     */
    public void trainProgramAdd(String jsonData){
        Map<String,Object> map = JSONUtils.toMap(jsonData);
        TrainProgram trainProgram = new TrainProgram();
        trainProgram.setGradeId(Integer.valueOf(map.get("gradeId").toString()));
        trainProgram.setTrainGoal(map.get("trainGoal").toString());
        trainProgram.setTrainGoalIntroduce(map.get("trainGoalIntroduce").toString());
        trainProgram.setTrainGoalDetail(map.get("trainGoalDetail").toString());
        trainProgram.setTrainSpecial(map.get("trainSpecial").toString());
        trainProgram.setTrainSpecialIntroduce(map.get("trainSpecialIntroduce").toString());
        trainProgram.setMainCourse(map.get("mainCourse").toString());
        trainProgram.setMainCourseIntroduce(map.get("mainCourseIntroduce").toString());
        trainProgram.setEducationalSystem(map.get("educationalSystem").toString());
        trainProgram.setEducationalSystemDetail(map.get("educationalSystemDetail").toString());
        trainProgram.setCreditRequirment(map.get("creditRequirment").toString());
        trainProgram.setCreditRequirementIntroduce(map.get("creditRequirementIntroduce").toString());
        trainProgram.setCreditRequirementDetail(map.get("creditRequirementDetail").toString());
        trainProgram.setConferDegree(map.get("conferDegree").toString());
        trainProgram.setConferDegreeIntroduce(map.get("conferDegreeIntroduce").toString());
        trainProgramRepo.save(trainProgram);
    }

    /**
     * 后台 -- 删除
     *
     * @return
     */
    public String trainProgramDelete(Integer id){
        TrainProgram trainProgram = trainProgramRepo.findTrainProgramById(id);
        if (StringUtils.isEmpty(trainProgram)){
            return "err";
        }else {
            trainProgram.setIsDeleted(1);
            trainProgramRepo.save(trainProgram);
        }
        return "yes";
    }

    /**
     * 后台 -- 培养方案修改
     * @param id
     * @param jsonData
     * @return
     */
    public void trainProgramAlter(Integer id,String jsonData){
        TrainProgram trainProgram = trainProgramRepo.findTrainProgramById(id);
        Map<String,Object> map = JSONUtils.toMap(jsonData);
        if (!StringUtils.isEmpty(trainProgram)){
            trainProgram.setGradeId(Integer.valueOf(map.get("gradeId").toString()));
            trainProgram.setTrainGoal(map.get("trainGoal").toString());
            trainProgram.setTrainGoalIntroduce(map.get("trainGoalIntroduce").toString());
            trainProgram.setTrainGoalDetail(map.get("trainGoalDetail").toString());
            trainProgram.setTrainSpecial(map.get("trainSpecial").toString());
            trainProgram.setTrainSpecialIntroduce(map.get("trainSpecialIntroduce").toString());
            trainProgram.setMainCourse(map.get("mainCourse").toString());
            trainProgram.setMainCourseIntroduce(map.get("mainCourseIntroduce").toString());
            trainProgram.setEducationalSystem(map.get("educationalSystem").toString());
            trainProgram.setEducationalSystemDetail(map.get("educationalSystemDetail").toString());
            trainProgram.setCreditRequirment(map.get("creditRequirment").toString());
            trainProgram.setCreditRequirementIntroduce(map.get("creditRequirementIntroduce").toString());
            trainProgram.setCreditRequirementDetail(map.get("creditRequirementDetail").toString());
            trainProgram.setConferDegree(map.get("conferDegree").toString());
            trainProgram.setConferDegreeIntroduce(map.get("conferDegreeIntroduce").toString());
            trainProgramRepo.save(trainProgram);
        }
    }

    /**
     * 根据id查询单个培养方案
     * @param id
     * @return
     */
    public TrainProgram findTrainProgramById(Integer id){
        return trainProgramRepo.findTrainProgramById(id);
    }

    /**
     * 根据年级查询培养方案
     * @param grade
     * @return
     */
    public TrainProgram findTrainProgramByGrade(Integer grade){
        return trainProgramRepo.findTrainProgramByGrade(grade);
    }
}
