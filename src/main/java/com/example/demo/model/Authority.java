///**
// *
// */
//package com.example.demo.model;
//
//import java.util.Set;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
///**
// * @author RezaKhaleghi
// *
// */
//@Entity
//@Table
//public class Authority
//{
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String username;
//	private String authority;
//
//	@OneToMany(mappedBy = "authority")
//    @JsonIgnore
//	private Set<User> users;
//
//	public Authority(){}
//
//    public Authority(String username, String authority){
//	    this.username = username;
//	    this.authority = authority;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o)
//		{
//			return true;
//		}
//        if (o == null || getClass() != o.getClass())
//		{
//			return false;
//		}
//
//        Authority authority1 = (Authority) o;
//
//        if (id != null ? !id.equals(authority1.id) : authority1.id != null)
//		{
//			return false;
//		}
//        if (username != null ? !username.equals(authority1.username) : authority1.username != null)
//		{
//			return false;
//		}
//        if (authority != null ? !authority.equals(authority1.authority) : authority1.authority != null)
//		{
//			return false;
//		}
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        result = 31 * result + (authority != null ? authority.hashCode() : 0);
//        return result;
//    }
//}
//
///* ---------------------------------------------------------------------*
// * This software is the confidential and proprietary
// * information of Lhasa Limited
// * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
// * ---
// * No part of this confidential information shall be disclosed
// * and it shall be used only in accordance with the terms of a
// * written license agreement entered into by holder of the information
// * with LHASA Ltd.
// * --------------------------------------------------------------------- */