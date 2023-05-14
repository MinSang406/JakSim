package com.example.JakSim.trainer.controller;

import com.example.JakSim.login.model.RegisterService;
import com.example.JakSim.login.model.UserInfo;
import com.example.JakSim.login.model.UserService;
import com.example.JakSim.review.model.ReviewDo;
import com.example.JakSim.trainer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TrainerController {
    private final RegisterService registerService;
    private final TrainerCreateService trainerCreateService;
    private final TrainerService trainerService;
    private final UserService userService;
    private final TrainerListService trainerListService;

    @GetMapping("trainer/register")
    public String create() {
        return "content/trainer/trainerRegister";
    }

    @GetMapping("trainer/search/{ptType}/{expType}")
    public String search(@PathVariable("ptType") int ptType, @PathVariable("expType") int expType, Model model) throws SQLException {
        model.addAttribute("result", trainerListService.getAllTrainerInfo(ptType, expType));
        System.out.println("-".repeat(30));
        for(Wrapper item : trainerListService.getAllTrainerInfo(ptType, expType)){
            System.out.println(item.getUtIdx() + ' ' + item.getUserName()+' ' + item.getImg());
        }
        return "content/trainer/searchTrainer";
    }

    @GetMapping("trainer/search")
    public String searchDefault(Model model) throws SQLException {
        model.addAttribute("result", trainerListService.getAllTrainerInfo(0, 0));
        return "content/trainer/searchTrainer";
    }

    @GetMapping("trainer/res")
    public String reservation(){
        return "content/trainer/reservation";
    }


    @GetMapping("trainer/create")
    public String createForm(@AuthenticationPrincipal User user,  Model model) throws SQLException {
        //model.addAttribute("user", registerService.findByUserId(user.getUsername()));

        return "content/trainer/create";
    }
    @PostMapping("trainer/create/action")
    public String createAction(TrainerCreateDto dto, MultipartHttpServletRequest mtfRequest, @AuthenticationPrincipal User user) throws IOException {
        // TrainerCreateDto에서 모든 데이터를 한번에 다 받아내는거임
        System.out.println(dto.toString()); //확인 중
        List<MultipartFile> files = mtfRequest.getFiles("files"); //이미지  파일임

        // 부분별로 끊어내는 Service 제작해주셈
        trainerCreateService.insertTrainerDo(user.getUsername(), dto.getInsta(), dto.getIntro(), dto.getGym());
        trainerCreateService.insertExpert(user.getUsername(), dto.getExpert1(), dto.getExpert2());
        trainerCreateService.insertCareer(user.getUsername(), dto.getCareer());
        trainerCreateService.insertCert(user.getUsername(), dto.getCert());
        trainerCreateService.insertPt(user.getUsername(), dto.getPt());
        trainerCreateService.insertImages(user.getUsername(), files);

        return "redirect:/";
    }


    @GetMapping("/trainer/{trainerId}")
    public String viewTrainer(@PathVariable("trainerId") int tIdx, @AuthenticationPrincipal User info, Model model) throws SQLException {
        String userId = info.getUsername();
        model.addAttribute("user", userId);

        List<TrainerCertDo> certList = trainerService.searchCert(tIdx);
        List<TrainerCareerDo> careerList = trainerService.searchCareer(tIdx);
        List<TrainerExpertDo> expertList = trainerService.searchExpert(tIdx);
        List<TrainerImageDo> imageList = trainerService.searchImage(tIdx);
        List<TrainerPtDo> ptList = trainerService.searchPt(tIdx);
        List<ReviewDo> reviewList = trainerService.searchAllReview();

        UserInfo trainerInfo = trainerService.searchTrainerName(tIdx);

        model.addAttribute("trainer", trainerService.searchTrainerDetails(tIdx));
        model.addAttribute("certList", certList);
        model.addAttribute("careerList", careerList);
        model.addAttribute("expertList", expertList);
        model.addAttribute("imageList", imageList);
        model.addAttribute("ptList", ptList);
        model.addAttribute("reviewList", reviewList);

        model.addAttribute("trainerInfo", trainerInfo);

        return "content/trainer/trainerDetail";
    }

    @PostMapping("/delete-review")
    public String deleteReview(@AuthenticationPrincipal User info) {
        String userId = info.getUsername();
        trainerService.deleteReviewByUserId(userId);
        return "redirect:/";
    }

    @GetMapping("/review/edit/{reviewId}")
    public String showEditReview(@PathVariable("reviewId") String reviewId, @AuthenticationPrincipal User info, Model model) {
        String userId = info.getUsername();
        ReviewDo myReview = trainerService.searchMyReview(reviewId);
        model.addAttribute("review", myReview);

        return "content/trainer/editReview";
    }

    @PostMapping("/review/update/{reviewId}")
    public String updateReview(@PathVariable("reviewId") String reviewId, @AuthenticationPrincipal User info,
                               @ModelAttribute("content") String content, @ModelAttribute("star") int star, Model model) throws SQLException {
        try {
            String userId = info.getUsername();
            ReviewDo myReview = trainerService.searchMyReview(userId);
            if (myReview == null) {
                return "redirect:/content/trainer/editReview";
            }
            model.addAttribute("review", myReview);
            trainerService.editReviewByUserId(myReview, userId, content, star);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }
    @GetMapping("trainer/change")
    public String changeTrainerForm(@AuthenticationPrincipal User user, Model model) throws SQLException {
        model.addAttribute("trainer", trainerService.searchTrainerByUserId(user.getUsername()));
        return "content/trainer/change";
    }

    @PostMapping("trainer/change/action")
    public String changeTrainerAction(@AuthenticationPrincipal User user, TrainerCreateDto dto, MultipartHttpServletRequest mtfRequest) throws IOException {
        List<MultipartFile> files = mtfRequest.getFiles("files"); //이미지 파일임
        int ut_idx = trainerCreateService.getTrainerId(user.getUsername());

        trainerCreateService.updateTrainerDo(user.getUsername(), dto.getInsta(), dto.getIntro(), dto.getGym());
        trainerCreateService.updateExpert(dto.getExpert1(), dto.getExpert2());
        trainerCreateService.updateCareer(dto.getCareer());
        trainerCreateService.updateCert(dto.getCert());
        trainerCreateService.updatePt(dto.getPt());
        trainerCreateService.updateImages(files);

        return String.format("redirect:/trainer/" + ut_idx);
    }
}
