package com.vs.Syntoy.utilities;

public class Constants {

	public static final String MAIN_API_TAG ="/main";
	public static final String MAIN_DESCRIPTION ="Api for main";
	public static final String ADMIN_APIS = "/admin/";
	public static final String EPISODE_APIS = "/episode/";
	public static final String FAQS_APIS = "/FAQs/";
	public static final String GROUP_APIS = "/group/";
	public static final String HISTORY_APIS = "/history/";
	public static final String NOTES_APIS = "/notes/";
	public static final String QUESTION_APIS = "/question/";
	public static final String SNIPPET_APIS = "/snippet/";
	public static final String USER_APIS = "/user/";
	public static final String SYNTALKER_APIS = "/syntalker/";
	
	public static final String LOGIN_API = "/login/";
	public static final String GET_API = "";
	public static final String GET_BY_ID_API = "/{id}";
	public static final String ADD_API = "/add";
	public static final String DELETE_API = "/delete/{id}";
	public static final String UPDATE_API = "/{id}";
	
	public static final String QUERY_ALL_ADMIN = "SELECT a from AdminEntity a";
	public static final String QUERY_ALL_EPISODE = "SELECT e from EpisodeEntity e ORDER BY e.episodeName";
	public static final String QUERY_ALL_FAQs= "SELECT f from FAQsEntity f";
	public static final String QUERY_ALL_GROUP= "SELECT g from GroupEntity g ORDER BY g.groupNickname";
	public static final String QUERY_ALL_HISTORY= "SELECT h from HistoryEntity h";
	public static final String QUERY_ALL_NOTES= "SELECT n from NotesEntity n";
	public static final String QUERY_ALL_QUESTION= "SELECT q from QuestionEntity q";
	public static final String QUERY_ALL_SNIPPET = "SELECT s from SnippetEntity s ORDER BY s.snippetName";
	public static final String QUERY_ALL_USERS = "SELECT u from UserEntity u ORDER BY u.userFirstname";
	public static final String QUERY_ALL_SYNTALKER = "SELECT t from SyntalkerEntity t ORDER BY t.syntalkerName";
	
	public static final String GET_EPISODE_DESC = "api to get all episodes";
	public static final String GET_EPISODE_BY_ID_DESC = "api to get episode by id";
	public static final String ADD_EPISODE_DESC = "api to add an episode";
	public static final String DELETE_EPISODE_DESC = "api to delete an episode by id";
	public static final String UPDATE_EPISODE_DESC = "api to update an episode";
	
	public static final String GET_SNIPPET_DESC = "api to get all snippet";
	public static final String GET_SNIPPET_BY_ID_DESC = "api to get snippet by id";
	public static final String ADD_SNIPPET_DESC = "api to add an snippet";
	public static final String DELETE_SNIPPET_DESC = "api to delete an snippet by id";
	public static final String UPDATE_SNIPPET_DESC = "api to update an snippet";
	
	public static final String GET_GROUP_DESC = "api to get all group";
	public static final String GET_GROUP_BY_ID_DESC = "api to get group by id";
	public static final String ADD_GROUP_DESC = "api to add an group";
	public static final String DELETE_GROUP_DESC = "api to delete an group by id";
	public static final String UPDATE_GROUP_DESC = "api to update an group";
	
	public static final String GET_QUESTION_DESC = "api to get all question";
	public static final String GET_QUESTION_BY_ID_DESC = "api to get question by id";
	public static final String ADD_QUESTION_DESC = "api to add an question";
	public static final String DELETE_QUESTION_DESC = "api to delete an question by id";
	public static final String UPDATE_QUESTION_DESC = "api to update an question";
	
	public static final String GET_ADMIN_DESC = "api to get all admin";
	public static final String GET_ADMIN_BY_ID_DESC = "api to get admin by id";
	public static final String ADD_ADMIN_DESC = "api to add an admin";
	public static final String DELETE_ADMIN_DESC = "api to delete an admin by id";
	public static final String UPDATE_ADMIN_DESC = "api to update an admin";
	
	public static final String GET_USER_DESC = "api to get all user";
	public static final String GET_USER_BY_ID_DESC = "api to get user by id";
	public static final String ADD_USER_DESC = "api to add an user";
	public static final String DELETE_USER_DESC = "api to delete an user by id";
	public static final String UPDATE_USER_DESC = "api to update an user";
	
	public static final String GET_FAQs_DESC = "api to get all FAQs";
	public static final String GET_FAQs_BY_ID_DESC = "api to get FAQs by id";
	public static final String ADD_FAQs_DESC = "api to add an FAQs";
	public static final String DELETE_FAQs_DESC = "api to delete an FAQs by id";
	public static final String UPDATE_FAQs_DESC = "api to update an episode";
	
	public static final String GET_NOTES_DESC = "api to get all notes";
	public static final String GET_NOTES_BY_ID_DESC = "api to get notes by id";
	public static final String ADD_NOTES_DESC = "api to add an notes";
	public static final String DELETE_NOTES_DESC = "api to delete an notes by id";
	public static final String UPDATE_NOTES_DESC = "api to update an notes";
	
	public static final String GET_HISTORY_DESC = "api to get all history";
	public static final String GET_HISTORY_BY_ID_DESC = "api to get history by id";
	public static final String ADD_HISTORY_DESC = "api to add an history";
	public static final String DELETE_HISTORY_DESC = "api to delete an history by id";
	public static final String UPDATE_HISTORY_DESC = "api to update an history";
	
	public static final String GET_SYNTALKER_DESC = "api to get all syntalker";
	public static final String GET_SYNTALKER_BY_ID_DESC = "api to get syntalker by id";
	public static final String ADD_SYNTALKER_DESC = "api to add a syntalker";
	public static final String DELETE_SYNTALKER_DESC = "api to delete a syntalker by id";
	public static final String UPDATE_SYNTALKER_DESC = "api to update a syntalker";
	
	public static final String AUTHORIZATION = "authorization";
	public static final String AUTH_DESC = "The auth token of the logged in validated user.Authorization must of the specified format: Bearer{space}{authToken}";
	
}
