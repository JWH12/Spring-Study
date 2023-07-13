package com.tj.edu.practice5.jpa.model;

import com.tj.edu.practice5.jpa.repository.MemberLogHistoryRepository;
import com.tj.edu.practice5.jpa.util.SpringBeanUtils;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Component
public class MemberEntityListener {
    @Autowired
    private MemberLogHistoryRepository memberLogHistoryRepository;

    @PostUpdate
    @PostPersist
    public void postPersistAndPostUpdate(Object o) {
//        MemberLogHistoryRepository memberLogHistoryRepository
//                = SpringBeanUtils.getBean(MemberLogHistoryRepository.class);

        Member member = (Member) o;

        MemberLogHistory memberLogHistory = MemberLogHistory.builder()
                .memberId(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .male(member.getMale())
                .build();
        memberLogHistoryRepository.save(memberLogHistory);

    }
}
