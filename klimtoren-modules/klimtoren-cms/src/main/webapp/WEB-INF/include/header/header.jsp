		<!-- HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="img/cms-logo.png" alt="SmartAdmin"> </span>
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
				Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
				<span id="activity" class="activity-dropdown"> <i class="fa fa-user"></i> <b class="badge"> 21 </b> </span>

				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">

					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					<div class="btn-group btn-group-justified" data-toggle="buttons">
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/mail.html">
							Berichten (14) </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/notifications.html">
							notify (3) </label>
						<label class="btn btn-default">
							<input type="radio" name="activity" id="ajax/notify/tasks.html">
							Taken (4) </label>
					</div>

					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">

						<div class="alert alert-transparent">
							<h4>Klik op een tabblad om hier berichten te tonen.</h4>
							Deze lege pagina helpt je jouw privacy te beschermen, of je kan hier het eerste bericht automatisch laten weergeven.
						</div>

						<i class="fa fa-lock fa-4x fa-border"></i>

					</div>
					<!-- end notification content -->

					<!-- footer: refresh area -->
					<span> Laatste update: 17 maart 2014 om 15:00
						<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Laden..." class="btn btn-xs btn-default pull-right">
							<i class="fa fa-refresh"></i>
						</button> </span>
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>

			<!-- projects dropdown -->
			<div id="project-context">

				<span class="label">Apps:</span>
				<span id="project-selector" class="popover-trigger-element dropdown-toggle" data-toggle="dropdown">Beheer <i class="fa fa-angle-down"></i></span>

				<!-- Suggestion: populate this list with fetch and push technique -->
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);"><i class="fa fa-bar-chart-o"></i> Rapport</a>
					</li>
					<li>
						<a href="javascript:void(0);"><i class="fa fa-globe"></i> Portaal</a>
					</li>
					<li class="divider"></li>
					<li class="active">
						<a href="javascript:void(0);"><i class="fa fa-group"></i> Beheer</a>
					</li>
				</ul>
				<!-- end dropdown-menu-->

			</div>
			<!-- end projects dropdown -->

			<!-- pulled right: nav area -->
			<div class="pull-right">

				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end collapse menu -->

				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
					<span> <a href="login.html" title="Sign Out"><i class="fa fa-sign-out"></i></a> </span>
				</div>
				<!-- end logout button -->

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->

				<!-- input: search field -->
				<form action="#search.html" class="header-search pull-right">
					<input type="text" placeholder="Find reports and more" id="search-fld">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
					<a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a>
				</form>
				<!-- end input: search field -->
			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->