<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.UserBean"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<p class="brand-link"> <img
		src="assets/dist/img/AdminLTELogo.png" alt="AdminLTE Logo"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">SSIT</span>
	</p>

	<!-- Sidebar -->
	<div
		class="sidebar os-host os-theme-light os-host-overflow os-host-overflow-y os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-transition">
		<div class="os-resize-observer-host observed">
			<div class="os-resize-observer" style="left: 0px; right: auto;"></div>
		</div>
		<div class="os-size-auto-observer observed"
			style="height: calc(100% + 1px); float: left;">
			<div class="os-resize-observer"></div>
		</div>
		<div class="os-content-glue"
			style="margin: 0px -8px; width: 249px; height: 318px;"></div>
		<div class="os-padding">
			<div class="os-viewport os-viewport-native-scrollbars-invisible"
				style="overflow-y: scroll;">
				<div class="os-content"
					style="padding: 0px 8px; height: 100%; width: 100%;">
					<!-- Sidebar user panel (optional) -->
					<div class="user-panel mt-3 pb-3 mb-3 d-flex">
						<div class="image">
							<img src="assets/dist/img/user2-160x160.jpg"
								class="img-circle elevation-2" alt="User Image">
						</div>
						<div class="info">
						<%
						int user_id=0,enrollment=-1;
						Cookie c[] = request.getCookies();
						for (Cookie x : c) {
							if (x.getName().equals("userId")) {
								user_id = Integer.parseInt(x.getValue());
							}
							if (x.getName().equals("enrollment")) {
								enrollment = Integer.parseInt(x.getValue());
							}
						}
						UserBean user;
						user = UserDao.getDetailsForRequestForUser(user_id);
						%>
							<p style="color: aliceblue;"><%=user.getFirstName() + " " + user.getLastName() %></p>
						</div>
					</div>

					<!-- SidebarSearch Form -->

					<!-- Sidebar Menu -->
					<nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

              <li class="nav-item menu-open">
                <ul class="nav nav-treeview">
                <%
                	if(user.getRole() == 4 ){
                %>
                  <li class="nav-item">
                    <a href="confirm_for_request.jsp" class="nav-link">
                      <i class="far fa-circle nav-icon"></i>
                      <p>New Request</p>
                    </a>
                  </li>
                 <%}else if(user.getRole() == 1) {%>
                 <li class="nav-item">
                    <a href="addd.jsp" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>Add Student</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="./index2.html" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>Add HOD</p>
                    </a>
                  </li>
				  <%} %>
                  <li class="nav-item">
                    <a href="forgot_password.jsp?mobile=0&password=1" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>Change Password</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="forgot_password.jsp?mobile=1&password=0" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>Change Mobile</p>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a href="login4.jsp" class="nav-link active">
                      <i class="far fa-circle nav-icon"></i>
                      <p>LogOut</p>
                    </a>
                  </li>
                </ul>
              </li>

            </ul>
          </nav>
					<!-- /.sidebar-menu -->
				</div>
			</div>
		</div>
		<div
			class="os-scrollbar os-scrollbar-horizontal os-scrollbar-unusable os-scrollbar-auto-hidden">
			<div class="os-scrollbar-track">
				<div class="os-scrollbar-handle"
					style="width: 100%; transform: translate(0px, 0px);"></div>
			</div>
		</div>
		<div
			class="os-scrollbar os-scrollbar-vertical os-scrollbar-auto-hidden">
			<div class="os-scrollbar-track">
				<div class="os-scrollbar-handle"
					style="height: 23.4731%; transform: translate(0px, 61.7331px);"></div>
			</div>
		</div>
		<div class="os-scrollbar-corner"></div>
	</div>
	<!-- /.sidebar -->
</aside>