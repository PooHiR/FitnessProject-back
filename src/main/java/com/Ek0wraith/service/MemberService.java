package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: MemberService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 11:01
 * @Version 1.0
 */
public interface MemberService {
    public List<Member> getMemberMapper(int page, int size);
    public List<Member> getAllMemberNoPage();
    public Map<String, Object> saveMemberBatch(List<Member> list);
    public Map<String, Object> addMember(Member member);
    public Map<String, Object> deleteMember(int memberNo);
    public Map<String, Object> updateMember(Member member);
    public Map<String, Object> updateMemberByMemberNo(Member member);
    public Common totalMember();
    public List<Member> getByKeywordMember(String keyWord, int page, int size);
    public Common totalMemberFuzzy(String keyWord);
    public Map<String, Object> getMemberPassword(String memberPhone, String memberPassword);
    public Member getMemberByMemberNo(int memberNo);
    public double getMemberIntegral(int memberNo);
    public double getMemberPower(int memberNo);
    public Double getMemberChange(int memberNo);
    public Double getTotalMoney(int memberNo);
    public int updateMemberChange(int memberNo);
    public Map<String,Object> updateMemberChangeByMemberNo(int memberNo, double coursePrice);
    public Map<String, Object> updateMemberIntegral(double price, int memberNo);
    public Map<String, Object> updateMemberPassword(String memberPhone, String memberPassword);
    public Map<String, Object> updateMemberPower(int memberPower, int memberNo);
    public Map<String, Object> getMemberBySeason(Integer year);
    public Map<String, Object> getMemberSexByYear(Integer year);
    public Map<String, Object> register(Member member);

}
