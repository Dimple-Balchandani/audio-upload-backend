package com.vs.Syntoy.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.Syntoy.dao.NotesDao;
import com.vs.Syntoy.dao.UserDao;
import com.vs.Syntoy.dbentities.NotesEntity;
import com.vs.Syntoy.dbentities.UserEntity;
import com.vs.Syntoy.model.NotesRequest;

@Transactional
@Service
public class NotesService {

	@Autowired
	private NotesDao notes;
	
	@Autowired
	private UserDao userDao;
	
	public void addNote(NotesRequest entity){
		NotesEntity note = new NotesEntity(entity);
		UserEntity user = userDao.findById(entity.getUserId());
		note.setUser(user);
		notes.addNotes(note);
	}
	
	public List<NotesEntity> getNotes(){
		return notes.listNotes();
	}
	
	public NotesEntity findNoteById(long id){
		return notes.findById(id);
	}
	
	public void deleteNote(Long id){
		notes.deleteNote(id);
	}
	
	public void updateNote(Long id, NotesRequest entity){
		UserEntity user = userDao.findById(entity.getUserId());
		NotesEntity note = new NotesEntity(entity);
		note.setId(id);
		note.setUser(user);
		Set<NotesEntity> notesSet = new HashSet<NotesEntity>();
		notesSet.add(note);
		notes.updateNote(id, note);
	}
}
