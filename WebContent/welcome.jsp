<!--
 * Copyright IBM Corp. 2014
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Go Trade</title>

    <!-- Latest compiled and minified CSS 
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">-->
	<link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="css/jumbotron-narrow.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
        <!--  
          <li ng-class="{active: location.path() != '/login'}"><a href="#!/index">Home</a></li>
          <li ng-class="{active: location.path() == '/login'}" ng-show="!user"><a href="#!/login">Login</a></li>
          <li ng-show="user"><a ng-click="logout()">Logout</a></li>
          -->
        </ul>
        <h3 class="text-muted">Go Trade</h3>
      </div>
      
    <TABLE width="100%" height="30" align="center">
  <TBODY>
        <TR>
      <TD></TD>
      <TD><FONT color="#ff0033"><FONT color="#ff0033"><FONT color="#ff0033">
            
<% String results;
results = (String) request.getAttribute("results");
if ( results != null )out.print(results);
%></FONT></FONT></FONT></TD>
      <TD></TD>
    </TR>
  </TBODY>
</TABLE>

	    

<h2>Login</h2>

<div class="row">
  <div class="col-md-6">
	<form action="app" method="POST" class="form-horizontal" >
	
	  <div class="form-group">
	    <label for="username" class="col-sm-3 control-label">User Name:</label>
        <div class="col-sm-9">
		  <input id="username" value="uid:0" name="uid" ng-model="username" type="text" class="form-control" />
        </div>
      </div>
      
      
   
      <div class="form-group">
        <label for="password" class="col-sm-3 control-label">Password:</label>
        <div class="col-sm-9">
          <input id="password" value="xxx" name="passwd" ng-model="password" type="password" class="form-control"/>
        </div>
      </div>
     
      <div class="form-group">
        <div class="col-sm-9 col-sm-offset-3">
          <input type="submit" value="Log In" class="btn btn-primary"/>
          <INPUT type="hidden" name="action" value="login">
        </div>
      </div>
     
    </form>
  </div>
</div>

     
      <div class="alert alert-info" ng-show="sessions.length == 0">
       <p>First time user? <a href="config?action=buildDB" target="_blank">Populate DB first!</p>
</div>
      <div ng-view></div>
      

      <div class="footer">
      </div>
    </div> <!-- /container -->

    <script src="js/jquery-1.11.0.min.js"></script>
   	<!-- Latest compiled and minified JavaScript 
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular-resource.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular-route.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular-cookies.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular-animate.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.11.0/ui-bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/0.11.0/ui-bootstrap-tpls.min.js"></script>
    <script src="//cdn.sockjs.org/sockjs-0.3.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.1/stomp.min.js"></script>-->
    
    <script src="js/angular.min.js"></script>
	<script src="js/angular-resource.js"></script>
    <script src="js/angular-route.js"></script>
    <script src="js/angular-cookies.js"></script>
    <script src="js/angular-animate.js"></script>
    <script src="js/ui-bootstrap.min.js"></script>
    <script src="js/ui-bootstrap-tpls.min.js"></script>
    <script src="js/sockjs-0.3.min.js"></script>
    <script src="js/stomp.min.js"></script>
    
    <!-- 
    <script src="app/app.js"></script>
	<script src="app/services.js"></script>
	<script src="app/login/login.js"></script>
	<script src="app/question/question.js"></script>
	<script src="app/sessions/sessions.js"></script>
	<script src="app/sessions/session.js"></script>
	  -->
  </body>
</html>
