package com.example.JakSim.trainer.model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TrainerCreateService {
    @Autowired
    private DataSource ds;
    private int ut_idx;

    public void insertTrainerDo(String userId, String insta, String intro, String gym){
        TrainerDo trainerDo = new TrainerDo();
        TrainerDao trainerDao = new TrainerDao(ds);

        if(insta.equals(""))
            insta = "-";

        trainerDo.setUserId(userId);
        trainerDo.setInsta(insta);
        trainerDo.setIntroduce(intro);
        trainerDo.setGym(gym);

        trainerDao.insertTrainerDo(trainerDo);
    }

    public void insertExpert(String userId, int expert1, int expert2){
        TrainerDao trainerDao = new TrainerDao(ds);
        int idx = trainerDao.getTrainerByUserId(userId).getId();
        System.out.println("expert ut_IDx: " + idx);
        List<Integer> experts = new ArrayList<>();
        experts.add(expert1);
        experts.add(expert2);

        for(int expert : experts){
            if(expert1 == 7 || expert2 == 7)
                continue;
            trainerDao.insertTrainerExpert(idx, expert);
        }
    }

    public void insertCert(String userId, String cert){
        TrainerDao trainerDao = new TrainerDao(ds);
        int idx = trainerDao.getTrainerByUserId(userId).getId();
        String[] certList = cert.split("/");
        for(String item : certList)
            trainerDao.insertCert(idx, item);
    }

    public void insertCareer(String userId, String career){
        TrainerDao trainerDao = new TrainerDao(ds);
        int idx = trainerDao.getTrainerByUserId(userId).getId();

        String[] careerList = career.split("/");
        for(String item: careerList) {
            System.out.println(item);
            String[] Do = item.split(" ");
            trainerDao.insertCareer(idx, Do[0], Do[1]);
        }
    }

    public void insertPt(String userId, String pt){
        TrainerDao trainerDao = new TrainerDao(ds);
        int idx = trainerDao.getTrainerByUserId(userId).getId();
        int type = 0;
        String[] ptList = pt.split("/");
        for(String item : ptList) {
            System.out.println(item);
            String[] Do = item.split(" ");
            if(Do[0].equals("단체"))
                type = 0;
            //Do[1] -> month, Do[2] -> times Do[3] -> price
            trainerDao.insertPt(idx, type, Integer.parseInt(Do[1]), Integer.parseInt(Do[2]), Integer.parseInt(Do[3]));
        }
    }

    public void insertImages(String userId, List<MultipartFile> fileList) throws IOException {
        TrainerDao trainerDao = new TrainerDao(ds);
        int idx = trainerDao.getTrainerByUserId(userId).getId();

        for(MultipartFile file : fileList){
            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/trainer";
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_"+ file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);
            file.transferTo(saveFile);

            trainerDao.insertTrainerImages(idx, "/files/trainer/" + fileName);
        }
    }

    public TrainerImageDo getImage(String userId){
        TrainerImageDo imageDo = new TrainerImageDo();
        TrainerDao trainerDao = new TrainerDao(ds);

        List<TrainerImageDo> imageList = trainerDao.getTrainerImage(trainerDao.getTrainerByUserId(userId).getId());
        imageDo = imageList.get(0);

        return imageDo;
    }

    public int getTrainerId(String userId){
        TrainerDao trainerDao = new TrainerDao(ds);
        this.ut_idx = trainerDao.getTrainerByUserId(userId).getId();
        return this.ut_idx;
    }

    public void updateTrainerDo(String username, String insta, String intro, String gym) {
        System.out.println("updateTrainerDo");
        TrainerDao trainerDao = new TrainerDao(ds);
        TrainerDo trainerDo = new TrainerDo();
        trainerDo.setId(this.ut_idx);
        trainerDo.setUserId(username);
        trainerDo.setInsta(insta);
        trainerDo.setIntroduce(intro);
        trainerDo.setGym(gym);
        trainerDao.updateTrainerDo(trainerDo);
    }

    public void updateExpert(int expert1, int expert2) {
        TrainerDao trainerDao = new TrainerDao(ds);
        List<Integer> experts = new ArrayList<>();
        experts.add(expert1);
        experts.add(expert2);

        for(int expert : experts){
            if(expert1 == 7 || expert2 == 7)
                continue;
            trainerDao.updateTrainerExpert(this.ut_idx, expert);
        }
    }

    public void updateCareer(String career) {
        TrainerDao trainerDao = new TrainerDao(ds);

        String[] careerList = career.split("/");
        for(String item: careerList) {
            System.out.println(item);
            String[] Do = item.split(" ");
            trainerDao.updateCareer(this.ut_idx, Do[0], Do[1]);
        }
    }

    public void updateCert(String cert) {
        TrainerDao trainerDao = new TrainerDao(ds);
        String[] certList = cert.split("/");
        for(String item : certList)
            trainerDao.updateCert(this.ut_idx, item);
    }

    public void updatePt(String pt) {
        TrainerDao trainerDao = new TrainerDao(ds);
        int type = 0;
        String[] ptList = pt.split("/");
        for(String item : ptList) {
            System.out.println(item);
            String[] Do = item.split(" ");
            if(Do[0].equals("단체"))
                type = 0;
            //Do[1] -> month, Do[2] -> times Do[3] -> price
            trainerDao.updatePt(this.ut_idx, type, Integer.parseInt(Do[1]), Integer.parseInt(Do[2]), Integer.parseInt(Do[3]));
        }
    }

    public void updateImages(List<MultipartFile> fileList) throws IOException {
        TrainerDao trainerDao = new TrainerDao(ds);

        for(MultipartFile file : fileList){
            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/trainer";
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_"+ file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);
            file.transferTo(saveFile);

            trainerDao.updateTrainerImages(this.ut_idx, "/files/trainer/" + fileName);
        }
    }
}
