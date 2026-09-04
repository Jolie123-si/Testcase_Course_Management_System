<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Course Management</title></head>
<body>

<h2>Save Course</h2>
<form method="post" action="courses">
    Code:        <input type="text" name="code" required/><br/><br/>
    Name:        <input type="text" name="name" required/><br/><br/>
    Credits:     <input type="number" name="credits" required/><br/><br/>
    MaxStudents: <input type="number" name="maxStudents" required/><br/><br/>
    <input type="submit" value="Save"/>
</form>

<h2>Search Course</h2>
<form method="get" action="courses">
    <input type="hidden" name="action" value="search"/>
    Code: <input type="text" name="code"/>
    <input type="submit" value="Search"/>
</form>

<h2>Delete Course</h2>
<form method="get" action="courses">
    <input type="hidden" name="action" value="delete"/>
    Code: <input type="text" name="code"/>
    <input type="submit" value="Delete"/>
</form>

<hr/>

<!-- Show result message -->
<% if (request.getAttribute("message") != null) { %>
    <p><b>Result: <%= request.getAttribute("message") %></b></p>
<% } %>

<!-- Show search result -->
<% if (request.getAttribute("searchResult") != null) {
       Object result = request.getAttribute("searchResult");
       if (result instanceof Course) {
           Course c = (Course) result;
%>
    <p><b>Found:</b> <%= c.getCourseCode() %> - <%= c.getCourseName() %> | Credits: <%= c.getCredits() %> | Max: <%= c.getMaxStudents() %></p>
<% } else { %>
    <p><b>Course not found</b></p>
<% } } %>

</body>
</html>
