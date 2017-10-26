angular.module('StarterApp').service('Utility', function (Network, $timeout, $mdDialog, session) {

	this.getIcon = function(type) {

		if(type == 'EDIT')
			return CONSTANTS.get('ICON_EDIT');
		else if(type == 'DELETE')
			return  CONSTANTS.get('ICON_DELETE');
		else if(type == 'CLOSE')
			return CONSTANTS.get('ICON_CLOSETASK');
		else if(type == 'ADD')
			return CONSTANTS.get('ICON_ADD');
		else if(type == 'REMARK')
			return CONSTANTS.get('ICON_REMARK');
		else if(type == 'COMPLETE') 
			return CONSTANTS.get('ICON_COMPLETE');
		else if(type == 'RESET') 
			return CONSTANTS.get('ICON_RESET');
		else if(type == 'PRINT') 
			return CONSTANTS.get('ICON_PRINT');
		else if(type == 'USER') 
			return CONSTANTS.get('ICON_USER');
		else if(type == 'UPLOAD')
			return CONSTANTS.get('ICON_UPLOAD');
		else if(type == 'DOWNLOAD')
			return CONSTANTS.get('ICON_DOWNLOAD');
		else if(type == 'ATTACHMENT')
			return CONSTANTS.get('ICON_ATTACHMENT');
	}

	this.formatDateForDisplay = function (date) {

		var d = new Date(date),
		month = '' + (d.getMonth() + 1),
		day = '' + d.getDate(),
		year = d.getFullYear();

		if (month.length < 2)
			month = '0' + month;
		if (day.length < 2)
			day = '0' + day;

		return [day, month, year].join('-');
	}

	this.formatDateForDB = function (date) {

		var d = new Date(date),
		month = '' + (d.getMonth() + 1),
		day = '' + d.getDate(),
		year = d.getFullYear();

		if (month.length < 2)
			month = '0' + month;
		if (day.length < 2)
			day = '0' + day;

		return [year, month, day].join('-');
	}

	this.checkInputOnlyNumbers = function (event) {

		if (event.charCode >= 48 && event.charCode <= 57)
			return true;
		else
			event.preventDefault();
	};

	this.dayDiff = function(startDate, endDate){

		if ((Date.parse(startDate) >= Date.parse(endDate))) 
			return true;
		else
			return false;
	}

	this.countDayDiff = function(date1, date2) {

		var timeDiff = Math.abs(date1.getTime() - date2.getTime());   
		return Math.ceil(timeDiff / (1000 * 3600 * 24));
	}

	this.loadTaskData = function() {

		return Network.getService(CONSTANTS.get('PROD_USER_TASK_LIST_JSON_API'))
		.success(function (response) {
		})
		.error(function (response) {
		});
	}


	this.getUserTypeList = function() {
		//WARNING : DELHI->10 & MUMBAI ->8
		this.typeList = [
		                 {id: 0, name: 'Supervisior'},
		                 {id: 1, name: 'USER-1'},
		                 {id: 2, name: 'USER-2'},
		                 {id: 3, name: 'USER-3'},
		                 {id: 4, name: 'USER-4'},
		                 {id: 5, name: 'USER-5'},
		                 {id: 6, name: 'USER-6'},
		                 {id: 7, name: 'USER-7'},
		                 {id: 8, name: 'USER-8'},
		                 {id: 9, name: 'USER-9'},
		                 {id: 10, name: 'USER-10'}
		                 ]

		return this.typeList;
	}

	this.updateJobInfo = function (jobInfo) {

		jobInfo.formattedDate = this.formatDateForDisplay(jobInfo.date);
		jobInfo.exceedingDate = this.getExceedingDate(jobInfo);
		jobInfo.exceedingDays = this.getExceedingDays(jobInfo);

		if(jobInfo.jobStatus == 'COMPLETED')
			jobInfo.taskTitle =  "NO TASK";
	}


	this.getStatusColor = function (status) {

		if(status == 'PENDING') {
			return "pending-color";
		}
		else if(status == 'NEW' || status == 'New') {
			return "new-color";
		}
		else if(status == 'ACTIVE') {
			return "active-color";
		}
		else if(status == 'COMPLETED') {
			return "completed-color";
		}
	}


	this.getExceedingDate = function (taskList) {

		if(taskList.taskStatus == 'PENDING') {

			return "(" + this.countDayDiff(new Date, new Date(taskList.expectedDate)) + " days)";
		}
		else if(taskList.taskStatus == 'ACTIVE') {
			return "(" + this.countDayDiff(new Date, new Date(taskList.startDate)) + " days)";
		}
		else {
			return "";
		}
	}
	
	this.getExceedingDays = function (taskList) {

		if(taskList.taskStatus == 'PENDING') {

			return this.countDayDiff(new Date, new Date(taskList.expectedDate));
		}
		else if(taskList.taskStatus == 'ACTIVE') {
			return this.countDayDiff(new Date, new Date(taskList.startDate));
		}
		else {
			return 0;
		}
	}


	this.showLoader = function(loaderData) {

		if ($("#loadingScreen").length == 0) {
			$('body').append("<div id='loadingScreen' class='fade-out'><div class='loader'><img id='loading-image' src='images/loader.gif' /></div></div>");
			if(loaderData && loaderData.backgroundClass) {
				$("#loadingScreen").addClass(loaderData.backgroundClass);
			} else {
				//nothing
			}
		} else {
		}
	};

	this.hideLoader = function() {
		$("#loadingScreen").remove();
	};


	this.isUserLogin = function () {

		// if (session.getRole() == 'User')
		// 	return true;
		// else
		// 	return false;
	}

	this.getJobDetails = function(ev, jobInfo) {

		this.showLoader();

		Network.getService(CONSTANTS.get('PROD_JOB_DETAILS_INFO_API') + jobInfo.jobNo)
		.success(function (response) {

			this.jobDetails = [];

			if(response.message == CONSTANTS.get('SUCCESS'))
			{
				if(response.data.length > 0)
				{							
					this.jobDetails = response.data[0];

					$mdDialog.show({
						controller: ViewJobInfoDialogController,
						templateUrl: CONSTANTS.get('WIDGET_JOB_INFO_DIALOG_URL'),
						parent: angular.element(document.body),
						targetEvent: ev,
						clickOutsideToClose: true,
						locals: {
							jobDetails: this.jobDetails
						}
					}).then(function () {
					}, function () {
					});
				}
			}
			else
			{
				$mdDialog.show(
						$mdDialog.alert()
						.clickOutsideToClose(true)
						.title(response.message)
						.ariaLabel('Alert')
						.ok('OK')
				);
			}
		})
		.error(function (response) {
			$mdDialog.show(
					$mdDialog.alert()
					.clickOutsideToClose(true)
					.title(CONSTANTS.get('ERROR_IN_JOB_API'))
					.ariaLabel('Alert')
					.ok('OK')
			);
		});	
	}

	this.displayRemarks = function (task) {

		if(task.userRemark == null)
			task.userRemark = "";
		if(task.adminRemark == null)
			task.adminRemark = "";

		if(task.adminRemark != "" && task.userRemark != "")
			return "Admin :"+task.adminRemark+"\nUser:"+task.userRemark;
		else if(task.adminRemark != "" && task.userRemark == "")
			return "Admin :"+task.adminRemark+"\nUser:";
		else if(task.adminRemark == "" && task.userRemark != "")
			return "Admin : \nUser:"+task.userRemark;
		else
			return "No Remark";

	}
	
	
	this.uploadAttachment = function (ev, job) {
		
		$mdDialog.show({
			controller: UploadAttachmentCtrl,
			templateUrl: CONSTANTS.get('WIDGET_UPLOAD_ATTACHMENT_DIALOG_URL'),
			parent: angular.element(document.body),
			targetEvent: ev,
			clickOutsideToClose: true,
			locals: {
				jobDetails: job
			}
		})
		.then(function () {
		}, function () {
		});
		
	}
	
	
	this.downloadAttachment = function (ev, job) {
		
	}
	
	this.viewUploadAttachment = function(jobNo) {
		
		this.showLoader();

		Network.getService(CONSTANTS.get('PROD_GET_UPLOAD_ATTACHMENT_LIST_API') + jobNo)
		.success(function (response) {

			if(response.message == CONSTANTS.get('SUCCESS'))
			{
				return response.data;
			}
			else
			{
				$mdDialog.show(
						$mdDialog.alert()
						.clickOutsideToClose(true)
						.title(response.message)
						.ariaLabel('Alert')
						.ok('OK')
				);
			}
		})
		.error(function (response) {
			$mdDialog.show(
					$mdDialog.alert()
					.clickOutsideToClose(true)
					.title(CONSTANTS.get('ERROR_IN_JOB_API'))
					.ariaLabel('Alert')
					.ok('OK')
			);
		});	
	}
});