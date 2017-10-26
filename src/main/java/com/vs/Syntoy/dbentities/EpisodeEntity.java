package com.vs.Syntoy.dbentities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vs.Syntoy.model.EpisodeRequest;

@Entity
@Table(name="episode")
public class EpisodeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="episode_id")
	private Long id;
	
	@NotNull
	@Column(name="episode_name")
	private String episodeName;
	
	@Column(name="episode_description")
	private String episodeDesc;
	
	@NotNull
	@Column(name="duration_H")
	private Long episodeHours;
	
	@NotNull
	@Column(name="duration_M")
	private Long episodeMin;
	
	@NotNull
	@Column(name="duration_S")
	private Long episodeSec;
	
	@NotNull
	@Column(name="episode_identifier")
	private String episodeIdentifier;
	
	@Column(name="episode_S3Link")
	private String episodeS3Link;
	
	@Column(name="syntlkers")
	private String syntlkers;

	@Column(name="release_date")
	private Date releaseDate;

	@Column(name="episode_upload_time")
	private Date uploadtime;



	@Column
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "episode", cascade = CascadeType.ALL)
	@JsonManagedReference
	@JsonIgnoreProperties({"episode","snippetName","cfd","b_value","colorCode","snippetStartHour","snippetStartMin","snippetStartSec",
		"snippetEndHour","snippetEndMin","snippetEndSec","snippetS3Link","r_value","g_value","syntlkers","snippetDesc",
		"snippetIdentifier","group","question","pre","post","pre_snippets","post_snippets"})
	private Set<SnippetEntity> snippet= new HashSet<SnippetEntity>();
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="uploaded_by")
	private AdminEntity admin;

	public EpisodeEntity(){}
	
	public EpisodeEntity(EpisodeRequest request){
		this.episodeName = request.getEpisodeName();
		this.episodeDesc = request.getEpisodeDesc();
		this.episodeIdentifier = request.getEpisodeIdentifier();
		this.episodeS3Link = request.getEpisodeS3Link();
		this.episodeHours = request.getEpisodeHours();
		this.episodeMin = request.getEpisodeMin();
		this.episodeSec = request.getEpisodeSec();
		this.syntlkers =  request.getSyntlkers();
		this.releaseDate =  request.getReleaseDate();
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getEpisodeDesc() {
		return episodeDesc;
	}

	public void setEpisodeDesc(String episodeDesc) {
		this.episodeDesc = episodeDesc;
	}

	public Long getEpisodeHours() {
		return episodeHours;
	}

	public void setEpisodeHours(Long episodeHours) {
		this.episodeHours = episodeHours;
	}

	public Long getEpisodeMin() {
		return episodeMin;
	}

	public void setEpisodeMin(Long episodeMin) {
		this.episodeMin = episodeMin;
	}

	public Long getEpisodeSec() {
		return episodeSec;
	}

	public void setEpisodeSec(Long episodeSec) {
		this.episodeSec = episodeSec;
	}

	public String getEpisodeIdentifier() {
		return episodeIdentifier;
	}

	public void setEpisodeIdentifier(String episodeIdentifier) {
		this.episodeIdentifier = episodeIdentifier;
	}

	public String getEpisodeS3Link() {
		return episodeS3Link;
	}

	public void setEpisodeS3Link(String episodeS3Link) {
		this.episodeS3Link = episodeS3Link;
	}

	public Set<SnippetEntity> getSnippet() {
		return snippet;
	}

	public void setSnippet(Set<SnippetEntity> snippet) {
		this.snippet = snippet;
	}

	public AdminEntity getAdmin() {
		return admin;
	}

	public void setAdmin(AdminEntity admin) {
		this.admin = admin;
	}

	
	public String getSyntlkers() {
		return syntlkers;
	}

	public void setSyntlkers(String syntlkers) {
		this.syntlkers = syntlkers;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	
}
