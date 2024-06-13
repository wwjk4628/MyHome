package himedia.myhome.vo;

import java.util.Date;

public class GuestBookVo {

	private Long no;
	private String name;
	private String pass;
	private String content;
	private Date createdAt;

	public GuestBookVo() {
	}

	public GuestBookVo(Long no, String name, String pass, String content, Date createdAt) {

		this.no = no;
		this.name = name;
		this.pass = pass;
		this.content = content;
		this.createdAt = createdAt;
	}

	public GuestBookVo(String name, String pass, String content) {

		this.name = name;
		this.pass = pass;
		this.content = content;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		if (pass == null)
			return "";
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", name=" + name + ", pass=" + pass + ", content=" + content + ", createdAt="
				+ createdAt + "]";
	}

}
