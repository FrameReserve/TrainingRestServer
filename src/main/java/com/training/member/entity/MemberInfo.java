package com.training.member.entity;

import com.training.core.entity.BaseEntity;


public class MemberInfo extends BaseEntity {

	/**
	 * 会员账号
	 */
	private String member_name;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * 性别 0.保密 1.男 2.女
	 */
	private Integer gender;
	
	/**
	 * 邮箱地址
	 */
	private String email;
	
	/**
	 * 移动电话
	 */
	private String mobile;
	
	/**
	 * 邮编
	 */
	private String zipcode;
	
	/**
	 * 收件人
	 */
	private String shipped_to_name;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 庭家电话
	 */
	private String telephone;
	
	/**
	 * 常居地
	 */
	private String usercity;
	
	/**
	 * 会员头像
	 */
	private String avatar;
	
	/**
	 * 自我介绍
	 */
	private String introduce;
	
	/**
	 * 登陆时间
	 */
	private Integer login_time;
	
	/**
	 * 登陆次数
	 */
	private Integer login_num;
	
	/**
	 * 评论数
	 */
	private Integer comment_num;
	
	/**
	 * 存款预
	 */
	private Double predeposit;
	
	/**
	 * 积分
	 */
	private Integer point;
	
	/**
	 * 找回密码邮箱验证码
	 */
	private String email_code;
	
	/**
	 * 预存款支付密码
	 */
	private String pay_password;
	
	/**
	 * 会员等级
	 */
	private Integer member_degree;
	
	/**
	 * 会员积分
	 */
	private Integer member_point;
	
	/**
	 * 会员贡献值
	 */
	private Integer member_contribution;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区
	 */
	private String district;
	
	// ------------------------------------- getter and setter --------------------------------------------
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getShipped_to_name() {
		return shipped_to_name;
	}
	public void setShipped_to_name(String shipped_to_name) {
		this.shipped_to_name = shipped_to_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUsercity() {
		return usercity;
	}
	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Integer getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Integer login_time) {
		this.login_time = login_time;
	}
	public Integer getLogin_num() {
		return login_num;
	}
	public void setLogin_num(Integer login_num) {
		this.login_num = login_num;
	}
	public Integer getComment_num() {
		return comment_num;
	}
	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}
	public Double getPredeposit() {
		return predeposit;
	}
	public void setPredeposit(Double predeposit) {
		this.predeposit = predeposit;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getEmail_code() {
		return email_code;
	}
	public void setEmail_code(String email_code) {
		this.email_code = email_code;
	}
	public String getPay_password() {
		return pay_password;
	}
	public void setPay_password(String pay_password) {
		this.pay_password = pay_password;
	}
	public Integer getMember_degree() {
		return member_degree;
	}
	public void setMember_degree(Integer member_degree) {
		this.member_degree = member_degree;
	}
	public Integer getMember_point() {
		return member_point;
	}
	public void setMember_point(Integer member_point) {
		this.member_point = member_point;
	}
	public Integer getMember_contribution() {
		return member_contribution;
	}
	public void setMember_contribution(Integer member_contribution) {
		this.member_contribution = member_contribution;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
}
