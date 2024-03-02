<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
<form action="/action_page.php">

  <div class="form-group">
    <label for="username">Username address:</label>
    <input type="username" class="form-control" placeholder="Enter Username" id="username">
  </div>

  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="email">
  </div>

  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>

  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="submit" class="btn btn-primary">로그인 완료</button>
</form>

</div>

<%@ include file="../layout/footer.jsp"%>

