$( document ).ready(function() {
$('.help-inline').each(function(){
      if($(this).text().length) {
          $(this).parent().parent().addClass("has-error");
      }
  });
});

