package com.vs.Syntoy.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.AdminDao;
import com.vs.Syntoy.dao.EpisodeDao;
import com.vs.Syntoy.dao.GroupDao;
import com.vs.Syntoy.dao.QuestionDao;
import com.vs.Syntoy.dao.SnippetDao;
import com.vs.Syntoy.dbentities.AdminEntity;
import com.vs.Syntoy.dbentities.EpisodeEntity;
import com.vs.Syntoy.dbentities.GroupEntity;
import com.vs.Syntoy.dbentities.QuestionEntity;
import com.vs.Syntoy.dbentities.SnippetEntity;
import com.vs.Syntoy.model.SnippetRequest;
import com.vs.Syntoy.utilities.S3Utility;

@Transactional
@Service
public class SnippetService {

	@Autowired
	private SnippetDao obj;
	
	@Autowired
	private EpisodeDao episode;
	
	@Autowired
	private GroupDao group;
	
	@Autowired
	private QuestionDao ques;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private S3Utility s3Utility;
	
	
	public void addSnippet(SnippetRequest snippet){
		SnippetEntity snippetEntity = new SnippetEntity(snippet);
		
		String colorCode = getColorCode(snippet.getR_value(),snippet.getG_value(),snippet.getB_value());
		snippetEntity.setColorCode(colorCode);
		
		for(int i=0;i<snippet.getGroupId().length;i++){
			GroupEntity grpEntity = group.findById(snippet.getGroupId()[i]);
			snippetEntity.getGroup().add(grpEntity);
		}
		
		for(int i=0;i<snippet.getEpisodeId().length;i++) {
			EpisodeEntity epiEntity = episode.findById(snippet.getEpisodeId()[i]);
			snippetEntity.setEpisode(epiEntity);
		}
		
		for(int i=0;i<snippet.getQuesId().length;i++) {
			QuestionEntity quesEntity = ques.findById(snippet.getQuesId()[i]);
			snippetEntity.getQuestion().add(quesEntity);
		}
		
		
		AdminEntity admin = adminDao.findById((long) 1);
		snippetEntity.setAdmin(admin);
		
		obj.addSnippet(snippetEntity);
		
		
		for(int i=0;i<snippet.getGroupId().length;i++){
			GroupEntity grpEntity = group.findById(snippet.getGroupId()[i]);
			grpEntity.getSnippet().add(snippetEntity);
			group.updateGroup(snippet.getGroupId()[i], grpEntity);
		}	
		
		for(int i=0;i<snippet.getQuesId().length;i++) {
			QuestionEntity quesEntity = ques.findById(snippet.getQuesId()[i]);
			quesEntity.getSnippet().add(snippetEntity);
			ques.updateQuestion(snippet.getQuesId()[i], quesEntity);
		}	
		
	}
	
	public List<SnippetEntity> getSnippet(){
		return obj.listSnippets();
	}
	
	public SnippetEntity findSnippetById(long id){
		return obj.findById(id);
	}
	
	public void deleteSnippet(Long id){
		obj.deleteSnippet(id);
	}
	
	public void updateSnippet(long id, SnippetRequest entity){
		
		SnippetEntity snippetEntity = new SnippetEntity(entity);
		snippetEntity.setSnippetId(id);
		
		for(int i=0;i<entity.getEpisodeId().length;i++) {
			EpisodeEntity episodeEntity = episode.findById(entity.getEpisodeId()[i]);
			snippetEntity.setEpisode(episodeEntity);
		}
		
		Set<SnippetEntity> snippetSet = new HashSet<SnippetEntity>();
		snippetSet.add(snippetEntity);
		
		for(int i=0;i<entity.getGroupId().length;i++){
			GroupEntity grpEntity = group.findById(entity.getGroupId()[i]);
			grpEntity.setSnippet(snippetSet);
			group.updateGroup(entity.getGroupId()[i], grpEntity);
		}	
		
		for(int i=0;i<entity.getQuesId().length;i++) {
			QuestionEntity quesEntity = ques.findById(entity.getQuesId()[i]);
			quesEntity.setSnippet(snippetSet);
			ques.updateQuestion(entity.getQuesId()[i], quesEntity);
		}	
		
		
		obj.updateSnippet(id, snippetEntity);
	}
	
	public String getColorCode(long r,long g, long b){
		
		int new_b = scaleValues((int) b);
		int new_r = scaleValues((int) r);
		int new_g = scaleValues((int) g);
		
		return "rgb("+new_r+","+new_g+","+new_b+")";
	}
	
	public int scaleValues(int x){
		int old_min = 0;
		int old_max = 100;
		int new_min = 0;
		int new_max = 255;
		
		int new_value = (((new_max - new_min)*(x - old_min))/(old_max - old_min)) + new_min;
		
		return new_value;
	}
}
