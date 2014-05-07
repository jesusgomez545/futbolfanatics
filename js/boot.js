/*
	:: boot.js ::
	Boot order calls to initialize normal workflow
*/

$(function(){		

		/*********************************
		**  Non Dependent script zone 	**
		**	Complexity level: 1			**
		**********************************/

		$("[rel='tooltip']").tooltip();

		$(".register-show").click(function(){
			window.location.replace("register.html") ;
		});

		$(".logout-button").click(function(){
			window.location.replace("index.html") ;
		});

		$(".login-show").click(function(){
			$(".username-login-field").val('');
			$(".password-login-field").val('');
			$("#modalLogin").modal("show");
		});

		$(".publication-button").click(function(){
			$(".username-field").val('');
			$(".content-field").val('');
			$('.new-img').val('');
			$('.extra-item').remove();
			$("#modalAdd").modal("show");
		});

		$("body").delegate(".edit-button", "click",function(){		
			if($("#modalEdit").length > 0)
			{
				var id = $(this).attr("id");
				var username = $(".pub-owner-"+id).text();
				var pub = $(".pub-content-"+id).val();
				$(".username-edit-field").val(username);
				$(".content-edit-field").val(pub);
				$(".edition-ready-button").attr('id', id);
				$("#modalEdit").modal("show");
			}else
	       		errorShow("Debes haber inicado sesion para tener acceso a esta funcionalidad !!!");
		});

       	$("body").delegate(".del-button", "click", function(){
           if($("#modalDelete").length > 0)
           {
	           var id = $(this).attr("id");
	           $(".delete-button").attr('id', id);                
	           $("#modalDelete").modal("show");
	       }else
	       		errorShow("Debes haber inicado sesion para tener acceso a esta funcionalidad !!!");
       	});

		$(".event-button").click(function(){window.location.replace("event.html")});

		$(".img-register-button").click(function(){			
			$(".image-profile-field").trigger('click');
		});

		$(".recover-solicitation-a").click(function(){window.location.replace("recover-solicitation.html")});

		/*****************************
		**  Dependent script zone 	**
		**  Complexity level: 2		**
		******************************/

		try{
			$(".login-form").submit(function(e){
				e.preventDefault();
				loginSym();
			});
		}catch(err){}

		try{
			$(".create-event-button").click(function(e){
				$(".new-event-name").val('');
				$('.new-event-date').val('');
				$('.new-event-msg').val('');
				$('.new-img').val('');
				$('.extra-item').remove();
				$("#modalEventCreate").modal("show");				
			});
		}catch(err){}

		try{
			$(".restart-solicitation-form").submit(function(e){
				e.preventDefault();
				window.location.replace("restart.html");
			});
		}catch(err){}

		try{
			$(".hashtag-search-form").submit(function(e){
				e.preventDefault();
				hashtagSearch();
			});
		}catch(err){}

		try{
			$(".more-button").click(function(){
				moreTweets("pageid-zone");
			});
		}catch(err){}

		try{
			$(".less-button").click(function(){
				lessTweets("pageid-zone");
			});
		}catch(err){}

		try{
			$("body").delegate(".show-button", "click", showFeeder);
		}catch(err){}

		try{
	       	$(".modify-form").submit(function(e){
				e.preventDefault();
				modifyProfile();
			});
		}catch(err){}

		try{
	       	$(".delete-button").click(deleteFeeder);
		}catch(err){}

		try{
			$(".pub-button").click(addFeeder);
		}catch(err){}

		try{
			$(".edition-ready-button").click(editFeeder);	
		}catch(err){}

		try{
			$(".plus-team-button").click(addTeam);
		}catch(err){}

		try{
			$(".plus-img-button").click(addImage);
		}catch(err){}

		try{
			$("body").delegate(".day","click",function(){
				var clss = $(this).attr("class").split(" ");
				console.log($(this));
				while(clss.length)				
					if((/^_id_\d+$/).test(clss[0]))
						break;
					else
						clss.shift();
				var data = {
					"date":$(this).attr("data-date"),
					"tittle":$(this).children().children().attr("data-original-title"),
					"content":$(this).children().children().attr("data-content")};				
				eventShow(clss[0], data);
			});
		}catch(err){}
});