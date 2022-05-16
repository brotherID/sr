function test() {
	
	
	
	var selectedOption = $('#select').val();
    if (selectedOption == "1") {
    	 $("#uploadMail").css("display", "none");
    	//$("#uploadMail").hide();
    }
    else
	{
    	 $("#uploadMail").css("display", "block");
    	//$("#uploadMail").show();
	}
	
	
}