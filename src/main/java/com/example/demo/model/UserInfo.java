/**
 *
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author RezaKhaleghi
 *
 */
public class UserInfo {

	private  String id;
    private String name;
    private  String givenName;
    private  String familyName;
    private  String gender;
    private  String picture;
    private  String link;
    private  String email;

    @JsonCreator
    public UserInfo(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("given_name") String givenName,
        @JsonProperty("family_name") String familyName,
        @JsonProperty("gender") String gender,
        @JsonProperty("picture") String picture,
        @JsonProperty("link") String link,
        @JsonProperty("email") String email) {
        this.id = id;
        this.name = name;
        this.givenName = givenName;
        this.familyName = familyName;
        this.gender = gender;
        this.picture = picture;
        this.link = link;
        this.email = email;
    }

    /**
	 *
	 */
	public UserInfo()
	{
		// TODO Auto-generated constructor stub
	}


    public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public String getGivenName()
	{
		return givenName;
	}

	public String getFamilyName()
	{
		return familyName;
	}

	public String getGender()
	{
		return gender;
	}

	public String getPicture()
	{
		return picture;
	}

	public String getLink()
	{
		return link;
	}

	public String getEmail()
	{
		return email;
	}
}