package com.example.JakSim.trainer.model;

import com.example.JakSim.login.model.UserDao;
import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.review.model.ReviewDao;
import com.example.JakSim.review.model.ReviewDo;
import com.example.JakSim.review.model.ReviewImageDo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.*;

@Service
public class TrainerService {
    @Autowired
    private DataSource ds;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TrainerService(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }

//    public static TrainerDo getTrainer(int tidx) {
//        TrainerDao trainerDao = new TrainerDao(ds);
//
//        return trainerDao.getTrainer(tidx);
//
//    }


    // 1. 트레이너 기본 정보(소개, 인스타주소, 헬스장주소)를 가져오기
    public TrainerDo searchTrainerDetails(int idx) {
        TrainerDao trainerDao = new TrainerDao(ds);
        TrainerDo trainerDo = new TrainerDo();
        trainerDo = trainerDao.getTrainer(idx);

        return trainerDo;
    }

    // userId로 트레이너 정보 가져오기
    public TrainerDo searchTrainerByUserId(String userId){
        TrainerDao trainerDao = new TrainerDao(ds);
        return trainerDao.getTrainerByUserId(userId);
    }

    // 1-2. 트레이너 등록번호(인덱스)를 통해 트레이너의 유저정보 가져오기
    public UserInfo searchTrainerName(int utIdx) throws SQLException {
        TrainerDao trainerDao = new TrainerDao(ds);
        UserInfo trainerUserInfo = trainerDao.getTrainerNameByIdx(utIdx);

        return trainerUserInfo;
    }

    // 2. 인덱스 통해 트레이너 자격증 정보 가져오기
    public List<TrainerCertDo> searchCert(int utIdx) {
        TrainerDao trainerDao = new TrainerDao(ds);
        List<TrainerCertDo> certList = trainerDao.getTrainerCert(utIdx);

        return certList;
    }

    //3. 인덱스 통해 전문분야 정보 가져오기
    public List<TrainerExpertDo> searchExpert(int utIdx) {
        TrainerDao trainerDao = new TrainerDao(ds);
        List<TrainerExpertDo> expertList = trainerDao.getTrainerExpert(utIdx);
        return expertList;
    }

    //4. 인덱스 통해 경력/수상정보 가져오기
    public List<TrainerCareerDo> searchCareer(int utIdx) {
        TrainerDao trainerDao = new TrainerDao(ds);
        List<TrainerCareerDo> careerList = trainerDao.getTrainerCareer(utIdx);

        return careerList;
    }

    //5. 인덱스 통해 이미지 가져오기
    public List<TrainerImageDo> searchImage(int utIdx) {
        TrainerDao trainerDao = new TrainerDao(ds);
        List<TrainerImageDo> trainerImageList = trainerDao.getTrainerImage(utIdx);

        return trainerImageList;
    }

    //6. 인덱스 통해 PT 상품 정보 가져오기
    public List<TrainerPtDo> searchPt (int utIdx) {
        TrainerDao trainerDao = new TrainerDao(ds);
        List<TrainerPtDo> trainerPtList = trainerDao.getTrainerPt(utIdx);

        return trainerPtList;

    }

    //7. 리뷰 가져오기-트레이너별
    public List<ReviewDo> searchAllReview() {
        ReviewDao reviewDao = new ReviewDao(ds);
        List<ReviewDo> reviewList = reviewDao.getAllReview(); //ALL리뷰아님 getReview()써야댐

        return reviewList;
    }

    //7-1. 리뷰 가져오기- 마이리뷰
    public ReviewDo searchMyReview(String userId) {
        ReviewDao reviewDao = new ReviewDao(ds);
        ReviewDo myReview = reviewDao.getMyReview(userId);

        return myReview;
    }

    //8. 리뷰 이미지 가져오기 리스트
    public List<ReviewImageDo> searchReviewImage(int rIdx) {
        ReviewDao reviewDao = new ReviewDao(ds);
        List<ReviewImageDo> reviewImageList = reviewDao.getReviewImage(rIdx);

        return reviewImageList;
    }

    //9. 리뷰 별점 인원수 가져오기
//    public int getNumOfStarRatings(List<ReviewDo> reviews) {
//        ReviewDao reviewDao = new ReviewDao(ds);
//        Set<Integer> ratings = new HashSet<>();
//        for (ReviewDo review : reviews) {
//            ratings.add(review.getStar());
//        }
//        return ratings.size();
//    }
    public int getNumOfStarRating(List<ReviewDo> reviews, int starRating) {
        int count = 0;
        for (ReviewDo review : reviews) {
            if (review.getStar() == starRating) {
                count++;
            }
        }
        return count;
    }

    //10. 리뷰 필터링 기능
    //10-1. 필터링-별점 높은 순
    public List<ReviewDo> sortByStarRatingDescending(List<ReviewDo> reviews) {
        Collections.sort(reviews, new Comparator<ReviewDo>() {
            @Override
            public int compare(ReviewDo r1, ReviewDo r2) {
                return r2.getStar() - r1.getStar();
            }
        });
        return reviews;
    }


    //10-2. 필터링-별점 낮은순
    public List<ReviewDo> sortByStarRatingAscending(List<ReviewDo> reviews) {
        Collections.sort(reviews, new Comparator<ReviewDo>() {
            @Override
            public int compare(ReviewDo r1, ReviewDo r2) {
                return r1.getStar() - r2.getStar();
            }
        });
        return reviews;
    }

    //10-3. 필터링-리뷰 최신순
    public List<ReviewDo> filterByLatest(List<ReviewDo> reviews) {
        List<ReviewDo> filteredReviews = new ArrayList<>(reviews);
        filteredReviews.sort(Comparator.comparing(ReviewDo::getCreateDate).reversed());
        return filteredReviews;
    }


    //11. 본인 리뷰 수정
    @Transactional
    public void editReviewByUserId(ReviewDo review, String userId, String newContent, int newRating) {
        ReviewDao reviewDao = new ReviewDao(ds);

        reviewDao.editReview(userId, newContent, newRating);
//        if (review.getUser_id().equals(userId) && review.getUser_id().equals(reviewId)) {
////            reviewDao.editReview(userId, newContent, newRating);
//            //return review;
//        }
        System.out.println("수정성공");

    }


    //12. 본인 리뷰 삭제
    @Transactional
    public void deleteReviewByUserId(String userId) {
        ReviewDo review = new ReviewDo();
        ReviewDao reviewDao = new ReviewDao(ds);
        reviewDao.deleteReview(userId);

    }


}