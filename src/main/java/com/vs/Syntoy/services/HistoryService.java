package com.vs.Syntoy.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.HistoryDao;
import com.vs.Syntoy.dao.UserDao;
import com.vs.Syntoy.dbentities.HistoryEntity;
import com.vs.Syntoy.dbentities.UserEntity;
import com.vs.Syntoy.model.HistoryRequest;


@Transactional
@Service
public class HistoryService {

	@Autowired
	private HistoryDao history;
	
	@Autowired
	private UserDao userDao;
	
	public void addHistory(HistoryRequest entity){
		String snippets = "";
		HistoryEntity obj = new HistoryEntity();
		UserEntity user = userDao.findById((long) 1);
		obj.setUser(user);
		for(int i=0; i<entity.getSnippetIds().size()-1; i++) {
			String snip = entity.getSnippetIds().get(i);
			snippets += snip.concat(",");
		}
		snippets = snippets.concat(entity.getSnippetIds().get(entity.getSnippetIds().size()-1));
		obj.setSnippetIds(snippets);	
		Date d = new Date();
		obj.setCreationTime(d);
		history.addHistory(obj);
	}
	
	public List<HistoryEntity> getHistory(){
		return history.listHistory();
	}
	
	public HistoryEntity findHistoryById(long id){
		return history.findById(id);
	}
	
	public void deleteHistory(Long id){
		history.deleteHistory(id);
	}
	
//	public void updateNote(Long id, HistoryEntity entity){
//		UserEntity user = userDao.findById((long) 1);
//		HistoryEntity note = new HistoryEntity();
//		note.setId(id);
//		note.setUser(user);
//		Set<HistoryEntity> historySet = new HashSet<HistoryEntity>();
//		historySet.add(note);
//		history.updateNote(id, note);
//	}
}
