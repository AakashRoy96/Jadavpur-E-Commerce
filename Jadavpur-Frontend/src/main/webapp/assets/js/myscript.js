$(function() 
{
	var $table = $('#productTable');
	
	if ($table.length) 
	{
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ], [ '3 Products', '5 Products', '10 Products', 'ALL Products' ] ],
			pageLength : 5,
			ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
			columns : [
						{
							data:'code',
							mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/rs/images/' + data
											+ '.jpg" class="dataTableImg"/>';
											}
						},
						{
							data : 'name',
						},
						{
							data : 'brand',
						},
						{
							data : 'unitPrice',
							mRender :function(data, type, row)
							{
								return '&#8377; ' + data
							}
						},
						{
							data : 'quantity',
							mRender :function(data, type, row)
							{
								if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;
							}
						},
						{
							data:'id',
							mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/product/view/single/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span>View Details</a> &#160;';
											
											return str;
											}
						}
				]
			
			});
		}
});