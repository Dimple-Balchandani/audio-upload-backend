package com.vs.Syntoy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.QuestionDao;
import com.vs.Syntoy.dbentities.GroupEntity;
import com.vs.Syntoy.dbentities.QuestionEntity;
import com.vs.Syntoy.model.QuestionRequest;

@Transactional
@Service
public class QuestionService {
	
	public static final Logger logger = LoggerFactory.getLogger(GroupService.class);

	
	@Autowired
	private QuestionDao obj;
	
	public Long addQuestion(QuestionRequest question){
		Long questionId = -1L;
		try{
			QuestionEntity ques = new QuestionEntity(question);
			obj.addQuestion(ques);
			questionId =  ques.getId();
		}
		catch (Exception e){
			logger.error("Exception in Add Group",e.getMessage());
		}

		return questionId;
	}
	
	public List<QuestionEntity> getQuestion(){
		return obj.listQuestions();
	}
	
	public QuestionEntity findQuestionById(Long id){
		return obj.findById(id);
	}
	
	public void deleteQuestion(Long id){
		obj.deleteQuestion(id);
	}
	
	public void updateQuestion(Long id, QuestionRequest entity){
		QuestionEntity ques = new QuestionEntity(entity);
		ques.setId(id);
		obj.updateQuestion(id, ques);
	}
}
