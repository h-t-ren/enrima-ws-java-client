<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Enrima Web Client Exmaple</title>
<script src="http://ajax.googleapis.com/ajax/libs/dojo/1.6/dojo/dojo.xd.js" djConfig="parseOnLoad: true"> </script>
<script type="text/javascript" src="<c:url value="http://code.jquery.com/jquery-1.7.1.min.js" />"></script>
<script type="text/javascript" src="resources/javascript/jquery.dataTables.js"></script>	

<link rel="stylesheet" href="resources/styles/blueprint/screen.css" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="resources/styles/blueprint/print.css" type="text/css" media="print" />
<!--[if lt IE 8]>
 <link rel="stylesheet" href="/resources/blueprint/ie.css" type="text/css" media="screen, projection" />
<![endif]-->
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/dojo/1.6/dijit/themes/tundra/tundra.css" />	
<link rel="stylesheet" href="resources/styles/enrima-web.css" type="text/css" media="screen" />
<link rel="stylesheet" href="resources/styles/table.css" type="text/css" media="screen, projection" />
<style type="text/css">
   html, body { width: 100%; height: 100%; margin: 0; }
</style>
  
</head>

    <body class="tundra">
        <div dojoType="dijit.layout.BorderContainer" style="width: 100%; height: 100%">
            <div id="header_toolbar" dojoType="dijit.layout.ContentPane" region="top">
                <div id="nav_top">
                   <div id="app_logo_area" >
                       <img src="resources/images/ime_logo.gif" alt="" width="53px" height="36px" style="background-color: #002288;" /> 
                   </div>
                 <div id="app_area" >Enrima</div>
                  <div id="app_main_area"> Enrima Web Example</div>
                  <div id="other_area"></div>
             </div>
            </div>

     <div id="app_body" dojoType="dijit.layout.ContentPane" region="center">


