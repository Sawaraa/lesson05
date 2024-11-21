function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
var buckets = null;
$.get("listProduct", function(data) {
    if (data !== '') {
        buckets = data;
    }
}).done(function() {
    	var tableContent = "<tr class='header'>"+
    					"<th style='width: 20%;'>Title</th>"+
    					"<th style='width: 20%;'>Description</th>"+
    				    "<th style='width: 20%;'>Author</th>"+
    				    "<th style='width: 20%;'>Pages</th>"+
    					"<th style='width: 20%;'>Price</th>"+
    					"<th style='width: 20%;'>Options</th>"+
    					"</tr>";


    //	buckets.forEach(function(basket)
    	jQuery.each(buckets, function(i, basket){
    		tableContent+="<tr>"+
    					  "<td>" + basket.title + "</td>"+
    					  "<td>" + basket.description + "</td>"+
    					  "<td>" + basket.author + "</td>"+
    					  "<td>" + basket.pages + "</td>"+
    					  "<td>" + basket.price + "</td>"+
    					  "<td><button onclick='deleteOrderFromBucket(" + basket.bucketId + ")'>delete</button></td>"+
    					  "</tr>"

    	});

    	  $('#myTable').html(tableContent);

    });




function deleteOrderFromBucket(bucketId) {
	var customUrl = '';
	var urlContent = window.location.href.split('/');
	for (var i = 0; i < urlContent.length-1; i++) {
		customUrl+=urlContent[i]+'/'
	}
	customUrl+='bucket?bucketId='+bucketId;

	$.ajax({
	    url: customUrl,
	    type: 'DELETE',
	    success: function(data) {
	    	if (data == 'Success') {
	    		location.reload();
			}
	    }
	});
}
