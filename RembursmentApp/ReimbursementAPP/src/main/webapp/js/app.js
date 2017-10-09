var logged = false;
window.onload = function(){

	loadHomeView();

	if(logged == false){
		$("#navbar").hide();
	}
	else{
		$("#navbar").show();};

		document.getElementById("homePage")
		.addEventListener("click", loadDashboardView);

		document.getElementById("remPage")
		.addEventListener("click", loadReimbursmentPageView);

		document.getElementById("settingPage")
		.addEventListener("click", loadSettingsPageView);

		document.getElementById("logout")
		.addEventListener("click", logout);

};


function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//console.log(xhr.responseText);
			document.getElementById('view').innerHTML = xhr.responseText;		
			document.getElementById("login")
			.addEventListener("click", login);
		}
	}
	console.log("getting homepage")
	xhr.open("GET", "getLoginView", true);
	xhr.send();
};


function login(){
	var email = document.getElementById("email").value;
	var pass = document.getElementById("pass").value;
	var tx = [email, pass];
	tx = JSON.stringify(tx);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var response =  xhr.responseText;

			if (response == "fail"){
				document.getElementById("message")
				.innerHTML = "Invalid credentials. Please try again";
			}
			else if(response == "pass"){
				document.getElementById("message")
				.innerHTML = "Invalid user. Please try again";
			}
			else{
				logged = true;
				console.log(response);
				loadDashboardView();
				$("#navbar").show();
			}
		}
	}

	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-type",
	"application/x-www-form-urlencoded");
	xhr.send(tx);
};

//logout of app and return to login
function logout(){

//	console.log("getting dash");
	var xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function(){
//	if(xhr.readyState == 4 && xhr.status == 200){
//	document.getElementById('view').
//	innerHTML = xhr.responseText;
//	}
//	}

	xhr.open("GET", "logout", true);
	xhr.send();

}

function loadDashboardView(){
	console.log("in load dashboard view");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getUserPageInfo(); // loads user info by calling function
			getReimbursmentPageInfo();
			
			
			//loadReimbursmentPageView()
		}
	}
	console.log("getting dash");
	xhr.open("GET", "getDashboard", true);
	xhr.send();
};


function loadReimbursmentPageView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			getReimbursmentPageInfo(); // loads user info by calling function

		}
	}
	console.log("getting user reimbursments")
	xhr.open("GET", "getRemPage", true);
	xhr.send();
};

function loadSettingsPageView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById('view').
			innerHTML = xhr.responseText;
			// loads user info by calling function
			getUserSettingsPageInfo();
		}
	}
	console.log("getting user settings")
	xhr.open("GET", "getEditUser", true);
	xhr.send();
};


function editReimbursement(i) {
	// opens editbility to whole table which defeats the purpose of having  seperate edit buttons
	document.getElementById("remTable").contentEditable = true; 

//	document.getElementById("demo").innerHTML = "The p element above is now editable. Try to change its text.";
};

//this should only allow status to be change and resolver notes
//function editReimbursement(var r){
//var table, tabledate, tr, td, i;
//var s = r + 1;
//table = document.getElementById("remTable");
//tr = table.getElementsByTagName("tr");
//for (i = 0; i < tr.length; i++) {
//
//	if(s == i){
//		
//		//td = tr[i].getElementsByTagName("td")[6]
//		//td.contentEditable = true;
//		tabledata = tr[i].getElementsByTagName("td").[7];
//		tabledata.contentEditable = true;	
//	}
//	
//	
//
//}       
//};
//search tool that searches for users by id.
function myFunction(){
	var input, filter, table, tr, td, i;
	input = document.getElementById("myInput");
	filter = input.value.toUpperCase();
	table = document.getElementById("remTable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[1];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}       
	}
};


//Can edit this to hold both manager info and user info
function getReimbursmentPageInfo(){ // loads basic user info and account info into html
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("inside reimbursement page info js function");
			console.log(xhr.responseText);
			var dto = JSON.parse(xhr.responseText);
			var someUser = dto.user;
			var rem = dto.reimbursement;

			// need to fix this data breach

			console.log(someUser);
			console.log(someUser.isManger);
			var checkIfManager = someUser
			// check to see if user roll is manager or plain user
			if(someUser.isManger == 0){
			document.getElementById("search").style.visibility = "hidden";
			document.getElementById("someButton").style.visibility = "hidden";
			
			if (rem.length == 0){
					document.getElementById("reimbursements").style.visibility = "hidden"; 
				}
				else{
					for(var i = 0; i < rem.length; i++){
						// populate users table
						var table = document.getElementById("remTable");
						var row = table.insertRow();
						//var button = row.
						var remId = row.insertCell(0);
						var submitterId = row.insertCell(1);
						var resId = row.insertCell(2);
						var submitdate = row.insertCell(3);
						var reslvDate= row.insertCell(4);
						var reslvNote = row.insertCell(5);
						var statusId = row.insertCell(6);
						var description = row.insertCell(7);
						var amount = row.insertCell(8);
						
						
						remId.innerHTML = rem[i].reimburseid;
						submitterId.innerHTML = rem[i].submitterID;
						resId.innerHTML = rem[i]. resolverID;
						submitdate.innerHTML = rem[i].submitDate;
						reslvDate.innerHTML =  rem[i].resolvedDate;
						reslvNote.innerHTML =  rem[i].resolvedNote;
						statusId.innerHTML = rem[i].statusID;
						description.innerHTML =  rem[i].description;
						amount.innerHTML = "$" + rem[i].amount;
					}
				}
			}

			else{
				//hides create reimbursement form in managers reimbursement page
				document.getElementById("theContainer").style.visibility = "hidden"; 
				for(var i = 0; i < rem.length; i++){
					//var btn = document.createElement("BUTTON")
					//	var node = document.cr
//					btn.id = 'EditButton';
//					btn.innerHTML = 'EDIT';
//					btn.setAttribute("value", 'EDIT');
//					btn.setAttribute("text", 'EDIT');
//					btn.style.fontSize = "14px";
//					btn.style.backgroundColor = '#4CAF50';

					// populate managers table
					var table = document.getElementById("remTable");
					var row = table.insertRow();
					//var button = row.
					var remId = row.insertCell(0);
					var submitterId = row.insertCell(1);
					var resId = row.insertCell(2);
					var submitdate = row.insertCell(3);
					var reslvDate= row.insertCell(4);
					var reslvNote = row.insertCell(5);
					var statusId = row.insertCell(6);
					var description = row.insertCell(7);
					var amount = row.insertCell(8);
					var edit = row.insertCell(9);// insert edit button
					var view = row.insertCell(10);// insert edit button
					
					remId.innerHTML = rem[i].reimburseid;
					submitterId.innerHTML = rem[i].submitterID;
					resId.innerHTML = rem[i]. resolverID;
					submitdate.innerHTML = rem[i].submitDate;
					reslvDate.innerHTML =  rem[i].resolvedDate;
					reslvNote.innerHTML =  rem[i].resolvedNote;
					statusId.innerHTML = rem[i].statusID;
					description.innerHTML =  rem[i].description;
					amount.innerHTML = "$" + rem[i].amount;
					//edit.innerHTML = btn;editReimbursement()
					edit.innerHTML = "<td><button onclick='editReimbursement(" + i +")'>Edit</button></td>";
							
					// <a class="nav-link" id="settingPage">Settings</a>
					view.innerHTML = "<td> <a href='partials/resolve.html?id=" + rem[i].reimburseid + "'>View</a></td>";


				}
			}

		}
	}

	xhr.open("GET", "getUserInfo", true);
	xhr.send();

};


function getUserPageInfo(){ // loads basic user info and account info into html
	console.log("in user page info function");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var someUser = JSON.parse(xhr.responseText);
			var user = someUser.user;
			document.getElementById('name').innerHTML = user.firstName + " " + user.lastNAme;
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

};
//need to be able to edit user info from the front end.
//currently the user info is showing null
//need to change this and the edit user servelet
function getUserSettingsPageInfo(){
	console.log("in user page info function");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var someUser = JSON.parse(xhr.responseText);
			var user = someUser.user;
			document.getElementById("firstname").placeholder =  user.firstName; 
		
			//document.getElementById('firstname').innerHTML = user.firstName;
			
			document.getElementById('lastname').placeholder = user.lastNAme;
			document.getElementById('email').placeholder = user.email;
			document.getElementById('pass').placeholder = user.password;


		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();

};

//function getQuery(variable){
//	var guery = window.location.search.substring[1];
//	var vars = query.spilt("&");// may need to change this symbol
//	for(var i=0; i<vars.length; i++){
//		var pair = vars[i].split("=");
//		if(pair[0] == variable
//				return pair[1]; // may need to add string link here;
//	}
//}
//	
//	function get(){ // allows us to edit users info
//	var id = document.
//		var remId = getQuery(id);
//		//var update = document.getElementbyId("updateUser").value;
//		console.log(remId);
//        
//		var x = JSON.stringify(remId);
//
//		var xhr = new XMLHttpRequest();
//		xhr.onreadystatechange = function(){
//			if(xhr.readyState == 4 && xhr.status == 200){
//				console.log(xhr.responseText);
//
//			}
//		}
//
//		xhr.open("POST", "editUser", true);
//		//set the header to tell the server you have data for it to process
//		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//research this !!!
//		xhr.send(x); //include your post data in the send()
//
//	};
function updateReimburements(){ // allows us to add new reimbursements 
	var rem = document.getElementbyId("updateRem");
	console.log(rem);

	var type = JSON.stringify(rem);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);

		}
	}

	xhr.open("POST", "update" , true);
	//set the header to tell the server you have data for it to process
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//research this !!!
	xhr.send(type); //include your post data in the send()

};

	function addRemibursement(){ // allows us to add new reimbursements 
		var rem = document.getElementbyId("addRem").value;
		console.log(rem);

		var type = JSON.stringify(rem);

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.responseText);
			
			}
		}

		xhr.open("POST", "addReimbursement" , true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//research this !!!
		xhr.send(type); //include your post data in the send()

	};

	function editUser(){ // allows us to edit users info
		var update = document.getElementbyId("updateUser").value;
		console.log(update);

		var x = JSON.stringify(update);

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.responseText);

			}
		}

		xhr.open("POST", "editUser", true);
		//set the header to tell the server you have data for it to process
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");//research this !!!
		xhr.send(x); //include your post data in the send()

	};

