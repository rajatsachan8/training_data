
$(document).ready(function(){
    
    $(':input').change(function(evt){

    var filter = $(':input:checked').map(function(index, el) {
        return "." + el.value;
    }).toArray().join("");
      
    $(".category").fadeTo("fast", 0.2).filter(filter).fadeTo("fast", 1);

});

$(':input').change(function(evt){
    var filter=$(':input:unchecked').map(function(index,el){
        return "."+el.value;
    }).toArray().join("");
    $(".category").fadeTo("fast",1);
});



$(function() {
		$('.pop').on('click', function() {
    
            $('.hello').html($(this).find('img').attr('alt'));
			$('.imagepreview').attr('src', $(this).find('img').attr('src'));
			$('#imagemodal').modal('show');   
		});		
});

});
