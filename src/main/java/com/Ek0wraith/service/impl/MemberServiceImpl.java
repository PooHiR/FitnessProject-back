package com.Ek0wraith.service.impl;

import com.Ek0wraith.entity.Common;
import com.Ek0wraith.entity.Member;
import com.Ek0wraith.mapper.MemberMapper;
import com.Ek0wraith.mapper.RegisterMapper;
import com.Ek0wraith.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * ClassName: MemberServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 17:49
 * @Version 1.0
 */

public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public List<Member> getMemberMapper(int page, int size) {
        return memberMapper.getAllMember(page,size);
    }

    @Override
    public List<Member> getAllMemberNoPage() {
        return null;
    }

    @Override
    public Map<String, Object> saveMemberBatch(List<Member> list) {
        return null;
    }

    @Override
    public Map<String, Object> addMember(Member member) {
        return null;
    }

    @Override
    public Map<String, Object> deleteMember(int memberNo) {
        return null;
    }

    @Override
    public Map<String, Object> updateMember(Member member) {
        return null;
    }

    @Override
    public Map<String, Object> updateMemberByMemberNo(Member member) {
        return null;
    }

    @Override
    public Common totalMember() {
        return null;
    }

    @Override
    public List<Member> getByKeywordMember(String keyWord, int page, int size) {
        return null;
    }

    @Override
    public Common totalMemberFuzzy(String keyWord) {
        return null;
    }

    @Override
    public Map<String, Object> getMemberPassword(String memberPhone, String memberPassword) {
        return null;
    }

    @Override
    public Member getMemberByMemberNo(int memberNo) {
        return null;
    }

    @Override
    public double getMemberIntegral(int memberNo) {
        return 0;
    }

    @Override
    public double getMemberPower(int memberNo) {
        return 0;
    }

    @Override
    public Double getMemberChange(int memberNo) {
        return null;
    }

    @Override
    public Double getTotalMoney(int memberNo) {
        return null;
    }

    @Override
    public int updateMemberChange(int memberNo) {
        return 0;
    }

    @Override
    public Map<String, Object> updateMemberChangeByMemberNo(int memberNo, double coursePrice) {
        return null;
    }

    @Override
    public Map<String, Object> updateMemberIntegral(double price, int memberNo) {
        return null;
    }

    @Override
    public Map<String, Object> updateMemberPassword(String memberPhone, String memberPassword) {
        return null;
    }

    @Override
    public Map<String, Object> updateMemberPower(int memberPower, int memberNo) {
        return null;
    }

    @Override
    public Map<String, Object> getMemberBySeason(Integer year) {
        return null;
    }

    @Override
    public Map<String, Object> getMemberSexByYear(Integer year) {
        return null;
    }

    @Override
    public Map<String, Object> register(Member member) {
        return null;
    }
}
