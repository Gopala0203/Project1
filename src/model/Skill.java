package model;

public class Skill {
	private int SkillId;
	private String SkillName;
	private String SkillDes;
	private String active;
	public Skill(String skillName, String skillDes, String active) {
		super();
		SkillName = skillName;
		SkillDes = skillDes;
		this.active = active;
	}
	@Override
	public String toString() {
		return "Skill [SkillId=" + SkillId + ", SkillName=" + SkillName + ", SkillDes=" + SkillDes + ", active="
				+ active + "]";
	}
	
	public int getSkillId() {
		return SkillId;
	}
	public void setSkillId(int skillId) {
		SkillId = skillId;
	}
	public String getSkillName() {
		return SkillName;
	}
	public void setSkillName(String skillName) {
		SkillName = skillName;
	}
	public String getSkillDes() {
		return SkillDes;
	}
	public void setSkillDes(String skillDes) {
		SkillDes = skillDes;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Skill() {
		
		
	}

}
