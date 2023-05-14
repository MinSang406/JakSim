package com.example.JakSim.trainer.model;


import com.example.JakSim.login.model.UserDao;
import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.review.model.ReviewDao;
import com.example.JakSim.review.model.ReviewDo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class TrainerListService {

    @Autowired
    private DataSource ds;

    public List<Wrapper> getAllTrainers() throws SQLException {
        TrainerDao trainerDao = new TrainerDao(ds);
        UserDao userDao = new UserDao(ds);
        int cnt = 0;

        Wrapper wrapper= null;
        List<Wrapper> wrapperList = new ArrayList<>();
        List<TrainerDo> trainerList = trainerDao.getAllTrainer();

        for(TrainerDo item : trainerList){
            wrapper = new Wrapper();

            wrapper.setUserName(userDao.findById(item.getUserId()).getUser_name());
            wrapper.setGym(item.getGym());
            wrapper.setImg(trainerDao.getTrainerImage(item.getId()).get(0).getPath());
            wrapper.setUtIdx(item.getId());

            wrapperList.add(wrapper);
        }
        for(Wrapper wrap : wrapperList)
            System.out.println(wrap.getUserName());
        wrapperList = wrapperList.subList(0,4);

        return wrapperList;
    }


    // 트레이너전체목록검색
    public List<Wrapper> getAllTrainerInfo(int ptType, int expType) throws SQLException {
//      ptType 0(전체) / 1(1:1) / 2(단체) || expType 0:바디프로필, 1: 파워리프팅 2:다이어트 3:재활운동 4:자세교정 5:컨디셔닝
        TrainerDao trainerDao = new TrainerDao(ds);
        List<TrainerDo> trainerList = trainerDao.getAllTrainer();
        List<Wrapper> wrapperList = new ArrayList<>();

        //트레이너별 묶기를 위한 for문
        for (TrainerDo trainer : trainerList) {

            Wrapper wrapper = new Wrapper();
            int utIdx = trainer.getId();

            // 헬스장 주소
            String gym = trainer.getGym();

            // 리뷰평균점수 내는 for문   double avgScore
            ReviewDao reviewDao = new ReviewDao(ds);
            List<ReviewDo> reviewList = reviewDao.getReview(utIdx);
            double totalStars = 0.0;
            for (ReviewDo review : reviewList) {
                totalStars += review.getStar();
            }

            double avgScore = reviewList.isEmpty() ? 0.0 : totalStars / reviewList.size();
            int reviewCount = reviewList.size();

            // 이름갖고오기  String userName
            String userId = trainer.getUserId();
            UserDao userDao = new UserDao(ds);
            UserInfo userInfo = userDao.findById(userId); //User ID 가지고 UserInfo 가져오기
            String userName = userInfo.getUser_name();

            // expertList 가져오기  List<Integer> expList
            List<TrainerExpertDo> expertList = trainerDao.getTrainerExpert(utIdx);
            List<Integer> expList = new ArrayList<>();
            for(TrainerExpertDo expertDo : expertList){
                expList.add(expertDo.getExpert());
            }

            // CertList 가져오기 만들어줄거  List<String> certs
            List<TrainerCertDo> certList = trainerDao.getTrainerCert(utIdx);
            List<String> certs = new ArrayList<>();
            for(TrainerCertDo trainerCertDoDo : certList){
                certs.add(trainerCertDoDo.getName());
            }

            // PT개인단체 가져오기   List<Integer> ptTypeList
            List<TrainerPtDo> ptList = trainerDao.getTrainerPt(utIdx);
            List<Integer> ptTypeList = new ArrayList<>();
            for(TrainerPtDo trainerPtDo : ptList){
                ptTypeList.add(trainerPtDo.getType());
            }

            // 사진가져오기.  String img
            List<TrainerImageDo> imgList = trainerDao.getTrainerImage(utIdx);
            List<String> imgs = new ArrayList<>();
            for(TrainerImageDo trainerImageDo : imgList){
                imgs.add(trainerImageDo.getPath());
            }
            String img = imgs.get(0);


            if(ptType == 0 ) {
                if (expType == 0) {
                    if (expList.contains(0)) {
                        wrapper.setGym(gym);
                        wrapper.setAvgScore(avgScore);
                        wrapper.setUserName(userName);
                        wrapper.setExpList(expList);
                        wrapper.setCerts(certs);
                        wrapper.setPtTypeList(ptTypeList);
                        wrapper.setReviewCount(reviewCount);
                        wrapper.setUtIdx(utIdx);
                        wrapper.setImg(img);
                        wrapperList.add(wrapper);
                    }
                }
                if (expType == 1) {
                    if (expList.contains(1)) {
                        wrapper.setGym(gym);
                        wrapper.setAvgScore(avgScore);
                        wrapper.setUserName(userName);
                        wrapper.setExpList(expList);
                        wrapper.setCerts(certs);
                        wrapper.setPtTypeList(ptTypeList);
                        wrapper.setReviewCount(reviewCount);
                        wrapper.setUtIdx(utIdx);
                        wrapper.setImg(img);
                        wrapperList.add(wrapper);
                    }
                }
                if (expType == 2) {
                    if (expList.contains(2)) {
                        wrapper.setGym(gym);
                        wrapper.setAvgScore(avgScore);
                        wrapper.setUserName(userName);
                        wrapper.setExpList(expList);
                        wrapper.setCerts(certs);
                        wrapper.setPtTypeList(ptTypeList);
                        wrapper.setReviewCount(reviewCount);
                        wrapper.setUtIdx(utIdx);
                        wrapper.setImg(img);
                        wrapperList.add(wrapper);
                    }
                }
                if (expType == 3) {
                    if (expList.contains(3)) {
                        wrapper.setGym(gym);
                        wrapper.setAvgScore(avgScore);
                        wrapper.setUserName(userName);
                        wrapper.setExpList(expList);
                        wrapper.setCerts(certs);
                        wrapper.setPtTypeList(ptTypeList);
                        wrapper.setReviewCount(reviewCount);
                        wrapper.setUtIdx(utIdx);
                        wrapper.setImg(img);
                        wrapperList.add(wrapper);
                    }
                }
                if (expType == 4) {
                    if (expList.contains(4)) {
                        wrapper.setGym(gym);
                        wrapper.setAvgScore(avgScore);
                        wrapper.setUserName(userName);
                        wrapper.setExpList(expList);
                        wrapper.setCerts(certs);
                        wrapper.setPtTypeList(ptTypeList);
                        wrapper.setReviewCount(reviewCount);
                        wrapper.setUtIdx(utIdx);
                        wrapper.setImg(img);
                        wrapperList.add(wrapper);
                    }
                }
                if (expType == 5) {
                    if (expList.contains(5)) {
                        wrapper.setGym(gym);
                        wrapper.setAvgScore(avgScore);
                        wrapper.setUserName(userName);
                        wrapper.setExpList(expList);
                        wrapper.setCerts(certs);
                        wrapper.setPtTypeList(ptTypeList);
                        wrapper.setReviewCount(reviewCount);
                        wrapper.setUtIdx(utIdx);
                        wrapper.setImg(img);
                        wrapperList.add(wrapper);
                    }
                }
            }
            if(ptType == 1) {
                if (ptTypeList.contains(0)) {
                    if (expType == 0) {
                        if (expList.contains(0)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 1) {
                        if (expList.contains(1)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 2) {
                        if (expList.contains(2)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 3) {
                        if (expList.contains(3)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 4) {
                        if (expList.contains(4)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 5) {
                        if (expList.contains(5)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                }
            }
            if(ptType == 2){
                if (ptTypeList.contains(1)) {
                    if (expType == 0) {
                        if (expList.contains(0)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 1) {
                        if (expList.contains(1)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 2) {
                        if (expList.contains(2)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 3) {
                        if (expList.contains(3)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 4) {
                        if (expList.contains(4)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                    if (expType == 5) {
                        if (expList.contains(5)) {
                            wrapper.setGym(gym);
                            wrapper.setAvgScore(avgScore);
                            wrapper.setUserName(userName);
                            wrapper.setExpList(expList);
                            wrapper.setCerts(certs);
                            wrapper.setPtTypeList(ptTypeList);
                            wrapper.setReviewCount(reviewCount);
                            wrapper.setUtIdx(utIdx);
                            wrapper.setImg(img);
                            wrapperList.add(wrapper);
                        }
                    }
                }
            }
        }

        return wrapperList;
    }

    // 필터링 리뷰평점
    public List<Wrapper> filterByAvgScore(int ptType, int expType) throws SQLException {
        List<Wrapper> wrapperList;
        wrapperList = getAllTrainerInfo(ptType, expType);
        // 리뷰평점을 기준으로 필터링
        wrapperList.sort(Comparator.comparing(Wrapper::getAvgScore).reversed());
        return wrapperList;
    }

    // 리뷰 많은 순
    public List<Wrapper> filterByCount(int ptType, int expType) throws SQLException {
        List<Wrapper> wrapperList;
        wrapperList = getAllTrainerInfo(ptType, expType);
        // 리뷰개수를 기준으로 필터링
        wrapperList.sort(Comparator.comparing(Wrapper::getReviewCount).reversed());
        return wrapperList;
    }

    // 리뷰 많은 순
    public List<Wrapper> filterByLatest(int ptType, int expType) throws SQLException {
        List<Wrapper> wrapperList;
        wrapperList = getAllTrainerInfo(ptType, expType);
        // 등록순서를 기준으로 필터링
        wrapperList.sort(Comparator.comparing(Wrapper::getUtIdx).reversed());
        return wrapperList;
    }
}


