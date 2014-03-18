<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../../include/header/html-head.jsp" />
</head>
<body>
	<jsp:include page="../../include/header/header.jsp" />
	
	<jsp:include page="../../include/header/admin-navigation.jsp" />
	
	<!-- MAIN PANEL -->
	<div id="main" role="main">

		<!-- RIBBON -->
		<div id="ribbon">

			<span class="ribbon-button-alignment"> <span id="refresh" class="btn btn-ribbon" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true"><i class="fa fa-refresh"></i></span> </span>

			<!-- breadcrumb -->
			<ol class="breadcrumb">
				<li>
					Beheer
				</li>
				<li>
					Gebruikers
				</li>
			</ol>
			<!-- end breadcrumb -->

			<!-- You can also add more buttons to the
			ribbon for further usability

			Example below:

			<span class="ribbon-button-alignment pull-right">
			<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
			<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
			<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
			</span> -->

		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">

			<div class=row>
				<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
						<h1 class="page-title txt-color-blueDark">
							<i class="fa fa-table fa-fw "></i> 
								Gebruikers 
							<span>> 
								Personeel
							</span>
						</h1>
					</div>
					<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
						<ul id="sparks" class="">
							<li class="sparks-info">
								<h5> My Income <span class="txt-color-blue">$47,171</span></h5>
								<div class="sparkline txt-color-blue hidden-mobile hidden-md hidden-sm">
									1300, 1877, 2500, 2577, 2000, 2100, 3000, 2700, 3631, 2471, 2700, 3631, 2471
								</div>
							</li>
							<li class="sparks-info">
								<h5> Site Traffic <span class="txt-color-purple"><i class="fa fa-arrow-circle-up" data-rel="bootstrap-tooltip" title="Increased"></i>&nbsp;45%</span></h5>
								<div class="sparkline txt-color-purple hidden-mobile hidden-md hidden-sm">
									110,150,300,130,400,240,220,310,220,300, 270, 210
								</div>
							</li>
							<li class="sparks-info">
								<h5> Site Orders <span class="txt-color-greenDark"><i class="fa fa-shopping-cart"></i>&nbsp;2447</span></h5>
								<div class="sparkline txt-color-greenDark hidden-mobile hidden-md hidden-sm">
									110,150,300,130,400,240,220,310,220,300, 270, 210
								</div>
							</li>
						</ul>
					</div>
			</div>
			<!-- widget grid -->
			<section id="widget-grid" class="">
			
				<!-- row -->
				<div class="row">
			
					<!-- NEW WIDGET START -->
					<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			
						<!-- Widget ID (each widget will need unique ID)-->
						<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-editbutton="true" data-widget-deletebutton="true">
							<!-- widget options:
							usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
			
							data-widget-colorbutton="false"
							data-widget-editbutton="false"
							data-widget-togglebutton="false"
							data-widget-deletebutton="false"
							data-widget-fullscreenbutton="false"
							data-widget-custombutton="false"
							data-widget-collapsed="true"
							data-widget-sortable="false"
			
							-->
							<header>
								<span class="widget-icon"> <i class="fa fa-table"></i> </span>
								<h2>Lagere school <i class="fa fa-caret-square-o-down"></i> </h2>
			
							</header>
			
							<!-- widget div-->
							<div>
			
								<!-- widget edit box -->
								<div class="jarviswidget-editbox">
									<!-- This area used as dropdown edit box -->
			
								</div>
								<!-- end widget edit box -->
			
								<!-- widget content -->
								<div class="widget-body no-padding">
									<div class="widget-body-toolbar">
			
									</div>
									
									<table id="dt_basic" class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>ID</th>
												<th>Naam</th>
												<th>E-mail</th>
												<th>Job</th>
												<th>Toegevoegd</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>Karl Van Iseghem</td>
												<td>karl.vaniseghem@klimtoren.be</td>
												<td>zorg-co&ouml;rdinator</td>
												<td>03/04/14</td>
											</tr>
											<tr>
												<td>2</td>
												<td>Ulrike Drieskens</td>
												<td>ulrike.driesekens@klimtoren.be</td>
												<td>onderwijzeres</td>
												<td>03/04/14</td>
											</tr>
										</tbody>
									</table>
			
								</div>
								<!-- end widget content -->
			
							</div>
							<!-- end widget div -->
			
						</div>
						<!-- end widget -->
		</div>
		<!-- END MAIN CONTENT -->

	</div>
	<!-- END MAIN PANEL -->
	
	<jsp:include page="../../include/footer/scripts.jsp" />
	
	<!-- MAIN APP JS FILE -->
		<script src="js/app.js"></script>

		<!-- PAGE RELATED PLUGIN(S) -->
		<script src="js/plugin/datatables/jquery.dataTables-cust.min.js"></script>
		<script src="js/plugin/datatables/ColReorder.min.js"></script>
		<script src="js/plugin/datatables/FixedColumns.min.js"></script>
		<script src="js/plugin/datatables/ColVis.min.js"></script>
		<script src="js/plugin/datatables/ZeroClipboard.js"></script>
		<script src="js/plugin/datatables/media/js/TableTools.min.js"></script>
		<script src="js/plugin/datatables/DT_bootstrap.js"></script>
		

		<script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
			
			/*
			 * BASIC
			 */
			$('#dt_basic').dataTable({
				"sPaginationType" : "bootstrap_full"
			});
	
			/* END BASIC */
	
			/* Add the events etc before DataTables hides a column */
			$("#datatable_fixed_column thead input").keyup(function() {
				oTable.fnFilter(this.value, oTable.oApi._fnVisibleToColumnIndex(oTable.fnSettings(), $("thead input").index(this)));
			});
	
			$("#datatable_fixed_column thead input").each(function(i) {
				this.initVal = this.value;
			});
			$("#datatable_fixed_column thead input").focus(function() {
				if (this.className == "search_init") {
					this.className = "";
					this.value = "";
				}
			});
			$("#datatable_fixed_column thead input").blur(function(i) {
				if (this.value == "") {
					this.className = "search_init";
					this.value = this.initVal;
				}
			});		
			
	
			var oTable = $('#datatable_fixed_column').dataTable({
				"sDom" : "<'dt-top-row'><'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
				//"sDom" : "t<'row dt-wrapper'<'col-sm-6'i><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'>>",
				"oLanguage" : {
					"sSearch" : "Search all columns:"
				},
				"bSortCellsTop" : true
			});		
			
	
	
			/*
			 * COL ORDER
			 */
			$('#datatable_col_reorder').dataTable({
				"sPaginationType" : "bootstrap",
				"sDom" : "R<'dt-top-row'Clf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
				"fnInitComplete" : function(oSettings, json) {
					$('.ColVis_Button').addClass('btn btn-default btn-sm').html('Columns <i class="icon-arrow-down"></i>');
				}
			});
			
			/* END COL ORDER */
	
			/* TABLE TOOLS */
			$('#datatable_tabletools').dataTable({
				"sDom" : "<'dt-top-row'Tlf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
				"oTableTools" : {
					"aButtons" : ["copy", "print", {
						"sExtends" : "collection",
						"sButtonText" : 'Save <span class="caret" />',
						"aButtons" : ["csv", "xls", "pdf"]
					}],
					"sSwfPath" : "js/plugin/datatables/media/swf/copy_csv_xls_pdf.swf"
				},
				"fnInitComplete" : function(oSettings, json) {
					$(this).closest('#dt_table_tools_wrapper').find('.DTTT.btn-group').addClass('table_tools_group').children('a.btn').each(function() {
						$(this).addClass('btn-sm btn-default');
					});
				}
			});
		
		/* END TABLE TOOLS */
		/* EVENTS */
			$('#dt_basic tbody tr').dblclick(function () {
// 		        var aData = oTable.fnGetData( this );
// 		        var iId = aData[0];
		 		
		        alert('ok');
		    }).click(function() {
		    	$(this).parent().find('tr').removeClass('active');
		    	$(this).addClass('active');
		    });
		});
 		</script>
</body>
</html>