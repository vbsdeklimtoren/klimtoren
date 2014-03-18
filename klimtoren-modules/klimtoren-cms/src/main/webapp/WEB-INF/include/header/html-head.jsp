<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="req" value="${pageContext.request}" />
<c:set var="url" value="${req.requestURL}" />
<c:set var="base" value="${fn.substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
<c:set var="baseLink" value="${fn:startsWith(base,  'http://cms.klimtoren.be') ? '/' : '/klimtoren-cms/'}" />


<title>Klimtoren Admin</title>

<meta name="description" content="Content Management System for VBS De Klimtoren">
<meta name="author" content="Karl Van Iseghem">

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<base href="${baseLink}" />

<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

<!-- Klimtoren CMS Styles -->
<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.css">
<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.css">

<link rel="stylesheet" type="text/css" media="screen" href="css/klimtoren-cms.css">

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">

<!-- FAVICONS -->
<link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

<!-- GOOGLE FONT -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">
