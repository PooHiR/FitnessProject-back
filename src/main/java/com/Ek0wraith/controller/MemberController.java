package com.Ek0wraith.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.Ek0wraith.entity.Common;
import com.Ek0wraith.entity.Member;
import com.Ek0wraith.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * ClassName: MemberController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 17:05
 * @Version 1.0
 */
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**获取所有会员信息
     * @description: 获取所有会员信息
     * @author: Ek0wraith
     * @date: 2024/6/13 19:53
     * @param: page 页码
     * @param: size 每页显示的数量
     * @return: 会员信息
     **/
    @RequestMapping(path = "/getAllMember")
    public List<Member> getAllMember(int page,int size){
        return memberService.getMemberMapper(page, size);
    }

    /**
     * @description: 新增会员
     * @author: Ek0wraith
     * @date: 2024/6/13 19:56
     * @param: member 会员表单
     * @return: map
     **/
    @RequestMapping(path = "/addMember")
    public Map<String,Object> addMember(Member member){
        return addMember(member);
    }
    
    /**
     * @description: 新增会员
     * @author: Ek0wraith
     * @date: 2024/6/13 20:09 
     * @param: member 会员表单
     * @return: map
     **/
    @PostMapping(path = "/register")
    public Map<String,Object> register(@RequestBody Member member){
        return memberService.register(member);
    }
    
    /**
     * @description: 删除用户
     * @author: Ek0wraith
     * @date: 2024/6/13 20:11 
     * @param: memberNo 用户编号
     * @return: map
     **/
    @RequestMapping(path = "/deleteMember")
    public Map<String,Object> deleteMember(int memberNo){
        return memberService.deleteMember(memberNo);
    }

    /**
     * @description: 更新用户
     * @author: Ek0wraith
     * @date: 2024/6/13 20:17
     * @param: member 会员表单
     * @return: map
     **/
    @RequestMapping(path = "/updateMember")
    public Map<String,Object> updateMember(Member member){
        return memberService.updateMember(member);
    }

    /**
     * @description: 通过会员编号更新会员
     * @author: Ek0wraith
     * @date: 2024/6/13 20:20
     * @param: member
     * @return: map
     **/
    @RequestMapping(path="/updateMemberByMemberNo")
    public Map<String,Object> updateMemberByMemberNo(Member member) {
        return memberService.updateMemberByMemberNo(member);
    }

    /**
     * @description: 查找会员表数据总条数
     * @author: Ek0wraith
     * @date: 2024/6/13 20:22
     * @return: dataTotal
     **/
    @RequestMapping(path = "/totalMember")
    public Common totalMember() {
        return memberService.totalMember();
    }

    /**
     * @description: 登录
     * @author: Ek0wraith
     * @date: 2024/6/14 9:54
     * @param: memberPhone 手机号
     * @param: memberPassword 密码
     * @return: map
     **/
    @RequestMapping(path="/getMemberPassword")
    @CrossOrigin
    public Map<String,Object> getMemberPassword(String memberPhone,String memberPassword){
        return memberService.getMemberPassword(memberPhone,memberPassword);
    }

    /**
     * @description: 模糊查询用户
     * @author: Ek0wraith
     * @date: 2024/6/14 10:05
     * @param: keyword 关键词
     * @param: page 页码
     * @param: size 每页显示的数量
     * @return: java.util.List<com.Ek0wraith.entity.Member>
     **/
    @RequestMapping(path = "/getByKeywordMember")
    public List<Member> getByKeywordMember(String keyWord,int page,int size){
        return memberService.getByKeywordMember(keyWord,page,size);
    }

    /**
     * @description: 模糊查询用户总数
     * @author: Ek0wraith
     * @date: 2024/6/14 10:08
     * @param: keyWord 关键词
     * @return: com.Ek0wraith.entity.Common
     **/
    @RequestMapping(path = "/totalMemberFuzzy")
    public Common totalMemberFuzzy(String keyWord) {
        return memberService.totalMemberFuzzy(keyWord);
    }

    /**
     * @description: 获取会员积分
     * @author: Ek0wraith
     * @date: 2024/6/14 10:09
     * @param: memberNo 会员编号
     * @return: double
     **/
    @RequestMapping(path = "/getMemberIntegral")
    public double getMemberIntegral(int memberNo) {
        return memberService.getMemberIntegral(memberNo);
    }

    /**
     * @description: 获取会员余额
     * @author: Ek0wraith
     * @date: 2024/6/14 10:12
     * @param: memberNo 会员编号
     * @return: double
     **/
    @ResponseBody
    @RequestMapping(path = "/getMemberChange")
    public double getMemberChange(int memberNo){
        return memberService.getMemberChange(memberNo);
    }

    /**
     * @description: 通过会员编号获取用户信息
     * @author: Ek0wraith
     * @date: 2024/6/14 10:14
     * @param: memberNo 会员编号
     * @return: com.Ek0wraith.entity.Member
     **/
    @RequestMapping(path = "/getMemberByMemberNo")
    public Member getMemberByMemberNo(Integer memberNo){
        return memberService.getMemberByMemberNo(memberNo);
    }

    /**
     * @description: 获取会员充值总额
     * @author: Ek0wraith
     * @date: 2024/6/14 10:19
     * @param: memberNo 会员编号
     * @return: java.lang.Double
     **/
    @RequestMapping(path = "/getTotalMoney")
    public Double getTotalMoney(Integer memberNo){
        return memberService.getTotalMoney(memberNo);
    }

    /**
     * @description: 获取会员权限
     * @author: Ek0wraith
     * @date: 2024/6/14 10:20
     * @param: memberNo 会员编号
     * @return: double
     **/
    @RequestMapping(path = "/getMemberPower")
    public double getMemberPower(Integer memberNo) {
        return memberService.getMemberPower(memberNo);
    }

    /**
     * @description: 更新会员额度
     * @author: Ek0wraith
     * @date: 2024/6/14 10:20
     * @param: memberNo 会员编号
     * @return: double
     **/
    @RequestMapping(path = "/updateMemberChange")
    public double updateMemberChange(Integer memberNo) {
        return memberService.updateMemberChange(memberNo);
    }

    /**
     * @description: 更新会员积分
     * @author: Ek0wraith
     * @date: 2024/6/14 10:21
     * @param: price
     * @param: memberNo 会员编号
     * @return: map
     **/
    @RequestMapping(path = "/updateMemberIntegral")
    public Map<String,Object> updateMemberIntegral(Double price,Integer memberNo) {
        return memberService.updateMemberIntegral(price,memberNo);
    }

    /**
     * @description: 更新会员余额
     * @author: Ek0wraith
     * @date: 2024/6/14 10:22
     * @param: memberNo 会员编号
     * @param: coursePrice
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(path = "/updateMemberChangeByMemberNo")
    public Map<String,Object> updateMemberChangeByMemberNo(int memberNo,double coursePrice) {
        return memberService.updateMemberChangeByMemberNo(memberNo,coursePrice);
    }

    /**
     * @description: 修改会员密码
     * @author: Ek0wraith
     * @date: 2024/6/14 10:25
     * @param: memberPhone 手机号
     * @param: memberPassword 密码
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(path = "/updateMemberPassword")
    public Map<String,Object> updateMemberPassword(String memberPhone,String memberPassword){
        return memberService.updateMemberPassword(memberPhone,memberPassword);
    }

    /**
     * @description: 修改会员权限
     * @author: Ek0wraith
     * @date: 2024/6/14 10:26
     * @param: memberPower
     * @param: memberNo
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(path = "/updateMemberPower")
    public Map<String,Object> updateMemberPower(int memberPower,int memberNo) {
        return memberService.updateMemberPower(memberPower,memberNo);
    }

    /**
     * @description: 导出接口
     * @author: Ek0wraith
     * @date: 2024/6/14 10:27
     * @param: response
     **/
    @GetMapping("/memberExport")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Member> list = memberService.getAllMemberNoPage();
        // 通过工具类创建writer 写出到磁盘路径
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("会员信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();
    }


    /**
     * @description: 导入
     * @author: Ek0wraith
     * @date: 2024/6/14 10:27
     * @param: file
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("/memberImport")
    @CrossOrigin
    public Map<String, Object> imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);

        List<Member> list = reader.readAll(Member.class);

        System.out.println(list);

        //上传的excel数据,保存到数据库中
        Map<String, Object> stringObjectMap = memberService.saveMemberBatch(list);
        return stringObjectMap;
    }
}
