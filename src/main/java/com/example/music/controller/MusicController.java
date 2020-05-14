package com.example.music.controller;

import com.example.music.SubmitInfo;
import com.example.music.dao.EvaluationRepository;
import com.example.music.dao.MusicRepository;
import com.example.music.entity.Evaluation;
import com.example.music.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;


    @GetMapping("musicList")
    @ResponseBody
    public List<SubmitInfo> musicNames(){
        List<Music> musicList =musicRepository.findAll();
        List<SubmitInfo> viewArr = new ArrayList<>();
        for (Music m:musicList){
            SubmitInfo submitInfo =  new SubmitInfo();
            submitInfo.setMusic_name(m.getName());
            submitInfo.setUrl(m.getUrl());
            viewArr.add(submitInfo);
        }
        return viewArr;
    }
    @PostMapping("submit")
    @ResponseBody
    public String submit(@RequestBody List<SubmitInfo> submitInfos){
        List<Evaluation> evaluationList = new ArrayList<>();
        for (SubmitInfo info:submitInfos
             ) {
            Evaluation e = new Evaluation();
            e.setMusic_name(info.getMusic_name());
            e.setScore(new BigDecimal(info.getScore()));
            e.setTime(new Date(System.currentTimeMillis()));
            evaluationList.add(e);
        }

        evaluationRepository.saveAll(evaluationList);
        return "Ok";
    }

    @GetMapping("score")
    @ResponseBody
    public Map<String,BigDecimal> score(){
        List<Evaluation> evaluationList = evaluationRepository.findAll();

        Map<String,List<Evaluation>> group = evaluationList.stream().collect(Collectors.groupingBy(t -> t.getMusic_name()));
        Map<String,BigDecimal> result = new HashMap<>();
        for(String k:group.keySet()){
            BigDecimal t = new BigDecimal(0);
            for(Evaluation e : group.get(k)){
               t = t.add(e.getScore()) ;
            }

            t = t.divide(new BigDecimal(group.get(k).size()),2, BigDecimal.ROUND_HALF_UP);
            result.put(k,t);
        }


        return result;
    }
}
