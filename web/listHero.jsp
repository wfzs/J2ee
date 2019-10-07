<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<table style="width:500px; margin:44px auto" align="center" border="1" cellspacing='0' class="table table-striped table-bordered table-hover table-condensed">
  <tr>
    <td>id</td>
    <td>name</td>
    <td>hp</td>
    <td>damage</td>
    <td>编辑</td>
    <td>删除</td>
  </tr>
  <c:forEach items="${heros}" var="hero" varStatus="st">
  <tr>
    <td>${hero.id }</td>
    <td>${hero.name }</td>
    <td>${hero.hp }</td>
    <td>${hero.damage }</td>
    <td><a href="editHero?id=${hero.id }">edit</a></td>
    <td><a href="deleteHero?id=${hero.id }">delete</a></td>
  </tr>
  </c:forEach> 
</table>
<nav>
          <ul class="pager">
 
            <li><a href="?start=0">首  页</a></li>
            <li><a href="?start=${pre}">上一页</a></li>
            <li><a href="?start=${next}">下一页</a></li>
            <li><a href="?start=${end}">末  页</a></li>
          </ul>           
        </nav>