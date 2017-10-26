package com.vs.Syntoy.dbentities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vs.Syntoy.model.SnippetRequest;

@Entity
@Table(name="snippet")
public class SnippetEntity {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="snippet_id")
	private Long Id;
	
	@NotNull
	@Column(name="snippet_name")
	private String snippetName;
	
	@Column(name="snippet_description")
	private String snippetDesc;
	
	@NotNull
	@Column(name="CFD")
	private Boolean CFD;
	
	@NotNull
	@Column(name="snippet_identifier")
	private String snippetIdentifier;
	
	@Column(name="snippet_S3Link")
	private String snippetS3Link;
	
	@NotNull
	@Column(name="R_value")
	private Long R_value;
	
	@NotNull
	@Column(name="G_value")
	private Long G_value;
	
	@NotNull
	@Column(name="B_value")
	private Long B_value;
	
	@Column(name="color_code")
	private String colorCode;
	
	@Column(name="snippet_start_H")
	private Long snippetStartHour;
	
	@Column(name="snippet_start_M")
	private Long snippetStartMin;
	
	@Column(name="snippet_start_S")
	private Long snippetStartSec;
	
	@Column(name="snippet_end_H")
	private Long snippetEndHour;
	
	@Column(name="snippet_end_M")
	private Long snippetEndMin;
	
	@Column(name="snippet_end_S")
	private Long snippetEndSec;
	
	@Column(name="syntlkers")
	private String syntlkers;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "episode_id",nullable=false)
	@JsonBackReference
	@JsonIgnoreProperties("snippet")
	private EpisodeEntity episode;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "snippet")
	private Set<GroupEntity> group = new HashSet<GroupEntity>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "snippet")
	private Set<QuestionEntity> question = new HashSet<QuestionEntity>();
	

	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="uploaded_by")
	private AdminEntity admin;

	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="pre_snippets",
		joinColumns={@JoinColumn(name="snippet_id")},
		inverseJoinColumns={@JoinColumn(name="pre_snippet_id")})
	private List<SnippetEntity> pre_snippets;
	
	@ManyToMany(mappedBy="pre_snippets")
	private List<SnippetEntity> pre;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="post_snippets",
		joinColumns={@JoinColumn(name="snippet_id")},
		inverseJoinColumns={@JoinColumn(name="post_snippet_id")})
	private List<SnippetEntity> post_snippets;
	
	@ManyToMany(mappedBy="pre_snippets")
	private List<SnippetEntity> post;
	
	public SnippetEntity(){}
	
	public SnippetEntity(SnippetRequest request){
		this.snippetIdentifier = request.getSnippetIdentifier();
		this.snippetName = request.getSnippetName();
		this.snippetDesc = request.getSnippetDesc();
		this.B_value = request.getB_value();
		this.G_value = request.getG_value();
		this.R_value = request.getR_value();
		this.CFD = request.getCFD();
		this.snippetEndHour = request.getSnippetEndHour();
		this.snippetEndMin = request.getSnippetEndMin();
		this.snippetEndSec = request.getSnippetEndSec();
		this.snippetStartHour = request.getSnippetStartHour();
		this.snippetStartMin = request.getSnippetStartMin();
		this.snippetStartSec = request.getSnippetStartSec();
		this.syntlkers =  request.getSyntlkers();
		
//		this.post_snippets = request.getPostSnippets();
//		this.pre_snippets = request.getPreSnippets();
	}
	
	public Long getSnippetId() {
		return Id;
	}

	@JsonIgnore
	public void setSnippetId(Long snippetId) {
		this.Id = snippetId;
	}

	public String getSnippetName() {
		return snippetName;
	}

	public void setSnippetName(String snippetName) {
		this.snippetName = snippetName;
	}

	public String getSnippetDesc() {
		return snippetDesc;
	}

	public void setSnippetDesc(String snippetDesc) {
		this.snippetDesc = snippetDesc;
	}

	public String getSnippetIdentifier() {
		return snippetIdentifier;
	}

	public void setSnippetIdentifier(String snippetIdentifier) {
		this.snippetIdentifier = snippetIdentifier;
	}

	public String getSnippetS3Link() {
		return snippetS3Link;
	}

	public void setSnippetS3Link(String snippetS3Link) {
		this.snippetS3Link = snippetS3Link;
	}

	public Long getR_value() {
		return R_value;
	}

	public void setR_value(Long r_value) {
		R_value = r_value;
	}

	public Long getG_value() {
		return G_value;
	}

	public void setG_value(Long g_value) {
		G_value = g_value;
	}

	public Long getB_value() {
		return B_value;
	}

	public void setB_value(Long b_value) {
		B_value = b_value;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public EpisodeEntity getEpisode() {
		return episode;
	}

	public void setEpisode(EpisodeEntity episode) {
		this.episode = episode;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Set<QuestionEntity> getQuestion() {
		return question;
	}

	public void setQuestion(Set<QuestionEntity> question) {
		this.question = question;
	}

	public Set<GroupEntity> getGroup() {
		return group;
	}

	public void setGroup(Set<GroupEntity> group) {
		this.group = group;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	public Boolean getCFD() {
		return CFD;
	}

	public void setCFD(Boolean cFD) {
		CFD = cFD;
	}

	public Long getSnippetStartHour() {
		return snippetStartHour;
	}

	public void setSnippetStartHour(Long snippetStartHour) {
		this.snippetStartHour = snippetStartHour;
	}

	public Long getSnippetStartMin() {
		return snippetStartMin;
	}

	public void setSnippetStartMin(Long snippetStartMin) {
		this.snippetStartMin = snippetStartMin;
	}

	public Long getSnippetStartSec() {
		return snippetStartSec;
	}

	public void setSnippetStartSec(Long snippetStartSec) {
		this.snippetStartSec = snippetStartSec;
	}

	public Long getSnippetEndHour() {
		return snippetEndHour;
	}

	public void setSnippetEndHour(Long snippetEndHour) {
		this.snippetEndHour = snippetEndHour;
	}

	public Long getSnippetEndMin() {
		return snippetEndMin;
	}

	public void setSnippetEndMin(Long snippetEndMin) {
		this.snippetEndMin = snippetEndMin;
	}

	public Long getSnippetEndSec() {
		return snippetEndSec;
	}

	public void setSnippetEndSec(Long snippetEndSec) {
		this.snippetEndSec = snippetEndSec;
	}

	public List<SnippetEntity> getPre_snippets() {
		return pre_snippets;
	}

	public void setPre_snippets(List<SnippetEntity> pre_snippets) {
		this.pre_snippets = pre_snippets;
	}

	public List<SnippetEntity> getPre() {
		return pre;
	}

	public void setPre(List<SnippetEntity> pre) {
		this.pre = pre;
	}

	public List<SnippetEntity> getPost_snippets() {
		return post_snippets;
	}

	public void setPost_snippets(List<SnippetEntity> post_snippets) {
		this.post_snippets = post_snippets;
	}

	public List<SnippetEntity> getPost() {
		return post;
	}

	public void setPost(List<SnippetEntity> post) {
		this.post = post;
	}

	public String getSyntlkers() {
		return syntlkers;
	}

	public void setSyntlkers(String syntlkers) {
		this.syntlkers = syntlkers;
	}

	
}
