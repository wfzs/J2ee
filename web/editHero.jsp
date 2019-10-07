<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<form action="/updateHero" method="post">
名字：<input type='text' name='name' value='${hero.name }'><br>
血量：<input type='text' name='hp' value='${hero.hp }'><br>
伤害：<input type='text' name='damage' value='${hero.damage }'><br>
<input type='hidden' name='id' value='${hero.id }'><br>
<input type='submit' value='更新'><br>
</form>