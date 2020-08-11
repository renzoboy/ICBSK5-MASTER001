<%@ page import="icbs.admin.UserMaster" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>FS Control Account Information</title>
    </head>
    <body>
         <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/fsControlAccount')}">FS Control Account List</a>
            <span class="fa fa-chevron-right"></span><span class="current">FS Control Account Information</span>
        </content>
        <content tag="main-content">
            <div class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
              
            
                <div class="row">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header">FS Control Account Information</legend>
                            <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <tr>
                                    <td><label>ID</label></td>
                                    <td>${fsControlAccountInstance?.id}</td>    
                                </tr> 
                                <tr>
                                    <td style = "width:30%;"><label>Account Code</label></td>
                                    <td style = "width:70%;">${fsControlAccountInstance?.account}</td>    
                                </tr>
                                <tr>
                                    <td style = "width:30%;"><label>Account Description</label></td>
                                    <td style = "width:70%;">${fsControlAccountInstance?.description}</td>    
                                </tr>
                                <tr>
                                    <td><label>Status</label></td>
                                    <td>${fsControlAccountInstance?.status?.description}</td>    
                                </tr>
                                <tr>
                                    <td><label>Date Created</label></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${fsControlAccountInstance.xCreatedDate}" /></td>    
                                </tr> 
                               
                                <tr>
                                    <td><label>Created by </label></td>
                                    <td>${fsControlAccountInstance?.createdBy?.name1} ${fsControlAccountInstance?.createdBy?.name2} ${fsControlAccountInstance?.createdBy?.name3}</td>    
                                </tr> 
                                 
                            </tbody>
                            </table>
                        </fieldset>
                    </div>  
                </div>
                    
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="edit" controller="fsControlAccount" id="${fsControlAccountInstance.id}" >Edit</g:link></li>
                <li><g:link action="create" controller="fsControlAccount" id="${fsControlAccountInstance.id}" >Create New</g:link></li>
                <li><g:link action="index" controller="fsControlAccount" >Back to FS Control Account List</g:link></li>
                
            </ul>
        </content>

    </body>
</html>
