$(document).ready(function(){


var $select = $('#down'); 
 $select.find('option').remove();  
$.each(localStorage,function(key, value) 
{
    $select.append('<option value=' + value+ '>' +key + '</option>');
});
});