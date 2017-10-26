angular.module('StarterApp').service('session', function () {

	this._userId = localStorage.getItem('session.userId');
	this._emailId = localStorage.getItem('session.emailId');
	this._id = localStorage.getItem('session.id');
	this._errorMessage = localStorage.getItem('session.errorMessage');

	this.getUserId = function () {
		return this._userId;
	};

	this.setUserId = function (userId) {
		this._userId = userId;
		localStorage.setItem('session.userId', userId);
		return this;
	};

	this.getEmailId = function () {
		return this._emailId;
	};

	this.setEmailId = function (emailId) {
		this._emailId = emailId;
		localStorage.setItem('session.emailId', emailId);
		return this;
	};

	this.getId = function () {
		return this._id;
	};

	this.setId = function (id) {
		this._id = id;
		localStorage.setItem('session.id', id);
		return this;
	};

	this.getErrorMessage = function () {
		return this._errorMessage;
	};

	this.setErrorMessage = function (errorMessage) {
		this._errorMessage = errorMessage;
		localStorage.setItem('session.errorMessage', errorMessage);
		return this;
	};
	

	this.destroy = function () {
		this.setUserId(null);
		this.setId(null);
		this.setEmailId(null);
		this.setErrorMessage(null);
	};
});