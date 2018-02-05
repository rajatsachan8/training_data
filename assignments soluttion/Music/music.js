$(document).ready(function(){

var $select = $('#down');  
$.each(localStorage,function(key, value) 
{   
    $select.append('<tr><td><input type="checkbox" value='+key+'>' +key+'</td></tr><br>');
    
});
});